package logikoa;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;



public class Ranking {

	private ArrayList<Jokalaria> ranking;
	private static Ranking nRanking=new Ranking();
	private Data myData=new Data();
	
	private Ranking(){
		ranking = new ArrayList<Jokalaria>();	
	}
	
	public static Ranking getRanking(){
		return nRanking;
	}
	
	public Iterator<Jokalaria> getIterator(){
		return ranking.iterator();
	}
	
	public void rankingSortu(){
		String query= "SELECT izena,denbora FROM jokalariak order by denbora;";
		Jokalaria j= null;
		try{
			ResultSet res= myData.executeQuery(query);
			while (res.next()){
				j= new Jokalaria(res.getString("izena"), res.getString("denbora"));
				ranking.add(j);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	
	public String rankinaBueltatu() {
		Iterator<Jokalaria> i = getIterator();
		int k=1;
		Jokalaria j= null;
		String emaitza="Posizioa		Izena		Denbora\r\n";
		while(i.hasNext() && k<=10){
			j=i.next();
			emaitza=emaitza+ k+"		" + j.getIzena() + "		" + j.getDenbora() + "\r\n";	
			k++;
		}
		return emaitza;
	}

}
