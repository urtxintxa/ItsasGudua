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
	
	public Jokoa getNireJokoa() {
		if(nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	
	public void partidaBatjolastu() {
		Jokalaria irabazlea=null;
    	
    	
    	System.out.println("Lehengo jokalaria, sartu izena.");
    	this.jokalariak[0]= new Jokalaria(this.izenaEskatu());
    	System.out.println("Bigarren jokalaria, sartu izena.");
    	this.jokalariak[1]= new Jokalaria(this.izenaEskatu());
    	
    	System.out.println(this.jokalariak[0].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[0].tableroaPrestatu();
    	System.out.println(this.jokalariak[1].getIzena() + ", zure tableroa prestatu.");
    	this.jokalariak[1].tableroaPrestatu();
    	
    	System.out.println("Has dadila partida.");
    	
    	while(irabazlea==null){
    		if(!this.jokalariak[this.txanda % 2].getPenalizazioa()){
    			this.jokalariak[this.txanda % 2].tiroEgin(this.jokalariak[(this.txanda + 1) % 2]);
    		}
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
		//System.out.println("Sartu zure izena: ");
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