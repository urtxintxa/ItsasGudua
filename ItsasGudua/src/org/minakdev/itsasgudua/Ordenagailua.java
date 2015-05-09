package org.minakdev.itsasgudua;

import java.util.ArrayList;

public class Ordenagailua extends Jokalaria{

	private ArrayList<Koordenatuak> itsasontzienKoordenatuak;
	
	public Ordenagailua(){
    	super("Ordenagailua");
    	this.itsasontzienKoordenatuak=new ArrayList<Koordenatuak>();
    }

	
	
	public void tiroEgin(Jokalaria pAurkari){
		int x=-1;
		int y=-1;
		Tableroa aurkariarenTableroa=pAurkari.getTableroa();	    	
		if(this.getPenalizazioa()){
			System.out.println("Ordenagailuak txanda galdu du.");
		    this.setPenalizazioa(false);
		}
		else{
			Koordenatuak koor;
		    this.jokalariarenEgoeraInprimatu();
		    pAurkari.jokalariarenEgoeraInprimatu();
		    pAurkari.partzialkiInprimatu();
		    		
			koor=this.kalkulatuHurrengoKoordenatuak(pAurkari);
			x= koor.getX();
			y= koor.getY();
			    	
			aurkariarenTableroa.setBegiratuta(x, y, true);
			Itsasontzia its=aurkariarenTableroa.itsasontzirikDago(x, y);
			if(its!=null){
				this.gehituKoordenatuak(new Koordenatuak(x, y));
			    its.kenduZatia();
			    if(its.hondoratutaDago()){
			    	pAurkari.getListaItsasontziak().kenduItsasontzia(its);
			    	this.itsasontzienKoordenatuak.clear();
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
		
	 	
	    private Koordenatuak kalkulatuHurrengoKoordenatuak(Jokalaria pAurkari){
	    	int x;
	    	int y;
	    	Koordenatuak koor=null;
			Koordenatuak k1;
			Koordenatuak k2;
	    	boolean koordenatuEgokiak=false;
	    	int zenbatKoor=this.zenbatKoordenatu();
	    	boolean jarraitu=true;
	    	Tableroa aurkariarenTableroa=pAurkari.getTableroa();
	    	
	    	if(zenbatKoor==0){
	    		while(!koordenatuEgokiak){
		    		x = this.lortuXY();
		    		y = this.lortuXY();
		    		koordenatuEgokiak=aurkariarenTableroa.koordenatuEgokiak(x, y);   
		    		if(koordenatuEgokiak){
		    			koordenatuEgokiak=!aurkariarenTableroa.begiratutaDago(x, y);
						koor = new Koordenatuak(x,y);
		    		}
	    		}
	    	}
	    	else{
	    		if(zenbatKoor==1){
	    			k1=this.itsasontzienKoordenatuak.get(0);
	    			x=k1.getX();
	    			y=k1.getY(); 
		    		if(aurkariarenTableroa.koordenatuEgokiak(x-1, y)){
		    			if(!aurkariarenTableroa.begiratutaDago(x-1, y)){
		    				return new Koordenatuak(x-1, y);
		    			}
		    		}
		    		if(aurkariarenTableroa.koordenatuEgokiak(x, y+1)){
		    			if(!aurkariarenTableroa.begiratutaDago(x, y+1)){
		    				return new Koordenatuak(x, y+1);
		    			}
		    		}
		    		if(aurkariarenTableroa.koordenatuEgokiak(x+1, y)){
		    			if(!aurkariarenTableroa.begiratutaDago(x+1, y)){
		    				return new Koordenatuak(x+1, y);
		    			}
		    		}
		    		if(aurkariarenTableroa.koordenatuEgokiak(x, y-1)){
		    			if(!aurkariarenTableroa.begiratutaDago(x, y-1)){
		    				return new Koordenatuak(x, y-1);
		    			}
		    		}
		    		this.itsasontzienKoordenatuak.remove(0);
						return this.kalkulatuHurrengoKoordenatuak(pAurkari);
	    		}
	    		else{
	    			k1=this.itsasontzienKoordenatuak.get(0);
	    			k2=this.itsasontzienKoordenatuak.get(1);
	    			x=k1.getX()-k2.getX();
	    			y=k1.getY()-k2.getY();
	    			boolean noranzkoaAldatu=false;
					if(y==0){
	    				x=k1.getX()+1;
	    				y=k1.getY();
	    				while(jarraitu){
	    					if(aurkariarenTableroa.koordenatuEgokiak(x, y)){
	    						if(!aurkariarenTableroa.begiratutaDago(x, y)){
	    							koor= new Koordenatuak(x,y);
									jarraitu=false;
	    						}
								else{
									if(aurkariarenTableroa.itsasontzirikDago(x,y)==null){
										noranzkoaAldatu=true;
										jarraitu=false;
									}
									else{x++;}
								}
	    					}
							else{
								noranzkoaAldatu=true;
								jarraitu=false;
							}
							
	    				}
						if(noranzkoaAldatu){
							jarraitu=true;
							x=k1.getX()-1;
							y=k1.getY();
							while(jarraitu){
								if(aurkariarenTableroa.koordenatuEgokiak(x, y)){
									if(!aurkariarenTableroa.begiratutaDago(x, y)){
										koor= new Koordenatuak(x,y);
										jarraitu=false;
									}
									else{
										if(aurkariarenTableroa.itsasontzirikDago(x,y)==null){
											jarraitu=false;
										}
										else{x--;}
									}
								}
								else{
									jarraitu=false;
								}
							
							}
						}
	    			}
					else{
						if(x==0){
							x=k1.getX();
							y=k1.getY()+1;
							while(jarraitu){
								if(aurkariarenTableroa.koordenatuEgokiak(x, y)){
									if(!aurkariarenTableroa.begiratutaDago(x, y)){
										koor= new Koordenatuak(x,y);
										jarraitu=false;
									}
									else{
										if(aurkariarenTableroa.itsasontzirikDago(x,y)==null){
											noranzkoaAldatu=true;
											jarraitu=false;
										}
										else{y++;}
									}
								}
								else{
									noranzkoaAldatu=true;
									jarraitu=false;
								}
								
							}
							if(noranzkoaAldatu){
								jarraitu=true;
								x=k1.getX();
								y=k1.getY()-1;
								while(jarraitu){
									if(aurkariarenTableroa.koordenatuEgokiak(x, y)){
										if(!aurkariarenTableroa.begiratutaDago(x, y)){
											koor= new Koordenatuak(x,y);
											jarraitu=false;
										}
										else{
											if(aurkariarenTableroa.itsasontzirikDago(x,y)==null){
												jarraitu=false;
											}
											else{y--;}
										}
									}
									else{
										jarraitu=false;
									}
								
								}
							}
						}
						
					}
	    		}
	    		
	    	}
			if(koor==null){
				for(int i=1; i<zenbatKoor; i++){
					this.itsasontzienKoordenatuak.remove(i);
				}
				return this.kalkulatuHurrengoKoordenatuak(pAurkari);
			}
	    	
	    	
	    	return koor;
	    }

	    private void gehituKoordenatuak(Koordenatuak pKoordenatuak){
	    	this.itsasontzienKoordenatuak.add(pKoordenatuak);
	    }

	    
	    private int zenbatKoordenatu(){
	    	return this.itsasontzienKoordenatuak.size();
	    }


	    public void tableroaPrestatu(){
	    	super.tableroaPrestatuAutomatiko();
	    }

}
