package jsondomaci;

import java.util.ArrayList;

public class Airport {
private int id;
private String name;
private String city;
private String country;
private double lati;
private double longi;
private String iata;
private ArrayList<Route> rute;
public Airport(int id, String name, String city, String country, double lati, double longi, String iata) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.country = country;
	this.lati = lati;
	this.longi = longi;
	this.iata = iata;
	rute = new ArrayList<Route>();
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getCountry() {
	return country;
}
public double getLati() {
	return lati;
}
public double getLongi() {
	return longi;
}
public String getIata() {
	return iata;
}
public String getCity() {
	return city;
}
public ArrayList<Route> getRute() {
	return rute;
}
public void dodajRutu(Route r) {
	rute.add(r);
}
public int distance(Airport a) {
    double theta = longi - a.getLongi();
    double dist = Math.sin(deg2rad(lati)) * Math.sin(deg2rad(a.getLati())) + Math.cos(deg2rad(lati)) * Math.cos(deg2rad(a.getLati())) * Math.cos(deg2rad(theta));
    dist = Math.acos(dist);
    dist = rad2deg(dist);
    dist = dist * 60 * 1.1515;
    dist = dist * 1.609344;

    return (int)(dist);
  }

private double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
  }
private double rad2deg(double rad) {
    return (rad * 180.0 / Math.PI);
  }
@Override
public String toString() {
	return "Airport [id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + ", lati=" + lati
			+ ", longi=" + longi + ", iata=" + iata + ", rute=" + rute + "]";
}


}
