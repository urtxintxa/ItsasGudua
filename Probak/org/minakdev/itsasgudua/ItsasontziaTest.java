package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItsasontziaTest {
	
	private Itsasontzia txalupa;
	private Itsasontzia ontzia;
	private Itsasontzia urpekaria;

	@Before
	public void setUp() throws Exception {
		txalupa = new Itsasontzia(Itsasontzia.getTxalupaTamaina(), false);
		ontzia = new Itsasontzia(0, false);
		urpekaria = new Itsasontzia(Itsasontzia.getUrpekariaTamaina(), true);
	}

	@After
	public void tearDown() throws Exception {
		txalupa = null;
		ontzia = null;
		urpekaria = null;
	}

	@Test
	public void testHondoratutaDago() {
		assertFalse(txalupa.hondoratutaDago());
		assertTrue(ontzia.hondoratutaDago());
	}

	@Test
	public void testGetAntiMina() {
		assertFalse(txalupa.getAntiMina());
		assertFalse(ontzia.getAntiMina());
		assertTrue(urpekaria.getAntiMina());
	}

	@Test
	public void testKenduZatia() {
		assertSame(txalupa.getHondoratuGabekoZatiKop(),2);
		
		txalupa.kenduZatia();
		assertFalse(txalupa.hondoratutaDago());
		assertSame(txalupa.getHondoratuGabekoZatiKop(),1);
		
		txalupa.kenduZatia();
		assertTrue(txalupa.hondoratutaDago());
		assertSame(txalupa.getHondoratuGabekoZatiKop(),0);
	}

}