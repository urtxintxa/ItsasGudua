package org.minakdev.itsasgudua;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Jokoa {
	
	private Jokalaria[] jokalariak;
	private int txanda;
	private static Jokoa nireJokoa = null;
	
	public static String leherketaSoinua = "soinuak/minaLeherketa.wav";
	public static String itsasontziaJo = "soinuak/itsasontziaJo.wav";
	
	private static Scanner sc = new Scanner(System.in);
	
	private Jokoa() {
		this.jokalariak= new Jokalaria[2];
    	this.txanda=0;
	}

	public static synchronized Jokoa getNireJokoa() {
		if(nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	
	public static void main(String[] args) {
		nireJokoa = Jokoa.getNireJokoa();
		
		System.out.println("Ongi etorri Itsas Gudua jokora :D");
		System.out.println();
		System.out.println("Jolasteko 1 zenbakia sakatu.");
		System.out.println("Irteteko 0 zenbakia sakatu.");
		
		int aukera = 0;
		boolean ezAmaitu = true;
		do {
			try {
				System.out.println("\nAukeratu 0 edo 1: ");
				aukera = sc.nextInt();	
				if(aukera > 1 || aukera < 0){
					throw new TartetikKanpoException("0 edo 1 aukeratu behar duzu.");
				}
				ezAmaitu = false;
			} catch (InputMismatchException e) {
				sc.nextLine();
				aukera = 0;
				System.out.println("0 edo 1 aukeratu behar duzu.");
			}catch (TartetikKanpoException e) {
				System.out.println(e.getMessage());
			}
		} while (ezAmaitu);
		
		if(aukera == 1){
			int jokatzekoModua = nireJokoa.jokatzekoModuaEskatu();
			if( jokatzekoModua == 1){
				nireJokoa.partidaBatJolastu();
			}
			else if(jokatzekoModua == 2){
				nireJokoa.partidaBatJolastu1();
			}
			else{
				nireJokoa.partidaBatJolastu2();
			}
		}
		else {
			System.exit(0);
		}
	}
	
	private String izenaEskatu() {
		String izena = sc.next();
		return izena;
	}
	
	private void jokatzekoParametroakEskatu() {
		System.out.println("3 tablero mota dituzue:");
		System.out.println("	1 - 5x5koa");
		System.out.println("	2 - 8x8koa");
		System.out.println("	3 - 12x12koa");
		
		boolean ezAmaitu = true;
		int n = 0;
		do {
			try {
				System.out.println("\nAukeratu aukera bat: ");
				n = sc.nextInt();	
				if(n > 3 || n < 1){
					throw new TartetikKanpoException("Zenbakia ez dago tartean.");
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
		
		if(n == 1){
			Jokalaria.setItsaspekoMax(1);
			Jokalaria.setOntziaMax(1);
			Jokalaria.setTxalupaMax(2);
			Jokalaria.setMinaIkutuMaximo(1);
			
			Itsasontzia.setUrpekariaTamaina(2);
			Itsasontzia.setOntziaTamaina(3);
			Itsasontzia.setTxalupaTamaina(1);
			
			Tableroa.setTamaina(5);
			Tableroa.setMinakop(3);
		}
		else if(n == 2){
			Jokalaria.setItsaspekoMax(2);
			Jokalaria.setOntziaMax(1);
			Jokalaria.setTxalupaMax(3);
			Jokalaria.setMinaIkutuMaximo(3);
			
			Itsasontzia.setUrpekariaTamaina(3);
			Itsasontzia.setOntziaTamaina(4);
			Itsasontzia.setTxalupaTamaina(2);
			
			Tableroa.setTamaina(8);
			Tableroa.setMinakop(7);
		}
		else {
			Jokalaria.setItsaspekoMax(4);
			Jokalaria.setOntziaMax(2);
			Jokalaria.setTxalupaMax(5);
			Jokalaria.setMinaIkutuMaximo(7);
			
			Itsasontzia.setUrpekariaTamaina(4);
			Itsasontzia.setOntziaTamaina(5);
			Itsasontzia.setTxalupaTamaina(2);
			
			Tableroa.setTamaina(12);
			Tableroa.setMinakop(15);
		}
	}
	
	public int jokatzekoModuaEskatu() {
		System.out.println("Jokatzeko 3 modu daude:");
		System.out.println("	1 - Jokalaria vs Jokalaria");
		System.out.println("	2 - Jokalaria vs Ordenagailua (Inteligentzia Artifiziala)");
		System.out.println("	3 - Jokalaria vs Ordenagailuaren Tableroa");
		
		boolean ezAmaitu = true;
		int n = 0;
		do {
			try {
				System.out.println("\nAukeratu aukera bat: ");
				n = sc.nextInt();	
				if(n > 3 || n < 1){
					throw new TartetikKanpoException("Zenbakia ez dago tartean.");
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

	public Jokalaria partidarenIrabazlea() {
		Jokalaria irabazlea=null;
        if(this.jokalariak[0].minaMaxGainditua()||this.jokalariak[0].zenbatItsasontzi()==0) {
        	irabazlea=this.jokalariak[1];
        }  
        if(this.jokalariak[1].minaMaxGainditua()||this.jokalariak[1].zenbatItsasontzi()==0) {
        	irabazlea=this.jokalariak[0];
        } 	
        
        return irabazlea;
	}
	
	private void jokalarienEgoeraInprimatu(){
    	this.jokalariak[0].jokalariarenEgoeraInprimatu();
    	this.jokalariak[1].jokalariarenEgoeraInprimatu();
    }
	
	protected void denboraItxaron(int pSegundoak) {
		pSegundoak = pSegundoak*1000;
		try {
			Thread.sleep(pSegundoak);
		} catch (Exception e) {}
	}
	
	public static void kontsolaGarbitu(int pLerroKop){
		for(int i = 0; i < pLerroKop; i++){
			System.out.println();
		}
	}
	
	public static void soinuaErreproduzitu(String pHelbidea) {
		try {
			Clip leherketa = AudioSystem.getClip();
			File fitxategia = new File(pHelbidea);
			leherketa.open(AudioSystem.getAudioInputStream(fitxategia));
			leherketa.start();
			Thread.sleep(1000);
			leherketa.close();
		}
		catch (Exception e) {}
	}
	
	public void partidaBatJolastu() {
		Jokalaria irabazlea=null;
    	
		System.out.println("\nHasteko tableroen parametroak definituko dituzue.");
    	this.jokatzekoParametroakEskatu();
		
    	System.out.println("\nLehengo jokalaria, sartu izena.");
    	this.jokalariak[0]= new Jokalaria(this.izenaEskatu());
    	System.out.println("\nBigarren jokalaria, sartu izena.");
    	this.jokalariak[1]= new Jokalaria(this.izenaEskatu());
    	
    	kontsolaGarbitu(40);
    	
    	System.out.println("\n"+this.jokalariak[0].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[0].tableroaPrestatu();
    	
    	kontsolaGarbitu(40);
    	
    	System.out.println("\n"+this.jokalariak[1].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[1].tableroaPrestatu();
    	
    	kontsolaGarbitu(40);
    	
    	System.out.println("//////////////////////////");
    	System.out.println("\n/ HAS DADILA PARTIDA :D /");
    	System.out.println("//////////////////////////");
    	
    	denboraItxaron(2);
    	
    	while(irabazlea==null){
    		this.jokalariak[this.txanda % 2].tiroEgin(this.jokalariak[(this.txanda + 1) % 2]);
    		this.jokalariak[(this.txanda + 1) % 2].partzialkiInprimatu();
    		this.txanda++;
    		irabazlea=this.partidarenIrabazlea();
    	}
    	
    	
    	System.out.println("Jokoa amaitu egin da.");
    	System.out.printf("Jokoaren irabazlea %s da", irabazlea.getIzena());
    	System.out.println();
    	
    	this.jokalarienEgoeraInprimatu();
    	
    	System.out.println();
    	System.out.println(this.jokalariak[0].getIzena()+"-(r)en tableroa: ");
    	this.jokalariak[0].guztizInprimatu();
    	
    	System.out.println(this.jokalariak[1].getIzena()+"-(r)en tableroa: ");
    	this.jokalariak[1].guztizInprimatu();

	}
	
	public void partidaBatJolastu1() {
		Jokalaria irabazlea=null;
    	
		System.out.println("\nHasteko tableroen parametroak definituko dituzu.");
    	this.jokatzekoParametroakEskatu();
		
    	System.out.println("\nJokalaria, sartu izena.");
    	this.jokalariak[0]= new Jokalaria(this.izenaEskatu());
    	this.jokalariak[1]= new Ordenagailua();
    	
    	kontsolaGarbitu(40);
    	
    	System.out.println("\n"+this.jokalariak[0].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[0].tableroaPrestatu();
    	
    	kontsolaGarbitu(40);
    	
    	this.jokalariak[1].tableroaPrestatu();
    	
    	System.out.println("//////////////////////////");
    	System.out.println("\n/ HAS DADILA PARTIDA :D /");
    	System.out.println("//////////////////////////");
    	
    	denboraItxaron(2);
    	
    	while(irabazlea==null){
    		this.jokalariak[this.txanda % 2].tiroEgin(this.jokalariak[(this.txanda + 1) % 2]);
    		this.jokalariak[(this.txanda + 1) % 2].partzialkiInprimatu();
    		this.txanda++;
    		irabazlea=this.partidarenIrabazlea();
    	}
    	
    	
    	System.out.println("Jokoa amaitu egin da.");
    	System.out.printf("Jokoaren irabazlea %s da", irabazlea.getIzena());
    	System.out.println();
    	
    	this.jokalarienEgoeraInprimatu();
    	
    	System.out.println();
    	System.out.println(this.jokalariak[0].getIzena()+"-(r)en tableroa: ");
    	this.jokalariak[0].guztizInprimatu();
    	
    	System.out.println(this.jokalariak[1].getIzena()+"-(r)en tableroa: ");
    	this.jokalariak[1].guztizInprimatu();
	}
	
	private void partidaBatJolastu2(){
		Jokalaria irabazlea=null;
    	
		System.out.println("\nHasteko tableroen parametroak definituko dituzu.");
    	this.jokatzekoParametroakEskatu();
		
    	System.out.println("\nJokalaria, sartu izena.");
    	this.jokalariak[0]= new Jokalaria(this.izenaEskatu());
    	this.jokalariak[1]= new Ordenagailua();
    	
    	this.jokalariak[1].tableroaPrestatu();
    	kontsolaGarbitu(40);
    	
    	System.out.println("//////////////////////////");
    	System.out.println("\n/ HAS DADILA PARTIDA :D /");
    	System.out.println("//////////////////////////");
    	
    	denboraItxaron(2);
    	while(irabazlea==null){
    		this.jokalariak[0].tiroEgin2(this.jokalariak[1]);
    		this.txanda++;
    		if(this.jokalariak[0].minaMaxGainditua()){
    			irabazlea=this.jokalariak[1];
    		}
    		if(this.jokalariak[1].zenbatItsasontzi()==0){
    			irabazlea=this.jokalariak[0];
    		}
    	}
    	
    	System.out.println("Jokoa amaitu egin da.  "+this.txanda+ " txandatan bukatu duzu." );
    	if (irabazlea instanceof Ordenagailua){
    		System.out.println("Galdu duzu :(");}
    	else{System.out.println("Jokoa irabazi duzu!! Zorionak!! :P");}
    	
    	this.jokalariak[1].guztizInprimatu();
	}
	public static Jokalaria noriTokatzenZaio(){
		return nireJokoa.jokalariak[nireJokoa.txanda%2];
	}
	
}