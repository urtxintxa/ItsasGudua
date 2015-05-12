package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroaTest {

	private Tableroa tablero;
	private Jokalaria jokalari;
	
	@Before
	public void setUp() throws Exception {
		jokalari = new Jokalaria("Son Goku");
		
		Jokalaria.setItsaspekoMax(2);
		Jokalaria.setOntziaMax(1);
		Jokalaria.setTxalupaMax(3);
		Jokalaria.setMinaIkutuMaximo(4);
		
		Itsasontzia.setUrpekariaTamaina(3);
		Itsasontzia.setOntziaTamaina(4);
		Itsasontzia.setTxalupaTamaina(2);
		
		Tableroa.setTamaina(8);
		Tableroa.setMinakop(7);
		tablero = jokalari.getTableroa();
	}

	@After
	public void tearDown() throws Exception {
		tablero = null;
		jokalari = null;
	}


	@Test
	public void testItsasontziaJarri() {
		//itsasontzirikDago() ere probatzeko
		
		Itsasontzia i1=new Itsasontzia(2, false);
		Itsasontzia i2=new Itsasontzia(2, false);
		Itsasontzia i3=new Itsasontzia(2, false);
		Itsasontzia i4=new Itsasontzia(3, true);
		Itsasontzia i5=new Itsasontzia(3, true);
		Itsasontzia i6=new Itsasontzia(4, false);
		tablero.itsasontziaJarri(1, 1, 2, 'b', i1);
		tablero.itsasontziaJarri(4, 5, 2, 'B', i2);
		tablero.itsasontziaJarri(1, 3, 2, 'h', i3);
		tablero.itsasontziaJarri(4, 2, 3, 'h', i4);
		tablero.itsasontziaJarri(2, 6, 3, 'b', i5);
		tablero.itsasontziaJarri(6, 1, 4, 'H', i6);
		tablero.tableroOsoaInprimatu();
		/**	lortu behar dena  
		 *    0  1 2 3 4 5 6 7 
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
		assertNotNull(tablero.itsasontzirikDago(1, 1));
		assertNotNull(tablero.itsasontzirikDago(2, 1));
		assertNotNull(tablero.itsasontzirikDago(1, 3));
		assertNotNull(tablero.itsasontzirikDago(1, 4));
		assertNotNull(tablero.itsasontzirikDago(2, 6));
		assertNotNull(tablero.itsasontzirikDago(3, 6));
		assertNotNull(tablero.itsasontzirikDago(4, 6));
		assertNotNull(tablero.itsasontzirikDago(4, 5));
		assertNotNull(tablero.itsasontzirikDago(4, 4));
		assertNotNull(tablero.itsasontzirikDago(4, 3));
		assertNotNull(tablero.itsasontzirikDago(4, 2));
		assertNotNull(tablero.itsasontzirikDago(5, 5));
		assertNotNull(tablero.itsasontzirikDago(6, 1));
		assertNotNull(tablero.itsasontzirikDago(6, 2));
		assertNotNull(tablero.itsasontzirikDago(6, 3));
		assertNotNull(tablero.itsasontzirikDago(6, 4));
		assertNull(tablero.itsasontzirikDago(1, 6));
		assertNull(tablero.itsasontzirikDago(7, 7));
		assertNull(tablero.itsasontzirikDago(5, 1));
		assertNull(tablero.itsasontzirikDago(7, 6));
		assertNull(tablero.itsasontzirikDago(1, 0));
		int itsKop=0;
		for(int i = 0; i < Tableroa.getTamaina(); i++){
			for(int j = 0; j < Tableroa.getTamaina(); j++){
				if(tablero.itsasontzirikDago(i, j)!=null){//itsasontzien zatiak
					itsKop++;
				}
			}
		}
		assertSame(itsKop,16);
		assertSame(tablero.itsasontzirikDago(4, 3),tablero.itsasontzirikDago(4, 4));
		assertNotSame(tablero.itsasontzirikDago(4, 5),tablero.itsasontzirikDago(4, 4));
		assertNotSame(tablero.itsasontzirikDago(4, 6),tablero.itsasontzirikDago(4, 4));
		assertNotSame(tablero.itsasontzirikDago(4, 6),tablero.itsasontzirikDago(4, 5));
				
	}

	@Test
	public void testMinakJarri() {
		tablero.minakJarri();
		int minaKop = 0;
		for(int i = 0; i < Tableroa.getTamaina(); i++){
			for(int j = 0; j < Tableroa.getTamaina(); j++){
				if(tablero.minarikDago(i, j)){
					minaKop++;
				}
			}
		}
		assertEquals(minaKop, 7);
	}


	@Test
	public void testBegiratutaDago() {
		assertFalse(tablero.begiratutaDago(0, 0));
		
		tablero.setBegiratuta(0, 0, false);
		assertFalse(tablero.begiratutaDago(0, 0));
		
		tablero.setBegiratuta(0, 0, true);
		assertTrue(tablero.begiratutaDago(0, 0));
	}

	@Test
	public void testTableroOsoaInprimatu() {
		System.out.println("tableroOsoaImprimatu");
		tablero.minakJarri();
		tablero.itsasontziaJarri(2, 6, 3, 'b', new Itsasontzia(3, true));
		tablero.itsasontziaJarri(6, 1, 4, 'H', new Itsasontzia(4, false));
		tablero.setBegiratuta(2, 6, true);
		tablero.setBegiratuta(1, 1, true);
		tablero.minakJarri();
		
		tablero.tableroOsoaInprimatu();
	}

	@Test
	public void testEgungoTableroaInprimatu() {
		System.out.println("egungoTableroaImprimatu");
		tablero.minakJarri();
		tablero.itsasontziaJarri(2, 6, 3, 'b', new Itsasontzia(3, true));
		tablero.itsasontziaJarri(6, 1, 4, 'H', new Itsasontzia(4, false));
		tablero.setBegiratuta(2, 6, true);
		tablero.setBegiratuta(1, 1, true);
		tablero.minakJarri();
		
		tablero.egungoTableroaInprimatu();
	}

	@Test
	public void testKoordenatuEgokiak() {
		assertFalse(tablero.koordenatuEgokiak(Tableroa.getTamaina(), Tableroa.getTamaina()));
		assertTrue(tablero.koordenatuEgokiak(0, 0));
		assertTrue(tablero.koordenatuEgokiak(Tableroa.getTamaina()- 1, Tableroa.getTamaina() - 1));
		assertFalse(tablero.koordenatuEgokiak(10, 1));
	}

	@Test
	public void testMinakBoom() {
		//metodo hau probatzeko metodoko baldintza batzuk (instanceof begiratzen dutenak
		//kendu behar dira. hori bakarrik funtzionatzen du partida bat jokatzean jokalariak
		//sortzen ditugunean. Partidak jokatu ditugunean ondo funtzionatzen duela ikusi dugu
		
		System.out.println("minakBoom");
		Itsasontzia i1=new Itsasontzia(2, false);
		Itsasontzia i2=new Itsasontzia(2, false);
		Itsasontzia i3=new Itsasontzia(2, false);
		Itsasontzia i4=new Itsasontzia(3, true);
		Itsasontzia i5=new Itsasontzia(3, true);
		Itsasontzia i6=new Itsasontzia(4, false);
		tablero.itsasontziaJarri(1, 1, 2, 'b', i1);
		tablero.itsasontziaJarri(4, 5, 2, 'B', i2);
		tablero.itsasontziaJarri(1, 3, 2, 'h', i3);
		tablero.itsasontziaJarri(4, 2, 3, 'h', i4);
		tablero.itsasontziaJarri(2, 6, 3, 'b', i5);
		tablero.itsasontziaJarri(6, 1, 4, 'H', i6);
		ListaItsasontziak itsasontziak= jokalari.getListaItsasontziak();
		itsasontziak.gehituItsasontzia(i1);
		itsasontziak.gehituItsasontzia(i2);
		itsasontziak.gehituItsasontzia(i3);
		itsasontziak.gehituItsasontzia(i4);
		itsasontziak.gehituItsasontzia(i5);
		itsasontziak.gehituItsasontzia(i6);
		assertSame(jokalari.zenbatItsasontzi(), 6);
		/**	lortu behar dena  
		 *    0  1 2 3 4 5 6 7 
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
		//minakBoom probatzeko normalean baino mina gehiago jarriko ditugu ea baten-bat boom egiten duenaren ondoan kokatzen bada
		tablero.minakJarri();
		tablero.minakJarri();
		tablero.minakJarri();
		tablero.tableroOsoaInprimatu();
		
		tablero.begiratutaDago(6, 4);

		tablero.minakBoom(5, 4, jokalari);
		assertSame(jokalari.zenbatItsasontzi(),5);
		tablero.tableroOsoaInprimatu();
		/**	lortzen dena (tablerotik zehar dauden minak kontua eduki gabe)
		 *    0  1 2 3 4 5 6 7 
			0   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
			1   ♒ ⏅ ♒ ⏅ ⏅ ♒ ♒ ♒ 
			2   ♒ ⏅ ♒ ♒ ♒ ♒ ⏅ ♒ 
			3   ♒ ♒ ♒ ♒ ♒ ♒ ⏅ ♒ 
			4   ♒ ♒ ⏅ ⏅ ⏅ ✝ ⏅ ♒ 
			5   ♒ ♒ ♒ ♒ ♒ ✝ ♒ ♒ 
			6   ♒ ⏅ ⏅ ✝ ✝ ♒ ♒ ♒ 
			7   ♒ ♒ ♒ ♒ ♒ ♒ ♒ ♒ 
		 * (4,3) eta (4,4) koordenatuetako itsasontziak antiMina direnez ez dira aldatzen
		 * (5,3) eta (6,5) koordenatuetan mina badago ez da aldatuko,
		 * ura badago, aldiz, begiratu bezala markatuko da
		 */
		tablero.egungoTableroaInprimatu();
		
	}

	@Test
	public void testGetTamaina() {
		assertSame(Tableroa.getTamaina(), 8);
	}

	@Test
	public void testSetBegiratuta() {
		tablero.setBegiratuta(1, 1, true);
		tablero.setBegiratuta(6, 6, true);
		assertFalse(tablero.begiratutaDago(0, 0));
		assertTrue(tablero.begiratutaDago(1, 1));
		assertTrue(tablero.begiratutaDago(6, 6));
		assertFalse(tablero.begiratutaDago(7, 7));
		
	}

}
