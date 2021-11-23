import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class SpielOberflaeche extends JFrame implements KeyListener  {

	//Anfang Attribute
	private		boolean				caveinside;
	private 	JFrame				spielFrame;
	private		JPanel				contentPane;
	private		int					widthMonitor;
	private		int					heightMonitor;
	private		int					welchesLevelIstAktiv;
	private		int					fensterausrichtungX;
	private		int					fensterausrichtungY;
	private		Point				originxy;
	private		int					counter = 0;
	private		GamePanel			spielFlaeche;
	private		Level			aktuellesLevel;
	public double		    		animationcounter 		= 0;
	public double					animationscounterUp		= 0;
	public double					animationscounterLeft	= 0;
	public double 					animationscounterRight 	= 0;
	public int						lastpressed;
	private String					levelAktiv = "Startlevel";
	private int						topLeftCornerX;
	private	int						topLeftCornerY;
	////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	private	final 	int				fensterHoehe		= 720 + 80;
	private final	int				fensterBreite		= 1280;
	///////////////////////////////////////////////////////////////
	private int 					feldEckevonBildschirmrandX;
	private int 					feldEckevonBildschirmrandY;
	///////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//KeyListener Attribute
	private boolean				pfeilTasteLinks;
	private boolean				pfeilTasteRechts;
	private boolean				pfeilTasteOben;
	private boolean				pfeilTasteUnten;
	private boolean				leerTaste;
	private boolean				escape;
	private	boolean				enter;
	/////////////////////////////////////////////////////////////////
	private	boolean				obenLaufenBlockiert;
	private	boolean				untenLaufenBlockiert;
	private	boolean				rechtsLaufenBlockiert;
	private	boolean				linksLaufenBlockiert;
	
	private Link 				spieler;
	
	private	boolean				neustart;
	
	private Image				windowIcon;
	//Ende Attribute
	
	//Anfang Konstruktor
	public SpielOberflaeche(int heightMonitorUebergabe, int widthMonitorUebergabe, int fensterausrichtungAufXUebergabe, int fensterausrichtungAufYUebergabe) throws AWTException {
		
		super();
		heightMonitor 				= heightMonitorUebergabe;
		widthMonitor 				= widthMonitorUebergabe;
		fensterausrichtungX 		= fensterausrichtungAufXUebergabe;
		fensterausrichtungY 		= fensterausrichtungAufYUebergabe;
		
		feldEckevonBildschirmrandX	= fensterausrichtungX  + 6; 
		feldEckevonBildschirmrandY  = fensterausrichtungY  + 18;
		
		windowIcon = new ImageIcon(getClass().getResource("/rsc/triforceIconGold.png")).getImage();
		
		this.setIconImage(windowIcon);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("The Legend of Java");
		this.addKeyListener(this);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	
		addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent evt) { System.exit(0); }
		    });
	
		setBounds(fensterausrichtungX,fensterausrichtungY , fensterBreite, fensterHoehe);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		
		spielFlaeche = new GamePanel(this);
	
		contentPane.add(spielFlaeche);
		repaint();
		
		initialisiereLevel1();

		/////////////////////////////////////////////
		//MultiThreading 
		Thread t1;
		try {
			t1 = new Thread( new GameLoop(this, aktuellesLevel) );
			t1.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		//////////////////////////////////////////////
	}
	//Ende Konstruktor
	
public boolean getIsPlayerInsideCave(){
	return caveinside;
}
	
public int getplayerx(){
	return spieler.getPositionX();
}

public int getplayery(){
	return spieler.getPositionY();
}

public void setplayercoordsx(int i){
	spieler.setposx(i);
}

public void setplayercoordsy(int u){
	spieler.setposy(u);
}
	
public void bumpPlayerRechts(){
	 spieler.erhoeheXKoordiante();
	 spieler.erhoeheXKoordiante();
	 spieler.erhoeheXKoordiante();
 }
 
 public void bumpPlayerLinks(){
	 spieler.vermindereXKoordinate();
	 spieler.vermindereXKoordinate();
	 spieler.vermindereXKoordinate();
 }
 
 public void bumpPlayerDown(){
	 spieler.erhoeheYKoordiante();
	 spieler.erhoeheYKoordiante();
	 spieler.erhoeheYKoordiante();
	 }
 
 public void bumpPlayerUp(){
	 spieler.vermindereYKoordinate();
	 spieler.vermindereYKoordinate();
	 spieler.vermindereYKoordinate();
 }
	//Level 1 Zeug
	private void initialisiereLevel1(){
		aktuellesLevel = new Level(spielFlaeche, this); 
		spielFlaeche.setzteLevelAktiv(1);
	}

		//Operation zum einlesen von Dateien --> Teile entnommen von https://stackoverflow.com/questions/25635636/eclipse-exported-runnable-jar-not-showing-images
	public Image dateiEinlesen(String quelle){
		Image datei = null;
		
		java.net.URL url = StartOberflaeche.class.getResource(quelle);
		ImageIcon icon = new ImageIcon(url);
		
		datei = icon.getImage();
		return datei;
	}
		

	//KeyListener Operationen
	@Override
	public void keyPressed(KeyEvent event1) {
		switch (event1.getKeyCode()) {

		case KeyEvent.VK_LEFT:
			lastpressed = 4;
			pfeilTasteLinks = true;
			break;
		
		case KeyEvent.VK_RIGHT:
			lastpressed = 3;
			pfeilTasteRechts = true;
			break;
		
		case KeyEvent.VK_UP:
			lastpressed = 2;
			pfeilTasteOben = true;
			break;
			
		case KeyEvent.VK_DOWN:
			lastpressed = 1;
			pfeilTasteUnten = true;
			break;
			
		case KeyEvent.VK_SPACE:
			leerTaste = true;
			break;
			
		case KeyEvent.VK_ESCAPE:
			escape = true;
			break;
		
		case KeyEvent.VK_ENTER:
			enter = true;
			break;
			
		default:
			break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent event2) {
		switch (event2.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			pfeilTasteLinks = false; 
			break;
		
		case KeyEvent.VK_RIGHT:
			pfeilTasteRechts = false;
			break;
			
		case KeyEvent.VK_UP:
			pfeilTasteOben = false;
			break;
			
		case KeyEvent.VK_DOWN:
			pfeilTasteUnten = false;
			break;
			
		case KeyEvent.VK_SPACE:
			leerTaste = false;
			break;
			
		case KeyEvent.VK_ENTER:
			enter = false;
			break;
			
		default:
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent event1) {	
	}
	
	//Ende KeyListener Operationen
	
	//Operation zum überprüfen der Eingaben und Laufen des Spielers
	public void pruefeEingaben(){
		while(counter == 0){
			originxy = this.getLocationOnScreen();
			counter++;
		}
		if(this.getLocationOnScreen() != originxy ) 
		setBounds(fensterausrichtungX,fensterausrichtungY , fensterBreite, fensterHoehe);
		spieler = aktuellesLevel.gibSpieler();
		 
		if (pfeilTasteLinks) {
			if(animationcounter >= 200){
				animationcounter = 0;
			}

			if(!linksLaufenBlockiert){
				spieler.vermindereXKoordinate();
			}
			animationcounter=animationcounter+1.25;
		}
		if (pfeilTasteRechts) {
			if(animationscounterRight >= 200){
				animationscounterRight = 0;
			}
	
			if(!rechtsLaufenBlockiert){ 
				spieler.erhoeheXKoordiante();
			}
			animationscounterRight=animationscounterRight+1.25;

		}
		if (pfeilTasteOben) {

			if(animationscounterLeft >= 200){
				animationscounterLeft = 0;
			}
			if(!obenLaufenBlockiert){
				spieler.vermindereYKoordinate();
			}
			animationscounterLeft=animationscounterLeft+1.25;
		}
		if (pfeilTasteUnten) {
			if(animationscounterUp >= 200){
				animationscounterUp = 0;
			}

			if(!untenLaufenBlockiert){
				spieler.erhoeheYKoordiante();
			}
			animationscounterUp=animationscounterUp+1.25;
			}
		
	}
	
	//Operationen für die Übergabe der KeyListener booleans
	public boolean getLeertaste(){
		return leerTaste;
	}
	
	public boolean getPfeilTasteLinks() {
		return pfeilTasteLinks;
	}
	
	public boolean getPfeilTasteOben(){
		return pfeilTasteOben;
	}
	
	public boolean getEnterPressed(){
		return enter;
	}
	
	public boolean getPfeilTasteRechts(){
		return pfeilTasteRechts;
	}
	
	public boolean getPfeilTasteUnten(){
		return pfeilTasteUnten;
	}
	
	//Animationscounter Operationen
	public double getAnimationsCounter(){
		return animationcounter;
	}
	
	public double getAnimationsCounterLinks(){
		return animationscounterLeft;
	}
	
	public double getAnimationsCounterRechts(){
		return animationscounterRight;
	}
	
	public double getAnimationsCounterOben(){
		return animationscounterUp;
	}
	//////////////////////////////////////////////////////////////////////
	
	public boolean getEscapeGedrückt(){
		return escape;
	}
	
	public int getSeitenAbstandX(){
		return fensterausrichtungX;
	}
	
	public int getSeitenAbstandY(){
		return fensterausrichtungY;
	}
	
	public int getLastPressed(){
		return lastpressed;
	}
	
	
	//Operation zum Überprüfen der Levelbegrentzung
	public void playerBegrenzung(){
		if(levelAktiv == "Startlevel"){
			if(spieler.getPositionY()<= 3 && spieler.getPositionX()<=470 || spieler.getPositionX()>=690 && spieler.getPositionY()<=3){
				spieler.laufNachUnten();
			}
				
			if(spieler.getPositionX()<=190){
				spieler.laufNachRechts();
			}
				
			if(spieler.getPositionY()==620){
				spieler.laufVorwärts();
			}
				
			if(spieler.getPositionX()>=1137 && spieler.getPositionY()>=275 || spieler.getPositionX()>=1137 && spieler.getPositionY()<=132){
				spieler.laufNachLinks();
			}
				
			if(spieler.getPositionY()>=132 && spieler.getPositionY()<=275 && spieler.getPositionX()>=1145){
				caveinside = true;
				levelAktiv="Schwertmeister";
				spieler.setposx(50);
				spieler.setposy(310);
			}
		}
		if(levelAktiv == "Schwertmeister"){
			System.out.println();
			if(spieler.getPositionY()<= 1){
				spieler.laufNachUnten();
			}
				
			if((spieler.getPositionX() <= 3) && (spieler.getPositionY() <= 200 || spieler.getPositionY() >= 440)){
				spieler.laufNachRechts();
			}
				
			if(spieler.getPositionY()==620){
				spieler.laufVorwärts();
			}
				
				
			if(spieler.getPositionX()>=1204){
				spieler.laufNachLinks();
			}
				
			if(spieler.getPositionY() > 200 && spieler.getPositionY() < 440 && spieler.getPositionX() <= 5){
				caveinside = false;
				spieler.setposx(1100);
				spieler.setposy(310);
				levelAktiv ="Startlevel";
			}
		}
	}
	// Ende Operation zum Überprüfen der Levelbegrentzung
	
	
	public boolean getNeustart(){
		return neustart;
	}
	
	//Operation zum neustarten des Spiels
	public void starteNeu() {
		neustart = true;
		
		StartOberflaeche neuesSpiel = new StartOberflaeche();
		this.dispose();
	}
	
	public Link getSpieler(){
		return spieler;
	}
	
	
}
