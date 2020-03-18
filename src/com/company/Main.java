package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome dell'immagine caricata nella cartella Images(senza estensione):\n");
        String imageName = scanner.next();
        String fileName = "Images/" + imageName + ".png";


        try
        {
            BufferedImage image = ImageIO.read(new File(fileName));
            FileWriter myWriter = new FileWriter("Files/" + imageName+ ".txt");
            myWriter.write("public static final int DIMENSIONE = 10;\n" +
                                "public static boolean[][] mkStruct (int d){\n" +
                                "   boolean[][] m = new boolean[d][d];{\n");
            for (int y = 0; y < image.getHeight(); y++)
            {
                for (int x = 0; x  < image.getWidth(); x++)
                {
                    int rgb = image.getRGB(x,y);
                    int  red   = (rgb & 0x00ff0000) >> 16;
                    int  green = (rgb & 0x0000ff00) >> 8;
                    int  blue  =  rgb & 0x000000ff;

                    if(red == 0 && green == 0 && blue == 0)
                        myWriter.write("    m["+ y +"][" + x + "] = false;\n");
                    else
                        myWriter.write("    m["+ y +"][" + x + "] = true;\n");

                }
            }
            myWriter.write("    }return m;\n" +
                                "}");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File Non trovato!");
        }
    }
}
