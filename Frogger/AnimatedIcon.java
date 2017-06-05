package frogger;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
   A car that can be moved around.
*/
public class AnimatedIcon implements Icon
{
   /**
      Constructs an Animated icon.
   */
   public AnimatedIcon()
   {
     width = height = 0;
   }
   // Creates an ImageIcon from BufferedImage.
   public ImageIcon newIcon(String filename) throws IOException
   {
	   BufferedImage image = null;
	   image = ImageIO.read(new File(filename)); 
	   ImageIcon imageicon = new ImageIcon(image);
	   return imageicon;
   }
   // Returns the height of the icon.
   public int getIconHeight()
   {
     return height;
   }
   // Returns the width of the icon.
   public int getIconWidth()
   {
     return width;
   }
   // Sets the height of the icon.
   public void setHeight(int h)
   {
     height = h;
   }
   // Sets the width of the icon.
   public void setWidth(int w)
   {
     width = w;
   }
   // PaintIcon method to draw the icon at the coordinates.
   public void paintIcon(Component comp, Graphics g, int x, int y)
   {
     this.paintIcon(comp, g, x, y);
   }
   
   //Variables.
   private int width;
   private int height;
}
