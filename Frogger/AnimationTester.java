package frogger;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
//import AnimatedIcon.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class AnimationTester {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Setting up the JFrame.
		final JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		//Setting up frog icon from image.
		AnimatedIcon frog = new AnimatedIcon();
		frog.setHeight(170);
		frog.setWidth(220);
		ImageIcon froggo = frog.newIcon("frog.png");
		
		
		frogHeight = froggo.getIconHeight();
		frogWidth = froggo.getIconWidth();
		final JLabel froggy = new JLabel(froggo);
	
		//Setting up car icon from image.
		AnimatedIcon car = new AnimatedIcon();
		car.setHeight(170);
		car.setWidth(210);
		ImageIcon cargo = frog.newIcon("car.png");
		carHeight = cargo.getIconHeight();
		carWidth = cargo.getIconWidth();
		
		//Sets game length and bounds.
		gameLength = carWidth * 5;
		gameHeight = frogHeight * 3;
		JLabel carCar = new JLabel(cargo);
		carCar.setBounds(0, frogHeight * 2 - frogHeight, carWidth, frogHeight);
		froggy.setBounds(gameLength/2, gameHeight - frogHeight, carWidth, frogHeight);
		
		//Finishes setting up the frame.
		frame.getContentPane().add(froggy);
		frame.getContentPane().add(carCar);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	    frame.setSize(gameLength, gameHeight);
	    
	    //Borders to help debug collisions.
	    //froggy.setBorder(BorderFactory.createLineBorder(Color.RED,1));
	    //carCar.setBorder(BorderFactory.createLineBorder(Color.RED,1));
	    
	    //Key Listener to move the frog.
		frame.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {

			}

			// Repaints after each key release. 
			public void keyReleased(KeyEvent e) {
				// Right arrow key code
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(froggy.getX() + carWidth < gameLength){
						prevFrogX = froggy.getX();
						// System.out.println(prevFrogX);
						froggy.setBounds(froggy.getX() + carWidth, froggy.getY(), carWidth, frogHeight);
						frame.repaint();
					}
				}
				// Left arrow key code
				else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(froggy.getX()> 0){
						prevFrogX = froggy.getX();
						froggy.setBounds(prevFrogX - carWidth, froggy.getY(), carWidth, frogHeight);
						frame.repaint();
					}
				} 
				//Right arrow key code.
				else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if(froggy.getY()> 0){
						prevFrogY = froggy.getY();
	
						froggy.setBounds(froggy.getX(), prevFrogY - frogHeight, carWidth, frogHeight);
						frame.repaint();
					}
				} 
				//Down arrow key code.
				else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(froggy.getY() + frogHeight < gameHeight){
						prevFrogY = froggy.getY();
						froggy.setBounds(froggy.getX(), prevFrogY + frogHeight, carWidth, frogHeight);
						frame.repaint();
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// Nothing
			}
		});
		
		// Sets initial direction of car.
		String direction = "right";

		// Main game loop. Checks collision and moves car.
		while (true) {
			//System.out.println(froggy.getX() + " " + froggy.getY());
			Thread.sleep(100);
			collide(carCar, froggy, direction);
			Thread.sleep(300);
			//If direction is right, car goes right.
			if (direction == "right") {
				if (carCar.getX()+carWidth < gameLength) {
					carCar.setBounds(carCar.getX() + carWidth, frogHeight * 2 - frogHeight, carWidth, frogHeight);
				} else {
					direction = "left";
				}

			}
			//If direction is left, car goes left.
			if (direction == "left") {
				if (carCar.getX() > 0) {
					carCar.setBounds(carCar.getX() - carWidth, frogHeight * 2 - frogHeight, carWidth, frogHeight);
				} else {
					direction = "right";
				}

			}

			win(froggy, frame);
		}
	}
	/**
	 * Checks if the car hits the frog.
	 */
	public static boolean collisionCheck(JLabel obj1, JLabel obj2, String direction) {
		if(direction == "right"){
			return(obj2.getX() - obj2.getWidth()/2 == obj1.getX() && (obj2.getY() == obj1.getY()));
		}
		else{
			return(obj2.getX() + obj2.getWidth()/2 == obj1.getX() && (obj2.getY() == obj1.getY()));
		}

      }
	
	//Calls the colision check, has debug statements.
	public static void collide(JLabel car, JLabel frog, String direction){
		if(collisionCheck(car, frog, direction)){
			System.out.println("X: " + car.getX() + ", objX: " + frog.getX());
			System.out.println("Y: " + car.getY() + ", objY: " + frog.getY());
			System.out.println("X: " + car.getX() + ", objWidth: " + (frog.getX() + frog.getWidth()/2));
			System.out.println("Y: " + car.getY() + ", objHeight: " + (frog.getY() + frog.getHeight()));
			frog.setBounds(gameLength/2, gameHeight - frogHeight, carWidth, frogHeight);
		}
	}
	// Checks if frog is at top lane.
	public static void win(JLabel frog, JFrame frame){
		if(frog.getY() == 0){
			JLabel win = new JLabel("You won!");
			win.setFont(new Font("Tahoma", Font.BOLD, 28));
			win.setBounds(gameLength/2 - 200, 20, 200, 30);
			frame.getContentPane().add(win);
		}
	}

	//Variables.
	private static int frogHeight;
	private static int frogWidth;
	private static int carHeight;
	private static int carWidth;
	private static int gameLength;
	private static int gameHeight;
	private static int prevFrogX;
	private static int prevFrogY;
}
