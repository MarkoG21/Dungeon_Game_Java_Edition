import javax.swing.JFrame;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 16.02.2017
  * @author 
  */

public class Link {
  
  // Anfang Attribute
  private int leben = 3;
  private int positionX;
  private int positionY;
  private int breite;
  private int höhe;
  private boolean specialAttack = true;
  private boolean istDerSpielerTot = false;
  private boolean besitztSchwert = false;
  private boolean besitztSchild = true;
  
  private	boolean	befindeImKampf;
  private	boolean unverwundbar;
  
  private int rubienenAnzahl = 0;
  private int triforceAnzahl = 0;
  private boolean hatFee = false;
  private	SpielOberflaeche	spielFeld;

  
  
  // Ende Attribute
  
  //Anfang Konstruktor
  public Link(SpielOberflaeche oberflaeche, int x1, int y1){
	  spielFeld = oberflaeche;
	  positionX = x1;
	  positionY = y1;
  }
  //Ende Konstruktor
  
  
  // Anfang Methoden
  
  public void setposx(int i){
	  System.out.println(i);
	  positionX = i;
	  System.out.println("Posx  "+positionX);
  }
  
  public void setposy(int u){
	  positionY = u;
	  System.out.println("Y=  "+u);
  }
  
  public void vermindereXKoordinate(){
	 positionX = positionX-1;
  }
  
  public void erhoeheXKoordiante(){
	  positionX = positionX+1;
  }
  
  public void vermindereYKoordinate(){
	  positionY = positionY-1;
  }
  
  public void erhoeheYKoordiante(){
	  positionY = positionY+1;
  }
  
  public int getleben() {
    return leben;
  }

  public int getPositionX() {
    return positionX;
  }

  public int getPositionY() {
    return positionY;
  }


  public int getBreite() {
    return breite;
  }


  public int getHöhe() {
    return höhe;
  }


  public boolean getSpecialAttack() {
    return specialAttack;
  }

  public boolean getIstDerSpielerTot() {
	  if(leben == 0){
		  istDerSpielerTot = true;
	  }
	  return istDerSpielerTot;
  }

  public boolean getBesitztSchwert() {
    return besitztSchwert;
  }

  public boolean getBesitztSchild() {
    return besitztSchild;
  }

  public int getRubienenAnzahl() {
    return rubienenAnzahl;
  }

  public int getTriforceAnzahl() {
    return triforceAnzahl;
  }

  public boolean getHatFee() {
    return hatFee;
  }

  public void laufVorwärts() {
    positionY--;
  }

  public void laufNachUnten() {
    positionY++;
  }

  public void laufNachRechts() {
    positionX++;
  }

  public void laufNachLinks() {
    positionX--;
  }

  public void schwertSchlag() {
    befindeImKampf = true;
	 
  }

  public void schwertWerf() {
    
  }

  public void getAusgerüstetesItem() {
    
  }

  public void sterben() {
    
  }

  public void wiederbeleben() {
    
  }

  
  public void lebenAufHeben() {
    
  }
  
  public void lebenZiehen() {
	    leben--;
  }
  
  public boolean getBefindeImKampf(){
	  return befindeImKampf;
  }
  
  public boolean getUnverwundbar(){
	  return unverwundbar;
  }
  
  public void setzteUnverwundbarStatus(boolean status){
	  unverwundbar = status;
  }
  
  public void setKampfStatus(boolean status){
	  befindeImKampf = status;
  }

  // Ende Methoden
} // end of UJ
