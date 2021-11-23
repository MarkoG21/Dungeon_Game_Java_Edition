import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public abstract class Gegner {
  
  // Anfang Attribute
		protected		SpielOberflaeche			spielFeld; 
		protected		int				posX;
		protected		int				posY;
		protected 	int 			leben;
		private 	int 			schadensWert;
		private 	int 			gibPositionX;
		private 	int 			getPositionY;
		private 	int 			getBreite;
		private 	int 			getHöhe;
		protected BufferedImage	img1;
  // Ende Attribute
  
  // Anfang Methoden
  public abstract boolean getIstDerGegnerTod();
  
  public abstract int getSchadensWert();
  
  public abstract int getPositionX();
  
  public abstract int getPositionY();
  
  public abstract int getGetBreite();
  
  public abstract int getGetHöhe();
  
  public abstract void angreifen();
  
  public abstract void zieheLeben();
  
  public abstract void bewegeZumSpieler();
  
}