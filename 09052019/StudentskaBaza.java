package sqljavadomaci;

import java.sql.*;


public class StudentskaBaza {

	String connectionString;
	Connection con;
	
	public StudentskaBaza(String conStr) {
		connectionString=conStr;
	}
	
	public void connect() {
		try {
			con=DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dodajStudenta(int index, String ime, String prezime,
			String datumUpisa, String datumRodjenja, String mestoRodjenja) {
	try {
		PreparedStatement ps=con.prepareStatement("INSERT INTO dosije VALUES (?,?,?,?,?,?)");
		ps.setInt(1, 20140021);
		ps.setString(2,"Milos");
		ps.setString(3, "Peric");
		ps.setString(4, "06.07.2014.");
		ps.setString(5, "20.01.1995.");
		ps.setString(6, "Beograd");
		ps.execute();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void izbrisatiIspite() {
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM ispit WHERE Ispit.ocena<5 AND Ispit.ocena>10");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		try {
			if(con!=null && con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
