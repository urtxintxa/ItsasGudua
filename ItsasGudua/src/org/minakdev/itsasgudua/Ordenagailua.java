package org.minakdev.itsasgudua;

import java.util.ArrayList;

public class Ordenagailua extends Jokalaria{

	private ArrayList<Koordenatuak> itsasontzienKoordenatuak;
	
	public Ordenagailua(){
    	super("Ordenagailua");
    	this.itsasontzienKoordenatuak=new ArrayList<Koordenatuak>();
    }

	
	//Metodo zaharrekin eginda dago, orain jokalariaren metodoak erabiliz egin behar da
	
	
	 public void tiroEgin(Jokalaria pAurkari){
	    	int x=-1;
	    	int y=-1;
	    	boolean koordenatuBegiratua=true;
	    	Koordenatuak koor;
	    	Tableroa aurkariarenTableroa=pAurkari.getTableroa();
	    	
	    	if(this.getPenalizazioa()){
	    		System.out.println(this.getIzena()+"Txanda galdu duzu.");
	    		this.setPenalizazioa(false);
	    	}
	    	else{
	    		this.jokalariarenEgoeraInprimatu();
	    		pAurkari.jokalariarenEgoeraInprimatu();
	    		this.aurkariarenTableroaInprimatu(pAurkari);
	    		
	    		
		    	
			    koor=this.kalkulatuHurrengoKoordenatuak();
			    x= koor.getX();
		    	y= koor.getY();		


		    	
		    	aurkariarenTableroa.setBegiratuta(x, y, true);
		    	Itsasontzia its=aurkariarenTableroa.itsasontzirikDago(x, y);
		    	if(its!=null){
		    		this.gehituKoordenatuak(new Koordenatuak(x, y));
		    		its.kenduZatia();
		    		if(its.hondoratutaDago()){
		    			pAurkari.getListaItsasontziak().kenduItsaontzia(its);
		    			
		    			
		    			
		    			
		    			
		    			
		    			//koor-en ondoan beti tiro egin edo itsasontzi hori hondoratu ondoren kendu
		    			//ordenagailuak "tranpa" egin
		    			
		    			
		    			
		    			
		    			
		    			//ein metodo bat koordenatuEgokiak eta ez begiratua bateratzeko::::koordenatuOnak()
		    			
		    			
		    			
		    			
		    			
		    			
		    			
		    			
		    			
		    		}
		    		if(pAurkari.zenbatItsasontzi()!=0){
		    			this.tiroEgin(pAurkari);
		    		}
		    	}
		    	else{
		    		if(aurkariarenTableroa.minarikDago(x, y)){
		    			this.setPenalizazioa(true);
		    			this.minaIkutuakHanditu();
		    			if(!this.minaMaxGainditua()){
		    				aurkariarenTableroa.minakBoom(x, y, pAurkari);
		    			}
		    		}
		    	}
		    	
		    	
		    	
	    		
	    		
	    	}
	    	
	    	
	    }

	    public void itsasontziaJarri(Itsasontzia pItsasontzia){
	    	int x=this.lortuX();
	    	int y=this.lortuY();
	    	char horBer=this.lortuHorBer();
	    	int tamaina= pItsasontzia.getTamainaMax();
	    	boolean koordenatuZuzenak = this.koordenatuZuzenak(x, y, horBer, tamaina);
	    	
	    	while(!koordenatuZuzenak){
	    		x=this.lortuX();
	        	y=this.lortuY();
	        	horBer=this.lortuHorBer();
	        	koordenatuZuzenak = this.koordenatuZuzenak(x, y, horBer, tamaina);
	    	}
	    	
	    	this.getListaItsasontziak().gehituItsasontzia(pItsasontzia);
	    	this.getTableroa().itsasontziaJarri(x, y, tamaina, horBer, pItsasontzia);
	    	
	    }

	    private int lortuX(){
	    	int x = (int)Math.random()*(Tableroa.getTamaina()  + 1);
	    	return x;
	    }

	    private int lortuY(){
	    	int x = (int)Math.random()*(Tableroa.getTamaina()  + 1);
	    	return x;
	    }

	    private char lortuHorBer(){
	        
	    }

	    private Koordenatuak kalkulatuHurrengoKoordenatuak(Jokalaria pAurkari){//parametrorik gabe
	    	int x;
	    	int y;
	    	Koordenatuak koor;
	    	boolean koordenatuEgokiak=false;
	    	int zenbatKoor=this.zenbatKoordenatu();
	    	boolean jarraitu=true;
	    	
	    	
	    	if(zenbatKoor==0){
	    		while(!koordenatuEgokiak){
		    		x=this.lortuX();
		    		y= this.lortuY();
		    		koordenatuEgokiak=this.getTableroa().koordenatuEgokiak(x, y);   
		    		if(koordenatuEgokiak){
		    			koordenatuEgokiak=!pAurkari.getTableroa().begiratutaDago(x, y);
		    			//
		    			
		    			
		    			
		    			
		    		}
	    		}
	    	}
	    	else{
	    		if(zenbatKoor==1){
	    			koor=this.itsasontzienKoordenatuak.get(0);
	    			x=koor.getX();
	    			y=koor.getY(); 
		    		if(this.getTableroa().koordenatuEgokiak(x-1, y)){
		    			if(!pAurkari.getTableroa().begiratutaDago(x-1, y)){
		    				return new Koordenatuak(x-1, y);
		    			}
		    		}
		    		if(this.getTableroa().koordenatuEgokiak(x, y+1)){
		    			if(!pAurkari.getTableroa().begiratutaDago(x, y+1)){
		    				return new Koordenatuak(x, y+1);
		    			}
		    		}
		    		if(this.getTableroa().koordenatuEgokiak(x+1, y)){
		    			if(!pAurkari.getTableroa().begiratutaDago(x+1, y)){
		    				return new Koordenatuak(x+1, y);
		    			}
		    		}
		    		if(this.getTableroa().koordenatuEgokiak(x, y-1)){
		    			if(!pAurkari.getTableroa().begiratutaDago(x, y-1)){
		    				return new Koordenatuak(x, y-1);
		    			}
		    		}
		    		this.itsasontzienKoordenatuak.remove(0);
	    			
	    		}
	    		else{
	    			koor=this.itsasontzienKoordenatuak.get(0);
	    			Koordenatuak koorAux=this.itsasontzienKoordenatuak.get(1);
	    			x=koor.getX()-koorAux.getX();
	    			y=koor.getY()-koorAux.getY();
	    			if(y==0){
	    				x=koor.getX()+1;
	    				y=koor.getY();
	    				while(jarraitu){
	    					if(this.getTableroa().koordenatuEgokiak(x, y)){
	    						if(!pAurkari.getTableroa().begiratutaDago(x, y)){
	    							return 
	    						}
	    					}
	    				}
	    			}
	    		}
	    		
	    	}
	    	
	    	
	    	return
	    }

	    private void gehituKoordenatuak(Koordenatuak pKoordenatuak){
	    	this.itsasontzienKoordenatuak.add(pKoordenatuak);
	    }

	    private void kenduKoordenatuak(Koordenatuak pKoordenatuak){
	    	this.itsasontzienKoordenatuak.remove(pKoordenatuak);
	    }
	    
	    private int zenbatKoordenatu(){
	    	return this.itsasontzienKoordenatuak.size();
	    }


}
