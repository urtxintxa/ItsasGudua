package org.minakdev.itsasgudua;

import java.util.Scanner;

public class Jokoa {
	
	private Jokalaria[] jokalariak;
	private int txanda;
	private static Jokoa nireJokoa = null;
	
	private Scanner sc = new Scanner(System.in);
	
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
	
	public void partidaBatjolastu() {
		Jokalaria irabazlea=null;
    	
    	System.out.println("\nLehengo jokalaria, sartu izena.");
    	this.jokalariak[0]= new Jokalaria(this.izenaEskatu());
    	System.out.println("\nBigarren jokalaria, sartu izena.");
    	this.jokalariak[1]= new Jokalaria(this.izenaEskatu());
    	
    	System.out.println("\n"+this.jokalariak[0].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[0].tableroaPrestatu();
    	System.out.println("\n"+this.jokalariak[1].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[1].tableroaPrestatu();
    	
    	System.out.println("\nHAS DADILA PARTIDA :D");
    	
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
    	
    	this.jokalariak[0].guztizInprimatu();
    	this.jokalariak[1].guztizInprimatu();

	}
	
	private String izenaEskatu() {
		String izena = sc.next();
		return izena;
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
}