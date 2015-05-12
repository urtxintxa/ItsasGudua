package org.minakdev.itsasgudua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdenagailuaTest {

	Ordenagailua o;
	Jokalaria j1;
	
	@Before
	public void setUp() throws Exception {
		o=new Ordenagailua();
		j1=new Jokalaria("Pepe");
		Jokalaria.setItsaspekoMax(2);
		Jokalaria.setOntziaMax(1);
		Jokalaria.setTxalupaMax(3);
		Jokalaria.setMinaIkutuMaximo(4);
		
		Itsasontzia.setUrpekariaTamaina(3);
		Itsasontzia.setOntziaTamaina(4);
		Itsasontzia.setTxalupaTamaina(2);
		
		Tableroa.setTamaina(8);
		Tableroa.setMinakop(7);
	}

	@After
	public void tearDown() throws Exception {
		o=null;
		j1=null;
	}

	@Test
	public void testTiroEgin() {	
		//metodo honetan ezin dugu kontrolatu mina bati ematea, baina kodea jokalariaren tiroEgin()-en oso antzekoa denez hor probatuko dugu
		//gehienbat hurrengo koordenatua ondo kalkulatzen duen begirazteko da
		
		//jokalariaren tableroa eta ListaItsasontziak prestatu
		j1=new Jokalaria("Pepe");
		Tableroa tableroa=j1.getTableroa();
		Itsasontzia i1=new Itsasontzia(2, false);
		Itsasontzia i2=new Itsasontzia(2, false);
		Itsasontzia i3=new Itsasontzia(2, false);
		Itsasontzia i4=new Itsasontzia(3, true);
		Itsasontzia i5=new Itsasontzia(3, true);
		Itsasontzia i6=new Itsasontzia(4, false);
		tableroa.itsasontziaJarri(1, 1, 2, 'b', i1);
		tableroa.itsasontziaJarri(4, 5, 2, 'B', i2);
		tableroa.itsasontziaJarri(1, 3, 2, 'h', i3);
		tableroa.itsasontziaJarri(4, 2, 3, 'h', i4);
		tableroa.itsasontziaJarri(2, 6, 3, 'b', i5);
		tableroa.itsasontziaJarri(6, 1, 4, 'H', i6);
		ListaItsasontziak  itsasontziak=j1.getListaItsasontziak();
		itsasontziak.gehituItsasontzia(i1);
		itsasontziak.gehituItsasontzia(i2);
		itsasontziak.gehituItsasontzia(i3);
		itsasontziak.gehituItsasontzia(i4);
		itsasontziak.gehituItsasontzia(i5);
		itsasontziak.gehituItsasontzia(i6);
		j1.guztizInprimatu();
		assertSame(j1.zenbatItsasontzi(),6);
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
		//(2,6) posizioko itsasontzia begiratua bezala markatu eta listan sartu
		tableroa.setBegiratuta(2, 6, true);
		o.gehituKoordenatuak(new Koordenatuak(2, 6));
		i5.kenduZatia();
		/**ordenagailuak goikoa,eskuinekoa, eta behekoa begiratuko ditu
		 * behekoa (3,6) listan sartu eta hurrengo txandan (4,6)-ri tiro egin eta lista husutko du
		 * hurrengo txandan random egingo duenez ez dakigu nora egingo duen tiro
		 */
		o.tiroEgin(j1);
		o.tiroEgin(j1);
		o.tiroEgin(j1);
		assertSame(j1.zenbatItsasontzi(),5);
		
		
		o.koordenatuenZerrendaHustu();
		//horizontalean dagoen itsasontzia eta bertikalean daudenak
		//gerta daiteke lehenagoko randomaren bitartez proba honetako emaitza aldatzea
		tableroa.setBegiratuta(4, 4, true);
		o.gehituKoordenatuak(new Koordenatuak(4, 4));
		i4.kenduZatia();
		/**ordenagailuak goikoa eta eskuinekoa begiratuko ditu
		 * eskuinekoa (4,5) listan sartu eta hurrengo txandan (4,6) begiratuta dagoenez eta itsasontzia duenez
		 * eskuinera joaten jarraituko du (4,7) ura joz
		 * hurrengo txandan ezkerrerantz egingo du itsasontziaren bi zatiak hondoratu arte eta koordenatuen lista hustuz
		 * hurrengo txandan random egingo du
		 */
		o.tiroEgin(j1);
		o.tiroEgin(j1);
		o.tiroEgin(j1);
		assertSame(j1.zenbatItsasontzi(),4);
		
		
		//koordenatuenZerrandaHustu() ren proba
		tableroa.setBegiratuta(1, 3, true);
		o.gehituKoordenatuak(new Koordenatuak(1, 3));
		i3.kenduZatia();
		/**ordenagailuak goikoa begiratuko ditu
		 * zerrenda hustuko dugunez ez du eskuina begiratuko eta ontzia ez du hondoratuko (random egingo du)
		 */
		o.tiroEgin(j1);
		o.koordenatuenZerrendaHustu();
		o.tiroEgin(j1);
		assertSame(j1.zenbatItsasontzi(),4);
		
		//penalizazioa duenean txanda galdu
		o.setPenalizazioa(true);
		o.tiroEgin(j1);
	}

	@Test
	public void testTableroaPrestatu() {
		//modu automatikoan egiten du
		o.tableroaPrestatu();
		assertSame(o.zenbatItsasontzi(),6);
		o.guztizInprimatu();
		//zenbatu zenbat itsasontzi zati (16) eta mina kop (7)
		int minaKop = 0;
		int itsKop=0;
		for(int i = 0; i < Tableroa.getTamaina(); i++){
			for(int j = 0; j < Tableroa.getTamaina(); j++){
				if(o.getTableroa().minarikDago(i, j)){
					minaKop++;
				}
				else{
					if(o.getTableroa().itsasontzirikDago(i, j)!=null){
						itsKop++;
					}
				}
			}
		}
		assertSame(minaKop,7);
		assertSame(itsKop,16);
		
	}



}
