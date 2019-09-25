package sqljavaFULL;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBProdavnica {
	

	public static String poslednjiLogovanKorisnik;
	java.sql.Date datum=new java.sql.Date(System.currentTimeMillis());
	
	String connectionString; 
	Connection con;       
	
	public DBProdavnica(String connectionString) {  
		super();
		this.connectionString = connectionString;
	}
	
	public void connect() {     
		
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  
	}
	
	public void disconect() {

		try {
			if(con!=null && con.isClosed()==false) { 
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean logujSe() {
		System.out.println("Unesite vas username");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		System.out.println("Unesite vas password");
		String password = sc.next();
		
		String upit = "select * from Korisnik where username = ? and password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(upit);
			ps.setString(1, username);
			ps.setString(2,  password);
			
			ResultSet rs = ps.executeQuery();
			boolean postojiRed = rs.next();
			if(postojiRed==true) {
				poslednjiLogovanKorisnik=username;
			}
			
			return postojiRed;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean registracija() {
		Scanner sc=new Scanner(System.in);
		
			System.out.println("Unesite username: ");
			String username=sc.next();
			for(int i=0;i<username.length();i++) {
				if(username.charAt(i)==' ') {
					System.out.println("Username ne sme da ima space");
					return false;
				}
			}
			
			//proveriti da li taj username postoji u bazi
		     PreparedStatement ps;
			try {
				ps = con.prepareStatement("SELECT COUNT (*) FROM Korisnik "
				  		+ "WHERE Korisnik.Username=?");
				 ps.setString(1, username);
			      ResultSet rs=ps.executeQuery();
			      int brpojavljivanja=rs.getInt(1);
			      if(brpojavljivanja>0) {
			    	  System.out.println("Username vec postoji u bazi");
				      return false;
			      }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		     
		
		
		System.out.println("Unesite password: ");
		String password=sc.next();
		System.out.println("Unesite password ponovo: ");
		String password2=sc.next();	
		if(password.length()<5) {
			System.out.println("Password mora da ima najmanje 5 karaktera");
			return false;
		}
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)==' ') {
				System.out.println("Password ne sme da ima space");
				return false;
			}
		}
		if(!password.equals(password2)) {
			System.out.println("Lozinke nisu iste");
			return false;
		}
		
	 PreparedStatement ps2;
	try {
		ps2 = con.prepareStatement("INSERT INTO Korisnik (Username,Password)"
		  		+ "VALUES (?,?)");
		 ps2.setString(1, username);
		  ps2.setString(2, password);
		  ps2.execute();
				  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		return true;
	}
	
	public void ispisiAutomobile() {
		
		try {
			
			Statement stm = con.createStatement();
			String upit = "SELECT * FROM Automobil,Nabavka"
					+ " WHERE Automobil.idAuto=Nabavka.idAuto"
					+ " AND Nabavka.idAuto NOT IN (SELECT IdAuto FROM Prodaja)";
			ResultSet rs= stm.executeQuery(upit);
			while(rs.next()) {
				int i=rs.getInt(1);
			    int j= rs.getInt(2);
			    int a=rs.getInt(3);
			    int b=rs.getInt(4);
			    String s=rs.getString(5);
				System.out.println(i+ " "+ j + " "+a+" "+b+" "+s);
			}
			Scanner sc=new Scanner(System.in);
			System.out.println("Unesite id automobila koji zelite da kupite: ");
			int ida=sc.nextInt();
			
			PreparedStatement ps2=con.prepareStatement("INSERT INTO Prodaja(IdAuto,"
					+ "Username, Datum) VALUES(?,?,?)" );
			ps2.setInt(1, ida);
			ps2.setString(2, poslednjiLogovanKorisnik);
			ps2.setDate(3, datum);
			ps2.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ispisiAutomobileKojeJeKupioTrenutniKorisnik() {
		String upit = "SELECT m.Naziv, a.idAuto FROM Automobil a, Model m, Prodaja p"
				+ " WHERE a.idAuto = p.idAuto and a.idModel=m.idModel and p.username = ?";
		try {
			PreparedStatement ps = con.prepareStatement(upit);
			ps.setString(1, poslednjiLogovanKorisnik);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void uplatiNovac() {
		Scanner sc=new Scanner(System.in);
	    try {
	    	System.out.println("Odaberite za koji automobil zelite da uplatite novac: ");
			int idAuta=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("SELECT Automobil.Cena, "
					+ "Uplata.Iznos, SUM(Uplata.Iznos) FROM Automobil, Uplata"
					+ " WHERE Automobil.idAuto=Uplata.idAuto AND Automobil.idAuto=?");
			ps.setInt(1, idAuta);
			ResultSet rs=ps.executeQuery();
			
			double novac=rs.getDouble(1);
			System.out.println("Unesite koliko novca zelite da uplatite: ");
			double uplata=sc.nextDouble();
			while(uplata>novac) {
				System.out.println("Uneli ste vise novca nego sto je potrebno.");
				System.out.println("Unesite koliko novca zelite da uplatite: ");
				uplata=sc.nextDouble();
			}
			PreparedStatement ps2=con.prepareStatement("INSERT INTO Uplata "
					+ "VALUES (?,?,?,?)");
			ps2.setInt(1, idAuta);
			ps2.setDouble(2,uplata);
			ps2.setDate(3,datum);
			ps2.setInt(4, 5);
			ps.execute();
			
	        System.out.println("Uplata je izvrsena");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
	
