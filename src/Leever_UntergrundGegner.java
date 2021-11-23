

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 09.03.2017
  * @author 
  */

public class Leever_UntergrundGegner extends Gegner {

	// Anfang Attribute
	private	Link 		spieler;
	private	boolean		befindeImAngriff;
	private String		leeveranimation = "oben";
	// Ende Attribute
	
	//Anfang Konstruktor
	public Leever_UntergrundGegner(SpielOberflaeche oberflaeche, int x1, int y1, Link s1) {
		posX 				= x1;
		posY 				= y1;
		spielFeld			= oberflaeche;
		leben				= 3;
		spieler				= s1;
		
	}
	//Ende Konstruktor
	
	
	
	// Anfang Operationen
  
	@Override
	public boolean getIstDerGegnerTod() {
		if (leben == 0) {
			return true;
		} 
		else {
			return false;
		}
	}

	@Override
	public int getSchadensWert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return posY;
	}

	@Override
	public int getGetBreite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGetHöhe() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void angreifen() {
		befindeImAngriff = true;
	}

	@Override
	public void zieheLeben() {
		if(leben>0){
			leben--;
		}
	}

	public void setAnimationState(String s){
		leeveranimation = s;
	}
	
	@Override
	public void bewegeZumSpieler() {
		if(spieler.getPositionX() != posX || spieler.getPositionY() != posY){
			if(spieler.getPositionX() > posX){
				if(leeveranimation=="oben"){
				posX++;
				}
				else{
					posX=posX+3;
				}
			}
			else{
				if(leeveranimation=="oben"){
				posX--;
				}
				else{
					posX=posX-3;
				}
			}
			
			if (spieler.getPositionY() > posY) {
				if(leeveranimation=="oben"){	
				posY++;
				}
				else{
					posY=posY+3;
				}
			} 
			else {
				if(leeveranimation=="oben"){
				posY--;
				}
				else{
					posY=posY-3;
				}
			}
		}
	}

	public boolean getBefindeImAngriff(){
		
		return befindeImAngriff;
	}

	public int getLeben(){
		return leben;
	}
  
  // Ende Operationen
  
  
} // end of Leever_UntergrundGegner
