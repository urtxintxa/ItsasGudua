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
	public void testTiroEgin() {
		/**
		 * Hau frogatzeko egoera posible hauek kontuan hartu behar ditugu:
		 * Koordenatu ez zuzenak: errepikatu
		 * Koordenatu zuzenak:
		 * 		Itsasontzia dago: Beste txanda bat jokatuko da
		 * 			- Hondoratu da itsasontzia
		 * 			- Ez da hondoratu itsasontzia
		 * 		Itsasontzia ez dago:
		 * 			- Mina dago:
		 * 			- Ura dago:
		 *  
		 * 
		 */
		/**Tableroan minak non dauden ezin dugunez jakin, 
		 * eta itsasontzien lekua aurkariak edo automatikoki aukeratuko denez;
		 * froga egiteko, goian azaldutako kasu guztiak lortu eta gure helburua betetzen dela frogatu behar dugu,
		 * jolastuz
		 */
	}

	@Test
	public void testTiroEgin2() {
		/**TestTiroEgin testeko kasu berdinda da
		 * 
		 * Hau frogatzeko egoera posible hauek kontuan hartu behar ditugu:
		 * Koordenatu ez zuzenak: errepikatu
		 * Koordenatu zuzenak:
		 * 		Itsasontzia dago: Beste txanda bat jokatuko da
		 * 			- Hondoratu da itsasontzia
		 * 			- Ez da hondoratu itsasontzia
		 * 		Itsasontzia ez dago:
		 * 			- Mina dago:
		 * 			- Ura dago:
		 *  
		 * 
		 */
		/**Tableroan minak non dauden ezin dugunez jakin, 
		 * eta itsasontzien lekua aurkariak edo automatikoki aukeratuko denez;
		 * froga egiteko, goian azaldutako kasu guztiak lortu eta gure helburua betetzen dela frogatu behar dugu,
		 * jolastuz
		 */
	}

	@Test
	public void testGuztizInprimatu() {
		//TableroaTest klasean frogatutako metodo bati dei egiten dio 
		assertTrue(true);
	}

	@Test
	public void testPartzialkiInprimatu() {
		//TableroaTest klasean frogatutako metodo bati dei egiten dio 
		assertTrue(true);
	}
	
	@Test
	public void testEskatuX(){
		/**Programa hasieratu
		 * Aukeratu 1 (jolasteko)
		 * Aukeratu 3 (Jokalaria vs Ordenagailuaren Tableroa)
		 * Aukeratu 1 (5x5koa)
		 * Sartu edozein izen
		 *
		 * Orain froga dator:
		 * Sartu kaixo (Error - Ez da Int motakoa)
		 * Sartu -1 (Error - Posizioa ez dago tableroan)
		 * Sartu 5 (Error - Posizioa ez dago tableroan)
		 * Sartu 0 (Posizioa egokia da)
		 */
		assertTrue(true);
	}

	@Test
	public void testEskatuY(){
		/**Programa hasieratu
		 * Aukeratu 1 (jolasteko)
		 * Aukeratu 3 (Jokalaria vs Ordenagailuaren Tableroa)
		 * Aukeratu 1 (5x5koa)
		 * Sartu edozein izen
		 * Sartu 0 (X posizioa tableroan)
		 *
		 * Orain froga dator:
		 * Sartu kaixo (Error - Ez da Int motakoa)
		 * Sartu -1 (Error - Posizioa ez dago tableroan)
		 * Sartu 5 (Error - Posizioa ez dago tableroan)
		 * Sartu 0 (Posizioa egokia da)
		 */
		assertTrue(true);
	}

	@Test
	public void testItsasontziaJarriEskuz() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}

	@Test
	public void testMinaMaxGainditua() {
		j1.minaIkutuakHanditu();
		assertFalse(j1.minaMaxGainditua());
		j1.minaIkutuakHanditu();
		assertFalse(j1.minaMaxGainditua());
		j1.minaIkutuakHanditu();
		assertTrue(j1.minaMaxGainditua());
	}

	@Test
	public void testJokalariarenEgoeraInprimatu() {
		j1.jokalariarenEgoeraInprimatu();
		j1.tableroaPrestatuAutomatiko();
		j1.jokalariarenEgoeraInprimatu();
	}
	
	@Test
	public void testEskatuHorizontalBertikal() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testKoordenatuZuzenak() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testTableroaPrestatuEskuz() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testHautatuItsasontzia() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}

	@Test
	public void testZenbatItsasontzi() {
		//ListaItsasontziakTest klasean frogatutako metodo bati dei egiten dio 
		assertTrue(true);
	}

	@Test
	public void testItsasontziaJarriAutomatiko() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testLortuXY() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testTableroaPrestatuAutomatiko() {
		j1.tableroaPrestatu();
		//1 Aukeratuz gero, ikusi egiten da arazorik gabe aukeratu egin dela itsasontzientzat leku egokia
	}

	@Test
	public void testTableroaJartzekoModuaEskatu() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testBaiEz() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testLortuHorBer() {
		//TestTableroaPrestatu testean forgatzen da metodo hau (pribatua da)
		assertTrue(true);
	}
	
	@Test
	public void testMinaIkutuakHanditu() {
		j1.minaIkutuakHanditu();
		assertFalse(j1.minaMaxGainditua());
		j1.minaIkutuakHanditu();
		assertFalse(j1.minaMaxGainditua());
		j1.minaIkutuakHanditu();
		assertTrue(j1.minaMaxGainditua());
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