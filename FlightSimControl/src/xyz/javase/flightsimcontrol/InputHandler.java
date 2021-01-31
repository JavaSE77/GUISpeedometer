package xyz.javase.flightsimcontrol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputHandler implements Runnable {
	
	private String current = null;
	private boolean hasNew = false;

	@Override
	public void run() {
		

	
		File file = new File("input.txt"); 
		
		while(true) {
        
        BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        String st; 
        try {
			while ((st = br.readLine()) != null) {
			  this.current = st;
			  this.hasNew = true;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		}
		
		
	}

	
	//resets has new
	public boolean hasNew() {
		boolean temp = hasNew;
		this.hasNew = false;
		return temp;
	}

	public String getMostRecent() {
		return this.current;
	}
	
}
