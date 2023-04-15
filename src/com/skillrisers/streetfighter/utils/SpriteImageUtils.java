package com.skillrisers.streetfighter.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteImageUtils {

    public static BufferedImage removeBackground(BufferedImage image) {
        
        // Get the dimensions of the image
        int width = image.getWidth();
        int height = image.getHeight();

        // Create a new BufferedImage with transparent pixels
        BufferedImage transparentImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get the background color of the image (in this example, white)
        Color backgroundColor = new Color(image.getRGB(0, 0));

        // Loop through each pixel in the image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                // Get the color of the current pixel
                Color pixelColor = new Color(image.getRGB(x, y));
                
                // If the current pixel is not the background color, copy it to the new image
                if (!pixelColor.equals(backgroundColor)) {
                    transparentImage.setRGB(x, y, pixelColor.getRGB());
                }
            }
        }

        // Return the new image with the background removed
        return transparentImage;
    }

}