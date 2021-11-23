/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 09.03.2017
  * @author 
  */

public class Molblin_Bogenschütze extends Gegner {

	// Anfang Attribute
	// Ende Attribute
	
	
	
	// Anfang Methoden
	@Override
	public boolean getIstDerGegnerTod() {
		if(leben ==0){
			return true;
		}
		else{
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
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zieheLeben() {
		// TODO Auto-generated method stub
		
	}
 // Ende Methoden

	@Override
	public void bewegeZumSpieler() {
		// TODO Auto-generated method stub
		
	}
  
 
  
  
 
} // end of Molblin_Bogenschütze
