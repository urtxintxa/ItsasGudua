package org.minakdev.itsasgudua;

public class Itsasontzia {

	//atributu
	private boolean antiMina;
	private int hondoratuGabekoZatiKop;
	private static int txalupaTamaina = 2;
	private static int urpekariaTamaina = 3;
	private static int ontziaTamaina = 4;
	
	public static int getTxalupaTamaina() {
		return txalupaTamaina;
	}

	public static int getOntziaTamaina() {
		return ontziaTamaina;
	}

	public static int getUrpekariaTamaina() {
		return urpekariaTamaina;
	}

	//eraikitzaile
	public Itsasontzia(int pEzHondoratu, boolean pAntiMina){
		this.antiMina=pAntiMina;
		this.hondoratuGabekoZatiKop= pEzHondoratu;
	}
	
	//gainontzeko metodoak
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
	
	public void kenduZatia(){//0 edo negatibo ez dela badakigu?
		this.hondoratuGabekoZatiKop--;
	}

}
