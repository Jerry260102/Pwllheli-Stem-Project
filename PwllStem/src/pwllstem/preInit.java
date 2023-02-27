package pwllstem;


import javax.swing.*;
import java.awt.*;

public class preInit {
    // SpreadSheet Location
    public static String filename = "csv/cog_metadata.csv";
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
            nIrePer, nIreUnknownPer, nIreDeltaPer, nIreOmiPer, nIreAlpPer,
            Alp202101, Alp202102, Alp202103, Alp202104, Alp202105, Alp202106, Alp202107, Alp202108, Alp202109, Alp202110, Alp202111, Alp202112,
            Alp202201, Alp202202, Alp202203, Alp202204, Alp202205, Alp202206, Alp202207, Alp202208, Alp202209, Alp202210, Alp202211, Alp202212,
            Delta202101, Delta202102, Delta202103, Delta202104, Delta202105, Delta202106, Delta202107, Delta202108, Delta202109, Delta202110, Delta202111, Delta202112,
            Delta202201, Delta202202, Delta202203, Delta202204, Delta202205, Delta202206, Delta202207, Delta202208, Delta202209, Delta202210, Delta202211, Delta202212,
            Omi202101, Omi202102, Omi202103, Omi202104, Omi202105, Omi202106, Omi202107, Omi202108, Omi202109, Omi202110, Omi202111, Omi202112,
            Omi202201, Omi202202, Omi202203, Omi202204, Omi202205, Omi202206, Omi202207, Omi202208, Omi202209, Omi202210, Omi202211, Omi202212,
            Unk202101, Unk202102, Unk202103, Unk202104, Unk202105, Unk202106, Unk202107, Unk202108, Unk202109, Unk202110, Unk202111, Unk202112,
            Unk202201, Unk202202, Unk202203, Unk202204, Unk202205, Unk202206, Unk202207, Unk202208, Unk202209, Unk202210, Unk202211, Unk202212;
    public static String MorW;
    // UI Variables Declaration
    public static JFrame frameUK, frameWales, frameEngland, frameScotland, frameNIre, frameVarTime;
    public static JLabel lblCountryUKPieChart, lblVariantUKPieChart, lblEnglandPieChart, lblWalesPieChart, lblScotlandPieChart, lblNIrePieChart, lblVarTimeChart;
    public static JButton btnUK , btnWales, btnEngland, btnScotland, btnNIre, btnVarTime, btnNext, btnPrev;
    public static ImageIcon[] icon;

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
