package org.minakdev.itsasgudua;

public class Laukia {
	
	private boolean begiratuta = false;
	private Itsasontzia itsasontzia = false; 
	private boolean mina = false;//6666
	
	public Laukia() {}
	
	public void nireaInprimatu() {
		if(this.mina) {
			if(this.begiratuta) {
				System.out.print("â˜ "); //mina boooom
			}
			else {
				System.out.println("â˜£"); //mina 
			}
		}
		else if(this.itsasontzia != null) {
			System.out.print("â�…");
		}
		else {
			System.out.print("~"); // ura
		}
	}
	
	public void aurkariarenaInprimatu() {
		if(!this.begiratuta) {
			System.out.print("Â·");
		}
		else {
			if(this.mina) {
				System.out.print("â˜ "); //mina boooom
			}
			else if(this.itsasontzia != null) {
				System.out.print("âœ�"); //itsasontzi hondoratua
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
