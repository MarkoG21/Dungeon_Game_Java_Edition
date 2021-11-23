
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class StartOberflaeche extends JFrame {

	private 		JPanel 		contentPane;
	//Diese Müssen Static sein da es eine Referenz aus dem System ist.
    private static 	double 		widthMonitor;
    private static 	double 		heightMonitor;
    private 		int 		fensterBreite 			= 1280;
    private 		int 		fensterHoehe 			= 720;
    private 		int 		fensterausrichtungAufX;
    private 		int			fensterausrichtungAufY;
    private 		Image		titelbild; 
    private			int			standartButtonBreite	= 550;
    private 		int			standartButtonHoehe 	= 80;
    private 		Image		buttonTextur;
    private			Image		buttonTexturEnde;
    private			Image		buttonTexturHover;
    private			Image		buttonTexturEndeHover;
    private			Image		selectionArrow;
    private			Image		selectionArrowL;
    private			Image		windowIcon;
    private			boolean		arrowanim = false;
    private			int			arrowx = 910; 
    private			int			arrowx2 = 910;
    private			int			arrowxl = 295;
    private			int			arrowxl2 = 295;
    private			boolean		buttonStartEnter = false;
    private			boolean		buttonEnde1 = false;
    private			int			animationslowdown = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    widthMonitor = screenSize.getWidth();
	    heightMonitor= screenSize.getHeight();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartOberflaeche frame = new StartOberflaeche();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public StartOberflaeche() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Beite und Hoehe + Zahl haben wir gemacht, da obwohl wird für das Bild die Richtige auflösung nahmen, der Fensterrand nicht genau
		//zum Bild passte, dadurch haben wir uns herangetastet bis es perfekt war.
		
		//Buttonausrichtung
		int buttonPosX = (fensterBreite/2) - (standartButtonBreite/2);
		int buttonPosY = fensterHoehe/2;
		
		
		
		//Textur für Buttons holen
		Image img = null;
		
		try {
			img = ImageIO.read(getClass().getResource("/rsc/Button Start.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		titelbild 						= new ImageIcon(getClass().getResource("/rsc/MainScreenV2.png")).getImage();
		buttonTextur 					= new ImageIcon(getClass().getResource("/rsc/Button Start.png")).getImage();
		buttonTexturEnde 				= new ImageIcon(getClass().getResource("/rsc/Exit.png")).getImage();
		buttonTexturHover				= new ImageIcon(getClass().getResource("/rsc/Button Start Hover.png")).getImage();
		buttonTexturEndeHover 			= new ImageIcon(getClass().getResource("/rsc/Exit Hover.png")).getImage();
		selectionArrow				 	= new ImageIcon(getClass().getResource("/rsc/selectionarrow.png")).getImage();
		selectionArrowL 				= new ImageIcon(getClass().getResource("/rsc/selectionarrowl.png")).getImage();
		windowIcon						= new ImageIcon(getClass().getResource("/rsc/triforceIcon.png")).getImage();
		fensterausrichtungAufX 			= (int) ((widthMonitor/2)-(fensterBreite/2));
		fensterausrichtungAufY			= (int) ((heightMonitor/2)-(fensterHoehe/2));	
		setUndecorated(true);
		setTitle("The Legend Of Java Launcher");
		setResizable(false);
		setVisible(true);
		setIconImage(windowIcon);
	
		setBounds( fensterausrichtungAufX , fensterausrichtungAufY , fensterBreite , fensterHoehe );
		contentPane = new JPanel(){
			@Override 
			
			
			
			public void paint(Graphics g){
				super.paintComponent(g);
				
				try {
					Thread.sleep(0, 800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				g.drawImage(titelbild, 0, 0, null);
				if(buttonStartEnter){
				g.drawImage(selectionArrow, arrowx, buttonPosY, null);
				g.drawImage(selectionArrowL, arrowxl, buttonPosY, null);
				}
				/*if(buttonEnde1){
					g.drawImage(selectionArrow, arrowx, buttonPosY+100, null);
				}*/
				if(buttonStartEnter){
					g.drawImage(buttonTexturHover, buttonPosX, buttonPosY, null);
					animationslowdown++;
					
					if(arrowx ==1000 && arrowxl == 205){
						arrowanim=false;
					}
					if(arrowx == 910 && arrowxl == 295){
						arrowanim = true;
					}
					if(arrowanim==true){
					if(animationslowdown==2){
					arrowx++;
					arrowxl--;
					animationslowdown = 0;
					}
					}
					if(arrowanim==false){
						if(animationslowdown==2){
						arrowx--;
						arrowxl++;
						animationslowdown =0;
						}
					}
					repaint();
				}
				else{
				g.drawImage(buttonTextur, buttonPosX, buttonPosY , null);
				arrowx=910;
				arrowxl=295;
				repaint();
				}
				if(buttonEnde1){
					g.drawImage(selectionArrow, arrowx2, buttonPosY+100, null);
					g.drawImage(selectionArrowL, arrowxl2, buttonPosY+100, null);
					g.drawImage(buttonTexturEndeHover, buttonPosX, buttonPosY+100, null);
					animationslowdown++;
					if(arrowx2 == 1000 && arrowxl2 == 205){
						arrowanim=false;
					}
					if(arrowx2 == 910 && arrowxl2 == 295){
						arrowanim = true;
					}
					if(arrowanim==true){
					if(animationslowdown==2){
					arrowx2++;
					arrowxl2--;
					animationslowdown = 0;
					}
					}
					if(arrowanim==false){
						if(animationslowdown==2){
						arrowx2--;
						arrowxl2++;
						animationslowdown =0;
						}
					}
					repaint();
				}
				else{
				g.drawImage(buttonTexturEnde, buttonPosX, buttonPosY+100,null);
				arrowx2 = 910;
				arrowxl2 = 295;
				}
				
			}
		};
	
		setContentPane(contentPane);


		contentPane.setLayout(null);
		/*
		JLabel titelbildFlaeche = new JLabel();
		titelbildFlaeche.setIcon(titelbild);
		titelbildFlaeche.setBounds(-1, -1, fensterBreite, fensterHoehe);
		
		////////////////////////////////////////
		///////////////////////////////////////
		//ContentPaneSetzung
		contentPane.add(titelbildFlaeche);*/
		
		////////////////////////////////////////
		//////////////////////////////////////
		//Buttons
		


		
		/////////////////////////////////
		//Start Button
		
		JButton buttonStart = new JButton();
		
		
		
		
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					SpielOberflaeche game = new SpielOberflaeche((int) heightMonitor, (int) widthMonitor, fensterausrichtungAufX, fensterausrichtungAufY);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		buttonStart.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	buttonStartEnter = true;
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	buttonStartEnter = false;
		    }
		});
		
		
		
		buttonStart.setBounds(buttonPosX, buttonPosY, standartButtonBreite, standartButtonHoehe);
		buttonStart.setVisible(true);
		buttonStart.setOpaque(false);
		//Sorgt für das Schreiben über dem ImageIcon
		buttonStart.setHorizontalTextPosition(JButton.CENTER);
		buttonStart.setVerticalTextPosition(JButton.CENTER);
		
		
		
		/////////////////////////////////////////
		//Stop Button
		JButton buttonEnde = new JButton();
		
		buttonEnde.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	buttonEnde1 = true;
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	buttonEnde1 = false;
		    }
		});
		
		
		Image img2;
		try {
			img2 = ImageIO.read(getClass().getResource("/rsc/Exit.png"));
			buttonEnde.setIcon(new ImageIcon(img2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		buttonEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		
		
		buttonEnde.setBounds(buttonPosX, buttonPosY + 100, standartButtonBreite, standartButtonHoehe);
		buttonEnde.setVisible(true);
		buttonEnde.setOpaque(false);
		//buttonEnde.requestFocus();
		
		//Sorgt für das Schreiben über dem ImageIcon --> Quelle: http://stackoverflow.com/questions/2713480/is-it-possible-to-put-text-on-top-of-a-image-in-a-button
		buttonEnde.setHorizontalTextPosition(JButton.CENTER);
		buttonEnde.setVerticalTextPosition(JButton.CENTER);
		
		contentPane.add(buttonEnde);
		contentPane.add(buttonStart);
		
	
	}
	//Ende Konstruktor
	
	// Anfang Methoden
	//Ende Methoden
	public void starteLoop(){
		
	}
}

