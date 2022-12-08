package pwllstem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PwllStem {
    //File Reader init
    public static String filename = "csv/cog_metadata_0.0005_424736.csv";
    public static CSVReader reader;

    // Variable Declaration
    static int dataSize, variants, deltaData, omiData, alpData;
    static int engData, engVar, engDelta, engOmi, engAlp;
    static int walData, walVar, walDelta, walOmi, walAlp;
    static int scoData, scoVar, scoDelta, scoOmi, scoAlp;
    static int nIreData, nIreVar, nIreDelta, nIreOmi, nIreAlp;
    static int varPer, deltaPer, omiPer, alpPer;
    static int engPer, engVarPer, engDeltaPer, engOmiPer, engAlpPer;
    static int walPer, walVarPer, walDeltaPer, walOmiPer, walAlpPer;
    static int scoPer, scoVarPer, scoDeltaPer, scoOmiPer, scoAlpPer;
    static int nIrePer, nIreVarPer, nIreDeltaPer, nIreOmiPer, nIreAlpPer;
    public static List<String[]> rows;

    // CSV Reader Initialization
    static {
        try {
            reader = new CSVReader(new FileReader(filename));
            rows = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
    // Count Rows with Values Function
    public static int cRwV(String[] values){
        //Counting
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

        // returns Count

        return count;
    }
    public static void main(String[] args){
        //Variable Assignment
        dataSize = rows.size() - 1;
        engData = cRwV(new String[]{"England"});
        engPer = Math.round(((float) engData * 100f) / (float) dataSize);
        engDelta = cRwV(new String[]{"England", "Delta"});
        engOmi = cRwV(new String[]{"England", "Omicron"});
        engAlp = cRwV(new String[]{"England", "Alpha"});
        engVar = engDelta + engOmi + engAlp;
        engVarPer = Math.round(((float) engVar * 100f) / (float) engData);
        engDeltaPer = Math.round(((float) engDelta * 100f) / (float) engVar);
        engAlpPer = Math.round(((float) engAlp * 100f) / (float) engVar);
        engOmiPer = Math.round(((float) engOmi * 100f) / (float) engVar);
        walData = cRwV(new String[]{"Wales"});
        walPer = Math.round(((float) walData * 100f) / (float) dataSize);
        walDelta = cRwV(new String[]{"Wales", "Delta"});
        walOmi = cRwV(new String[]{"Wales", "Omicron"});
        walAlp = cRwV(new String[]{"Wales", "Alpha"});
        walVar = walDelta + walOmi + walAlp;
        walVarPer = Math.round(((float) walVar * 100f) / (float) walData);
        walDeltaPer = Math.round(((float) walDelta * 100f) / (float) walVar);
        walAlpPer = Math.round(((float) walAlp * 100f) / (float) walVar);
        walOmiPer = Math.round(((float) walOmi * 100f) / (float) walVar);
        scoData = cRwV(new String[]{"Scotland"});
        scoDelta = cRwV(new String[]{"Scotland", "Delta"});
        scoOmi = cRwV(new String[]{"Scotland", "Omicron"});
        scoAlp = cRwV(new String[]{"Scotland", "Alpha"});
        scoVar = scoDelta + scoOmi + scoAlp;
        scoVarPer = Math.round(((float) scoVar * 100f) / (float) scoData);
        scoDeltaPer = Math.round(((float) scoDelta * 100f) / (float) scoVar);
        scoAlpPer = Math.round(((float) scoAlp * 100f) / (float) scoVar);
        scoOmiPer = Math.round(((float) scoOmi * 100f) / (float) scoVar);
        nIreData = cRwV(new String[]{"Northern_Ireland"});
        nIreDelta = cRwV(new String[]{"Northern_Ireland", "Delta"});
        nIreOmi = cRwV(new String[]{"Northern_Ireland", "Omicron"});
        nIreAlp = cRwV(new String[]{"Northern_Ireland", "Alpha"});
        nIreVar = nIreDelta + nIreOmi + nIreAlp;
        nIreVarPer = Math.round(((float) nIreVar * 100f) / (float) nIreData);
        nIreDeltaPer = Math.round(((float) nIreDelta * 100f) / (float) nIreVar);
        nIreAlpPer = Math.round(((float) nIreAlp * 100f) / (float) nIreVar);
        nIreOmiPer = Math.round(((float) nIreOmi * 100f) / (float) nIreVar);
        deltaData = cRwV(new String[]{"Delta"});
        omiData = cRwV(new String[]{"Omicron"});
        alpData = cRwV(new String[]{"Alpha"});
        variants = deltaData + omiData + alpData;
        varPer = Math.round(((float) variants * 100) / (float) dataSize);
        deltaPer = Math.round(((float) deltaData * 100) / (float) variants);
        omiPer = Math.round(((float) omiData * 100f) / (float) variants);
        alpPer = Math.round(((float) alpData * 100f) / (float) variants);
        // Printing Results to the console
        System.out.println("Data Size: " + (rows.size() - 1));
        System.out.println("Cases by Country:");
        System.out.println("England: " + engData + " (" + engPer + "%)");
        System.out.println("Identified Variants: " + engVar + " (" + engVarPer + "%)");
        System.out.println("Delta: " + engDelta + " (" + engDeltaPer + "%)");
        System.out.println("Omicron: " + engOmi + " (" + engOmiPer + "%)");
        System.out.println("Alpha: " + engAlp + " (" + engAlpPer + "%)");
        System.out.println("Wales: " + walData + " (" + walPer + "%)");
        System.out.println("Identified Variants: " + walVar + " (" + walVarPer + "%)");
        System.out.println("Delta: " + walDelta + " (" + walDeltaPer + "%)");
        System.out.println("Omicron: " + walOmi + " (" + walOmiPer + "%)");
        System.out.println("Alpha: " + walAlp + " (" + walAlpPer + "%)");
        System.out.println("Scotland: " + scoData + " (" + scoPer + "%)");
        System.out.println("Identified Variants: " + scoVar + " (" + scoVarPer + "%)");
        System.out.println("Delta: " + scoDelta + " (" + scoDeltaPer + "%)");
        System.out.println("Omicron: " + scoOmi + " (" + scoOmiPer + "%)");
        System.out.println("Alpha: " + scoAlp + " (" + scoAlpPer + "%)");
        System.out.println("Northern Ireland: " + nIreData + " (" + nIrePer + "%)");
        System.out.println("Identified Variants: " + nIreVar + " (" + nIreVarPer + "%)");
        System.out.println("Delta: " + nIreDelta + " (" + nIreDeltaPer + "%)");
        System.out.println("Omicron: " + nIreOmi + " (" + nIreOmiPer + "%)");
        System.out.println("Alpha: " + nIreAlp + " (" + nIreAlpPer + "%)");
        System.out.println("Cases by Identified Variants: " + variants + " (" + varPer + "%)");
        System.out.println("Delta: " + deltaData + " (" + deltaPer + "%)");
        System.out.println("Omicron: " + omiData + " (" + omiPer + "%)");
        System.out.println("Alpha: " + alpData + " (" + alpPer + "%)");
    }
}