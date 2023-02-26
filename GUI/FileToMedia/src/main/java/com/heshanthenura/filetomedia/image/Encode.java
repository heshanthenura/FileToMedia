package com.heshanthenura.filetomedia.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encode {
    public void Encode(String pathStr) throws IOException {

        int index = 0;
        int frameWidth=600;
        int frameHeight = 400;
        Path path = Path.of(pathStr);
        byte[] byteData = Files.readAllBytes(path);
        StringBuilder bitsArray = new StringBuilder();

        for (byte b : byteData) {
//            System.out.println(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0'));
            bitsArray.append(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0'));
        }

        System.out.println(bitsArray);
        System.out.println("Frames= " + Math.ceil((float) bitsArray.length() / (1920 * 1080)));
        System.out.println(bitsArray.length());
        BufferedImage image = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < frameWidth; x++) {
            for (int y = 0; y < frameHeight; y++) {
                index = (y*frameWidth)+x;
                if (index<bitsArray.length()){
                    if(String.valueOf(bitsArray.charAt(index)).equals("1")){
                        int color = new Color(255,255,255).getRGB();
                        image.setRGB(x,y,color);
//                        System.out.println("index="+index+" bit="+bitsArray.charAt(index)+" color = white");
                    }else {
                        int color = new Color(0,0,0).getRGB();
                        image.setRGB(x,y,color);
//                        System.out.println("index="+index+" bit="+bitsArray.charAt(index)+" color = black");
                    }
                }else {
                    int color = new Color(255,0,0).getRGB();
                    image.setRGB(x,y,color);
//                    System.out.println("red");
                }

            }
        }
        File output = new File("predefined_pixel_image.png");
        ImageIO.write(image, "png", output);

    }
}

