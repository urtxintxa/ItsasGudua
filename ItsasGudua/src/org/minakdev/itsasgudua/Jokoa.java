package org.minakdev.itsasgudua;

import java.util.Scanner;

public class Jokoa {
	
	private Jokalaria[] jokalariak;
	private int txanda;
	private static Jokoa nireJokoa = null;
	
	private Scanner sc = new Scanner(System.in);
	
	private Jokoa() {
		
	}
	
	public Jokoa getNireJokoa() {
		if(nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	
	public void partidaBatjolastu() {
		
	}
	
	private String izenaEskatu() {
		System.out.println("Sartu zure izena: ");
		String izena = sc.next();
		return izena;
	}

	public Jokalaria partidarenIrabazlea() {
		
	}
}