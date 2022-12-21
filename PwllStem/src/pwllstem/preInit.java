package pwllstem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class preInit {
    public static String filename = "csv/cog_metadata_0.0005_424736.csv";
    public static CSVReader reader;

    // Variable Declaration
    static int dataSize, unknown, deltaData, omiData, alpData;
    static int engData, engUnknown, engDelta, engOmi, engAlp;
    static int walData, walUnknown, walDelta, walOmi, walAlp;
    static int scoData, scoUnknown, scoDelta, scoOmi, scoAlp;
    static int nIreData, nIreUnknown, nIreDelta, nIreOmi, nIreAlp;
    static int unknownPer, deltaPer, omiPer, alpPer;
    static int engPer, engUnknownPer, engDeltaPer, engOmiPer, engAlpPer;
    static int walPer, walUnknownPer, walDeltaPer, walOmiPer, walAlpPer;
    static int scoPer, scoUnknownPer, scoDeltaPer, scoOmiPer, scoAlpPer;
    static int nIrePer, nIreUnknownPer, nIreDeltaPer, nIreOmiPer, nIreAlpPer;
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
    public static JFrame frameMain, frameUK, frameWales, frameEngland, frameScotland, frameNIre ;
    public static JPanel panelMain, panelUk, panelWales, panelEngland, panelScotland, panelNire;
    public static JLabel lblMain, lblUKPanel, lblWalesPanel, lblEnglandPanel, lblScotlandPanel, lblNIrePanel;
    public static JButton btnUK , btnWales, btnEngland, btnScotland, btnNIre;
    public static GridBagConstraints c;
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
}
