package logikoa;

public abstract class Kasilla {

	protected String balioa;
	protected boolean sakatuta;
	protected boolean markatuta;
	
	public Kasilla(){
		this.sakatuta=false;
		this.markatuta=false;
	}

	protected void ireki(){
		this.sakatuta=true;
	}
	
	public boolean irekita(){
		return sakatuta;
	}
	
	public boolean markatuta(){
		return markatuta;
	}
	
	public void markatu(){
		if (markatuta){
			markatuta=false;
		}
		else{
			markatuta=true;
		}
	}
	
	public String getBalioa(){
		return this.balioa;
	}
	
	public void sakatu(){
		this.sakatuta=true;
	}

}
