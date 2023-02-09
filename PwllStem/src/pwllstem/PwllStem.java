package pwllstem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.knowm.xchart.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static pwllstem.preInit.*;

public class PwllStem {

    public static void varInit() throws IOException, CsvValidationException {
        // Variable Assignment
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] nextLine;
        dataSize = engData = walData = scoData = nIreData = 0;
        engAlp = engDelta = engOmi = engUnknown = 0;
        walAlp = walDelta = walOmi = walUnknown = 0;
        scoAlp = scoDelta = scoOmi = scoUnknown = 0;
        nIreAlp = nIreDelta = nIreOmi = nIreUnknown = 0;
        while((nextLine = reader.readNext())!=null){
            String nl = Arrays.asList(nextLine).toString();
            dataSize+=1;
            if(nl.contains("Alpha")) alpData+=1;
            if(nl.contains("Omicron")) omiData+=1;
            if(nl.contains("Delta")) deltaData+=1;
            if(nl.contains("England")){
                engData+=1;
                if(nl.contains("Alpha")) engAlp+=1;
                if(nl.contains("Omicron")) engOmi+=1;
                if(nl.contains("Delta")) engDelta+=1;
            }
            if(nl.contains("Wales")){
                walData+=1;
                if(nl.contains("Alpha")) walAlp+=1;
                if(nl.contains("Omicron")) walOmi+=1;
                if(nl.contains("Delta")) walDelta+=1;
            }
            if(nl.contains("Scotland")){
                scoData+=1;
                if(nl.contains("Alpha")) scoAlp+=1;
                if(nl.contains("Omicron")) scoOmi+=1;
                if(nl.contains("Delta")) scoDelta+=1;
            }
            if(nl.contains("Northern_Ireland")){
                nIreData+=1;
                if(nl.contains("Alpha")) nIreAlp+=1;
                if(nl.contains("Omicron")) nIreOmi+=1;
                if(nl.contains("Delta")) nIreDelta+=1;
            }

        }
        System.out.println(dataSize);
        // England
        engPer = Math.round(((float) engData * 100f) / (float) dataSize);
        engUnknown = engData - engDelta - engOmi - engAlp;
        engUnknownPer = Math.round(((float) engUnknown * 100f) / (float) engData);
        engDeltaPer = Math.round(((float) engDelta * 100f) / (float) engData);
        engAlpPer = Math.round(((float) engAlp * 100f) / (float) engData);
        engOmiPer = Math.round(((float) engOmi * 100f) / (float) engData);
        // Wales
        walPer = Math.round(((float) walData * 100f) / (float) dataSize);
        walUnknown = walData - walDelta - walOmi - walAlp;
        walUnknownPer = Math.round(((float) walUnknown * 100f) / (float) walData);
        walDeltaPer = Math.round(((float) walDelta * 100f) / (float) walData);
        walAlpPer = Math.round(((float) walAlp * 100f) / (float) walData);
        walOmiPer = Math.round(((float) walOmi * 100f) / (float) walData);
        // Scotland
        scoPer = Math.round(((float) scoData * 100f) / (float) dataSize);
        scoUnknown = scoData - scoDelta - scoOmi - scoAlp;
        scoUnknownPer = Math.round(((float) scoUnknown * 100f) / (float) scoData);
        scoDeltaPer = Math.round(((float) scoDelta * 100f) / (float) scoData);
        scoAlpPer = Math.round(((float) scoAlp * 100f) / (float) scoData);
        scoOmiPer = Math.round(((float) scoOmi * 100f) / (float) scoData);
        // Northern Ireland
        nIrePer = Math.round(((float) nIreData * 100f) / (float) dataSize);
        nIreUnknown = nIreData - nIreDelta - nIreOmi - nIreAlp;
        nIreUnknownPer = Math.round(((float) nIreUnknown * 100f) / (float) nIreData);
        nIreDeltaPer = Math.round(((float) nIreDelta * 100f) / (float) nIreData);
        nIreAlpPer = Math.round(((float) nIreAlp * 100f) / (float) nIreData);
        nIreOmiPer = Math.round(((float) nIreOmi * 100f) / (float) nIreData);
        // Variants
        unknown = dataSize - deltaData - omiData - alpData;
        unknownPer = Math.round(((float) unknown * 100) / (float) dataSize);
        deltaPer = Math.round(((float) deltaData * 100) / (float) dataSize);
        omiPer = Math.round(((float) omiData * 100f) / (float) dataSize);
        alpPer = Math.round(((float) alpData * 100f) / (float) dataSize);
    }
    public static void PieChartsInit() throws IOException{
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
        BitmapEncoder.saveBitmapWithDPI(pieChartCountries, "./Pictures/UKCountryPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartVariants, "./Pictures/UKVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartEngVar, "./Pictures/ENGVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartWalVar, "./Pictures/WALVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartScoVar, "./Pictures/SCOVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(pieChartNIreVar, "./Pictures/NIREVariantPieChart", BitmapEncoder.BitmapFormat.PNG, 100);
    }
    public static void barChartsInit() throws IOException {
        CategoryChart barChartVariants = new CategoryChartBuilder().width(400).height(300).title("Results by Variant").build();
        barChartVariants.getStyler().setLegendVisible(false);
        barChartVariants.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartVariants.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(alpPer, deltaPer, omiPer, unknownPer));
        CategoryChart barChartCountries = new CategoryChartBuilder().width(400).height(300).title("Results by Country").build();
        barChartCountries.getStyler().setLegendVisible(false);
        barChartCountries.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartCountries.addSeries("Test", Arrays.asList("Wales", "England", "Scotland", "N. Ireland"), Arrays.asList(walPer, engPer, scoPer, nIrePer));
        CategoryChart barChartEngVar = new CategoryChartBuilder().width(400).height(300).title("Results by Variant").build();
        barChartEngVar.getStyler().setLegendVisible(false);
        barChartEngVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartEngVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(engAlpPer, engDeltaPer, engOmiPer, engUnknownPer));
        CategoryChart barChartWalVar = new CategoryChartBuilder().width(400).height(300).title("Results by Variant").build();
        barChartWalVar.getStyler().setLegendVisible(false);
        barChartWalVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartWalVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(walAlpPer, walDeltaPer, walOmiPer, walUnknownPer));
        CategoryChart barChartScoVar = new CategoryChartBuilder().width(400).height(300).title("Results by Variant").build();
        barChartScoVar.getStyler().setLegendVisible(false);
        barChartScoVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartScoVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(scoAlpPer, scoDeltaPer, scoOmiPer, scoUnknownPer));
        CategoryChart barChartNIreVar = new CategoryChartBuilder().width(400).height(300).title("Results by Variant").build();
        barChartNIreVar.getStyler().setLegendVisible(false);
        barChartNIreVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartNIreVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(nIreAlpPer, nIreDeltaPer, nIreOmiPer, nIreUnknownPer));
        BitmapEncoder.saveBitmapWithDPI(barChartVariants, "./Pictures/UKVariantBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(barChartCountries, "./Pictures/UKCountryBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(barChartEngVar, "./Pictures/ENGVariantBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(barChartWalVar, "./Pictures/WALVariantBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(barChartScoVar, "./Pictures/SCOVariantBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
        BitmapEncoder.saveBitmapWithDPI(barChartNIreVar, "./Pictures/NIREVariantBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
    }
    public static void mainUiInit() {
        // Main UI Initialization
        frameMain = new JFrame("Main Frame");
        panelMain = new JPanel(new GridBagLayout());
        // Main Label
        lblMain = new JLabel("Covid Cases");
        lblMain.setFont(new Font("Arial", Font.PLAIN, 48));
        // UK Button
        btnUK = new JButton("UK");
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
        frameMain.setSize(new Dimension(1280, 720));
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);
    }
    public static void UKUiInit(){
        // UK Sub UI Initialization
        frameUK = new JFrame("UK Frame");
        panelUK = new JPanel(new GridBagLayout());
        lblUKPanel = new JLabel("Cases in UK");
        lblUKPanel.setFont(new Font("Arial", Font.PLAIN, 48));
        lblUKTotalCases = new JLabel("Total Cases: "+dataSize);
        lblUKTotalCases.setFont(new Font("Arial", Font.PLAIN, 26));
        lblUKTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.addChangeListener(event -> {
            if (BarORPie.isSelected()){
                BarORPie.setText("Pie");
                lblVariantUKPieChart.setIcon(new ImageIcon("./Pictures/UKVariantBarChart.png"));
                lblCountryUKPieChart.setIcon(new ImageIcon("./Pictures/UKCountryBarChart.png"));

            } else {
                BarORPie.setText("Bar");
                lblVariantUKPieChart.setIcon(new ImageIcon("./Pictures/UKVariantPieChart.png"));
                lblCountryUKPieChart.setIcon(new ImageIcon("./Pictures/UKCountryPieChart.png"));

            }
        });
        lblCountryUKPieChart = new JLabel();
        lblCountryUKPieChart.setIcon(new ImageIcon("./Pictures/UKCountryPieChart.png"));
        lblVariantUKPieChart = new JLabel();
        lblVariantUKPieChart.setIcon(new ImageIcon("./Pictures/UKVariantPieChart.png"));
        c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10,10,0,0);
        c.anchor = GridBagConstraints.NORTHWEST;
        panelUK.add(BarORPie,c);
        c.gridx = 2;
        c.insets = new Insets(10,0,0,10);
        c.anchor = GridBagConstraints.NORTHEAST;
        panelUK.add(lblUKTotalCases,c);
        c.gridx = 0;
        c.insets = new Insets(10,0,0, 0);
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.NORTH;
        panelUK.add(lblUKPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.insets = new Insets(0,10,0, 0);
        c.anchor = GridBagConstraints.WEST;
        panelUK.add(lblCountryUKPieChart, c);
        c.gridy = 0;
        c.gridx = 1;
        panelUK.add(Box.createHorizontalStrut(10),c);
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(0,0,0, 10);
        c.anchor = GridBagConstraints.EAST;
        panelUK.add(lblVariantUKPieChart, c);
        frameUK.add(panelUK);
        frameUK.setSize(new Dimension(1280,720));
    }
    public static void ENGUiInit(){
        // UK Sub UI Initialization
        frameEngland = new JFrame("England Frame");
        panelEngland = new JPanel(new GridBagLayout());
        lblEnglandPanel = new JLabel("Cases in England");
        lblEnglandPanel.setFont(new Font("Arial", Font.PLAIN, 48));
        lblEngTotalCases = new JLabel("Total Cases: "+engData);
        lblEngTotalCases.setFont(new Font("Arial", Font.PLAIN, 26));
        lblEngTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.addChangeListener(event -> {
            if (BarORPie.isSelected()){
                BarORPie.setText("Pie");
                lblEnglandPieChart.setIcon(new ImageIcon("./Pictures/ENGVariantBarChart.png"));

            } else {
                BarORPie.setText("Bar");
                lblEnglandPieChart.setIcon(new ImageIcon("./Pictures/ENGVariantPieChart.png"));

            }
        });
        lblEnglandPieChart = new JLabel();
        lblEnglandPieChart.setIcon(new ImageIcon("./Pictures/ENGVariantPieChart.png"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(10,10,0,0);
        panelEngland.add(BarORPie, c);
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets(10,0,0,10);
        panelEngland.add(lblEngTotalCases, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10,0,0,0);
        panelEngland.add(lblEnglandPanel,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=3;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        panelEngland.add(lblEnglandPieChart,c);
        frameEngland.add(panelEngland);
        frameEngland.setSize(new Dimension(1280,720));
    }
    public static void WALUiInit(){
        // UK Sub UI Initialization
        frameWales = new JFrame("Wales Frame");
        panelWales = new JPanel(new GridBagLayout());
        lblWalesPanel = new JLabel("Cases in Wales");
        lblWalesPanel.setFont(new Font("Arial", Font.PLAIN, 48));
        lblWalTotalCases = new JLabel("Total Cases: "+walData);
        lblWalTotalCases.setFont(new Font("Arial", Font.PLAIN, 26));
        lblWalTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.addChangeListener(event -> {
            if (BarORPie.isSelected()){
                BarORPie.setText("Pie");
                lblWalesPieChart.setIcon(new ImageIcon("./Pictures/WALVariantBarChart.png"));

            } else {
                BarORPie.setText("Bar");
                lblWalesPieChart.setIcon(new ImageIcon("./Pictures/WALVariantPieChart.png"));

            }
        });
        lblWalesPieChart = new JLabel();
        lblWalesPieChart.setIcon(new ImageIcon("./Pictures/WALVariantPieChart.png"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(10,10,0,0);
        panelWales.add(BarORPie, c);
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets(10,0,0,10);
        panelWales.add(lblWalTotalCases, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10,0,0,0);
        panelWales.add(lblWalesPanel,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=3;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        panelWales.add(lblWalesPieChart,c);
        frameWales.add(panelWales);
        frameWales.setSize(new Dimension(1280,720));
    }
    public static void SCOUiInit(){
        // UK Sub UI Initialization
        frameScotland = new JFrame("Scotland Frame");
        panelScotland = new JPanel(new GridBagLayout());
        lblScotlandPanel = new JLabel("Cases in Scotland");
        lblScotlandPanel.setFont(new Font("Arial", Font.PLAIN, 48));
        lblScoTotalCases = new JLabel("Total Cases: "+scoData);
        lblScoTotalCases.setFont(new Font("Arial", Font.PLAIN, 26));
        lblScoTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.addChangeListener(event -> {
            if (BarORPie.isSelected()){
                BarORPie.setText("Pie");
                lblScotlandPieChart.setIcon(new ImageIcon("./Pictures/SCOVariantBarChart.png"));

            } else {
                BarORPie.setText("Bar");
                lblScotlandPieChart.setIcon(new ImageIcon("./Pictures/SCOVariantPieChart.png"));

            }
        });
        lblScotlandPieChart = new JLabel();
        lblScotlandPieChart.setIcon(new ImageIcon("./Pictures/SCOVariantPieChart.png"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(10,10,0,0);
        panelScotland.add(BarORPie, c);
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets(10,0,0,10);
        panelScotland.add(lblScoTotalCases, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10,0,0,0);
        panelScotland.add(lblScotlandPanel,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=3;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        panelScotland.add(lblScotlandPieChart,c);
        frameScotland.add(panelScotland);
        frameScotland.setSize(new Dimension(1280,720));
    }
    public static void NIREUiInit(){
        // UK Sub UI Initialization
        frameNIre = new JFrame("Northern Ireland Frame");
        panelNire = new JPanel(new GridBagLayout());
        lblNIrePanel = new JLabel("Cases in Northern Ireland");
        lblNIrePanel.setFont(new Font("Arial", Font.PLAIN, 48));
        lblNIreTotalCases = new JLabel("Total Cases: "+nIreData);
        lblNIreTotalCases.setFont(new Font("Arial", Font.PLAIN, 26));
        lblNIreTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.addChangeListener(event -> {
            if (BarORPie.isSelected()){
                BarORPie.setText("Pie");
                lblNIrePieChart.setIcon(new ImageIcon("./Pictures/NIREVariantBarChart.png"));

            } else {
                BarORPie.setText("Bar");
                lblNIrePieChart.setIcon(new ImageIcon("./Pictures/NIREVariantPieChart.png"));

            }
        });
        lblNIrePieChart = new JLabel();
        lblNIrePieChart.setIcon(new ImageIcon("./Pictures/NIREVariantPieChart.png"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(10,10,0,0);
        panelScotland.add(BarORPie, c);
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets(10,0,0,10);
        panelNire.add(lblNIreTotalCases, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10,0,0,0);
        panelNire.add(lblNIrePanel,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=3;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        panelNire.add(lblNIrePieChart,c);
        frameNIre.add(panelNire);
        frameNIre.setSize(new Dimension(1280,720));
    }
    public static void main(String[] args) throws IOException,CsvValidationException {
        //Variable Assignment
        varInit();
        PieChartsInit();
        barChartsInit();
        mainUiInit();
        UKUiInit();
        ENGUiInit();
        WALUiInit();
        SCOUiInit();
        NIREUiInit();

        btnUK.addActionListener(e -> frameUK.setVisible(true));
        btnEngland.addActionListener(e -> frameEngland.setVisible(true));
        btnWales.addActionListener(e -> frameWales.setVisible(true));
        btnScotland.addActionListener(e -> frameScotland.setVisible(true));
        btnNIre.addActionListener(e -> frameNIre.setVisible(true));
    }
}