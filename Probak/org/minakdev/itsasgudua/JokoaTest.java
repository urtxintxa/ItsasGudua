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
		String[] a = null;
		Jokoa.main(a);
		
		/*
		Kontsolako irteeran begiratuko dugu ea eskatuIzena
		metodoak izena hartzen duen. Hala ere, exception-ekin
		tratatua denez, %100an badakigu izen oso bat sartuko dela
		
		jokatzekoModuaEskatu eta jokatzekoParametroakEskatu metodoek Exception-ak
		ere erabiltzen dituzte, beraz zihurtatu dezakegu funtzionatuko dutela
		
		
		*/
		
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
		
		gureJokoa.soinuaErreproduzitu(Jokoa.leherketaSoinua); //soinuak karpetan dagoen soinua
		gureJokoa.soinuaErreproduzitu(Jokoa.itsasontziaJo); //soinuak karpetan dagoen soinua
		
		gureJokoa.soinuaErreproduzitu("kaixo"); //Exception bat
	}

	@Test
	public void testNoriTokatzenZaio() {
		assertSame(gureJokoa.noriTokatzenZaio(), null);
	}
}
