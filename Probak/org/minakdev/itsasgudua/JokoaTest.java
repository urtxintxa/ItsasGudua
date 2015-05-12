package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JokoaTest {
	
	Jokoa gureJokoa = Jokoa.getNireJokoa();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testDenboraItxaron() {
		gureJokoa.denboraItxaron(1);
	}

	@Test
	public void testKontsolaGarbitu() {
		gureJokoa.kontsolaGarbitu(1);
	}

	@Test
	public void testSoinuaErreproduzitu() {
		gureJokoa.soinuaErreproduzitu(Jokoa.leherketaSoinua);
		gureJokoa.soinuaErreproduzitu(Jokoa.itsasontziaJo);
	}

	@Test
	public void testNoriTokatzenZaio() {
		assertSame(gureJokoa.noriTokatzenZaio(), null);
	}
}
