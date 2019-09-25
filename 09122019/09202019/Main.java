package jsondomaci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder aerodromi = new StringBuilder();
		ArrayList<Airport> spisakAerodroma = new ArrayList<Airport>(); 
		ArrayList<Route> spisakRuta = new ArrayList<Route>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			String linija;
			while ((linija=br.readLine()) != null) {
				aerodromi.append(linija);
			}
			br.close();
			StringBuilder rute = new StringBuilder();
			br = new BufferedReader(new FileReader(args[1]));
			while ((linija=br.readLine()) != null) {
				rute.append(linija);
			}
			br.close(); 
			JSONParser parser = new JSONParser();
			JSONArray aerodromiJSON = (JSONArray) parser.parse(aerodromi.toString());
			JSONArray ruteJSON = (JSONArray) parser.parse(rute.toString());
			for (int i = 0; i < aerodromiJSON.size(); i++) {
			    JSONObject jsonobject = (JSONObject) aerodromiJSON.get(i);
			    int id = Integer.parseInt(jsonobject.get("airportID").toString());
			    String name = (String) jsonobject.get("name");
			    String city = (String) jsonobject.get("city");
			    String country = (String) jsonobject.get("country");
			    double lati = Double.parseDouble(jsonobject.get("latitude").toString());
			    double longi = Double.parseDouble(jsonobject.get("longitude").toString());		    
			    String iata = (String) jsonobject.get("iata");
			    spisakAerodroma.add(new Airport(id, name, city, country, lati, longi, iata));
			}
			for (int i = 0; i < ruteJSON.size(); i++) {
				JSONObject jsonobject = (JSONObject) ruteJSON.get(i);
				String fromA = (String) jsonobject.get("fromAirport");
			    String toA = (String) jsonobject.get("toAirport");
			    spisakRuta.add(new Route(fromA, toA));
			}			
			for(Airport a: spisakAerodroma) {
				for(Route r: spisakRuta) {	
				if(a.getIata().equals(r.getFrom())) {
						a.dodajRutu(r);
					}
				}
			}
			String iataOd = args[2];
			String iataDo = args[3];
			Airport bgd=null;
			Airport fra=null;
			Airport cdg=null;
			Airport lhr=null;
			Airport ams=null;
			Airport odAerodroma=null;
			Airport doAerodroma=null;
			String max = "";
			String temp = "";
			int min = Integer.MAX_VALUE;
			for(int i=0; i<spisakAerodroma.size(); i++) {
				if(spisakAerodroma.get(i).getIata().equals(iataOd)) {
					odAerodroma = spisakAerodroma.get(i);
				}
				if(spisakAerodroma.get(i).getIata().equals(iataDo)) {
					doAerodroma = spisakAerodroma.get(i);
				}
				if(spisakAerodroma.get(i).getIata().equals("BEG")){
					bgd = spisakAerodroma.get(i);
				}
				if(spisakAerodroma.get(i).getIata().equals("FRA")){
					fra = spisakAerodroma.get(i);
				}
				if(spisakAerodroma.get(i).getIata().equals("CDG")){
					cdg = spisakAerodroma.get(i);
				}
				if(spisakAerodroma.get(i).getIata().equals("LHR")){
					lhr = spisakAerodroma.get(i);
				}
				if(spisakAerodroma.get(i).getIata().equals("AMS")){
					ams = spisakAerodroma.get(i);
				}
			}
			if(odAerodroma == null || doAerodroma == null) {
				System.out.println("Aerodromi ne postoje");
				return;
			}
			String tekst = "";
			boolean postoji = false;
			for(int i=0; i<odAerodroma.getRute().size(); i++) {
				 if(odAerodroma.getRute().get(i).getTo().equals(iataDo)){
					 postoji = true;
					 tekst += odAerodroma.getCity() + " " + doAerodroma.getCity();
					 min = odAerodroma.distance(doAerodroma);
					 tekst += " " +   min;
				 }
			
			}
			if(postoji) {
			System.out.println(tekst);
			} else System.out.println("Putanja od " + args[2] + " do " + args[3] + " ne postoji");	
			
			Node nodeBEG= new Node("BEG");
			Node nodeFRA = new Node("FRA");
			Node nodeCDG = new Node("CDG");
			Node nodeLHR = new Node("LHR");
			Node nodeAMS = new Node("AMS");
			
			nodeBEG.addDestination(nodeFRA, bgd.distance(fra));
			nodeBEG.addDestination(nodeCDG, bgd.distance(cdg));
			nodeBEG.addDestination(nodeLHR, bgd.distance(lhr));
			nodeFRA.addDestination(nodeAMS, fra.distance(ams));
			nodeCDG.addDestination(nodeAMS, cdg.distance(ams));
			nodeLHR.addDestination(nodeAMS, lhr.distance(ams));
			
			Graph graph = new Graph();
			graph.addNode(nodeBEG);
			graph.addNode(nodeFRA);
			graph.addNode(nodeCDG);
			graph.addNode(nodeLHR);
			graph.addNode(nodeAMS);
			
		graph = Graph.calculateShortestPathFromSource(graph, nodeBEG);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
