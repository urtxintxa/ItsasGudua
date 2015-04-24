package org.minakdev.itsasgudua;

public class Laukia {
	
	private boolean begiratuta = false;
	private Itsasontzia itsasontzia = null;
	private boolean mina = false;
	
	public Laukia() {}
	
	public void osoaInprimatu() {
		if(this.mina) {
			if(this.begiratuta) {
				System.out.print("☠"); //mina boom
			}
			else {
				System.out.print("☣"); //mina 
			}
		}
		else if(this.itsasontzia != null) {
			if(this.begiratuta) {
				System.out.print("✝"); //itsasontzi hondoratua
			}
			else {
				System.out.printf("⏅"); //itsasontzia
			}
		}
		else {
			if(this.begiratuta){
				System.out.print("~"); // ur ikusia
			}
			else {
				System.out.print("≈"); //ur ez ikusia 
			}
		}
	}
	
	public void egungoaInprimatu() {
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
				System.out.print("≈"); //ura
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
