package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


public class Main
{
    public static final String RESET = "\033[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args)
    {

        File folder = new File("Images");

        try
        {
            for (final File fileEntry : folder.listFiles())
            {
                String fileName = fileEntry.getName();
                System.out.println("Convertendo il file " + fileName+ "...");
                BufferedImage image = ImageIO.read(fileEntry);

                String imageName = fileName.substring(0,fileName.length()-4);
                int dimensions = image.getHeight();
                FileWriter myWriter = new FileWriter("Files/" + imageName + ".txt");
                myWriter.write("public static final int DIMENSIONE = " + dimensions + ";\n" +
                        "public static boolean[][] mkStruct (int d){\n" +
                        "   boolean[][] m = new boolean[d][d];{\n");
                for (int y = 0; y < image.getHeight(); y++)
                {
                    for (int x = 0; x < image.getWidth(); x++)
                    {
                        int rgb = image.getRGB(x, y);
                        int red = (rgb & 0x00ff0000) >> 16;
                        int green = (rgb & 0x0000ff00) >> 8;
                        int blue = rgb & 0x000000ff;

                        if (red == 255 && green == 255 && blue == 255)
                            myWriter.write("    m[" + y + "][" + x + "] = false;\n");
                        else
                            myWriter.write("    m[" + y + "][" + x + "] = true;\n");
                    }
                }
                myWriter.write("    }return m;\n" +
                        "}");
                myWriter.close();
                System.out.println(Main.ANSI_GREEN + "File " + imageName + ".txt creato con successo :D" + Main.RESET);
            }
        } catch (IOException e)
        {
            System.out.println(Main.ANSI_RED + e.getMessage() + Main.RESET);
        }
    }
}
