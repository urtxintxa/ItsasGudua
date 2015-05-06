package org.minakdev.itsasgudua;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Jokalaria {
	private Tableroa tablero;
	private boolean penalizazioa;
	private int minaIkutuak;
	private static int minaIkutuMaximo = 3;
	private ListaItsasontziak itsasontziak;
	private static int txalupaMax = 3;
	private static int itsaspekoMax = 2;
	private static int ontziaMax = 1;
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
			System.out.println("\n"+this.izena+" zure txanda da.");
			this.jokalariarenEgoeraInprimatu();
			pAurkari.jokalariarenEgoeraInprimatu();
			pAurkari.partzialkiInprimatu();
			boolean egokia = false;
			boolean begiratuta = true;
			int pX = 0;
			int pY = 0;
			while(!egokia || begiratuta){
				pX=this.eskatuX();
				pY=this.eskatuY();
				if(pAurkari.tablero.koordenatuEgokiak(pX, pY)){
					begiratuta=pAurkari.tablero.begiratutaDago(pX, pY);
					egokia=true;
				}
				else{
					egokia=false;
				}
			}
			pAurkari.tablero.setBegiratuta(pX,pY,true);
			boolean amaitu=false;
			Itsasontzia it=pAurkari.tablero.itsasontzirikDago(pX,pY);
			if(it!=null){
				it.kenduZatia();
				if(it.hondoratutaDago()){
					pAurkari.itsasontziak.kenduItsasontzia(it);
					if(pAurkari.itsasontziak.zenbatItsasontzi()==0){
						amaitu=true;
					}
				}
				if (!amaitu){this.tiroEgin(pAurkari);}
			}
			else {
				if(pAurkari.tablero.minarikDago(pX, pY)){
					this.penalizazioa = true;
					this.minaIkutuak++;
					this.leherketaSoinua();
					if(!this.minaMaxGainditua()) {
						pAurkari.tablero.minakBoom(pX, pY, pAurkari);
					}
				}
			}
		}
		else {
			System.out.println(this.izena + " ezin duzu jokatu, penalizazioa duzu.");
			this.penalizazioa = false;
		}
	}

	public void guztizInprimatu() {
		this.tablero.tableroOsoaInprimatu();
	}

	public void partzialkiInprimatu() {
		this.tablero.egungoTableroaInprimatu();
	}

	private int eskatuX() {
		boolean ezAmaitu = true;
		int n = 0;
		do {
			try {
				System.out.println("\nSartu X koordenatua, 0 eta "+(Tableroa.getTamaina()-1)+" artekoa (biak barne): ");
				n = sc.nextInt();	
				if(n > (Tableroa.getTamaina()-1) || n < 0){
					throw new TartetikKanpoException("Zenbakiak ez daude tartean.");
				}
				ezAmaitu = false;
			} catch (InputMismatchException e) {
				sc.nextLine();
				n = 0;
				System.out.println("Ez duzu zenbaki oso bat sartu.");
			}catch (TartetikKanpoException e) {
				System.out.println(e.getMessage());
			}

			
		} while (ezAmaitu);
		return n;
	}

	private int eskatuY(){
		boolean ezAmaitu = true;
		int n = 0;
		do {
			try {
				System.out.println("\nSartu Y koordenatua, 0 eta "+(Tableroa.getTamaina()-1)+" artekoa (biak barne): ");
				n = sc.nextInt();	
				if(n > (Tableroa.getTamaina()-1) || n < 0){
					throw new TartetikKanpoException("Zenbakiak ez daude tartean.");
				}
				ezAmaitu = false;
			} catch (InputMismatchException e) {
				sc.nextLine();
				n = 0;
				System.out.println("Ez duzu zenbaki oso bat sartu.");
			}catch (TartetikKanpoException e) {
				System.out.println(e.getMessage());
			}

			
		} while (ezAmaitu);
		return n;
	}

	public void itsasontziaJarriEskuz(Itsasontzia pItsasontzia) {	
		this.guztizInprimatu();
		int x= this.eskatuX();
		int y= this.eskatuY();
		char hB= this.eskatuHorizontalBertikal();
		int tamaina =pItsasontzia.getHondoratuGabekoZatiKop();
		boolean koordenatuZuzenak = this.koordenatuZuzenak(x, y, hB, tamaina);

		while (!koordenatuZuzenak) {
			System.out.println("Sartu dituzun koordenatuetan ezin da itsasontzia jarri. Saiatu berriz.");
			this.guztizInprimatu();
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
		System.out.println();
		System.out.println(this.getIzena());
		System.out.println("Gelditzen zaizkizun itsasontziak:	"+ this.zenbatItsasontzi());
		System.out.println("Gelditzen zaizkizun bizitzak:	    "+ (Jokalaria.minaIkutuMaximo-this.minaIkutuak) );
	}
	
	public String getIzena() {
		return this.izena;
	}
	
	private char eskatuHorizontalBertikal() {
		String s = null ;
		boolean zuzena = false;

		while (!zuzena) {
			System.out.println("\nSartu H (horizontal) edo B (bertikal).");
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

	public void tableroaPrestatuEskuz() {
		int txalupaKop = 0;
		int urpekariKop = 0;
		int ontziKop = 0;
		
		int txalupaTamaina = Itsasontzia.getTxalupaTamaina();
		int urpekariTamaina = Itsasontzia.getUrpekariaTamaina();
		int ontziTamaina = Itsasontzia.getOntziaTamaina();
		Itsasontzia its;
		boolean atera = false;
		
		do {
			int ontziMota= this.hautatuItsasontzia(txalupaKop, urpekariKop, ontziKop);
			if(ontziMota==1){
				if(Jokalaria.txalupaMax-txalupaKop!=0){
					its = new Itsasontzia(txalupaTamaina, false);
					txalupaKop++;
					this.itsasontziaJarriEskuz(its);
				}
				else{
					System.out.println("Txalupa guztiak jarrita daude.");
					System.out.println("Aukeratu beste itsasontzi mota bat.");
				}
			}
			else{
				if(ontziMota==2){
					if(Jokalaria.itsaspekoMax-urpekariKop!=0){
						its=new Itsasontzia(urpekariTamaina, true);
						urpekariKop++;
						this.itsasontziaJarriEskuz(its);
					}
					else{
						System.out.println("Itsaspeko guztiak jarrita daude.");
						System.out.println("Aukeratu beste itsasontzi mota bat.");
					}
				}
			
				else{
					if(ontziMota==3){
						if(Jokalaria.ontziaMax-ontziKop!=0){
							its= new Itsasontzia(ontziTamaina, false);
							ontziKop++;
							this.itsasontziaJarriEskuz(its);
						}
						else{
							System.out.println("Ontzi guztiak jarrita daude.");
							System.out.println("Aukeratu beste itsasontzi mota bat.");
						}
					}
				}
			}
			if(Jokalaria.txalupaMax==txalupaKop && Jokalaria.itsaspekoMax==urpekariKop && Jokalaria.ontziaMax==ontziKop){
				atera=true;
			}
		} while (!atera);
		this.tablero.minakJarri();
	}
	
	private int hautatuItsasontzia(int pTxalupaKop, int pUrpekariKop, int pOntziKop) {
		System.out.println("\nAukeratu jarri nahi duzun ontzia.");
		System.out.println("1 - Txalupa ("+(txalupaMax-pTxalupaKop)+" gelditzen zaizkizu ipintzeko)");
		System.out.println("2 - Urpekaria ("+(itsaspekoMax-pUrpekariKop)+" gelditzen zaizkizu ipintzeko)");
		System.out.println("3 - Ontzia ("+(ontziaMax-pOntziKop)+" gelditzen zaizkizu ipintzeko)");
		System.out.println("\nSartu itsasontziaren kodea: ");
		
		int itsasontzia = 0;
		boolean ezAmaitu = true;
		do {
			try {
				itsasontzia = sc.nextInt();
				if(itsasontzia < 1 || itsasontzia > 3) {
					throw new TartetikKanpoException("Sartutako zenbakia ez da zuzena.");
				}
				ezAmaitu = false;
			} catch (InputMismatchException e) {
				sc.nextLine();
				itsasontzia = 0;
				System.out.println("Ez duzu zenbakirik sartu.");
			} catch (TartetikKanpoException e) {
				System.out.println(e.getMessage());
			}
		} while (ezAmaitu);	
		return itsasontzia;
	}
	
	
	public int zenbatItsasontzi(){
		return this.itsasontziak.zenbatItsasontzi();
	}


	public ListaItsasontziak getListaItsasontziak(){
		return this.itsasontziak;
	}
	
	public void itsasontziaJarriAutomatico(Itsasontzia pItsasontzia){
    	int x=this.lortuXY();
    	int y=this.lortuXY();
    	char horBer=this.lortuHorBer();
    	int tamaina= pItsasontzia.getHondoratuGabekoZatiKop();
    	boolean koordenatuZuzenak = this.koordenatuZuzenak(x, y, horBer, tamaina);
    	
    	while(!koordenatuZuzenak){
    		x=this.lortuXY();
        	y=this.lortuXY();
        	horBer=this.lortuHorBer();
        	koordenatuZuzenak = this.koordenatuZuzenak(x, y, horBer, tamaina);
    	}
    	
    	this.itsasontziak.gehituItsasontzia(pItsasontzia);
    	this.tablero.itsasontziaJarri(x, y, tamaina, horBer, pItsasontzia);
    	
    }
	
	
	private int lortuXY(){
    	int xy = (int)(Math.random()*(Tableroa.getTamaina()+1));
    	return xy;
    }
	
	
	public void tableroaPrestatuAutomatiko() {
		int i = 0;
		Itsasontzia its;

		while (i < Jokalaria.itsaspekoMax) {
			its = new Itsasontzia(Itsasontzia.getUrpekariaTamaina(), true);
			this.itsasontziaJarriAutomatico(its);
			i++;
		}
		i = 0;
		while (i < Jokalaria.ontziaMax) {
			its = new Itsasontzia(Itsasontzia.getOntziaTamaina(), false);
			this.itsasontziaJarriAutomatico(its);
			i++;
		}
		i = 0;

		while (i < Jokalaria.txalupaMax) {
			its = new Itsasontzia(Itsasontzia.getTxalupaTamaina(), false);
			this.itsasontziaJarriAutomatico(its);
			i++;
		}
		this.guztizInprimatu();
		this.tablero.minakJarri();
		
	}

	
	public void tableroaPrestatu(){
		boolean amaitu=false;
		int aukera=0;
		
		do{
				aukera=this.tableroaJartzekoModuaHautatu();
				if(aukera == 1){
					this.tableroaPrestatuAutomatiko();
				}
				else{
					if(aukera == 2){
						this.tableroaPrestatuEskuz();
					}
				}
				System.out.println("\nTableroa ondo dago?    B/E");
				char baiEz=this.baiEz();
				if(baiEz == 'B'){
					amaitu=true;
				}
				else{
					this.tablero = new Tableroa();
					this.itsasontziak = new ListaItsasontziak();
				}
			
			
		}while(!amaitu);
		
	}
	
	private int tableroaJartzekoModuaHautatu(){
		boolean amaitu=false;
		int aukera=0;
		do{
			try{
				System.out.println("\nTableroa jartzeko modua aukeratu: ");
				System.out.println("1 - Automatiko");
				System.out.println("2 - Eskuz");
				aukera = sc.nextInt();
				if (aukera!=1 && aukera!=2 ){
					throw new TartetikKanpoException("Sartutako zenbakia ez da zuzena.");
				}
				amaitu=true;
			}
			catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Ez duzu zenbakirik sartu.");
			}
			catch (TartetikKanpoException e) {
				System.out.println(e.getMessage());
			}
			
		}while(!amaitu);
		
		return aukera;
	}
	
	private char baiEz(){
		String s = null ;
		boolean zuzena = false;

		while (!zuzena) {
			s = sc.next();
			if (s.equals("E") || s.equals("B")) {
				zuzena = true;
			} else {
				System.out.println("Sartu duzuna ez da egokia.");
				System.out.println("Sartu berriz");

			}
		}

		return s.charAt(0);
		
	}
	
	private char lortuHorBer(){
		int a = (int)(Math.random()*(2));
		if(a==0) {return 'H';}
		else{return 'B';}
	}
	
	private void leherketaSoinua() {
		try {
			Clip leherketa = AudioSystem.getClip();
			File fitxategia = new File("Soinuak/leherketa.wav");
			leherketa.open(AudioSystem.getAudioInputStream(fitxategia));
			leherketa.start();
			Thread.sleep(1000);
			leherketa.close();
		}
		catch (Exception e) {}
	}
	
	//Hemendik aurrera herentziarako
	/*public Tableroa getTableroa(){
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
	}*/
}
