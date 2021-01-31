package xyz.javase.flightsimcontrol;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		

		
		while(true) {
			
			InputHandler input = new InputHandler();
			Thread inputThread = new Thread(input);  
			inputThread.start(); 
        
        
        JFrame frame = new JFrame("Flight Control Sim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);

        frame.setVisible(true);
        
	    BufferedImage bg = ImageIO.read(new File("speedometer.jpg"));
	    BufferedImage fg = ImageIO.read(new File("speedoneedle.png"));
        GUI gui = new GUI(frame, bg, fg);


        
        Thread.sleep(1000);
        int i = 0;
        int par = 0;
        
        while(true) {
        	
        	if(input.hasNew()) {
        		par = Integer.parseInt(input.getMostRecent());
        	}
            gui.setForegroundDegree(par);
            Thread.sleep(1000);
        	
        	
        }
	}
		
	}
	
	
//	list = input.getList();
//	
//	if(i < list.size()) {
//		par = Integer.parseInt(list.get(i));
//		i++;
//	
//	} else {
//		par = Integer.parseInt(list.get(list.size() -1));
//	}
//	
//
//gui.setForegroundDegree(par);
//Thread.sleep(1000);

//  fg = ImageIO.read(new File("speedoneedle.png"));
//  fg = rotate(fg, par);
//
//  g.drawImage(bg, 0, 0, 900, 900, null);
//  g.drawImage(fg, 0, 0, 900, 900, null);
	
//  Graphics g = frame.getGraphics();
//  BufferedImage bg = ImageIO.read(new File("speedometer.jpg"));
//  BufferedImage fg = ImageIO.read(new File("speedoneedle.png"));
//  g.drawImage(bg, 0, 0, 900, 900, null);
//  g.drawImage(fg, 0, 0, 900, 900, null);
    
	
    
	
//    public static BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {
//
//        double rads = Math.toRadians(angle);
//        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
//        int w = img.getWidth();
//        int h = img.getHeight();
//        int newWidth = (int) Math.floor(w * cos + h * sin);
//        int newHeight = (int) Math.floor(h * cos + w * sin);
//
//        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2d = rotated.createGraphics();
//        AffineTransform at = new AffineTransform();
//        at.translate((newWidth - w) / 2, (newHeight - h) / 2);
//
//        int x = w / 2;
//        int y = h / 2;
//
//        at.rotate(rads, x, y);
//        g2d.setTransform(at);
//        g2d.drawImage(img, 0, 0, null);
//        g2d.dispose();
//        
//        System.out.println("h: " + rotated.getHeight() + " w: " + rotated.getWidth());
//
//        return rotated;
//    }
	
//	class DrawingSpace extends JPanel
//	{
//	    private BufferedImage bg, hero;
//	    private int bgWidth, bgHeight;
//	    private int heroWidth, heroHeight;  
//	    private int scWidth, scHeight;
//	    private int mouseX, mouseY;
//
//	    public DrawingSpace(){      
//	        loadImages();
//	        init();     
//	        setPreferredSize(new Dimension(scWidth, scHeight));     
//
//	    }
//
//	    private void init(){
//	        mouseX = 0;
//	        mouseY = 0;
//	        heroWidth = hero.getWidth();
//	        heroHeight = hero.getHeight();      
//	        bgWidth = bg.getWidth();
//	        bgHeight = bg.getHeight();      
//	        scWidth = bgWidth;
//	        scHeight = bgHeight;        
//	    }
//
//	    private void loadImages(){
//	        try{
//	            bg = ImageIO.read(getClass().getResource("Images/background.jpg"));
//	            hero = ImageIO.read(getClass().getResource("Images/knight.png"));
//	        }catch(IOException ioe){System.out.println("Unable to open file");}
//	    }
//
//	    @Override public void paintComponent(Graphics g){
//	        super.paintComponent(g);        
//	        g.drawImage(bg, 0, 0, bgWidth, bgHeight, null);
//	        g.drawImage(hero, mouseX-(heroWidth/2), mouseY-(heroHeight/2), heroWidth, heroHeight, null);        
//	    }
//
//
//	}
	
}
