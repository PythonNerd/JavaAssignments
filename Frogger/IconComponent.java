package frogger;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.Icon;

/**
 * This component draws an IconComponent.
 */
public class IconComponent extends JComponent {
	/**
	 * Constructor for creating icon.
	 * 
	 * @param icon
	 */
	public IconComponent(Icon icon) {
		this.icon = icon;
	}
	/**
	 * PaintComponent method for painting icons.
	 */
	public void paintComponent(Graphics g) {
		icon.paintIcon(this, g, x, y);
	}
	// Returns x value.
	public int getX() {
		return x;
	}
	// Returns y value.
	public int getY() {
		return y;
	}
	//
	public static void setX(int newx) {
		x = newx;
	}

	public static void setY(int newy) {
		y = newy;
	}

	private static int x;
	private static int y;
	private Icon icon;
}
