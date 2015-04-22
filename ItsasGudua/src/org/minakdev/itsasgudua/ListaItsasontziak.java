package org.minakdev.itsasgudua;

import java.util.ArrayList;

public class ListaItsasontziak {
	private ArrayList<Itsasontzia> lista;
	
	public ListaItsasontziak() {
		this.lista = new ArrayList<Itsasontzia>();
	}
	
	public void gehituItsasontzia(Itsasontzia pItsasontzia) {
		this.lista.add(pItsasontzia);
	}
	
	public void kenduItsasontzia(Itsasontzia pItsasontzia) {
		this.lista.remove(pItsasontzia);
	}

	public int zenbatItsasontzi() {
		return this.lista.size();
	}
}
