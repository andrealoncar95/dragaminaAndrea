package logikoa;

public class Jokoa {


	private int zutabeak;
	private int lerroak;
	private  Kasilla [][] arraya;
	private int bonbaKop;
	private Stopwatch erlojua;
	private static Jokoa nireJokoa= new Jokoa();
	private Jokalaria jokalaria;

	private Jokoa() {
	}

	public void hasieratu(int zailtasuna){
		if (zailtasuna==1){
			this.zutabeak=8;
			this.lerroak=8;
			this.bonbaKop=10;
		}
		else if (zailtasuna==2){
			this.zutabeak=16;
			this.lerroak=16;
			this.bonbaKop=40;
		}
		else if (zailtasuna==3){
			this.zutabeak=30;
			this.lerroak=16;
			this.bonbaKop=99;
		}
		this.arraya=new Kasilla [zutabeak][lerroak];
	}

	public static Jokoa getNireJokoa(){
		return nireJokoa;
	}

	public int getzutabeak (){
		return zutabeak;
	}

	public int getlerroak (){
		return lerroak;
	}

	public int getBonbak(){
		return bonbaKop;
	}


	public void bonbaJarri(){
		double i=0;
		double z=0;
		int kopurua = 0;
		do  {
			i=Math.random()*getzutabeak();
			z=Math.random()*getlerroak();
			i=(int)i;
			z=(int)z;
			if  (z!=0 && i!=0 && z!=lerroak-1 && i!=zutabeak-1&& arraya[(int)i][(int) z].getBalioa()!="B"){
				arraya[(int)i][(int) z ]=new Bonba();
				kopurua++;
			}
		}
		while (bonbaKop != kopurua);
	}


	public void zenbakiakJarri() {
		for (int i=0; i < zutabeak; i++){
			for (int z=0; z < lerroak ; z++){
				int laukizenbakia = 0;
				if (arraya[i][z].getBalioa()!="B"){
					if (z-1 >= 0 && i >= 0 && z-1 < lerroak-1 && i < zutabeak-1&&arraya[i][z-1].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z-1 >= 0 && i-1 >= 0 && z-1 < lerroak-1 && i-1 < zutabeak-1&&arraya[i-1][z-1].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z-1 >= 0 && i+1 >= 0 && z-1 < lerroak-1 && i+1 < zutabeak-1&&arraya[i+1][z-1].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z+1 >= 0 && i >= 0 && z+1 < lerroak-1 && i < zutabeak-1&&arraya[i][z+1].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z+1 >= 0 && i+1 >= 0 && z+1 < lerroak-1 && i+1 < zutabeak-1&&arraya[i+1][z+1].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z+1 >= 0 && i-1 >= 0 && z+1 < lerroak-1 && i-1 < zutabeak-1&&arraya[i-1][z+1].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z >= 0 && i+1 >= 0 && z < lerroak-1 && i+1 < zutabeak-1&&arraya[i+1][z].getBalioa()== "B"){
						laukizenbakia++;
					}
					if (z >= 0 && i-1 >= 0 && z < lerroak-1 && i-1 < zutabeak-1&&arraya[i-1][z].getBalioa()== "B"){
						laukizenbakia++;
					}	
					if (laukizenbakia != 0){
						arraya[i][z]=new Zenbaki(String.valueOf(laukizenbakia));
					}
				}
			}
		}
	}

	public String getText(int z, int l) {
		return arraya[z][l].getBalioa();
	}
	
	public String getMarka(int z,int l){
		if (!arraya[z][l].markatuta()){
			return "M";
		}
		else
			return " ";
	}

	public void jokoaBukatu() {
		for(int z=0; z<getzutabeak();z++){
			for(int l=0; l < getlerroak(); l++){
				arraya[z][l].sakatu();
			}
		}
	}

	public void ireki(int z, int l){
		if (!arraya[z][l].irekita()&&!arraya[z][l].markatuta()){
			if(arraya[z][l].getBalioa()==" "){
				Zuri zuria= (Zuri) arraya[z][l];
				zuria.ireki(z-1,l-1);
				zuria.ireki(z,l-1);
				zuria.ireki(z+1,l-1);
				zuria.ireki(z-1,l);
				zuria.ireki(z+1,l);
				zuria.ireki(z-1,l+1);
				zuria.ireki(z,l+1);
				zuria.ireki(z+1,l+1);
			}
			else{
				arraya[z][l].ireki();
			}
		}
	}

	public void markatu(int z, int l){
		if (!arraya[z][l].irekita()){
			arraya[z][l].markatu();
		}
	}

	public boolean markatuta(int z,int l){
		return arraya[z][l].markatuta();
	}

	public boolean sakatuta(int z,int l){
		return arraya[z][l].irekita();
	}

	public void zuriuneakBete(){
		for(int z=0; z < getzutabeak(); z++){
			for(int l=0; l < getlerroak(); l++){
				if (arraya[z][l]==null){
					arraya[z][l]= new Zuri();
				}
			}
		}
	}


	public boolean irabazi() {
		boolean irabazi=false;
		int sakatuak=0;
		for(int z=0; z<getzutabeak();z++){
			for(int l=0; l < getlerroak(); l++){
				if (!arraya[z][l].irekita()){
					sakatuak++;
				}
			}
		}
		if (sakatuak==this.bonbaKop){
			irabazi=true;
			double denbora=kronometroaGelditu();
			int minutuak=(int)denbora/60;
			int segunduak=(int) denbora%60;
			String puntuazioa= Integer.toString(minutuak)+":"+Integer.toString(segunduak);
			if (!jokalaria.jokalariaDago(jokalaria.getIzena())){
				jokalaria.jokalariaSartu(jokalaria.getIzena(), puntuazioa);
			}else{
				jokalaria.denboraEguneratu(jokalaria.getIzena(), puntuazioa);
			}
			
		}
		return irabazi;
	}
	
	public void kronometroaHasi(){
		erlojua= new Stopwatch();
	}
	
	public double kronometroaGelditu(){
		return erlojua.elapsedTime();
	}
	
	public void jokalariaGehitu(String izena) {
		jokalaria=new Jokalaria(izena, "999:99");
		
	}
	
}
