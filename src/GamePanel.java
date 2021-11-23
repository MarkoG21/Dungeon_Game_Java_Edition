import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;


public class GamePanel extends JPanel {

	//Übertragungswichtige Attribute
	private 	Image 	hintergrund;			//Attribut  1
	private		Image	spielerBild1;			//Attribut	4
	private		int		spielerBildPosX1;		//Attribut  5
	private		int		spielerBildPosY1; 		//Attribut  6
	
	private		Image	gegner1Bild1;			//Attribut	7
	private		int		gegner1BildPosX1;		//Attribut  8
	private		int		gegner1BildPosY1;		//Attribut  9
	
	// Sonstige Benötigte bilder
	private		Image	statusbar;
	private		Image	statusbarSpacePressed;
	private		Image	lebensBild;
	private		Image	lebensBildDark;
	private		Image	wassertextur;
	private		Image   gameOverImage;
	
	private		Image	sword;
	private		int		swordX;
	private		int		swordY;
	
	private		int		wateranim =0;

	private		SpielOberflaeche 	fenster;
	
	private		int					spielerLeben = 3; // Startinitialisierung von 3	
	
	private 	boolean				gameOver;
	private		boolean				enemyHitted;
	
	private		long				swordStartTime;
	private		long				swordTestTime;
	
	//Anfang Konstruktor
	public GamePanel(SpielOberflaeche f1) throws AWTException{
		super();
		
		fenster = f1;
		
		setBounds(0, 0, 1280, 720+108);
		setVisible(true);
		
		//Importieren der Texturen
		statusbar 				= fenster.dateiEinlesen("/rsc/Statusbar.png");
		statusbarSpacePressed 	= fenster.dateiEinlesen("/rsc/StatusbarLeertaste.png");
		lebensBild 				= fenster.dateiEinlesen("/rsc/StatusBar/HerzBild.png");
		lebensBildDark 			= fenster.dateiEinlesen("/rsc/StatusBar/HerzBildDark.png");
		wassertextur			= fenster.dateiEinlesen("/rsc/lvl1/water.jpg");
		gameOverImage			= fenster.dateiEinlesen("/rsc/GameOverSpaceholder.png");
	}
	//Ende Konstruktor
	
	
	@Override
	public void paint(Graphics g){
			super.paintComponent(g);
		    
			if(!gameOver){
				g.drawImage(wassertextur,0,wateranim,null);
				g.drawImage(hintergrund, 0, 0, null);
			
				g.drawImage(gegner1Bild1, gegner1BildPosX1, gegner1BildPosY1, null);
				
				g.drawImage(spielerBild1, spielerBildPosX1, spielerBildPosY1, null);
				
				//Wasser Animation#
				wateranim--;
				if(wateranim==-720){
					wateranim=0;
				}
				
				
				//SchadensindikatorGegner
				if(enemyHitted){
					g.drawString("- 1", gegner1BildPosX1+40, gegner1BildPosY1+5);
				}
				//////////////////////////////////////////////////////////////////////	
				//Statusbar
				if(fenster.getLeertaste()){
					g.drawImage(statusbarSpacePressed, 0, 710 , null);
				}
				else{
					g.drawImage(statusbar, 0, 710, null);
				}
				//
				//spawnpunkte Herzen überarbeiten
				switch (spielerLeben) {
					case 3:
						g.drawImage(lebensBild,		610, 760, null); // Linkes Herz
						g.drawImage(lebensBild, 	630, 760, null); // Mittleres Herz
						g.drawImage(lebensBild, 	650, 760, null); // Rechtes Herz
						break;
					case 2:
						g.drawImage(lebensBild,		610, 760, null); // Linkes Herz
						g.drawImage(lebensBild, 	630, 760, null); // Mittleres Herz
						g.drawImage(lebensBildDark, 650, 760, null); // Rechtes Herz
						break;
					case 1:
						g.drawImage(lebensBild, 	610, 760, null); // Linkes Herz
						g.drawImage(lebensBildDark, 630, 760, null); // Mittleres Herz
						g.drawImage(lebensBildDark, 650, 760, null); // Rechtes Herz
						break;
					case 0:
						g.drawImage(lebensBildDark, 610, 760, null); // Linkes Herz
						g.drawImage(lebensBildDark, 630, 760, null); // Mittleres Herz
						g.drawImage(lebensBildDark, 650, 760, null); // Rechtes Herz
						break;
					default:
						break;
				}
				g.drawString("Pre Alpha Version Made by Marko Guastella & Tim Bächle", 725, 775);
				///////////////////////////////////////////////////////////////////
			}
			else{
				g.drawImage(gameOverImage, 0, 0, null);
				
				if(fenster.getEnterPressed()){
					fenster.starteNeu();
				}
			}
		//Schwert Zeichnung
		g.drawImage(sword, swordX, swordY, null);
		
		//Falls Schwert vorhanden nach 0.5 sekunden wieder löschen
		swordTestTime = System.currentTimeMillis();
		if((swordTestTime - swordStartTime) > 500){
			sword = null;
		}
		
		
	}			
	
	
	//Anfang Operationen
	
	public void setzteLevelAktiv(int aktivstatus){
	}
	
	
	//Operation zum übertragen unterschiedlicher Daten --> ansteuerung der zu überschreibenden Information durch int welchesAttributwirdUeberschrieben 
	public void setzeDaten(int welchesAttributwirdUeberschrieben, Image bild, int pos){
		
		switch (welchesAttributwirdUeberschrieben){
		case 1:
			hintergrund			= bild;
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			spielerBild1		= bild;
			break;
		case 5:
			spielerBildPosX1	= pos;
			break;
		case 6:
			spielerBildPosY1	= pos;
			break;
		case 7:
			gegner1Bild1		= bild;
			break;
		case 8:
			gegner1BildPosX1	= pos;
			break;
		case 9:
			gegner1BildPosY1	= pos;
		default:
			break;
		}
		
	}
	
	public void setzteSpielerLeben(int leben){
		spielerLeben = leben;
	}


	public void setzeGameOver() {
		gameOver = true;
	}
	
	public void setEnemyHitted(boolean status){
		enemyHitted = status;
	}
	
	public boolean getEnemyHitted(){
		return enemyHitted;
	}
	
	public void setzteSchwertTexturUndPos (String richtung){
		Link spieler = fenster.getSpieler();
		
		if(richtung == "Hoch"){
			swordX = spieler.getPositionX() + 28;
			swordY = spieler.getPositionY() - 40;
			sword  = fenster.dateiEinlesen("/rsc/Schwert/SchwertHoch.png");
		}
		if(richtung == "Runter"){
			swordX = spieler.getPositionX() + 28;
			swordY = spieler.getPositionY() + 100;
			sword  = fenster.dateiEinlesen("/rsc/Schwert/SchwertRunter.png");
		}
		if(richtung == "Rechts"){
			swordX = spieler.getPositionX() + 76;
			swordY = spieler.getPositionY() + 40;
			sword  = fenster.dateiEinlesen("/rsc/Schwert/SchwertRechts.png");
		}
		if(richtung == "Links"){
			swordX = spieler.getPositionX() - 40;
			swordY = spieler.getPositionY() + 40;
			sword  = fenster.dateiEinlesen("/rsc/Schwert/SchwertLinks.png");
		}
		starteTimer();
	}
	
	private void starteTimer(){
		swordStartTime = System.currentTimeMillis();
	}
	
}
