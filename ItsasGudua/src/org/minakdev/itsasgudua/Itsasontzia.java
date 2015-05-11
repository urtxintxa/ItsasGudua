package org.minakdev.itsasgudua;

public class Itsasontzia {

	//atributu
	private boolean antiMina;
	private int hondoratuGabekoZatiKop;
	private static int txalupaTamaina = 2;
	private static int urpekariaTamaina = 3;
	private static int ontziaTamaina = 4;
	
	
	public Itsasontzia(int pEzHondoratu, boolean pAntiMina){
		this.antiMina=pAntiMina;
		this.hondoratuGabekoZatiKop= pEzHondoratu;
	}
	public static int getTxalupaTamaina() {
		return txalupaTamaina;
	}

	public static int getOntziaTamaina() {
		return ontziaTamaina;
	}

	public static int getUrpekariaTamaina() {
		return urpekariaTamaina;
	}
	
	public static void setTxalupaTamaina(int pTamaina) {
		txalupaTamaina = pTamaina;
	}

	public static void setOntziaTamaina(int pTamaina) {
		ontziaTamaina = pTamaina;
	}

	public static void setUrpekariaTamaina(int pTamaina) {
		urpekariaTamaina = pTamaina;
	}
	
	public int getHondoratuGabekoZatiKop() {
		return hondoratuGabekoZatiKop;
	}


	

	public boolean hondoratutaDago(){
		boolean emaitza=false;
		if (this.hondoratuGabekoZatiKop==0){
			emaitza=true;
		}
		return emaitza;
	}
		
	public boolean getAntiMina(){
		return this.antiMina;
	}
	
	public void kenduZatia(){
		this.hondoratuGabekoZatiKop--;
	}

}
