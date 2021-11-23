
public class GameLoop implements Runnable {

	private 			SpielOberflaeche	gui;
	private				Level				aktuellesLevel;
	private				long				startZeitGUIAktualisierung;
	private				long				zeitMesspunktGUIAktualisierung;
	
	private				long				startZeitDatenAktualisierung;
	private				long				zeitMesspunktDatenAktualisierung;
	
	
	public GameLoop(SpielOberflaeche SpielFeld, Level aktuell) throws InterruptedException{
		gui 			= SpielFeld;
		aktuellesLevel	= aktuell;
	}
		
	
	@Override
	public void run() {
		
		startZeitGUIAktualisierung 		= System.currentTimeMillis();
		startZeitDatenAktualisierung	= System.currentTimeMillis();
		
		while(true){
			
			//Main Aktualisierung der Daten alle 6 Millisekunden
			zeitMesspunktDatenAktualisierung 	= System.currentTimeMillis();
			if((zeitMesspunktDatenAktualisierung - startZeitDatenAktualisierung) >= 6){
				aktuellesLevel.aktualisiereDaten();
				gui.pruefeEingaben();
				gui.playerBegrenzung();
				startZeitDatenAktualisierung	= System.currentTimeMillis();
			}
			//Ende Main Aktualisierung
			
			//Aktualisierung der GUI alle 9 Millisekunden
			zeitMesspunktGUIAktualisierung 		= System.currentTimeMillis();
			if((zeitMesspunktGUIAktualisierung - startZeitGUIAktualisierung) >= 9){
				guiAktualisieren();
				startZeitGUIAktualisierung 		= System.currentTimeMillis();
			}
			//EndeAktualisierung der GUI alle 9 Millisekunden
			
			//�berpr�fung auf Beenden des Spiels
			if(gui.getEscapeGedr�ckt()){
				gui.dispose();
				break;
			}
			if(gui.getNeustart()){
				break;
			}
			
			//Ende �berpr�fung auf Beenden des Spiels
			
		}
	}
	
	//Operation zur aktualisierung der GUI
	private void guiAktualisieren(){ 
		gui.repaint();		
	}
	
}	




	
	
	
	

