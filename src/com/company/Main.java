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
        String imageName = "";
        while(true) {
            System.out.println("Inserisci il nome dell'immagine caricata nella cartella Images(senza estensione) (scrivere .exit per terminare l'esecuzione):");
            imageName = scanner.next();
            if (imageName.equals(".exit"))
                break;
            String fileName = "Images/" + imageName + ".png";


            try {
                BufferedImage image = ImageIO.read(new File(fileName));
                int dimensions = image.getHeight();
                FileWriter myWriter = new FileWriter("Files/" + imageName + ".txt");
                myWriter.write("public static final int DIMENSIONE = " + dimensions + ";\n" +
                        "public static boolean[][] mkStruct (int d){\n" +
                        "   boolean[][] m = new boolean[d][d];{\n");
                for (int y = 0; y < image.getHeight(); y++) {
                    for (int x = 0; x < image.getWidth(); x++) {
                        int rgb = image.getRGB(x, y);
                        int red = (rgb & 0x00ff0000) >> 16;
                        int green = (rgb & 0x0000ff00) >> 8;
                        int blue = rgb & 0x000000ff;

                        if (red == 0 && green == 0 && blue == 0)
                            myWriter.write("    m[" + y + "][" + x + "] = false;\n");
                        else
                            myWriter.write("    m[" + y + "][" + x + "] = true;\n");

                    }
                }
                myWriter.write("    }return m;\n" +
                        "}");
                myWriter.close();
                System.out.println("File creato con successo :D");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
