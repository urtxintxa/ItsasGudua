package org.minakdev.itsasgudua;

public class Tableroa {
	
	private Laukia[][] lista;
	private static int minaKop = 3;
	private static int tamaina = 6;
	
	public Tableroa() {
		for(int i = 0; i < tamaina; i++) {
			for(int j = 0; j < tamaina; j++) {
				this.lista = new Laukia[i][j];
			}
		}
	}
	
	public void itsasontziaJarri(int pX, int pY, int pTamaina, char pNoranzkoa, Itsasontzia pItsasontzia) {
		if(pNoranzkoa == 'B') {
			for(int i = 0; i < pTamaina; i++) {
				this.lista[pX+i][pY].setItsasontzia(pItsasontzia);
			}
		}
		else {
			for(int i = 0; i < pTamaina; i++) {
				this.lista[pX][pY+1].setItsasontzia(pItsasontzia);			
			}
		}
	}
	
	public void minakJarri() {
		for(int i = 0; i < minaKop; i++ ) {
			boolean topatua = false;
			while(!topatua) {
				int x = (int)(Math.random()*(tamaina+1));
				int y = (int)(Math.random()*(tamaina+1));
				if(this.koordenatuEgokiak(x, y)) {
					this.lista[x][y].setMina(true);
					topatua = true;
				}
			}
			
		}
	}
	
	public Itsasontzia itsasontzirikDago(int pX, int pY) {
		return this.lista[pX][pY].getItsasontzia();
	}
	
	public boolean minarikDago(int pX, int pY) {
		return this.lista[pX][pY].getMina();
	}
	
	public void tableroOsoaInprimatu() {
		for(int i = 0; i < tamaina; i++) {
			for(int j = 0; j <= tamaina; j++) {
				this.lista[i][j].nireaInprimatu();
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void minakBoom(int pX, int pY, Jokalaria pAurkaria) {
		//1
		if(this.koordenatuEgokiak(pX - 1, pY - 1)){
			if(!this.begiratutaDago(pX - 1, pY - 1)) {
				this.minaLehertu(pX - 1, pY - 1, pAurkaria);
			}
		}
		//2
		else if(this.koordenatuEgokiak(pX, pY - 1)){
			if(!this.begiratutaDago(pX, pY - 1)) {
				this.minaLehertu(pX, pY - 1, pAurkaria);
			}
		}
		//3
		else if(this.koordenatuEgokiak(pX + 1, pY - 1)){
			if(!this.begiratutaDago(pX + 1, pY - 1)) {
				this.minaLehertu(pX + 1, pY - 1, pAurkaria);
			}
		}
		//4
		else if(this.koordenatuEgokiak(pX - 1, pY)){
			if(!this.begiratutaDago(pX - 1, pY)) {
				this.minaLehertu(pX - 1, pY, pAurkaria);
			}
		}
		//6
		else if(this.koordenatuEgokiak(pX + 1, pY)){
			if(!this.begiratutaDago(pX + 1, pY)) {
				this.minaLehertu(pX + 1, pY, pAurkaria);
			}
		}
		//7
		else if(this.koordenatuEgokiak(pX - 1, pY + 1)){
			if(!this.begiratutaDago(pX - 1, pY + 1)) {
				this.minaLehertu(pX - 1, pY + 1, pAurkaria);
			}
		}
		//8
		else if(this.koordenatuEgokiak(pX, pY + 1)){
			if(!this.begiratutaDago(pX, pY + 1)) {
				this.minaLehertu(pX, pY + 1, pAurkaria);
			}
		}
		//9
		else if(this.koordenatuEgokiak(pX + 1, pY + 1)){
			if(!this.begiratutaDago(pX + 1, pY + 1)) {
				this.minaLehertu(pX + 1, pY + 1, pAurkaria);
			}
		}
	}
	
	public void egungoTableroaInprimatu() {
		for(int i = 0; i <= tamaina; i++) {
			for(int j = 0; j <= tamaina; j++) {
				this.lista[i][j].aurkariarenaInprimatu();
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public boolean begiratutaDago(int pX, int pY) {
		return this.lista[pX][pY].getBegiratuta();
	}
	
	public boolean koordenatuEgokiak(int pX, int pY) {
		if(pX < 0 || pX > tamaina || pY < 0 || pY > tamaina ) {
			return false;
		}
		else {
			if(this.lista[pX][pY].getMina() || this.lista[pX][pY].getItsasontzia() != null) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	private void minaLehertu(int pX, int pY, Jokalaria pAurkaria) {
		if(this.itsasontzirikDago(pX, pY) != null){
			if()
		}
	}
	
	public void setBegiratuta(int pX, int pY, boolean pBegiratuta) {
		this.lista[pX][pY].setBegiratuta(pBegiratuta);
	}
}
