package org.minakdev.itsasgudua;

public class Laukia {
	
	private boolean begiratuta = false;
	private Itsasontzia itsasontzia = false; 
	//lol
	private boolean mina = false;
	
	public Laukia() {}
	
	public void nireaInprimatu() {
		if(this.mina) {
			if(this.begiratuta) {
				System.out.print("☠"); //mina boooom
			}
			else {
				System.out.println("☣"); //mina 
			}
		}
		else if(this.itsasontzia != null) {
			System.out.print("⏅");
		}
		else {
			System.out.print("~"); // ura
		}
	}
	
	public void aurkariarenaInprimatu() {
		if(!this.begiratuta) {
			System.out.print("·");
		}
		else {
			if(this.mina) {
				System.out.print("☠"); //mina boooom
			}
			else if(this.itsasontzia != null) {
				System.out.print("✝"); //itsasontzi hondoratua
			}
			else {
				System.out.print("~"); //ura
			}
		}
	}
	
	public boolean getBegiratuta() {
		return this.begiratuta;
	}
	
	public Itsasontzia getItsasontzia() {
		return this.itsasontzia;
	}
	
	public boolean getMina() {
		return this.mina;
	}
	
	public void setBegiratuta(boolean pBegiratuta) {
		this.begiratuta = pBegiratuta;
	}
	
	public void setItsasontzia(Itsasontzia pItsasontzia) {
		this.itsasontzia = pItsasontzia;
	}
	
	public void setMina(boolean pMina) {
		this.mina = pMina;
	}

}
