package logikoa;

import java.sql.ResultSet;

public class Jokalaria {
	
	private String izena;
	private String denbora;
	private Data myData = new Data();
	
	public Jokalaria(String pizena, String pDenbora){
		izena = pizena;
		denbora = pDenbora;
	}
	
	public void setIzena(String pizena){
		izena = pizena;
	}

	public String getIzena() {
		return izena;
	}

	public String getDenbora() {
		return denbora;
	}
	
	
	public boolean jokalariaDago(String pIzena) {
		String query= "SELECT izena FROM jokalariak where izena='"+pIzena+"';";
		try{
			ResultSet res= myData.executeQuery(query);
			return res.next();
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void denboraEguneratu(String pIzena, String denbora) {
		String query= "UPDATE jokalariak set denbora='"+denbora+"' where izena='"+pIzena+"';";
		try{
			myData.executeUpdate(query);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void jokalariaSartu(String pIzena, String denbora){
		String query= "INSERT into jokalariak values ('0','"+pIzena+"','"+denbora+"');";
		try{
			myData.executeUpdate(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
