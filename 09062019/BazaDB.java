package sqljavadomaci2;

import java.sql.*;

public class BazaDB {
	private String connectionString;
	private Connection con;

	public BazaDB(String conStr) {
		this.connectionString = conStr;
	}

	public void connect() {
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ispisFudbalera() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Fudbaler.Ime, Tim.Naziv" + "	FROM Fudbaler JOIN TIM using(IdTim)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Ime: " + rs.getString(1) + " Tim: " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fudbaleriManUTD() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Fudbaler.Ime, Tim.Naziv"
					+ "	FROM Fudbaler JOIN TIM using(IdTim)" + " WHERE Tim.Naziv = \"Manchester United\"");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Ime: " + rs.getString(1) + " Tim: " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fubalerGolovi() { 
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Ime, COUNT(IdGol)" + " FROM Fudbaler JOIN Gol using(IdFud)"
					+ " GROUP BY IdFud" + " ORDER BY COUNT(IdGol) DESC, IME ASC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Ime: " + rs.getString(1) + " Broj golova: " + rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fudbalerNajviseGolova() { 
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT Ime, count(IdGol)" 
							+ " FROM Fudbaler JOIN Gol using(IdFud)"
							+ " GROUP BY IdFud HAVING count(IdGol) IN (SELECT MAX(c)"
							+ "	FROM (SELECT count(IdGol) AS c"
							+ " FROM Fudbaler JOIN Gol using(IdFud)" 
							+ " GROUP by IdFud))"
							+ " ORDER BY Ime ASC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Ime: " + rs.getString(1) + " Broj golova: " + rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void kartoni() {
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT Ime, COUNT(case when TIP = \"crveni karton\" then 1 else null end), COUNT(case when TIP = \"zuti karton\" then 1 else null end)"
							+ " FROM Fudbaler JOIN Karton using(IdFud)" + " GROUP BY IdFud"
							+ " ORDER BY COUNT(case when TIP = \"crveni karton\" then 1 else null end) DESC, Ime ASC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Ime: " + rs.getString(1) + " Broj crvenih kartona: " + rs.getInt(2)
						+ " Broj zutih kartona: " + rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gradoviGdeJeFudbalerIgrao(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT DISTINCT Tim.mesto AS \"Gradovi u kojim je igrao\""
					+ " FROM  Fudbaler JOIN Tim  using(IdTim) JOIN Utakmica on (IdTim = IdDomacin)"
					+ " where IdFud = ?"
					+ " UNION"
					+ " SELECT Tim.Mesto"
					+ " From Tim"
					+ " WHERE IdTim in(SELECT IdDomacin"
					+ " FROM  Fudbaler JOIN Tim  using(IdTim) JOIN Utakmica on (IdGost = IdTim)"
					+ " where IdFud = ?)");
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Gradovi u kojim je igrao: " + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dodajFudbalera(String ime, String tim) {
		PreparedStatement max;
		try {
			max = con.prepareStatement("SELECT MAX(IdFud)" + " FROM Fudbaler");
			ResultSet rsmax = max.executeQuery();
			int idFudb = (rsmax.getInt(1) + 1);
			PreparedStatement ps = con.prepareStatement("INSERT INTO Fudbaler(IdFud, Ime, IdTim)"
					+ " VALUES(?, ?, ( SELECT IdTim from Tim" + " WHERE Tim.Naziv = ?))");
			ps.setInt(1, idFudb);
			ps.setString(2, ime);
			ps.setString(3, tim);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dodajTim(String ime, String mesto) {
		try {
			PreparedStatement maxps = con.prepareStatement("SELECT MAX(IdTim)" + " FROM Tim");
			ResultSet maxRs = maxps.executeQuery();
			int idTim = maxRs.getInt(1) + 1;
			PreparedStatement ps = con.prepareStatement("INSERT INTO TIM(IdTim, Naziv, Mesto)" + " VALUES(?,?,?)");
			ps.setInt(1, idTim);
			ps.setString(2, ime);
			ps.setString(3, mesto);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dodajUtakmicu(String domaci, String gost, int kolo, String ishod, int godina) {
		try {
			if (!ishod.equals("X") && !ishod.equals("1") && !ishod.equals("2")) {
				System.out.println("Ukucali ste los ishod(prihvata se X, 1 , 2)");
				return;
			}
			boolean imaGost = false;
			boolean imaDomacin = false;
			PreparedStatement naziv = con
					.prepareStatement("Select Naziv" + " FROM TIM" + " WHERE Naziv = ? OR Naziv = ?");
			naziv.setString(1, domaci);
			naziv.setString(2, gost);
			ResultSet provera = naziv.executeQuery();
			while (provera.next()) {
				if (provera.getString(1).equals(gost)) {
					imaGost = true;
				}
				if (provera.getString(1).equals(domaci)) {
					imaDomacin = true;
				}
			}
			if (!imaDomacin || !imaGost) {
				System.out.println("Jedan od timova koji ste ukucali ne postoji");
				return;
			}
		}
			catch(SQLException e) {
				
			}
		try {
			PreparedStatement koloCheck = con.prepareStatement("SELECT Naziv"
					+ " FROM Tim JOIN Utakmica on (IdTim = IdDomacin OR IdTim = IdGost)"
					+ " WHERE KOLO = ?");
			koloCheck.setInt(1, kolo);
			ResultSet rsKolo = koloCheck.executeQuery();
			boolean ima = false;
			while(rsKolo.next()) {
				if (rsKolo.getString(1).equals(domaci) || rsKolo.getString(1).equals(gost)) {
					ima = true;
				}
			}
			if (ima) {
				System.out.println("Tim ne moze da igra dva puta u istom kolu" );
				return;
			}
		} catch(SQLException e) {
			
		}
		try {
			PreparedStatement maxps = con.prepareStatement("SELECT MAX(IdUta)" + " FROM Utakmica");
			ResultSet maxRs = maxps.executeQuery();
			int idUta = maxRs.getInt(1) + 1;
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO Utakmica(IdUta, IdDomacin, IdGost, Kolo, Ishod, Godina)"
							+ " VALUES(?, (SELECT IdTim FROM Tim WHERE Naziv = ?), (SELECT IdTim FROM Tim WHERE Naziv = ?), ?, ?, ?)");
			ps.setInt(1, idUta);
			ps.setString(2, domaci);
			ps.setString(3, gost);
			ps.setInt(4, kolo);
			ps.setString(5, ishod);
			ps.setInt(6, godina);
			ps.executeUpdate();
			PreparedStatement psUtakmice = con.prepareStatement("INSERT INTO IGRAO(idFud,idUta, PozicijaIgraca)"
					+ " SELECT IdFud, IdUta, null"
					+ " FROM Fudbaler JOIN Tim  using(IdTim) JOIN Utakmica on (IdTim = IdDomacin OR IdTim = IdGost)"
					+ " WHERE IdUta = ?");
			psUtakmice.setInt(1, idUta);
			psUtakmice.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void obrisiTim(String ime) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT Naziv"
					+ " FROM Tim");
			ResultSet rs = ps.executeQuery();
			boolean postoji = false;
			while(rs.next()) {
				if(ime.equals(rs.getString(1))) {
					postoji = true;
				}
			}
			if(!postoji) {
				System.out.println("Tim koji ste ukucali ne postoji");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		 try {
			ps = con.prepareStatement("DELETE FROM Utakmica"
					+ " WHERE IdDomacin in (SELECT IdTim FROM Tim WHERE Tim.Naziv = ?) OR IdGost in (SELECT IdTim FROM Tim WHERE Tim.Naziv = ?)");
			ps.setString(1, ime);
			ps.setString(2, ime);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			ps = con.prepareStatement("DELETE FROM Igrao"
					+ " WHERE IdFud IN (SELECT IdFud FROM Fudbaler WHERE IdTim IN (SELECT IdTim FROM Tim WHERE Naziv = ?))");
			ps.setString(1, ime);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			ps = con.prepareStatement("DELETE FROM Gol"
					+ " WHERE IdFud IN (SELECT IdFud FROM Fudbaler WHERE IdTim IN (SELECT IdTim FROM Tim WHERE Naziv = ?))");
			ps.setString(1, ime);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			ps = con.prepareStatement("DELETE FROM Karton"
					+ " WHERE IdFud IN (SELECT IdFud FROM Fudbaler WHERE IdTim IN (SELECT IdTim FROM Tim WHERE Naziv = ?))");
			ps.setString(1, ime);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			ps = con.prepareStatement("DELETE FROM Fudbaler"
					+ " WHERE IdTim IN (SELECT IdTim FROM Tim WHERE Naziv = ?)");
			ps.setString(1, ime);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			ps = con.prepareStatement("DELETE FROM Tim"
					+ " WHERE Tim.naziv = ?");
			ps.setString(1, ime);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
