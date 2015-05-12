package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LaukiaTest {
	
	private Laukia laukia;
	
	private Itsasontzia itsasontzi;

	@Before
	public void setUp() throws Exception {
		laukia = new Laukia();
		itsasontzi = new Itsasontzia(0, true);
	}

	@After
	public void tearDown() throws Exception {
		laukia = null;
	}

	@Test
	public void testOsoaInprimatu() {
		//lauki begiratua
		laukia.setBegiratuta(true);
		laukia.osoaInprimatu();
		
		//ez begiratua
		laukia.setBegiratuta(false);
		laukia.osoaInprimatu();
		
		//mina ez begiratua
		laukia.setMina(true);
		laukia.osoaInprimatu();
		
		//mina begiratua
		laukia.setBegiratuta(true);
		laukia.osoaInprimatu();
		
		//itsasontzi begiratua
		laukia.setMina(false);
		laukia.setItsasontzia(itsasontzi);
		laukia.osoaInprimatu();
		
		//itsasontzi ez begiratua
		laukia.setBegiratuta(false);
		laukia.osoaInprimatu();
		
		System.out.println();
	}

	@Test
	public void testEgungoaInprimatu() {
		//lauki begiratua
		laukia.setBegiratuta(true);
		laukia.egungoaInprimatu();
		
		//ez begiratua
		laukia.setBegiratuta(false);
		laukia.egungoaInprimatu();
		
		//mina ez begiratua
		laukia.setMina(true);
		laukia.egungoaInprimatu();
		
		//mina begiratua
		laukia.setBegiratuta(true);
		laukia.egungoaInprimatu();
		
		//itsasontzi begiratua
		laukia.setMina(false);
		laukia.setItsasontzia(itsasontzi);
		laukia.egungoaInprimatu();
		
		//itsasontzi ez begiratua
		laukia.setBegiratuta(false);
		laukia.egungoaInprimatu();
		
		System.out.println();
	}

	@Test
	public void testSetBegiratuta() {
		assertFalse(laukia.getBegiratuta());
		
		laukia.setBegiratuta(true);
		assertTrue(laukia.getBegiratuta());
	}

	@Test
	public void testSetItsasontzia() {
		assertNull(laukia.getItsasontzia());
		
		laukia.setItsasontzia(itsasontzi);
		assertNotNull(laukia.getItsasontzia());
	}

	@Test
	public void testSetMina() {
		assertFalse(laukia.getMina());
		
		laukia.setMina(true);
		assertTrue(laukia.getMina());
	}

}
