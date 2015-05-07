package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaItsasontziakTest {
	
	private ListaItsasontziak nireLista;
	private Itsasontzia itsasontzi1;
	private Itsasontzia itsasontzi2;
	private Itsasontzia itsasontzi3;

	@Before
	public void setUp() throws Exception {
		nireLista = new ListaItsasontziak();
		
		itsasontzi1 = new Itsasontzia(3, true);
		itsasontzi2 = new Itsasontzia(2, false);
		itsasontzi3 = new Itsasontzia(1, false);
	}

	@After
	public void tearDown() throws Exception {
		nireLista = null;
		itsasontzi1 = null;
		itsasontzi2 = null;
		itsasontzi3 = null;
	}


	@Test
	public void testGehituItsasontzia() {
		assertSame(nireLista.zenbatItsasontzi(), 0);
		
		nireLista.gehituItsasontzia(itsasontzi1);
		assertSame(nireLista.zenbatItsasontzi(), 1);
		
		nireLista.gehituItsasontzia(itsasontzi2);
		assertSame(nireLista.zenbatItsasontzi(), 2);
		
		nireLista.gehituItsasontzia(itsasontzi3);
		assertSame(nireLista.zenbatItsasontzi(), 3);
		
		nireLista.kenduItsasontzia(itsasontzi2);
		assertSame(nireLista.zenbatItsasontzi(), 2);
	}

}
