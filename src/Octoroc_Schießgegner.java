/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 16.02.2017
  * @author 
  */

public class Octoroc_Schießgegner extends Gegner {
  
  // Anfang Attribute
  private int leben;
  private int schadensWert;
  private int gibPositionX;
  private int getPositionY;
  private int getBreite;
  private int getHöhe;
  // Ende Attribute
  
  // Anfang Methoden
  @Override
  public boolean getIstDerGegnerTod() {
	if (leben == 0) {
		return true;
	} else {
		return false;
	}
  }
  public int getLeben() {
    return leben;
  }
  
  public int getSchadensWert() {
    return 0;
  }
  
  public int getPositionX() {
    return gibPositionX;
  }
  
  public int getPositionY() {
    return getPositionY;
  }
  
  public int getGetBreite() {
    return getBreite;
  }
  
  public int getGetHöhe() {
    return getHöhe;
  }
  
  public void angreifen() {
    
  }
  
  public void zieheLeben() {
    
  }
  // Ende Methoden
@Override
public void bewegeZumSpieler() {
	// TODO Auto-generated method stub
	
}


  
  
} // end of Gegner
