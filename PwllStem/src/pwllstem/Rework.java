package pwllstem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Rework {
    //File Reader init
    public static String filename = "csv/cog_metadata_0.0005_424736.csv";
    public static CSVReader reader;

    //Data Variables
    static int dataSize, variants, deltaData, omiData, alpData;
    static int engData, engVar, engDelta, engOmi, engAlp;
    static int walData, walVar, walDelta, walOmi, walAlp;
    static int scoData, scoVar, scoDelta, scoOmi, scoAlp;
    static int nIreData, nIreVar, nIreDelta, nIreOmi, nIreAlp;
    static int deltaPer, omiPer, alpPer;
    static int engPer, engDeltaPer, engOmiPer, engAlpPer;
    static int walPer, walDeltaPer, walOmiPer, walAlpPer;
    static int scoPer, scoDeltaPer, scoOmiPer, scoAlpPer;
    static int nIrePer, nIreDeltaPer, nIreOmiPer, nIreAlpPer;

    // Read the file into a list of strings
    public static List<String[]> rows;
    static {
        try {
            reader = new CSVReader(new FileReader(filename));
            rows = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        dataSize = rows.size()-1;
        engData = cRwV(new String[] {"England"});
        engDelta = cRwV(new String[] {"England", "Delta"});
        engDeltaPer = Math.round(((float)engDelta*100f)/(float)engData);
        engOmi = cRwV(new String[] {"England", "Omicron"});
        engOmiPer = Math.round(((float)engOmi*100f)/(float)engData);
        engAlp = cRwV(new String[] {"England", "Alpha"});
        engVar = engDelta+engOmi+engAlp;
        walData = cRwV(new String[] {"Wales"});
        walDelta = cRwV(new String[] {"Wales", "Delta"});
        walOmi = cRwV(new String[] {"Wales", "Omicron"});
        walAlp = cRwV(new String[] {"Wales", "Alpha"});
        walVar = walDelta+walOmi+walAlp;
        scoData = cRwV(new String[] {"Scotland"});
        scoDelta = cRwV(new String[] {"Scotland", "Delta"});
        scoOmi = cRwV(new String[] {"Scotland", "Omicron"});
        scoAlp = cRwV(new String[] {"Scotland", "Alpha"});
        scoVar = scoDelta+scoOmi+scoAlp;
        nIreData = cRwV(new String[] {"Northern_Ireland"});
        nIreDelta = cRwV(new String[] {"Northern_Ireland", "Delta"});
        nIreOmi = cRwV(new String[] {"Northern_Ireland", "Omicron"});
        nIreAlp = cRwV(new String[] {"Northern_Ireland", "Alpha"});
        nIreVar = nIreDelta+nIreOmi+nIreAlp;
        deltaData = cRwV(new String[] {"Delta"});
        omiData = cRwV(new String[] {"Omicron"});
        alpData = cRwV(new String[] {"Alpha"});
        variants = deltaData+omiData+alpData;
        deltaPer = Math.round(((float) deltaData*100) / (float) variants);
        omiPer = Math.round(((float) omiData*100f) / (float) variants);
        alpPer = Math.round(((float) alpData*100f) / (float) variants);

        System.out.println("Data Size: "+(rows.size()-1));
        System.out.println("Cases by Country:");
        System.out.println("England: "+engData);
        System.out.println("Identified Variants: "+engVar);
        System.out.println("Delta: "+engDelta);
        System.out.println("Omicron: "+engOmi);
        System.out.println("Alpha: "+engAlp);
        System.out.println("Wales: "+walData);
        System.out.println("Identified Variants: "+walVar);
        System.out.println("Delta: "+walDelta);
        System.out.println("Omicron: "+walOmi);
        System.out.println("Alpha: "+walAlp);
        System.out.println("Scotland: "+scoData);
        System.out.println("Identified Variants: "+scoVar);
        System.out.println("Delta: "+scoDelta);
        System.out.println("Omicron: "+scoOmi);
        System.out.println("Alpha: "+scoAlp);
        System.out.println("Northern Ireland: "+nIreData);
        System.out.println("Identified Variants: "+nIreVar);
        System.out.println("Delta: "+nIreDelta);
        System.out.println("Omicron: "+nIreOmi);
        System.out.println("Alpha: "+nIreAlp);
        System.out.println("Cases by Identified Variants: "+variants);
        System.out.println("Delta: "+deltaData+" ("+deltaPer+"%)");
        System.out.println("Omicron: "+omiData+" ("+omiPer+"%)");
        System.out.println("Alpha: "+alpData+" ("+alpPer+"%)");
    }
    // Count Rows with Values:
    public static int cRwV(String[] values) throws IOException {
        // Open the CSV file for reading
        // Count the number of rows that contain all the values
        int count = 0;
        for (String[] row : rows) {
            boolean found = true;
            for (String value : values) {
                if (!Arrays.asList(row).toString().contains(value)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }

        // Close the reader to free up resources

        return count;
    }
}