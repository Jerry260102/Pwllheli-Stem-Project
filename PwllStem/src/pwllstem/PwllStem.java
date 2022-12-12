package pwllstem;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PwllStem {
    //File Reader init
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
        // England
        engData = cRwV(new String[]{"England"});
        engPer = Math.round(((float) engData * 100f) / (float) dataSize);
        engDelta = cRwV(new String[]{"England", "Delta"});
        engOmi = cRwV(new String[]{"England", "Omicron"});
        engAlp = cRwV(new String[]{"England", "Alpha"});
        engUnknown = engData - engDelta - engOmi - engAlp;
        engUnknownPer = Math.round(((float) engUnknown * 100f) / (float) engData);
        engDeltaPer = Math.round(((float) engDelta * 100f) / (float) engData);
        engAlpPer = Math.round(((float) engAlp * 100f) / (float) engData);
        engOmiPer = Math.round(((float) engOmi * 100f) / (float) engData);
        // Wales
        walData = cRwV(new String[]{"Wales"});
        walPer = Math.round(((float) walData * 100f) / (float) dataSize);
        walDelta = cRwV(new String[]{"Wales", "Delta"});
        walOmi = cRwV(new String[]{"Wales", "Omicron"});
        walAlp = cRwV(new String[]{"Wales", "Alpha"});
        walUnknown = walData - walDelta - walOmi - walAlp;
        walUnknownPer = Math.round(((float) walUnknown * 100f) / (float) walData);
        walDeltaPer = Math.round(((float) walDelta * 100f) / (float) walData);
        walAlpPer = Math.round(((float) walAlp * 100f) / (float) walData);
        walOmiPer = Math.round(((float) walOmi * 100f) / (float) walData);
        // Scotland
        scoData = cRwV(new String[]{"Scotland"});
        scoPer = Math.round(((float) scoData * 100f) / (float) dataSize);
        scoDelta = cRwV(new String[]{"Scotland", "Delta"});
        scoOmi = cRwV(new String[]{"Scotland", "Omicron"});
        scoAlp = cRwV(new String[]{"Scotland", "Alpha"});
        scoUnknown = scoData - scoDelta - scoOmi - scoAlp;
        scoUnknownPer = Math.round(((float) scoUnknown * 100f) / (float) scoData);
        scoDeltaPer = Math.round(((float) scoDelta * 100f) / (float) scoData);
        scoAlpPer = Math.round(((float) scoAlp * 100f) / (float) scoData);
        scoOmiPer = Math.round(((float) scoOmi * 100f) / (float) scoData);
        // Northern Ireland
        nIreData = cRwV(new String[]{"Northern_Ireland"});
        nIrePer = Math.round(((float) nIreData * 100f) / (float) dataSize);
        nIreDelta = cRwV(new String[]{"Northern_Ireland", "Delta"});
        nIreOmi = cRwV(new String[]{"Northern_Ireland", "Omicron"});
        nIreAlp = cRwV(new String[]{"Northern_Ireland", "Alpha"});
        nIreUnknown = nIreData - nIreDelta - nIreOmi - nIreAlp;
        nIreUnknownPer = Math.round(((float) nIreUnknown * 100f) / (float) nIreData);
        nIreDeltaPer = Math.round(((float) nIreDelta * 100f) / (float) nIreData);
        nIreAlpPer = Math.round(((float) nIreAlp * 100f) / (float) nIreData);
        nIreOmiPer = Math.round(((float) nIreOmi * 100f) / (float) nIreData);
        deltaData = cRwV(new String[]{"Delta"});
        omiData = cRwV(new String[]{"Omicron"});
        alpData = cRwV(new String[]{"Alpha"});
        // Variants
        unknown = dataSize - deltaData - omiData - alpData;
        unknownPer = Math.round(((float) unknown * 100) / (float) dataSize);
        deltaPer = Math.round(((float) deltaData * 100) / (float) dataSize);
        omiPer = Math.round(((float) omiData * 100f) / (float) dataSize);
        alpPer = Math.round(((float) alpData * 100f) / (float) dataSize);
        // Printing Results to the console
        System.out.println("Data Size: " + (rows.size() - 1));
        System.out.println("Cases by Country:");
        System.out.println("England: " + engData + " (" + engPer + "%)");
        System.out.println("Variants in England: ");
        System.out.println("Unknown: " + unknown + " (" + "%)");
        System.out.println("Delta: " + engDelta + " (" + engDeltaPer + "%)");
        System.out.println("Omicron: " + engOmi + " (" + engOmiPer + "%)");
        System.out.println("Alpha: " + engAlp + " (" + engAlpPer + "%)");
        System.out.println("Wales: " + walData + " (" + walPer + "%)");
        System.out.println("Variants in Wales: ");
        System.out.println("Unknown: " + walUnknown + " (" + walUnknownPer + "%)");
        System.out.println("Delta: " + walDelta + " (" + walDeltaPer + "%)");
        System.out.println("Omicron: " + walOmi + " (" + walOmiPer + "%)");
        System.out.println("Alpha: " + walAlp + " (" + walAlpPer + "%)");
        System.out.println("Scotland: " + scoData + " (" + scoPer + "%)");
        System.out.println("Variants in Scotland: ");
        System.out.println("Unknown" + scoUnknown + " ("+scoUnknownPer+"%)");
        System.out.println("Delta: " + scoDelta + " (" + scoDeltaPer + "%)");
        System.out.println("Omicron: " + scoOmi + " (" + scoOmiPer + "%)");
        System.out.println("Alpha: " + scoAlp + " (" + scoAlpPer + "%)");
        System.out.println("Northern Ireland: " + nIreData + " (" + nIrePer + "%)");
        System.out.println("Variants in Northern Ireland: ");
        System.out.println("Unknown: " + nIreUnknown + " (" + nIreUnknownPer + "%)");
        System.out.println("Delta: " + nIreDelta + " (" + nIreDeltaPer + "%)");
        System.out.println("Omicron: " + nIreOmi + " (" + nIreOmiPer + "%)");
        System.out.println("Alpha: " + nIreAlp + " (" + nIreAlpPer + "%)");
        System.out.println("Cases by Variants: ");
        System.out.println("Unknown: " + unknown + " (" + unknownPer + "%)");
        System.out.println("Delta: " + deltaData + " (" + deltaPer + "%)");
        System.out.println("Omicron: " + omiData + " (" + omiPer + "%)");
        System.out.println("Alpha: " + alpData + " (" + alpPer + "%)");
        PieChart pieChartCountries = new PieChartBuilder().width(400).height(300)
                .title("Results by Country").build();
        pieChartCountries.addSeries("England", engPer);
        pieChartCountries.addSeries("Wales", walPer);
        pieChartCountries.addSeries("Scotland", scoPer);
        pieChartCountries.addSeries("Northern Ireland", nIrePer);
        pieChartCountries.getStyler().setSeriesColors(new Color[]{
                Color.red,
                Color.green,
                Color.blue,
                Color.orange
        });
        PieChart pieChartVariants = new PieChartBuilder().width(400).height(300)
                .title("Results by Variant").build();
        pieChartVariants.addSeries("Unknown", unknownPer);
        pieChartVariants.addSeries("Alpha", alpPer);
        pieChartVariants.addSeries("Delta", deltaPer);
        pieChartVariants.addSeries("Omicron", omiPer);
        PieChart pieChartEngVar = new PieChartBuilder().width(400).height(300)
                .title("England by Variant").build();
        pieChartEngVar.addSeries("Unknown", engUnknownPer);
        pieChartEngVar.addSeries("Alpha", engAlpPer);
        pieChartEngVar.addSeries("Delta", engDeltaPer);
        pieChartEngVar.addSeries("Omicron", engOmiPer);
        PieChart pieChartWalVar = new PieChartBuilder().width(400).height(300)
                .title("Wales by Variant").build();
        pieChartWalVar.addSeries("Unknown", walUnknownPer);
        pieChartWalVar.addSeries("Alpha", walAlpPer);
        pieChartWalVar.addSeries("Delta", walDeltaPer);
        pieChartWalVar.addSeries("Omicron", walOmiPer);
        PieChart pieChartScoVar = new PieChartBuilder().width(400).height(300)
                .title("Scotland by Variant").build();
        pieChartScoVar.addSeries("Unknown", scoUnknownPer);
        pieChartScoVar.addSeries("Alpha", scoAlpPer);
        pieChartScoVar.addSeries("Delta", scoDeltaPer);
        pieChartScoVar.addSeries("Omicron", scoOmiPer);
        PieChart pieChartNIreVar = new PieChartBuilder().width(400).height(300)
                .title("Northern Ireland by Variant").build();
        pieChartNIreVar.addSeries("Unknown", nIreUnknownPer);
        pieChartNIreVar.addSeries("Alpha", nIreAlpPer);
        pieChartNIreVar.addSeries("Delta", nIreDeltaPer);
        pieChartNIreVar.addSeries("Omicron", nIreOmiPer);
        List<PieChart> charts = new ArrayList<PieChart>();
        charts.add(pieChartCountries);
        charts.add(pieChartVariants);
        charts.add(pieChartEngVar);
        charts.add(pieChartWalVar);
        charts.add(pieChartScoVar);
        charts.add(pieChartNIreVar);
        new SwingWrapper<PieChart>(charts).displayChartMatrix();
    }
}