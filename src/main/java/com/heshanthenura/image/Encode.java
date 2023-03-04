package com.heshanthenura.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.MAGENTA_BACK;
import static com.diogonunes.jcolor.Attribute.YELLOW_TEXT;

public class Encode {

    public void encode() throws IOException {
        int x=0;
        int y=0;
        int index = 0;
        int frameWidth=0;
        int frameHeight = 0;
        int totalImgBits=0;
        int fileBits=0;
        int fileExtBits=0;
        int remainingBits=0;
        boolean isValid = false;
        String response=null;
        String filePath = null;
        String extension = null;
        Path path = null;
        
        Scanner scanner = new Scanner(System.in);

//      Path path = Path.of("text.txt");

        byte[] byteData = new byte[0];

//region file select
        while (!isValid) {
            try {
                System.out.print("Enter the file path: ");
//                filePath = scanner.nextLine();
//                path = Path.of(filePath);
                path = Path.of("text.txt");
                byteData = Files.readAllBytes(path);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Error Relating to file path");
            }
        }
//endregion

        StringBuilder bitsArray = new StringBuilder();

//region fileToBits
        for (byte b : byteData) {
//            System.out.println(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0'));
            bitsArray.append(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0'));
        }
//        System.out.println(bitsArray);
        fileBits=bitsArray.length();
//endregion

//region extension work
        extension=(path.getFileName().toString().split("\\.")[1]);
        byte[] bytesExt = extension.getBytes();
        StringBuilder binaryExt = new StringBuilder();

        for (byte b : bytesExt) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binaryExt.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        fileExtBits=binaryExt.length();

//endregion

//        region widthInput
        isValid=false;
        while (!isValid) {
            try {
                System.out.print("Enter the image width: ");
//                frameWidth = Integer.parseInt(scanner.nextLine());
                frameWidth = 1920;
                isValid=true;
            } catch (Exception e) {
                System.out.println("Error relating to Image width" + " : check whether width containgin spaces,latters or special characters");
            }
        }
//        endregion

//        region heightInput
        isValid=false;
        while (!isValid) {
            try {
                System.out.print("Enter the image height: ");
//                frameHeight = Integer.parseInt(scanner.nextLine());
                frameHeight = 1080;
                isValid=true;
            } catch (Exception e) {
                System.out.println("Error relating to Image height" + " : check whether width containgin spaces,latters or special characters");
            }
        }
//endregion

//        region total bits in image
        totalImgBits=frameWidth*frameHeight;
//        System.out.println(totalImgBits);
//endregion

        System.out.println("Information");
        System.out.println("Total bits in Image:"+totalImgBits);
        System.out.println("Total Bits in File: "+fileBits);
        System.out.println("Bits in Extension: "+fileExtBits);
        remainingBits=totalImgBits-(fileBits+fileExtBits);
        System.out.println("Remaining Bits: "+remainingBits);

        if (totalImgBits<(fileBits+fileExtBits)){
            System.out.println("Cannot Image Bit Size is Smaller than Expected. Try changing the width and height");
            System.exit(0);
        }

////        region response
//        isValid=false;
//        while (!isValid) {
//            try {
//                System.out.print("Do you want to generate Image (yes/no)");
//                response = (scanner.nextLine());
//                response=response.toLowerCase();
//                System.out.println(response);
//                if (response.equals("yes") || response.equals("y") || response.equals("")) {
//                    response="yes";
//                    isValid=true;
//
//                }else if(response.equals("no") || response.equals("n")){
//                    response="no";
//                    isValid=true;
//                }
//                else{
//                    System.out.println("Error relating to response response should be (yes or no) ");
//                    isValid=false;
//                }
//            } catch (Exception e) {
//                System.out.println("Error relating to response response should be (yes or no) ");
//            }
//        }
////endregion
response="yes";
        if (response.equals("yes")){
////            region outputPath
//            isValid=false;
//            while (!isValid) {
//                try {
//                    System.out.print("Enter the image output path: ");
//                    String outputPathStr = (scanner.nextLine());
//                    Path outputPath = Paths.get(outputPathStr);
//                    if (Files.exists(outputPath)) {
//                        isValid=true;
//                    } else {
//                        System.out.println("Path does not exist.");
//                        isValid=false;
//
//                    }
//                } catch (Exception e) {
//                    System.out.println("Path does not exist.");
//                    isValid=false;
//                }
//            }
////            endregion

            BufferedImage image = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);

        System.out.println("Frames= " + Math.ceil((float) bitsArray.length() / (1920 * 1080)));
        System.out.println(bitsArray.length());
//        for (x = 0; x < frameWidth; x++) {
//            for (y = 0; y < frameHeight; y++) {
//                index = (y*frameWidth)+x;
//                if (index<bitsArray.length()){
//                    if(String.valueOf(bitsArray.charAt(index)).equals("1")){
//                        int color = new Color(255,255,255).getRGB();
//                        image.setRGB(x,y,color);
//                        System.out.println("index="+index+" bit="+bitsArray.charAt(index)+" color = white");
//                    }else {
//                        int color = new Color(0,0,0).getRGB();
//                        image.setRGB(x,y,color);
//                        System.out.println("index="+index+" bit="+bitsArray.charAt(index)+" color = black");
//                    }
//                }else {
//                    int color = new Color(255,0,0).getRGB();
//                    image.setRGB(x,y,color);
//                    System.out.println("red");
//                }
//            }
//        }

            //TODO implement img generation

        File output = new File("predefined_pixel_image.png");
        ImageIO.write(image, "png", output);

        }




    }






}