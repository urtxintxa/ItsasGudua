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
		//Pepitoren tableroa eta ListaItsasontziak prestatu
		Tableroa tableroa=j1.getTableroa();
		Itsasontzia i1=new Itsasontzia(2, false);
		Itsasontzia i2=new Itsasontzia(2, false);
		tableroa.itsasontziaJarri(2, 1, 2, 'b', i1);
		tableroa.itsasontziaJarri(6, 5, 2, 'h', i2);
		ListaItsasontziak  itsasontziak=j1.getListaItsasontziak();
		itsasontziak.gehituItsasontzia(i1);
		itsasontziak.gehituItsasontzia(i2);
		j1.guztizInprimatu();
		assertSame(j1.zenbatItsasontzi(),2);
		/**	lortu behar dena  
		 *    0  1 2 3 4 5 6 7 
			0   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			1   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			2   ♒ ⏅ ♒ ♒ ♒ ♒ ♒ ♒ 
			3   ♒ ⏅ ♒ ♒ ♒ ♒ ♒ ♒ 
			4   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			5   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			6   ♒ ♒ ♒ ♒ ♒ ⏅ ⏅ ♒ 
			7   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			 * 
			 */
		Jokalaria j2=new Jokalaria("Froga");
		// egin beharreko tiroak ordenean: (8) (2-8) (2-1) (2-1) (3-1) (4-1)
		j2.tiroEgin(j1);
		// (8) zenbakiak ez daudela tartean esango du
		// (2-8) zenbakiak ez daudela tartean esango du
		// (1) itsasontzi bati tiro egin diozula esango du
		// (2-1) koordenatu horiek begiratuta daudela esango du
		// (3-1) itsasontzi bati tiro egiteaz gain, itsasontzia hondoratu duzula esango du
		// (4-1) ura jo duzula esango du
		assertSame(j1.zenbatItsasontzi(),1);
		
		j2.setPenalizazioa(true);
		j2.tiroEgin(j1);
		//penalizazioa dela eta ezin duzula jokatu esango du
		
		//minak ez dakigu non jarriko diren (random); hori dela eta, jolastuz minei tiro egitean ondo doala frogatu dugu
	}

	@Test
	public void testTiroEgin2() {
		//Ordenagailuaren tableroa eta ListaItsasontziak prestatu
		Tableroa tableroa=j1.getTableroa();
		Itsasontzia i1=new Itsasontzia(2, false);
		Itsasontzia i2=new Itsasontzia(2, false);
		tableroa.itsasontziaJarri(2, 1, 2, 'b', i1);
		tableroa.itsasontziaJarri(6, 5, 2, 'h', i2);
		ListaItsasontziak  itsasontziak=j1.getListaItsasontziak();
		itsasontziak.gehituItsasontzia(i1);
		itsasontziak.gehituItsasontzia(i2);
		assertSame(j1.zenbatItsasontzi(),2);
		/**	Ordenagailuaren tableroa hau da:  
		 *    0  1 2 3 4 5 6 7 
			0   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			1   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			2   ♒ ⏅ ♒ ♒ ♒ ♒ ♒ ♒ 
			3   ♒ ⏅ ♒ ♒ ♒ ♒ ♒ ♒ 
			4   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			5   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			6   ♒ ♒ ♒ ♒ ♒ ⏅ ⏅ ♒ 
			7   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			 * 
			 */
		Jokalaria j2=new Jokalaria("Froga");
		// egin beharreko tiroak ordenean: (8) (2-8) (2-1) (2-1) (3-1) (4-1)
		j2.tiroEgin2(j1);
		// (8) zenbakiak ez daudela tartean esango du
		// (2-8) zenbakiak ez daudela tartean esango du
		// (1) itsasontzi bati tiro egin diozula esango du
		// (2-1) koordenatu horiek begiratuta daudela esango du
		// (3-1) itsasontzi bati tiro egiteaz gain, itsasontzia hondoratu duzula esango du
		// (4-1) ura jo duzula esango du
		assertSame(j1.zenbatItsasontzi(),1);
	
		j2.setPenalizazioa(true);
		j2.tiroEgin2(j1);
		//penalizazioa dela eta txanda galdu duzula esango du
	
		//minak ez dakigu non jarriko diren (random); hori dela eta, jolastuz minei tiro egitean ondo doala frogatu dugu
	}

	@Test
	public void testGuztizInprimatu() {
		//TableroaTest klasean frogatutako metodo bati dei egiten dio 
	}

	@Test
	public void testPartzialkiInprimatu() {
		//TableroaTest klasean frogatutako metodo bati dei egiten dio 
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
		assertSame(j1.zenbatItsasontzi(),6);
	}
		
	@Test
	public void testZenbatItsasontzi() {
		//ListaItsasontziakTest klasean frogatutako metodo bati dei egiten dio 
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