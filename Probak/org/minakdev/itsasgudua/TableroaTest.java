package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroaTest {
	
	private Tableroa tablero;
	private Itsasontzia itsasontzi;

	@Before
	public void setUp() throws Exception {
		Tableroa.setMinakop(3);
		tablero = new Tableroa();
		itsasontzi = new Itsasontzia(3, true);
	}

	@After
	public void tearDown() throws Exception {
		tablero = null;
		itsasontzi = null;
	}

	@Test
	public void testSetTamaina() {
		Tableroa.setTamaina(10);
		assertTrue(tablero.getTamaina() == 10);
		
	}


	@Test
	public void testMinakJarri() {
		tablero.minakJarri();
	}
	
	@Test
	public void testMinarikDago() {
		Tableroa.setTamaina(10);
		tablero.minakJarri();
		int minaKop = 0;
		for(int i = 0; i < tablero.getTamaina()-1; i++){
			for(int j = 0; j < tablero.getTamaina()-1; j++){
				if(tablero.minarikDago(i, j)){
					minaKop++;
				}
			}
		}
		
		assertTrue(minaKop == 3);
	}

	@Test
	public void testItsasontzirikDago() {
		tablero.itsasontziaJarri(0, 0, 3, 'H', itsasontzi);
		assertTrue(tablero.itsasontzirikDago(0, 0) != null);
	}

	@Test
	public void testTableroOsoaInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testMinakBoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testEgungoTableroaInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testBegiratutaDago() {
		fail("Not yet implemented");
	}

	@Test
	public void testKoordenatuEgokiak() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBegiratuta() {
		fail("Not yet implemented");
	}

}
