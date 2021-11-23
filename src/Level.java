import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Level{

	//Generelle Attribute
	private			GamePanel 				spielFlaeche;
	private			SpielOberflaeche		gui;
	
	//Attribute Level 1
	private			Image					cave1;
	private 		Image					sworddown1;
	private 		Image					sworddown2;
	private 		Image					sworddown3;
	private 		Image					sworddown4;
	private 		Image					sworddown5;
	private 		Image					sworddown6;
	private 		Image					sworddown7;
	private			boolean					pausereset=true;
	private			boolean					startanimdown2=false;
	
	private			Image					linkIdle;
	private 		Image					linkfacing1;
	private 		Image					linkfacing2;
	private 		Image					linkfacing3;
	private 		Image					linkfacing4;
	private 		Image					linkfacing5;
	private 		Image					linkfacing6;
	private 		Image					linkfacing7;
	private 		Image					linkfacing8;
	
	private			Image					linkIdleRight;
	private			Image					linkright1;
	private			Image					linkright2;
	private			Image					linkright3;
	private			Image					linkright4;
	private			Image					linkright5;
	private			Image					linkright6;
	private			Image					linkright7;
	private			Image					linkright8;
	
	private			Image					linkIdleOben;
	private			Image					linkoben1;
	private			Image					linkoben2;
	private			Image					linkoben3;
	private			Image					linkoben4;
	private			Image					linkoben5;
	private			Image					linkoben6;
	private			Image					linkoben7;
	private			Image					linkoben8;
	
	private			Image					linkIdleLinks;
	private			Image					linklinks1;
	private			Image					linklinks2;
	private			Image					linklinks3;
	private			Image					linklinks4;
	private			Image					linklinks5;
	private			Image					linklinks6;
	private			Image					linklinks7;
	private			Image					linklinks8;
	private			int						LeeverUntergrundAnimation;
	
	private 		Image					hintergrundBild;
	private			Image					leeverBild;
	private			Image					leeverBild2;
	private			Image					leeverBild3;
	private			Image					leeverBild4;
	private			Image					leeverBild5;
	private			Image					leeverBildBlack;
	private			int						leevergrumbe = 0;
	private			Link					spieler;
	private			Leever_UntergrundGegner gegner1;
	private			int						leeveranimation = 0;
	private			boolean					leeverGoAnimate = true;
	private			int						startPunktXGegner1 = 900;
	private			int						startPunktYGegner1 = 500;
	private			int						startPunktXSpieler = 240; 
	private			int						startPunktYSpieler = 260; 
	private			int						swordanimdown=0;
	
	//Timing spezifische Attribute
	private			long					startZeitSystem;
	private			long					zeitZuSpäteremZeitpunkt;
	
	private			long					startZeitUnverwundbarkeitSpieler;
	private			long					zeitMesspunktUnverwundbarkeitSpieler;
	
	private			long					startZeitLeertastenSpamVermeidung;
	private			long					zeitMesspunktLeertastenSpamVermeidung;
	
	private			long					startZeitSchadensindikatorenGegner;
	private			long					zeitMesspunktSchadensindikatorenGegner;
	
	//Konstruktor
	public Level(GamePanel p1, SpielOberflaeche g1){
		spielFlaeche 	= p1;
		gui				= g1;
		
		
		holeResourcen();
		initialisiereObjekte();
		teileStartInformationenMitGUI();
		
		
		startZeitSystem 					= System.currentTimeMillis();
		startZeitUnverwundbarkeitSpieler	= System.currentTimeMillis();
		startZeitLeertastenSpamVermeidung	= System.currentTimeMillis();
		startZeitSchadensindikatorenGegner	= System.currentTimeMillis();
	}

	
	//Operationen
	private void 	holeResourcen(){                                                       
		linkIdle		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/Idle.png");         
		linkfacing1		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/1.png");            
		linkfacing2		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/2.png");            
		linkfacing3		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/3.png");            
		linkfacing4		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/4.png");            
		linkfacing5		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/5.png");               
		linkfacing6		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/6.png");               
		linkfacing7		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/7.png");               
		linkfacing8		= gui.dateiEinlesen("/rsc/Link/linkwalkingdown/8.png");
		                                                                                      
		linkIdleRight	= gui.dateiEinlesen("/rsc/Link/linkwalkingright/Idle.png");           
		linkright1		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/1.png");              
		linkright2		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/2.png");              
		linkright3		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/3.png");              
		linkright4		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/4.png");              
		linkright5		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/5.png");              
		linkright6		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/6.png");              
		linkright7		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/7.png");              
		linkright8		= gui.dateiEinlesen("/rsc/Link/linkwalkingright/8.png");              
		                                                                                                                                                                               
		linkIdleOben	= gui.dateiEinlesen("/rsc/Link/linkwalkingup/Idle.png");              
		linkoben1		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/1.png");                 
		linkoben2		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/2.png");                 
		linkoben3		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/3.png");                 
		linkoben4		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/4.png");                 
		linkoben5		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/5.png");                 
		linkoben6		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/6.png");              
		linkoben7		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/7.png");              
		linkoben8		= gui.dateiEinlesen("/rsc/Link/linkwalkingup/8.png");              
		                                                                                                                                             
		linkIdleLinks	= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/Idle.png");         
		linklinks1		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/1.png");            
		linklinks2		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/2.png");            
		linklinks3		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/3.png");            
		linklinks4		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/4.png");            
		linklinks5		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/5.png");            
		linklinks6		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/6.png");            
		linklinks7		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/7.png");            
		linklinks8		= gui.dateiEinlesen("/rsc/Link/linkwalkingleft/8.png");            
		
		
		hintergrundBild	= gui.dateiEinlesen("/rsc/level1_1280x720.png");
		leeverBild 		= gui.dateiEinlesen("/rsc/Leever/1.png");
		leeverBild2 	= gui.dateiEinlesen("/rsc/Leever/2.png");
		leeverBild3 	= gui.dateiEinlesen("/rsc/Leever/3.png");
		leeverBild4 	= gui.dateiEinlesen("/rsc/Leever/4.png");
		leeverBild5 	= gui.dateiEinlesen("/rsc/Leever/5.png");
		//leeverBildBlack = gui.dateiEinlesen("/rsc/Leever/6.png");
		
		cave1 = gui.dateiEinlesen("/rsc/Cave/cave1.jpg");
		  
		/*sworddown1       = gui.dateiEinlesen("/rsc/Link/linksworddown/1.png");
		sworddown2       = gui.dateiEinlesen("/rsc/Link/linksworddown/2.png");
		sworddown3       = gui.dateiEinlesen("/rsc/Link/linksworddown/3.png");
		sworddown4       = gui.dateiEinlesen("/rsc/Link/linksworddown/4.png");
		sworddown5       = gui.dateiEinlesen("/rsc/Link/linksworddown/5.png");
		sworddown6       = gui.dateiEinlesen("/rsc/Link/linksworddown/6.png");
		sworddown7       = gui.dateiEinlesen("/rsc/Link/linksworddown/7.png");*/
	}
	
	
	
	private	void 	initialisiereObjekte(){
		spieler = new Link(gui, startPunktXSpieler, startPunktYSpieler);
		gegner1 = new Leever_UntergrundGegner(gui, startPunktXGegner1, startPunktYGegner1, spieler);
	}
	
	
	private	void	teileStartInformationenMitGUI(){
		spielFlaeche.setzeDaten(1, hintergrundBild, 0);
		spielFlaeche.setzeDaten(4, linkIdle, 0);
		spielFlaeche.setzeDaten(7, leeverBild, 0);
		
		//SpielerPos
		spielFlaeche.setzeDaten(5, null, spieler.getPositionX());
		spielFlaeche.setzeDaten(6, null, spieler.getPositionY());
		//GegnerPos
		spielFlaeche.setzeDaten(8, null, gegner1.getPositionX());
		spielFlaeche.setzeDaten(9, null, gegner1.getPositionY());
	}
	
	public void		aktualisiereDaten(){
		if(gui.getIsPlayerInsideCave() == true){
			spielFlaeche.setzeDaten(1, cave1, 0);
		}
		else{
			spielFlaeche.setzeDaten(1, hintergrundBild, 0);	
		}
		
		//Leever Animation
		LeeverUntergrundAnimation++;
		if(LeeverUntergrundAnimation==1000){
			leeverGoAnimate=false;
			spielFlaeche.setzeDaten(7, leeverBild4, 0);
		}
			if(LeeverUntergrundAnimation==1050){
				spielFlaeche.setzeDaten(7, leeverBild3, 0);
			}
				if(LeeverUntergrundAnimation==1100){
					spielFlaeche.setzeDaten(7, leeverBild2, 0);
				}
					if(LeeverUntergrundAnimation==1150){
						spielFlaeche.setzeDaten(7, leeverBild, 0);
					}
					
					if(LeeverUntergrundAnimation>1200){
						leevergrumbe++;
						if(leevergrumbe<50){
						spielFlaeche.setzeDaten(7, leeverBildBlack,0 );
						}
								if(leevergrumbe>50 && leevergrumbe < 100){
									spielFlaeche.setzeDaten(7, leeverBild,0 );
								}
								if(leevergrumbe ==100){
									leevergrumbe=0;
								}
								
						gegner1.setAnimationState("else");
						if(LeeverUntergrundAnimation>1600){
							leeveranimation=0;
							LeeverUntergrundAnimation=-300;
							gegner1.setAnimationState("oben");
							leeverGoAnimate=true;
						}
					}
		
		
		
		//Falls Schadensindikatoren angezeigt werden, sollen diese nach 3 Sekunden wieder verschwinden
		if(spielFlaeche.getEnemyHitted()){
			zeitMesspunktSchadensindikatorenGegner = System.currentTimeMillis();
			if((zeitMesspunktSchadensindikatorenGegner - startZeitSchadensindikatorenGegner) >= 3000){
				spielFlaeche.setEnemyHitted(false);;
				startZeitSchadensindikatorenGegner = System.currentTimeMillis();
			}
		}
		//Ende Schadensindikatoren Löschung
		
		//Gegner in Spielerichtung schicken
		zeitZuSpäteremZeitpunkt = System.currentTimeMillis();
		
		if((zeitZuSpäteremZeitpunkt - startZeitSystem) > 50){
			startZeitSystem = System.currentTimeMillis();
			gegner1.bewegeZumSpieler();
		}
		//Ende Gegner in Spielerichtung schicken
		
		//Gegner Angriff prüfen und auf Kollision überprüfen
		// Hitbox vom Schwert 40x20 
		if(!spieler.getBesitztSchwert()){
			if(gui.getLeertaste()){
				
				zeitMesspunktLeertastenSpamVermeidung = System.currentTimeMillis();
				
				if(!spieler.getBefindeImKampf() && ((zeitMesspunktLeertastenSpamVermeidung - startZeitLeertastenSpamVermeidung) >= 250)){
			
					spieler.setKampfStatus(true);
					
					switch (gui.getLastPressed()) {
					case 1:
						//Angriff nach Unten
						spielFlaeche.setzteSchwertTexturUndPos("Runter");
						if(((gegner1.getPositionX() >= (spieler.getPositionX() + (28 - 40))) && (gegner1.getPositionX() <= (spieler.getPositionX()+48))) && ((gegner1.getPositionY() <= (spieler.getPositionY()+ 140)) && (gegner1.getPositionY() >= (spieler.getPositionY() +60)))){
							gegner1.zieheLeben();
							spielFlaeche.setEnemyHitted(true);
						}
						break;
					case 2:
						//Angriff nach Oben
						spielFlaeche.setzteSchwertTexturUndPos("Hoch");
						if(((gegner1.getPositionX() >= (spieler.getPositionX() + (28 - 40))) && (gegner1.getPositionX() <= (spieler.getPositionX()+48))) && ((gegner1.getPositionY() <= (spieler.getPositionY()+ 80)) && (gegner1.getPositionY() >= (spieler.getPositionY())))){
							gegner1.zieheLeben();
							spielFlaeche.setEnemyHitted(true);
						}
						break;
					case 3:
						//Angriff nach Rechts
						spielFlaeche.setzteSchwertTexturUndPos("Rechts");
						if(((gegner1.getPositionX() >= (spieler.getPositionX() + (76 - 40))) && (gegner1.getPositionX() <= (spieler.getPositionX()+116))) && ((gegner1.getPositionY() <= (spieler.getPositionY()+ 60)) && (gegner1.getPositionY() >= (spieler.getPositionY() - 40)))){
							gegner1.zieheLeben();
							spielFlaeche.setEnemyHitted(true);
						}
						break;
					case 4:
						//Angriff nach Links
						spielFlaeche.setzteSchwertTexturUndPos("Links");
						if(((gegner1.getPositionX() <= spieler.getPositionX()) && (gegner1.getPositionX() >= (spieler.getPositionX() - (40 + 80) ))) && ((gegner1.getPositionY() <= (spieler.getPositionY()+ 60)) && (gegner1.getPositionY() >= (spieler.getPositionY() - 40)))){
							gegner1.zieheLeben();
							spielFlaeche.setEnemyHitted(true);
						}
						break;
		
					default:
						break;
					}
					startZeitLeertastenSpamVermeidung = System.currentTimeMillis();
				}
				spieler.setKampfStatus(false);
				
		    }
		}
		//Ende Gegner Angriff prüfen
		
		//////////////////Spieler - Gegner Kollison////////////////////////////////
		if(gegner1 != null){
		if(!gegner1.getIstDerGegnerTod() && !spieler.getIstDerSpielerTot()){
				if(((gegner1.getPositionX() <= (spieler.getPositionX() + 76)) && (gegner1.getPositionX() >= spieler.getPositionX())) && ((gegner1.getPositionY() <= (spieler.getPositionY()+ 100)) && (gegner1.getPositionY() >= spieler.getPositionY()))) {
						
						if(gegner1.getBefindeImAngriff() && !spieler.getBefindeImKampf()){
							zeitMesspunktUnverwundbarkeitSpieler = System.currentTimeMillis();
							
							if((zeitMesspunktUnverwundbarkeitSpieler - startZeitUnverwundbarkeitSpieler) > 1500){
								spieler.setzteUnverwundbarStatus(false);
							}
							
							
							if(!spieler.getUnverwundbar()){
								spieler.lebenZiehen();
								spieler.setzteUnverwundbarStatus(true);
								startZeitUnverwundbarkeitSpieler = System.currentTimeMillis();
							}
							
						}
						if(gegner1.getBefindeImAngriff() && spieler.getBefindeImKampf()){
							System.out.println("Angiff auf Angriff wird zu Block");
						}
						if(!gegner1.getBefindeImAngriff() && spieler.getBefindeImKampf()){
							gegner1.zieheLeben();
							spielFlaeche.setEnemyHitted(true);
						}
						if(!gegner1.getBefindeImAngriff() && !spieler.getBefindeImKampf()){
							// Gegner soll nun auf zufälliger Basis den Angriff starten --> zu 35%
							double zufälligeGegnerAngriffsZahl = Math.random() * 10;
							if(zufälligeGegnerAngriffsZahl >= 1 && zufälligeGegnerAngriffsZahl <= 3.5){
								gegner1.angreifen();
							}
						}
				}
		}
	}

		//////////////////Ende Spieler - Gegner Kollison///////////////////////////
		
		
		//Spieler Leben überprüfen und weitergeben --> Für statusbar
			spielerCheck();
		// Spieler Leben überprüfen Ende
		
			
			if(leeverGoAnimate==true){
		if(leeveranimation < 40){spielFlaeche.setzeDaten(7, leeverBild, 0);}
		if(leeveranimation >= 40 && leeveranimation <80){spielFlaeche.setzeDaten(7, leeverBild2, 0);}
		if(leeveranimation >= 80 && leeveranimation <120){spielFlaeche.setzeDaten(7, leeverBild3, 0);}
		if(leeveranimation >= 120 && leeveranimation < 160){spielFlaeche.setzeDaten(7, leeverBild4, 0);}
		if(leeveranimation >= 160 && leeveranimation <=200){spielFlaeche.setzeDaten(7, leeverBild5, 0);}
		if(leeveranimation==200){
			leeveranimation = 120;
		}
			leeveranimation++;
			}
		//SpielerPos
		spielFlaeche.setzeDaten(5, null, spieler.getPositionX());
		spielFlaeche.setzeDaten(6, null, spieler.getPositionY());
		
		if(gui.lastpressed == 1){
			spielFlaeche.setzeDaten(4, linkIdle, 0);
		}
		if(gui.lastpressed == 3){
			spielFlaeche.setzeDaten(4, linkIdleRight, 0);
		}
		
		if(gui.lastpressed == 2){
			spielFlaeche.setzeDaten(4, linkIdleOben, 0);
		}
		
		if(gui.lastpressed == 4){
			spielFlaeche.setzeDaten(4, linkIdleLinks, 0);
		}
		
		
		if(gui.getPfeilTasteRechts()==true){
		if(gui.getAnimationsCounterRechts()<=25){
		spielFlaeche.setzeDaten(4, linkright1, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=50 && gui.getAnimationsCounterRechts() > 25) {
		spielFlaeche.setzeDaten(4, linkright2, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=75 && gui.getAnimationsCounterRechts() > 50){
		spielFlaeche.setzeDaten(4, linkright3, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=100 && gui.getAnimationsCounterRechts() > 75){
		spielFlaeche.setzeDaten(4, linkright4, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=125 && gui.getAnimationsCounterRechts() > 100){
		spielFlaeche.setzeDaten(4, linkright5, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=150 && gui.getAnimationsCounterRechts() > 125){
		spielFlaeche.setzeDaten(4, linkright6, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=175 && gui.getAnimationsCounterRechts() > 150){
		spielFlaeche.setzeDaten(4, linkright7, 0);
		}
		
		if(gui.getAnimationsCounterRechts()<=200 && gui.getAnimationsCounterRechts() > 175){
		spielFlaeche.setzeDaten(4, linkright8, 0);
		}
		
		
		}
		
		// Schwert Animation
		if(gui.getLeertaste()){
			startanimdown2=true;
		}
		
		swordanimdown=swordanimdown+2;
		if(!gui.getLeertaste()){
			pausereset=true;
		}
		if(gui.lastpressed==1){
			if(startanimdown2==true){
				if(pausereset==true){
				swordanimdown=0;
				pausereset=false;
				}
			if(swordanimdown<=25){

				spielFlaeche.setzeDaten(4, sworddown1, 0);
				}
				
				if(swordanimdown<=50 && swordanimdown > 25) {
				spielFlaeche.setzeDaten(4, sworddown2, 0);
				}
				
				if(swordanimdown<=75 && swordanimdown > 50){
				spielFlaeche.setzeDaten(4, sworddown3, 0);
				}
				
				if(swordanimdown<=100 && swordanimdown > 75){
				spielFlaeche.setzeDaten(4, sworddown4, 0);
				}
				
				if(swordanimdown<=125 && swordanimdown > 100){
				spielFlaeche.setzeDaten(4, sworddown5, 0);
				}
				
				if(swordanimdown<=150 && swordanimdown > 125){
				spielFlaeche.setzeDaten(4, sworddown6, 0);
				}
				
				if(swordanimdown<=175 && swordanimdown > 150){
				spielFlaeche.setzeDaten(4, sworddown7, 0);
				if(swordanimdown > 175){
				pausereset=true;
				startanimdown2=false;
				
				}
			  }
		    }
			
			
		}
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////
		
		
		if(gui.getPfeilTasteUnten()==true){
		if(gui.getAnimationsCounterOben()<=25){
		spielFlaeche.setzeDaten(4, linkfacing1, 0);
		}
		
		if(gui.getAnimationsCounterOben()<=50 && gui.getAnimationsCounterOben() > 25) {
		spielFlaeche.setzeDaten(4, linkfacing2, 0);
		}
		
		if(gui.getAnimationsCounterOben()<=75 && gui.getAnimationsCounterOben() > 50){
		spielFlaeche.setzeDaten(4, linkfacing3, 0);
		}
		
		if(gui.getAnimationsCounterOben()<=100 && gui.getAnimationsCounterOben()> 75){
		spielFlaeche.setzeDaten(4, linkfacing4, 0);
		}
		
		if(gui.getAnimationsCounterOben() <=125 && gui.getAnimationsCounterOben() > 100){
		spielFlaeche.setzeDaten(4, linkfacing5, 0);
		}
		
		if(gui.getAnimationsCounterOben()<=150 && gui.getAnimationsCounterOben() > 125){
		spielFlaeche.setzeDaten(4, linkfacing6, 0);
		}
		
		if(gui.getAnimationsCounterOben()<=175 && gui.getAnimationsCounterOben() > 150){
		spielFlaeche.setzeDaten(4, linkfacing7, 0);
		}
		
		if(gui.getAnimationsCounterOben()<=200 && gui.getAnimationsCounterOben() > 175){
		spielFlaeche.setzeDaten(4, linkfacing8, 0);
		}
	}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(gui.getPfeilTasteOben()==true){
		if(gui.getAnimationsCounterLinks()<=25){
		spielFlaeche.setzeDaten(4, linkoben1, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=50 && gui.getAnimationsCounterLinks() > 25) {
		spielFlaeche.setzeDaten(4, linkoben2, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=75 && gui.getAnimationsCounterLinks() > 50){
		spielFlaeche.setzeDaten(4, linkoben3, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=100 && gui.getAnimationsCounterLinks() > 75){
		spielFlaeche.setzeDaten(4, linkoben4, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=125 && gui.getAnimationsCounterLinks() > 100){
		spielFlaeche.setzeDaten(4, linkoben5, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=150 && gui.getAnimationsCounterLinks() > 125){
		spielFlaeche.setzeDaten(4, linkoben6, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=175 && gui.getAnimationsCounterLinks() > 150){
		spielFlaeche.setzeDaten(4, linkoben7, 0);
		}
		
		if(gui.getAnimationsCounterLinks() <=200 && gui.getAnimationsCounterLinks() > 175){
		spielFlaeche.setzeDaten(4, linkoben8, 0);
		}
	}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(gui.getPfeilTasteLinks()==true){
		if(gui.getAnimationsCounter()<=25){
		spielFlaeche.setzeDaten(4, linklinks1, 0);
		}
		
		if(gui.getAnimationsCounter()<=50 && gui.getAnimationsCounter() > 25) {
		spielFlaeche.setzeDaten(4, linklinks2, 0);
		}
		
		if(gui.getAnimationsCounter()<=75 && gui.getAnimationsCounter() > 50){
		spielFlaeche.setzeDaten(4, linklinks3, 0);
		}
		
		if(gui.getAnimationsCounter()<=100 && gui.getAnimationsCounter() > 75){
		spielFlaeche.setzeDaten(4, linklinks4, 0);
		}
		
		if(gui.getAnimationsCounter()<=125 && gui.getAnimationsCounter() > 100){
		spielFlaeche.setzeDaten(4, linklinks5, 0);
		}
		
		if(gui.getAnimationsCounter()<=150 && gui.getAnimationsCounter() > 125){
		spielFlaeche.setzeDaten(4, linklinks6, 0);
		}
		
		if(gui.getAnimationsCounter()<=175 && gui.getAnimationsCounter() > 150){
		spielFlaeche.setzeDaten(4, linklinks7, 0);
		}
		
		if(gui.getAnimationsCounter()<=200 && gui.getAnimationsCounter() > 175){
		spielFlaeche.setzeDaten(4, linklinks8, 0);
		}
	}
		
		/////////////////////////////////
		//GegnerPos
		spielFlaeche.setzeDaten(8, null, gegner1.getPositionX());
		spielFlaeche.setzeDaten(9, null, gegner1.getPositionY());
		
		//Tod Abfrage
		if(spieler.getIstDerSpielerTot()){
			spielFlaeche.setzeDaten(4, null, 0);
			spielFlaeche.setzeGameOver();
		}
		if(gegner1.getIstDerGegnerTod()){
			spielFlaeche.setzeDaten(7, null, 0);
		}
	}
	
	public boolean abbruch(){
		if(spieler.getIstDerSpielerTot()){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public Link gibSpieler(){
		return spieler;
	}
	
	private void spielerCheck(){
		spielFlaeche.setzteSpielerLeben(spieler.getleben());
	}
}
