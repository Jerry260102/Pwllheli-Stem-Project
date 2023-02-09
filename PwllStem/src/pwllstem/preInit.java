package pwllstem;


import javax.swing.*;
import java.awt.*;

public class preInit {
    // SpreadSheet Location
    public static String filename = "csv/cog_metadata_0.0005_424736.csv";
    // Variable Declaration
    static int dataSize, unknown, deltaData, omiData, alpData,
            engData, engUnknown, engDelta, engOmi, engAlp,
            walData, walUnknown, walDelta, walOmi, walAlp,
            scoData, scoUnknown, scoDelta, scoOmi, scoAlp,
            nIreData, nIreUnknown, nIreDelta, nIreOmi, nIreAlp,
            unknownPer, deltaPer, omiPer, alpPer,
            engPer, engUnknownPer, engDeltaPer, engOmiPer, engAlpPer,
            walPer, walUnknownPer, walDeltaPer, walOmiPer, walAlpPer,
            scoPer, scoUnknownPer, scoDeltaPer, scoOmiPer, scoAlpPer,
            nIrePer, nIreUnknownPer, nIreDeltaPer, nIreOmiPer, nIreAlpPer;

    // UI Variables Declaration
    public static JFrame frameMain, frameUK, frameWales, frameEngland, frameScotland, frameNIre ;
    public static JPanel panelMain, panelUK, panelWales, panelEngland, panelScotland, panelNire;
    public static JLabel lblMain, lblUKPanel, lblUKTotalCases, lblCountryUKPieChart, lblVariantUKPieChart,
            lblEnglandPanel, lblEngTotalCases, lblEnglandPieChart, lblWalesPanel, lblWalTotalCases, lblWalesPieChart,
            lblScotlandPanel, lblScoTotalCases, lblScotlandPieChart, lblNIrePanel, lblNIreTotalCases, lblNIrePieChart;
    public static JButton btnUK , btnWales, btnEngland, btnScotland, btnNIre;

    public static GridBagConstraints c;
    // Count Rows with Values Function
//    public static int cRwV(String[] values) throws IOException, CsvValidationException {
//        //Counting
//        CSVReader reader = new CSVReader(new FileReader(filename));
//        String[] nextLine;
//        int count = 0;
//        while((nextLine = reader.readNext())!=null) {
//            boolean found = true;
//            for (String value : values) {
//                if (!Arrays.asList(nextLine).toString().contains(value)) {
//                        found = false;
//                        break;
//                }
//            }
//                if (found) {
//                    count++;
//                }
//            }
//
//
//        // returns Count
//
//        return count;
//    }
}
