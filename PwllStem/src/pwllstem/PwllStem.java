/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pwllstem;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jerzy
 */

public class PwllStem {
    private static final String filename = "csv/cog_metadata_0.0005_424736.csv";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List<String> wholeData = new ArrayList<>();
        List<String> EnglandData = new ArrayList<>();
        List<String> WalesData = new ArrayList<>();
        List<String> ScotlandData = new ArrayList<>();
        List<String> NIrelandData = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("England")){
                    EnglandData.add(line);
                } else if (line.contains("Wales")) {
                    WalesData.add(line);                    
                } else if (line.contains("Scotland")) {
                    ScotlandData.add(line);
                } else if (line.contains("Northern_Ireland")) {
                    NIrelandData.add(line);
                }
                wholeData.add(line);
            }
        }catch (Exception ex){
            throw new Exception("Error Opening File");
        }
        System.out.println("Amount of Tests in CSV: "+(wholeData.size()-1));
        System.out.println("Amount of Tests in England: "+(EnglandData.size()));
        System.out.println("Amount of Tests in Wales: "+(WalesData.size()));
        System.out.println("Amount of Tests in Scotland: "+(ScotlandData.size()));
        System.out.println("Amount of Tests in Northern Ireland: "+(NIrelandData.size()));
    }
    
}
