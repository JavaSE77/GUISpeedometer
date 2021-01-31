package xyz.javase.flightsimcontrol;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GUI {

	//private instances for the GUI to deal with
	private BufferedImage fg;
	private BufferedImage bg;
	private JFrame frame;
	private int fgDegree = 0;
	private int bgDegree = 0;
	private Graphics g;
	
	/**
	 * @param JFrame frame BufferedImage background image, BufferedImage foreground image
	 * this will handle each GUI.
	 * */
	public GUI(JFrame frame, BufferedImage bg, BufferedImage fg) {
		this.frame = frame;
		this.bg = bg;
		this.fg = fg;
		this.g = this.frame.getGraphics();
		
        this.g.drawImage(bg, 0, 0, 900, 900, null);
        this.g.drawImage(fg, 0, 0, 900, 900, null);
	}
	
	/**
	 * @return BufferedImage foreground image
	 * */
	public BufferedImage getForeground() {
		return fg;
	}
	
	/**
	 * @return BufferedImage background image
	 * */
	public BufferedImage getBackground() {
		return bg;
	}
	
	/**
	 * @return JFrame frame holding the images. 
	 * */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * @param BufferedImage background image
	 * */
	public void setBackground(BufferedImage bg) {
		this.bg = bg;
		
        this.g.drawImage(bg, 0, 0, 900, 900, null);
        this.g.drawImage(fg, 0, 0, 900, 900, null);
	}
	
	/**
	 * @param BufferedImage foreground image
	 * */
	public void setForeground(BufferedImage fg) {
		this.fg = fg;
		
		this.g.drawImage(bg, 0, 0, 900, 900, null);
        this.g.drawImage(fg, 0, 0, 900, 900, null);
	}

	/**
	 * @param int degree
	 * rotates the image from its current location to the desired location
	 * */
	public void setForegroundDegree(int degree) {
		if (this.fgDegree != degree) {
			if (this.fgDegree > degree) {
				setForeground(rotate(this.getForeground(), (degree - this.fgDegree)));
				this.fgDegree = degree;
			} else {
				setForeground(rotate(this.getForeground(), (360 - this.fgDegree + degree)));
				this.fgDegree = degree;
			}
		}
	}

	
	/**
	 * @param int degree
	 * rotates the image from its current location to the desired location
	 * */
	public void setBackgroundDegree(int degree) {
		if (this.bgDegree != degree) {
			if (this.bgDegree > degree) {
				setBackground(rotate(this.getBackground(), (degree - this.bgDegree)));
				this.bgDegree = degree;
			} else {
				setBackground(rotate(this.getBackground(), (360 + degree - this.bgDegree)));
				this.bgDegree = degree;
			}
		}
	}
	
    private BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();    
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, bimg.getType());  
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }
	
}
