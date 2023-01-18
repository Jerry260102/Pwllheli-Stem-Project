package pwllstem;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.BitmapEncoder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static pwllstem.preInit.*;

public class PwllStem {

    public static void varInit(){
        // Variable Assignment
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
    }
    public static void uiInit() {
        // Main UI Initialization
        frameMain = new JFrame("Main Frame");
        panelMain = new JPanel(new GridBagLayout());
        // Main Label
        lblMain = new JLabel("Covid Cases");
        lblMain.setFont(new Font("Arial", Font.PLAIN, 48));
        // UK Button
        btnUK = new JButton("UK");
        btnUK.addActionListener(e -> {
            // UK Sub UI Initialization
            frameUK = new JFrame("UK Frame");
            panelUK = new JPanel(new GridBagLayout());
            lblUKPanel = new JLabel("Cases in UK");
            lblUKPanel.setFont(new Font("Arial", Font.PLAIN, 48));
            lblCountryUKChart = new JLabel();
            lblCountryUKChart.setIcon(new ImageIcon("./UKCountryPieChart.png"));
            lblVariantUkChart = new JLabel();
            lblVariantUkChart.setIcon(new ImageIcon("./UKVariantPieChart.png"));
            c = new GridBagConstraints();
            c.gridwidth = 3;
            c.gridx = 0;
            c.gridy = 0;
            panelUK.add(lblUKPanel, c);
            c.gridwidth = 1;
            c.gridy = 1;
            panelUK.add(lblCountryUKChart, c);
            c.gridy = 0;
            c.gridx = 1;
            panelUK.add(Box.createHorizontalStrut(10),c);
            c.gridx = 2;
            c.gridy = 1;
            panelUK.add(lblVariantUkChart, c);
            frameUK.add(panelUK);
            frameUK.setMinimumSize(new Dimension(500,200));
            frameUK.setVisible(true);
        });
        // Wales Button
        btnWales = new JButton("Wales");
        // England Button
        btnEngland = new JButton( "England");
        // Scotland Button
        btnScotland = new JButton("Scotland");
        // Northern Ireland Button
        btnNIre = new JButton("Northern Ireland");
        // UI Layout
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panelMain.add(lblMain, c);
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        panelMain.add(btnUK, c);
        c.gridy = 2;
        panelMain.add(btnWales, c);
        c.gridy = 3;
        panelMain.add(btnEngland, c);
        c.gridy = 4;
        panelMain.add(btnScotland, c);
        c.gridy = 5;
        panelMain.add(btnNIre, c);
        frameMain.add(panelMain);
        frameMain.setMinimumSize(new Dimension(400, 300));
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        //Variable Assignment
        uiInit();
        varInit();



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
        BitmapEncoder.saveBitmapWithDPI(pieChartCountries, "./UKCountryPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartVariants, "./UKVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartEngVar, "./ENGVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 300);
        BitmapEncoder.saveBitmapWithDPI(pieChartWalVar, "./WALVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 300);
        BitmapEncoder.saveBitmapWithDPI(pieChartScoVar, "./SCOVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 300);
        BitmapEncoder.saveBitmapWithDPI(pieChartNIreVar, "./NIREVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 300);
    }
}