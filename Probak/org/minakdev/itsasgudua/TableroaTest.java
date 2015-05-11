package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroaTest {
	
	private Tableroa tablero;
	private Itsasontzia itsasontzi;
	private Jokalaria jokalari;

	@Before
	public void setUp() throws Exception {
		jokalari = new Jokalaria("Son Goku");
		
		Tableroa.setMinakop(3);
		Tableroa.setTamaina(10);
		tablero = new Tableroa();
		itsasontzi = new Itsasontzia(3, true);
	}

	@After
	public void tearDown() throws Exception {
		tablero = null;
		itsasontzi = null;
		jokalari = null;
	}

	@Test
	public void testSetTamaina() {
		assertEquals(tablero.getTamaina(), 10);
	}

	@Test
	public void testMinarikDago() {
		tablero.minakJarri();
		int minaKop = 0;
		for(int i = 0; i < tablero.getTamaina()-1; i++){
			for(int j = 0; j < tablero.getTamaina()-1; j++){
				if(tablero.minarikDago(i, j)){
					minaKop++;
				}
			}
		}
		assertEquals(minaKop, 3);
	}

	@Test
	public void testItsasontzirikDago() {
		assertSame(tablero.itsasontzirikDago(0, 0), null);
		
		tablero.itsasontziaJarri(0, 0, 3, 'H', itsasontzi);
		assertNotSame(tablero.itsasontzirikDago(0, 0), null);
	}

	@Test
	public void testTableroOsoaInprimatu() {
		tablero.begiratutaDago(0, 0);
		tablero.begiratutaDago(1, 1);
		tablero.begiratutaDago(6, 6);
		tablero.begiratutaDago(7, 7);
		
		tablero.tableroOsoaInprimatu();
		
		tablero.minakBoom(3, 3, jokalari);
		tablero.tableroOsoaInprimatu();
	}

	@Test
	public void testEgungoTableroaInprimatu() {
		tablero.begiratutaDago(0, 0);
		tablero.begiratutaDago(1, 1);
		tablero.begiratutaDago(6, 6);
		tablero.begiratutaDago(7, 7);
		
		tablero.tableroOsoaInprimatu();
		
		tablero.minakBoom(3, 3, jokalari);
		tablero.egungoTableroaInprimatu();
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
	public void testKoordenatuEgokiak() {
		assertFalse(tablero.koordenatuEgokiak(tablero.getTamaina(), tablero.getTamaina()));
		assertTrue(tablero.koordenatuEgokiak(0, 0));
		assertTrue(tablero.koordenatuEgokiak(tablero.getTamaina()- 1, tablero.getTamaina() - 1));
		
	}

}
