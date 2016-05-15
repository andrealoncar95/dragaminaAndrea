package logikoa;

public class Zuri extends Kasilla {

	public Zuri(){
		super();
		this.balioa=" ";
	}

	public void ireki(int z, int l){
		if (z>=0 && z<Jokoa.getNireJokoa().getzutabeak() && l>=0 && l<Jokoa.getNireJokoa().getlerroak()){
			this.sakatuta=true;
			Jokoa.getNireJokoa().ireki(z, l);}
	}
}

