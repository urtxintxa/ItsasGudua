package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JokalariaTest {

	Jokalaria j1;
	
	@Before
	public void setUp() throws Exception {
		j1=new Jokalaria("Pepito");
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

	@After
	public void tearDown() throws Exception {
		j1=null;
	}

	@Test
	public void testJokalaria() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTxalupaMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetItsaspekoMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOntziaMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMinaIkutuMaximo() {
		fail("Not yet implemented");
	}

	@Test
	public void testTiroEgin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGuztizInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testPartzialkiInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testMinaMaxGainditua() {
		fail("Not yet implemented");
	}

	@Test
	public void testJokalariarenEgoeraInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIzena() {
		fail("Not yet implemented");
	}

	@Test
	public void testZenbatItsasontzi() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaItsasontziak() {
		fail("Not yet implemented");
	}

	@Test
	public void testTableroaPrestatu() {
		
		//tableroa modu automatikoan
		j1.tableroaPrestatu();
		//tableroa jartzeko modua aukeratzean zenbakiak ez den zerbait sartu eta zenbaki okerrak
		//1=modu automatikoa
		//tablero egokia den aukeratzean datu okerrak
		//B= tablero egokia
		assertSame(j1.zenbatItsasontzi(),6);//kopurua goiko set-en arabera alda daiteke				
		
		//tableroa egokia ez denean jartzen dituen ontziak tablero eta lista berri batean sartzen dituela ikusteko 
		j1=new Jokalaria("Pepito");//daukan tableroa erreseteatzeko
		j1.tableroaPrestatu();
		//1=automatiko
		//E=oker		errepikatu aldi batzuetan
		//B= tablero egokia
		assertSame(j1.zenbatItsasontzi(),6);
		
		//tableroa eskuz jarri
		j1=new Jokalaria("Pepito");//daukan tableroa erreseteatzeko
		j1.tableroaPrestatu();
		/**Itsasontzia hautatzeko momentuan datu okerrak sartu
		 * 1=txalupa
		 * Itsasontzia jartzeko datuak sartzerakoan (x,y,horizontalBertikal) datu okerrak sartu
		 * X=1, Y=1, bertikal;	
		 * 2=urpekaria
		 * aukera desegokiak:  X=2, Y=1, horizontal; itsasontzia dago	X=6, Y=2, bertikal; tablerotik kanpo
		 * X=4, Y=2, horizontal;
		 * 2=urpekaria
		 * X=2, Y=6, bertikal;
		 * 2=urpekari (max gainditua)
		 * 1=txalupa
		 * X=1, Y=3, horizontal;
		 * 1=txalupa
		 * X=4, Y=5, bertikal;
		 * 1=txalupa (max gainditua)
		 * 3=ontzia
		 * X=6, Y=1, horizontal;
		 */
		/**	lortu behar dena  
		 *    0 1 2 3 4 5 6 7 
			0   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			1   ♒ ⏅ ♒ ⏅ ⏅ ♒ ♒ ♒ 
			2   ♒ ⏅ ♒ ♒ ♒ ♒ ⏅ ♒ 
			3   ♒ ♒ ♒ ♒ ♒ ♒ ⏅ ♒ 
			4   ♒ ♒ ⏅ ⏅ ⏅ ⏅ ⏅ ♒ 
			5   ♒ ♒ ♒ ♒ ♒ ⏅ ♒ ♒ 
			6   ♒ ⏅ ⏅ ⏅ ⏅ ♒ ♒ ♒ 
			7   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
		 * 
		 */
		//B=tablero egokia
		assertSame(j1.zenbatItsasontzi(),6);
		
	}

}
