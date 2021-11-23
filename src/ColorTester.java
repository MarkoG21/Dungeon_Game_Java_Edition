import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

public class ColorTester extends Robot {

	// Attribute

	//Ende Attribute
	private int seitenAbstandX;
	private int seitenAbstandY;
	//Anfang Konstruktor
	public ColorTester(int x1, int y1) throws AWTException {
		super();
		seitenAbstandX = x1;
		seitenAbstandY = y1;
	}
	//Ende Konstruktor
	
	//Anfang Operationen
	public Color checkColourValue(int x, int y){
		return this.getPixelColor(x + seitenAbstandX, y + seitenAbstandY);
		
	}
	//Ende Operationen

	
}
