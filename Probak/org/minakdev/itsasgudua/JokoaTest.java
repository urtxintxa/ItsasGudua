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
		
		/*
		Main metodoak, jokatzekoModuaEskatu metodoa deitzen du.
		Metodo honek, zenbaki bat eskatuko du, 1, 2 edo 3.
		
			1. proba zenbaki oso bat ez den karakterea sartzen probatuko dugu
			gureJokoa.main(a);
		
			2. proba tarte horretatik ez dagoen zenbaki bat sartuz
			gureJokoa.main(a);
		
			3. proba, 1 zenbakia sartuz (partidaBatJolastu() deituko du)
			gureJokoa.main(a);
		
			4. proba 2 zenbakia sartuz (partidaBatJolastu1() deituko du)
			gureJokoa.main(a);
			
			5. proba 3 zenbakia sartuz (partidaBatJolastu2() deituko du)
			gureJokoa.main(a);
		
		partidaBatJolastu metodoek, jokatzekoParametroakEskatu() metodoa deituko dute, tableroaren tamaina ezartzeko
		Hemen ere, beste kasu batzuk agertzen zaizkigu, beraz guztiak probatu behar
			1. zenbaki oso bat ez sartzea
			2. zenbakia tartetik kanpo egotea
			3. 1 zenbakia sartzea
			4. 2 zenbakia sartzea
			5. 3 zenbakia sartzea
		
		Proba guztietan izen desberdinak sartzen probatu dugu, eta guztietan funtzionatu du.
		
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
}
