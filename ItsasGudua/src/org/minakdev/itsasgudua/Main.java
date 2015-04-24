package org.minakdev.itsasgudua;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Jokoa gureJokoa = Jokoa.getNireJokoa();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ongi etorri Itsas Gudua jokora :D");
		System.out.println();
		System.out.println("Jolasteko 1 zenbakia sakatu.");
		System.out.println("Irteteko 0 zenbakia sakatu.");

		int aukera = sc.nextInt();
		
		//Exception-a falta da.
		
		if(aukera == 1) {
			gureJokoa.partidaBatjolastu();
		}
		else {
			System.exit(0);
		}
		

	}

}
