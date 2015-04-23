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
		laukia.osoaInprimatu();
		
		laukia.setBegiratuta(false);
		laukia.osoaInprimatu();
		
		laukia.setMina(true);
		laukia.osoaInprimatu();
		
		laukia.setBegiratuta(true);
		laukia.osoaInprimatu();
		
		laukia.setMina(false);
		laukia.setItsasontzia(itsasontzi);
		laukia.osoaInprimatu();
		
		laukia.setBegiratuta(false);
		laukia.osoaInprimatu();
		
		System.out.println();
	}

	@Test
	public void testEgungoaInprimatu() {
		laukia.egungoaInprimatu();
		
		laukia.setBegiratuta(false);
		laukia.egungoaInprimatu();
		
		laukia.setMina(true);
		laukia.egungoaInprimatu();
		
		laukia.setBegiratuta(true);
		laukia.egungoaInprimatu();
		
		laukia.setMina(false);
		laukia.setItsasontzia(itsasontzi);
		laukia.egungoaInprimatu();
		
		laukia.setBegiratuta(false);
		laukia.egungoaInprimatu();
		
		System.out.println();
	}

	@Test
	public void testSetBegiratuta() {
		assertTrue(laukia.getBegiratuta() == false);
		
		laukia.setBegiratuta(true);
		assertTrue(laukia.getBegiratuta() == true);
	}

	@Test
	public void testSetItsasontzia() {
		assertTrue(laukia.getItsasontzia() == null);
		
		laukia.setItsasontzia(itsasontzi);
		assertTrue(laukia.getItsasontzia() != null);
	}

	@Test
	public void testSetMina() {
		assertTrue(laukia.getMina() == false);
		
		laukia.setMina(true);
		assertTrue(laukia.getMina() == true);
	}

}
