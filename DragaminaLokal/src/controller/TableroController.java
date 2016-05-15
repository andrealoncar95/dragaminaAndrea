package controller;

import logikoa.Jokalaria;
import logikoa.Jokoa;

public class TableroController {

	private static TableroController instantzia=new TableroController();
	private Jokalaria j;

	private TableroController(){
	}

	public static TableroController getTableroController(){
		return instantzia;
	}

	public void tableroaHasieratu(int zail){
		Jokoa.getNireJokoa().hasieratu(zail);
		Jokoa.getNireJokoa().zuriuneakBete();
		Jokoa.getNireJokoa().bonbaJarri();
		Jokoa.getNireJokoa().zenbakiakJarri();
		Jokoa.getNireJokoa().kronometroaHasi();
	}

	public int getZutabeak(){
		return Jokoa.getNireJokoa().getzutabeak();
	}

	public int getLerroak(){
		return Jokoa.getNireJokoa().getlerroak();
	}

	public String getText(int z, int l) {
		return Jokoa.getNireJokoa().getText(z, l);
	}
	
	public int getBonbak(){
		return Jokoa.getNireJokoa().getBonbak();
	}


}
