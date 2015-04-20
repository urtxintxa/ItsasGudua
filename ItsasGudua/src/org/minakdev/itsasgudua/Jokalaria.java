package org.minakdev.itsasgudua;

import java.util.Scanner;

public class Jokalaria {
	private Tableroa tablero;
	private boolean penalizazioa;
	private int minaIkutuak;
	private static int minaIkutuMaximo;
	private ListaItsasontziak itsasontziak;
	private static int txalupaMax;
	private static int ontziaMax;
	private static int itsaspekoMax;
	private String izena;
	
	Scanner sc = new Scanner(System.in);
	
	public Jokalaria(String pIzena){
		this.tablero=new Tableroa();
		this.penalizazioa=false;
		this.minaIkutuak=0;
		this.itsasontziak=new ListaItsasontziak();
		this.izena=pIzena;
	}

	public void tiroEgin(Jokalaria pAurkari){
		if(!this.penalizazioa){
			this.jokalariarenEgoeraInprimatu();
			pAurkari.partzialkiInprimatu();
			boolean ego=false;
			boolean beg=true;
			int pX=0;
			int pY=0;
			while(!ego || beg){
				pX=this.eskatuX();
				pY=this.eskatuY();
				if(this.tablero.koordenatuEgokiak(pX, pY)){
					beg=this.tablero.begiratutaDago(pX, pY);
					ego=true;
				}
				else{
					ego=false;
				}
			}
			this.tablero.setBegiratuta(pX,pY,true);
			boolean am=false;
			Itsasontzia it=this.tablero.itsasontzirikDago(pX,pY);
			if(it!=null){
				it.zatiaKendu();
				if(it.hondoratutaDago()){
					this.itsasontziak.kenduItsasontzia(it);
					if(this.itsasontziak.zenbatItsasontzi()==0){
						am=true;
					}
				}
				
			}
			if(!am){
				if(this.tablero.minarikDago(pX, pY)){
					this.penalizazioa=true;
					this.minaIkutuak++;
				}
				boolean de=false;
				if(this.minaMaxGainditua()){
					de=true;
				}
				if(!de){
					this.tablero.minakBoom(pX, pY, pAurkari);
				}
			}
		}
	}

	public void guztizInprimatu(){
		this.tablero.tableroOsoaInprimatu();
	}

	public void partzialkiInprimatu(){
		this.tablero.egungoTableroaInprimatu();
	}

	private int eskatuX(){
		return 0; //sartu zurea Eneko
	}

	private int eskatuY(){
		return 0; //sartu zurea Eneko
	}

	public void itsasontziaJarri(Itsasontzia pItsasontzia) {	
		int x= this.eskatuX();
		int y= this.eskatuY();
		char hB= this.eskatuHorizontalBertikal();
		int tamaina =pItsasontzia.getTamainaMax();
		boolean koordenatuZuzenak = this.koordenatuZuzenak(x, y, hB, tamaina);

		while (!koordenatuZuzenak) {
			System.out.println("Sartu dituzun koordenatuetan ezin da itsasontzia jarri. Saiatu berriz.");
			this.nireTableroaInprimatu();
			x = this.eskatuX();
			y = this.eskatuY();
			hB = this.eskatuHorizontalBertikal();
			koordenatuZuzenak = this.koordenatuZuzenak(x, y, hB, tamaina);
		}

		this.itsasontziak.gehituItsasontzia(pItsasontzia);
		this.tablero.itsasontziaJarri(x, y, tamaina, hB, pItsasontzia);

	}

	public boolean minaMaxGainditua() {
		boolean gainditua = false;
		if (this.minaIkutuak >= Jokalaria.minaIkutuMaximo) {
			gainditua = true;
		}
		return gainditua;
	}

	public void jokalariarenEgoeraInprimatu() {
		System.out.println(this.getIzena());
		System.out.println("Gelditzen zaizkizun itsasontziak:	"+ this.zenbatItsasontzi());
		System.out.println("Gelditzen zaizkizun bizitzak:	"+ (Jokalaria.minaIkutuMaximo-this.minaIkutuak) );
	}

	
	public String getIzena() {
		return this.izena;
	}

	
	private char eskatuHorizontalBertikal() {
		String s = null ;
		boolean zuzena = false;

		while (!zuzena) {
			System.out.println("Sartu H (horizontal) edo B (bertikal).");
			s = sc.next();
			if (s.equals("H") || s.equals("B")) {
				zuzena = true;
			} else {
				System.out.println(this.izena + " sartu duzuna ez da egokia.");

			}
		}

		return s.charAt(0);
	}

	protected boolean koordenatuZuzenak(int pX, int pY, char pHorBer,
			int pTamaina) {
		boolean zuzena = true;
		int i = 0;

		if (pHorBer == 'B') {
			while (i < pTamaina && zuzena) {
				if (this.tablero.koordenatuEgokiak(pX+i, pY)) {
					if (this.tablero.itsasontzirikDago(pX+i, pY) != null) {
						zuzena = false;
					}
					i++;
				} 
				else {
					zuzena = false;
				}
			}

		}

		else { 
			if(pHorBer=='H'){
				while (i < pTamaina && zuzena) {
					if (this.tablero.koordenatuEgokiak(pX, pY+i)) {
						if (this.tablero.itsasontzirikDago(pX, pY+i) != null) {
							zuzena = false;
						}
						i++;
					} 
					else {
						zuzena = false;
					}
				}
			}
		}

		return zuzena;
	}

	public void tableroaPrestatu() {
		int i = 0;
		Itsasontzia its;

		while (i < Jokalaria.itsaspekoMax) {
			System.out.println("Urpekaria jarri.");
			its = new Itsaspekoa();
			this.itsasontziaJarri(its);
			i++;
		}
		i = 0;
		while (i < Jokalaria.ontziaMax) {
			System.out.println("Ontzia jarri.");
			its = new Ontzia();
			this.itsasontziaJarri(its);
			i++;
		}
		i = 0;

		while (i < Jokalaria.txalupaMax) {
			System.out.println("Txalupa jarri.");
			its = new Txalupa();
			this.itsasontziaJarri(its);
			i++;
		}

		this.tablero.minakJarri();
	}
	
	
	public int zenbatItsasontzi(){
		return this.itsasontziak.zenbatItsasontzi();
	}

	//Hemendik aurrera herentziarako
	public ListaItsasontziak getListaItsasontziak(){
		return this.itsasontziak;
	}
	
	
	public Tableroa getTableroa(){
		return this.tablero;
	}
	
	public void setPenalizazioa(boolean pPenalizazioa){
		this.penalizazioa=pPenalizazioa;
	}
	
	public boolean getPenalizazioa(){
		return this.penalizazioa;
	}
	
	public void minaIkutuakHanditu(){
		this.minaIkutuak++;
	}
}
