/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pwllstem;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jerzy
 */

public class PwllStem_backup {
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
        List<String> DeltaData = new ArrayList<>();
        List<String> OmicronData = new ArrayList<>();
        List<String> AlphaData = new ArrayList<>();
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
                if (line.contains("Delta")) {
                    DeltaData.add(line);
                }
                if (line.contains("Omicron")) {
                    OmicronData.add(line);
                }
                if (line.contains("Alpha")) {
                    AlphaData.add(line);
                }
                wholeData.add(line);
            }
        }catch (Exception ex){
            throw new Exception("Error Opening File");
        }
        //change to float
        float Data = wholeData.size()-1;
        float EngData = EnglandData.size();
        float WalData = WalesData.size();
        float NIreData = NIrelandData.size();
        float ScoData = ScotlandData.size();
        float DelData = DeltaData.size();
        float OmiData = OmicronData.size();
        float AlpData = AlphaData.size();
        float variants = AlpData + OmiData + DelData;
        //Finding percentages
        float Engper = (EngData * 100) / Data;
        float Walper = (WalData * 100) / Data;
        float NIreper = (NIreData * 100) / Data;
        float Scoper = (ScoData * 100) / Data;
        float Delper = (DelData * 100) / variants;
        float Omiper = (OmiData * 100) / variants;
        float Alpper = (AlpData * 100) / variants;
        //printing of data
        System.out.println("Amount of Tests in CSV: "+(wholeData.size()-1));
        System.out.println("Tests by Region");
        System.out.println("Amount of Tests in England: "+(EnglandData.size()));
        System.out.println("Amount of Tests in Wales: "+(WalesData.size()));
        System.out.println("Amount of Tests in Scotland: "+(ScotlandData.size()));
        System.out.println("Amount of Tests in Northern Ireland: "+(NIrelandData.size()));
        System.out.println("Percentage per Region:");
        System.out.println("Percentage of Tests in England: " + (Math.round(Engper)));
        System.out.println("Percentage of Tests in Wales: " + (Math.round(Walper)));
        System.out.println("Percentage of Tests in NIreland: " + (Math.round(NIreper)));
        System.out.println("Percentage of Tests in Scotland: " + (Math.round(Math.ceil(Scoper))));
        System.out.println("cases of Variants:");
        System.out.println("cases of Delta: " + (DeltaData.size()));
        System.out.println("cases of Omicron: " + (OmicronData.size()));
        System.out.println("cases of Alpha: " + (AlphaData.size()));
        System.out.println("percentage of Variants:");
        System.out.println("Percentage of Delta cases: " + (Math.round(Delper)));
        System.out.println("Percentage of Omicron cases: " + (Math.round(Omiper)));
        System.out.println("Percentage of Alpha cases: " + (Math.round(Alpper)));
    }
    
}
