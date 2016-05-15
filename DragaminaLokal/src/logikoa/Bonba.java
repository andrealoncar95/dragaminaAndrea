package logikoa;

public class Bonba extends Kasilla {

	public Bonba(){
		super();
		this.balioa="B";
		
	}
	
	public void ireki(){
		Jokoa.getNireJokoa().jokoaBukatu();
	}

}
