package pwllstem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.knowm.xchart.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

import static pwllstem.preInit.*;

public class PwllStem {
    private static int i = 0;

    public static void varInit() throws IOException, CsvValidationException {
        System.out.println(Files.isRegularFile(Paths.get(filename)));
        if(!Files.isRegularFile(Paths.get(filename))){
            Path gzfilename = Paths.get("csv/cog_metadata.csv.gz");
            InputStream in1 = new URL("https://cog-uk.s3.climb.ac.uk/phylogenetics/latest/cog_metadata.csv.gz").openStream();
            Files.copy(in1, gzfilename, StandardCopyOption.REPLACE_EXISTING);
            try(final OutputStream out = Files.newOutputStream(Path.of(filename));
                final InputStream in2   = new GZIPInputStream(Files.newInputStream(gzfilename))) {
                in2.transferTo(out);
            }
        }
        // Variable Assignment
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] nextLine;
        dataSize = engData = walData = scoData = nIreData = 0;
        engAlp = engDelta = engOmi = engUnknown = 0;
        walAlp = walDelta = walOmi = walUnknown = 0;
        scoAlp = scoDelta = scoOmi = scoUnknown = 0;
        nIreAlp = nIreDelta = nIreOmi = nIreUnknown = 0;
        Alp202101 = Alp202102 = Alp202103 = Alp202104 = Alp202105 = Alp202106 = Alp202107 = Alp202108 = Alp202109 = Alp202110 = Alp202111 = Alp202112 = 0;
        Alp202201 = Alp202202 = Alp202203 = Alp202204 = Alp202205 = Alp202206 = Alp202207 = Alp202208 = Alp202209 = Alp202210 = Alp202211 = Alp202212 = 0;
        Delta202101 = Delta202102 = Delta202103 = Delta202104 = Delta202105 = Delta202106 = Delta202107 = Delta202108 = Delta202109 = Delta202110 = Delta202111 = Delta202112 = 0;
        Delta202201 = Delta202202 = Delta202203 = Delta202204 = Delta202205 = Delta202206 = Delta202207 = Delta202208 = Delta202209 = Delta202210 = Delta202211 = Delta202212 = 0;
        Omi202101 = Omi202102 = Omi202103 = Omi202104 = Omi202105 = Omi202106 = Omi202107 = Omi202108 = Omi202109 = Omi202110 = Omi202111 = Omi202112 = 0;
        Omi202201 = Omi202202 = Omi202203 = Omi202204 = Omi202205 = Omi202206 = Omi202207 = Omi202208 = Omi202209 = Omi202210 = Omi202211 = Omi202212 = 0;
        Unk202101 = Unk202102 = Unk202103 = Unk202104 = Unk202105 = Unk202106 = Unk202107 = Unk202108 = Unk202109 = Unk202110 = Unk202111 = Unk202112 = 0;
        Unk202201 = Unk202202 = Unk202203 = Unk202204 = Unk202205 = Unk202206 = Unk202207 = Unk202208 = Unk202209 = Unk202210 = Unk202211 = Unk202212 = 0;
        int temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0, temp6 = 0, temp7 = 0, temp8 = 0, temp9 = 0, temp10 = 0, temp11 = 0, temp12 = 0,
                temp13 = 0, temp14 = 0, temp15 = 0, temp16 = 0, temp17 = 0, temp18 = 0, temp19 = 0, temp20 = 0, temp21 = 0, temp22 = 0, temp23 = 0, temp24 = 0;

        while((nextLine = reader.readNext())!=null){
            String nl = Arrays.asList(nextLine).toString();
            if(nextLine[4].contains("2021-01")) temp1+=1;
            if(nextLine[4].contains("2021-02")) temp2+=1;
            if(nextLine[4].contains("2021-03")) temp3+=1;
            if(nextLine[4].contains("2021-04")) temp4+=1;
            if(nextLine[4].contains("2021-05")) temp5+=1;
            if(nextLine[4].contains("2021-06")) temp6+=1;
            if(nextLine[4].contains("2021-07")) temp7+=1;
            if(nextLine[4].contains("2021-08")) temp8+=1;
            if(nextLine[4].contains("2021-09")) temp9+=1;
            if(nextLine[4].contains("2021-10")) temp10+=1;
            if(nextLine[4].contains("2021-11")) temp11+=1;
            if(nextLine[4].contains("2021-12")) temp12+=1;
            if(nextLine[4].contains("2022-01")) temp13+=1;
            if(nextLine[4].contains("2022-02")) temp14+=1;
            if(nextLine[4].contains("2022-03")) temp15+=1;
            if(nextLine[4].contains("2022-04")) temp16+=1;
            if(nextLine[4].contains("2022-05")) temp17+=1;
            if(nextLine[4].contains("2022-06")) temp18+=1;
            if(nextLine[4].contains("2022-07")) temp19+=1;
            if(nextLine[4].contains("2022-08")) temp20+=1;
            if(nextLine[4].contains("2022-09")) temp21+=1;
            if(nextLine[4].contains("2022-10")) temp22+=1;
            if(nextLine[4].contains("2022-11")) temp23+=1;
            if(nextLine[4].contains("2022-12")) temp24+=1;

            if(nextLine[4].contains("2021-01") && nl.contains("Alpha")) Alp202101+=1;
            if(nextLine[4].contains("2021-02") && nl.contains("Alpha")) Alp202102+=1;
            if(nextLine[4].contains("2021-03") && nl.contains("Alpha")) Alp202103+=1;
            if(nextLine[4].contains("2021-04") && nl.contains("Alpha")) Alp202104+=1;
            if(nextLine[4].contains("2021-05") && nl.contains("Alpha")) Alp202105+=1;
            if(nextLine[4].contains("2021-06") && nl.contains("Alpha")) Alp202106+=1;
            if(nextLine[4].contains("2021-07") && nl.contains("Alpha")) Alp202107+=1;
            if(nextLine[4].contains("2021-08") && nl.contains("Alpha")) Alp202108+=1;
            if(nextLine[4].contains("2021-09") && nl.contains("Alpha")) Alp202109+=1;
            if(nextLine[4].contains("2021-10") && nl.contains("Alpha")) Alp202110+=1;
            if(nextLine[4].contains("2021-11") && nl.contains("Alpha")) Alp202111+=1;
            if(nextLine[4].contains("2021-12") && nl.contains("Alpha")) Alp202112+=1;
            if(nextLine[4].contains("2022-01") && nl.contains("Alpha")) Alp202201+=1;
            if(nextLine[4].contains("2022-02") && nl.contains("Alpha")) Alp202202+=1;
            if(nextLine[4].contains("2022-03") && nl.contains("Alpha")) Alp202203+=1;
            if(nextLine[4].contains("2022-04") && nl.contains("Alpha")) Alp202204+=1;
            if(nextLine[4].contains("2022-05") && nl.contains("Alpha")) Alp202205+=1;
            if(nextLine[4].contains("2022-06") && nl.contains("Alpha")) Alp202206+=1;
            if(nextLine[4].contains("2022-07") && nl.contains("Alpha")) Alp202207+=1;
            if(nextLine[4].contains("2022-08") && nl.contains("Alpha")) Alp202208+=1;
            if(nextLine[4].contains("2022-09") && nl.contains("Alpha")) Alp202209+=1;
            if(nextLine[4].contains("2022-10") && nl.contains("Alpha")) Alp202210+=1;
            if(nextLine[4].contains("2022-11") && nl.contains("Alpha")) Alp202211+=1;
            if(nextLine[4].contains("2022-12") && nl.contains("Alpha")) Alp202212+=1;

            if(nextLine[4].contains("2021-01") && nl.contains("Delta")) Delta202101+=1;
            if(nextLine[4].contains("2021-02") && nl.contains("Delta")) Delta202102+=1;
            if(nextLine[4].contains("2021-03") && nl.contains("Delta")) Delta202103+=1;
            if(nextLine[4].contains("2021-04") && nl.contains("Delta")) Delta202104+=1;
            if(nextLine[4].contains("2021-05") && nl.contains("Delta")) Delta202105+=1;
            if(nextLine[4].contains("2021-06") && nl.contains("Delta")) Delta202106+=1;
            if(nextLine[4].contains("2021-07") && nl.contains("Delta")) Delta202107+=1;
            if(nextLine[4].contains("2021-08") && nl.contains("Delta")) Delta202108+=1;
            if(nextLine[4].contains("2021-09") && nl.contains("Delta")) Delta202109+=1;
            if(nextLine[4].contains("2021-10") && nl.contains("Delta")) Delta202110+=1;
            if(nextLine[4].contains("2021-11") && nl.contains("Delta")) Delta202111+=1;
            if(nextLine[4].contains("2021-12") && nl.contains("Delta")) Delta202112+=1;
            if(nextLine[4].contains("2022-01") && nl.contains("Delta")) Delta202201+=1;
            if(nextLine[4].contains("2022-02") && nl.contains("Delta")) Delta202202+=1;
            if(nextLine[4].contains("2022-03") && nl.contains("Delta")) Delta202203+=1;
            if(nextLine[4].contains("2022-04") && nl.contains("Delta")) Delta202204+=1;
            if(nextLine[4].contains("2022-05") && nl.contains("Delta")) Delta202205+=1;
            if(nextLine[4].contains("2022-06") && nl.contains("Delta")) Delta202206+=1;
            if(nextLine[4].contains("2022-07") && nl.contains("Delta")) Delta202207+=1;
            if(nextLine[4].contains("2022-08") && nl.contains("Delta")) Delta202208+=1;
            if(nextLine[4].contains("2022-09") && nl.contains("Delta")) Delta202209+=1;
            if(nextLine[4].contains("2022-10") && nl.contains("Delta")) Delta202210+=1;
            if(nextLine[4].contains("2022-11") && nl.contains("Delta")) Delta202211+=1;
            if(nextLine[4].contains("2022-12") && nl.contains("Delta")) Delta202212+=1;

            if(nextLine[4].contains("2021-01") && nl.contains("Omicron")) Omi202101+=1;
            if(nextLine[4].contains("2021-02") && nl.contains("Omicron")) Omi202102+=1;
            if(nextLine[4].contains("2021-03") && nl.contains("Omicron")) Omi202103+=1;
            if(nextLine[4].contains("2021-04") && nl.contains("Omicron")) Omi202104+=1;
            if(nextLine[4].contains("2021-05") && nl.contains("Omicron")) Omi202105+=1;
            if(nextLine[4].contains("2021-06") && nl.contains("Omicron")) Omi202106+=1;
            if(nextLine[4].contains("2021-07") && nl.contains("Omicron")) Omi202107+=1;
            if(nextLine[4].contains("2021-08") && nl.contains("Omicron")) Omi202108+=1;
            if(nextLine[4].contains("2021-09") && nl.contains("Omicron")) Omi202109+=1;
            if(nextLine[4].contains("2021-10") && nl.contains("Omicron")) Omi202110+=1;
            if(nextLine[4].contains("2021-11") && nl.contains("Omicron")) Omi202111+=1;
            if(nextLine[4].contains("2021-12") && nl.contains("Omicron")) Omi202112+=1;
            if(nextLine[4].contains("2022-01") && nl.contains("Omicron")) Omi202201+=1;
            if(nextLine[4].contains("2022-02") && nl.contains("Omicron")) Omi202202+=1;
            if(nextLine[4].contains("2022-03") && nl.contains("Omicron")) Omi202203+=1;
            if(nextLine[4].contains("2022-04") && nl.contains("Omicron")) Omi202204+=1;
            if(nextLine[4].contains("2022-05") && nl.contains("Omicron")) Omi202205+=1;
            if(nextLine[4].contains("2022-06") && nl.contains("Omicron")) Omi202206+=1;
            if(nextLine[4].contains("2022-07") && nl.contains("Omicron")) Omi202207+=1;
            if(nextLine[4].contains("2022-08") && nl.contains("Omicron")) Omi202208+=1;
            if(nextLine[4].contains("2022-09") && nl.contains("Omicron")) Omi202209+=1;
            if(nextLine[4].contains("2022-10") && nl.contains("Omicron")) Omi202210+=1;
            if(nextLine[4].contains("2022-11") && nl.contains("Omicron")) Omi202211+=1;
            if(nextLine[4].contains("2022-12") && nl.contains("Omicron")) Omi202212+=1;

            Unk202101=temp1-Alp202101-Delta202101-Omi202101;
            Unk202102=temp2-Alp202102-Delta202102-Omi202102;
            Unk202103=temp3-Alp202103-Delta202103-Omi202103;
            Unk202104=temp4-Alp202104-Delta202104-Omi202104;
            Unk202105=temp5-Alp202105-Delta202105-Omi202105;
            Unk202106=temp6-Alp202106-Delta202106-Omi202106;
            Unk202107=temp7-Alp202107-Delta202107-Omi202107;
            Unk202108=temp8-Alp202108-Delta202108-Omi202108;
            Unk202109=temp9-Alp202109-Delta202109-Omi202109;
            Unk202110=temp10-Alp202110-Delta202110-Omi202110;
            Unk202111=temp11-Alp202111-Delta202111-Omi202111;
            Unk202112=temp12-Alp202112-Delta202112-Omi202112;
            Unk202201=temp13-Alp202201-Delta202201-Omi202201;
            Unk202202=temp14-Alp202202-Delta202202-Omi202202;
            Unk202203=temp15-Alp202203-Delta202203-Omi202203;
            Unk202204=temp16-Alp202204-Delta202204-Omi202204;
            Unk202205=temp17-Alp202205-Delta202205-Omi202205;
            Unk202206=temp18-Alp202206-Delta202206-Omi202206;
            Unk202207=temp19-Alp202207-Delta202207-Omi202207;
            Unk202208=temp20-Alp202208-Delta202208-Omi202208;
            Unk202209=temp21-Alp202209-Delta202209-Omi202209;
            Unk202210=temp22-Alp202210-Delta202210-Omi202210;
            Unk202211=temp23-Alp202211-Delta202211-Omi202211;
            Unk202212=temp24-Alp202212-Delta202212-Omi202212;
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
        PieChart pieChartCountries = new PieChartBuilder().width(425).height(400)
                .title("UK by Country").build();
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
        PieChart pieChartVariants = new PieChartBuilder().width(425).height(400)
                .title("UK by Variant").build();
        pieChartVariants.addSeries("Unknown", unknownPer);
        pieChartVariants.addSeries("Alpha", alpPer);
        pieChartVariants.addSeries("Delta", deltaPer);
        pieChartVariants.addSeries("Omicron", omiPer);
        PieChart pieChartEngVar = new PieChartBuilder().width(425).height(400)
                .title("England by Variant").build();
        pieChartEngVar.addSeries("Unknown", engUnknownPer);
        pieChartEngVar.addSeries("Alpha", engAlpPer);
        pieChartEngVar.addSeries("Delta", engDeltaPer);
        pieChartEngVar.addSeries("Omicron", engOmiPer);
        PieChart pieChartWalVar = new PieChartBuilder().width(425).height(400)
                .title("Wales by Variant").build();
        pieChartWalVar.addSeries("Unknown", walUnknownPer);
        pieChartWalVar.addSeries("Alpha", walAlpPer);
        pieChartWalVar.addSeries("Delta", walDeltaPer);
        pieChartWalVar.addSeries("Omicron", walOmiPer);
        PieChart pieChartScoVar = new PieChartBuilder().width(425).height(400)
                .title("Scotland by Variant").build();
        pieChartScoVar.addSeries("Unknown", scoUnknownPer);
        pieChartScoVar.addSeries("Alpha", scoAlpPer);
        pieChartScoVar.addSeries("Delta", scoDeltaPer);
        pieChartScoVar.addSeries("Omicron", scoOmiPer);
        PieChart pieChartNIreVar = new PieChartBuilder().width(425).height(400)
                .title("N.Ireland by Variant").build();
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
        CategoryChart barChartVariants = new CategoryChartBuilder().width(425).height(400).title("UK by Variant").build();
        barChartVariants.getStyler().setLegendVisible(false);
        barChartVariants.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartVariants.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(alpPer, deltaPer, omiPer, unknownPer));
        CategoryChart barChartCountries = new CategoryChartBuilder().width(425).height(400).title("UK by Country").build();
        barChartCountries.getStyler().setLegendVisible(false);
        barChartCountries.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartCountries.addSeries("Test", Arrays.asList("Wales", "England", "Scotland", "N. Ireland"), Arrays.asList(walPer, engPer, scoPer, nIrePer));
        CategoryChart barChartEngVar = new CategoryChartBuilder().width(425).height(400).title("England by Variant").build();
        barChartEngVar.getStyler().setLegendVisible(false);
        barChartEngVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartEngVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(engAlpPer, engDeltaPer, engOmiPer, engUnknownPer));
        CategoryChart barChartWalVar = new CategoryChartBuilder().width(425).height(400).title("Wales by Variant").build();
        barChartWalVar.getStyler().setLegendVisible(false);
        barChartWalVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartWalVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(walAlpPer, walDeltaPer, walOmiPer, walUnknownPer));
        CategoryChart barChartScoVar = new CategoryChartBuilder().width(425).height(400).title("Scotland by Variant").build();
        barChartScoVar.getStyler().setLegendVisible(false);
        barChartScoVar.getStyler().setSeriesColors(new Color[] {Color.BLUE});
        barChartScoVar.addSeries("Test", Arrays.asList("Alpha", "Delta", "Omicron", "Unknown"), Arrays.asList(scoAlpPer, scoDeltaPer, scoOmiPer, scoUnknownPer));
        CategoryChart barChartNIreVar = new CategoryChartBuilder().width(425).height(400).title("N.Ireland by Variant").build();
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
    public static void VariantTimeCharts() throws IOException{
        CategoryChart barChart2021quart1 = new CategoryChartBuilder().width(850).height(400).title("2021 - Quarter 1").build();
        barChart2021quart1.getStyler().setLegendVisible(true);
        barChart2021quart1.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2021quart1.addSeries("Alpha", Arrays.asList("2021-01", "2021-02", "2021-03"), Arrays.asList(Alp202101, Alp202102, Alp202103));
        barChart2021quart1.addSeries("Delta", Arrays.asList("2021-01", "2021-02", "2021-03"), Arrays.asList(Delta202101, Delta202102, Delta202103));
        barChart2021quart1.addSeries("Omicron", Arrays.asList("2021-01", "2021-02", "2021-03"), Arrays.asList(Omi202101, Omi202102, Omi202103));
        barChart2021quart1.addSeries("Unknown", Arrays.asList("2021-01", "2021-02", "2021-03"), Arrays.asList(Unk202101, Unk202102, Unk202103));
        BitmapEncoder.saveBitmapWithDPI(barChart2021quart1, "./Pictures/2021-quart1-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2021quart2 = new CategoryChartBuilder().width(800).height(400).title("2021 - Quarter 2").build();
        barChart2021quart2.getStyler().setLegendVisible(true);
        barChart2021quart2.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2021quart2.addSeries("Alpha", Arrays.asList("2021-04", "2021-05", "2021-06"), Arrays.asList(Alp202104, Alp202105, Alp202106));
        barChart2021quart2.addSeries("Delta", Arrays.asList("2021-04", "2021-05", "2021-06"), Arrays.asList(Delta202104, Delta202105, Delta202106));
        barChart2021quart2.addSeries("Omicron", Arrays.asList("2021-04", "2021-05", "2021-06"), Arrays.asList(Omi202104, Omi202105, Omi202106));
        barChart2021quart2.addSeries("Unknown", Arrays.asList("2021-04", "2021-05", "2021-06"), Arrays.asList(Unk202104, Unk202105, Unk202106));
        BitmapEncoder.saveBitmapWithDPI(barChart2021quart2, "./Pictures/2021-quart2-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2021quart3 = new CategoryChartBuilder().width(800).height(400).title("2021 - Quarter 3").build();
        barChart2021quart3.getStyler().setLegendVisible(true);
        barChart2021quart3.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2021quart3.addSeries("Alpha", Arrays.asList("2021-07", "2021-08", "2021-09"), Arrays.asList(Alp202107, Alp202108, Alp202109));
        barChart2021quart3.addSeries("Delta", Arrays.asList("2021-07", "2021-08", "2021-09"), Arrays.asList(Delta202107, Delta202108, Delta202109));
        barChart2021quart3.addSeries("Omicron", Arrays.asList("2021-07", "2021-08", "2021-09"), Arrays.asList(Omi202107, Omi202108, Omi202109));
        barChart2021quart3.addSeries("Unknown", Arrays.asList("2021-07", "2021-08", "2021-09"), Arrays.asList(Unk202107, Unk202108, Unk202109));
        BitmapEncoder.saveBitmapWithDPI(barChart2021quart3, "./Pictures/2021-quart3-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2021quart4 = new CategoryChartBuilder().width(800).height(400).title("2021 - Quarter 4").build();
        barChart2021quart4.getStyler().setLegendVisible(true);
        barChart2021quart4.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2021quart4.addSeries("Alpha", Arrays.asList("2021-10", "2021-11", "2021-12"), Arrays.asList(Alp202110, Alp202111, Alp202112));
        barChart2021quart4.addSeries("Delta", Arrays.asList("2021-10", "2021-11", "2021-12"), Arrays.asList(Delta202110, Delta202111, Delta202112));
        barChart2021quart4.addSeries("Omicron", Arrays.asList("2021-10", "2021-11", "2021-12"), Arrays.asList(Omi202110, Omi202111, Omi202112));
        barChart2021quart4.addSeries("Unknown", Arrays.asList("2021-10", "2021-11", "2021-12"), Arrays.asList(Unk202110, Unk202111, Unk202112));
        BitmapEncoder.saveBitmapWithDPI(barChart2021quart4, "./Pictures/2021-quart4-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2022quart1 = new CategoryChartBuilder().width(800).height(400).title("2022 - Quarter 1").build();
        barChart2022quart1.getStyler().setLegendVisible(true);
        barChart2022quart1.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2022quart1.addSeries("Alpha", Arrays.asList("2022-01", "2022-02", "2022-03"), Arrays.asList(Alp202201, Alp202202, Alp202203));
        barChart2022quart1.addSeries("Delta", Arrays.asList("2022-01", "2022-02", "2022-03"), Arrays.asList(Delta202201, Delta202202, Delta202203));
        barChart2022quart1.addSeries("Omicron", Arrays.asList("2022-01", "2022-02", "2022-03"), Arrays.asList(Omi202201, Omi202202, Omi202203));
        barChart2022quart1.addSeries("Unknown", Arrays.asList("2022-01", "2022-02", "2022-03"), Arrays.asList(Unk202201, Unk202202, Unk202203));
        BitmapEncoder.saveBitmapWithDPI(barChart2022quart1, "./Pictures/2022-quart1-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2022quart2 = new CategoryChartBuilder().width(800).height(400).title("2022 - Quarter 2").build();
        barChart2022quart2.getStyler().setLegendVisible(true);
        barChart2022quart2.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2022quart2.addSeries("Alpha", Arrays.asList("2022-04", "2022-05", "2022-06"), Arrays.asList(Alp202204, Alp202205, Alp202206));
        barChart2022quart2.addSeries("Delta", Arrays.asList("2022-04", "2022-05", "2022-06"), Arrays.asList(Delta202204, Delta202205, Delta202206));
        barChart2022quart2.addSeries("Omicron", Arrays.asList("2022-04", "2022-05", "2022-06"), Arrays.asList(Omi202204, Omi202205, Omi202206));
        barChart2022quart2.addSeries("Unknown", Arrays.asList("2022-04", "2022-05", "2022-06"), Arrays.asList(Unk202204, Unk202205, Unk202206));
        BitmapEncoder.saveBitmapWithDPI(barChart2022quart2, "./Pictures/2022-quart2-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2022quart3 = new CategoryChartBuilder().width(800).height(400).title("2022 - Quarter 3").build();
        barChart2022quart3.getStyler().setLegendVisible(true);
        barChart2022quart3.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2022quart3.addSeries("Alpha", Arrays.asList("2022-07", "2022-08", "2022-09"), Arrays.asList(Alp202207, Alp202208, Alp202209));
        barChart2022quart3.addSeries("Delta", Arrays.asList("2022-07", "2022-08", "2022-09"), Arrays.asList(Delta202207, Delta202208, Delta202209));
        barChart2022quart3.addSeries("Omicron", Arrays.asList("2022-07", "2022-08", "2022-09"), Arrays.asList(Omi202207, Omi202208, Omi202209));
        barChart2022quart3.addSeries("Unknown", Arrays.asList("2022-07", "2022-08", "2022-09"), Arrays.asList(Unk202207, Unk202208, Unk202209));
        BitmapEncoder.saveBitmapWithDPI(barChart2022quart3, "./Pictures/2022-quart3-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);

        CategoryChart barChart2022quart4 = new CategoryChartBuilder().width(800).height(400).title("2022 - Quarter 4").build();
        barChart2022quart4.getStyler().setLegendVisible(true);
        barChart2022quart4.getStyler().setSeriesColors(new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK});
        barChart2022quart4.addSeries("Alpha", Arrays.asList("2022-10", "2022-11", "2022-12"), Arrays.asList(Alp202210, Alp202211, Alp202212));
        barChart2022quart4.addSeries("Delta", Arrays.asList("2022-10", "2022-11", "2022-12"), Arrays.asList(Delta202210, Delta202211, Delta202212));
        barChart2022quart4.addSeries("Omicron", Arrays.asList("2022-10", "2022-11", "2022-12"), Arrays.asList(Omi202210, Omi202211, Omi202212));
        barChart2022quart4.addSeries("Unknown", Arrays.asList("2022-10", "2022-11", "2022-12"), Arrays.asList(Unk202210, Unk202211, Unk202212));
        BitmapEncoder.saveBitmapWithDPI(barChart2022quart4, "./Pictures/2022-quart4-VariantTimeBarChart", BitmapEncoder.BitmapFormat.PNG, 100);
    }
    public static void mainUiInit() {
        // Main UI Initialization
        frameMain = new JFrame("Main Frame");
        panelMain = new JPanel(new GridBagLayout());
        // Main Label
        JButton btnAber = new JButton(new ImageIcon("./Pictures/aber.png"));
        JButton btnLlandrillo = new JButton(new ImageIcon("./Pictures/llandrillo.png"));
        JLabel lblEESW = new JLabel(new ImageIcon("./Pictures/eesw.png"));
        lblMain = new JLabel("Covid Cases");
        lblMain.setFont(new Font("Courier New", Font.BOLD, 48));
        // UK Button
        btnUK = new JButton("UK");
        btnUK.setFont(new Font("Courier New",Font.PLAIN, 14));
        // Wales Button
        btnWales = new JButton("Wales");
        btnWales.setFont(new Font("Courier New",Font.PLAIN, 14));
        // England Button
        btnEngland = new JButton( "England");
        btnEngland.setFont(new Font("Courier New",Font.PLAIN, 14));
        // Scotland Button
        btnScotland = new JButton("Scotland");
        btnScotland.setFont(new Font("Courier New",Font.PLAIN, 14));
        // Northern Ireland Button
        btnNIre = new JButton("Northern Ireland");
        btnNIre.setFont(new Font("Courier New",Font.PLAIN, 14));
        btnVarTime = new JButton("Variants over Time");
        btnVarTime.setFont(new Font("Courier New",Font.PLAIN, 14));
        // UI Layout
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 10 , 0, 0);
        c.anchor = GridBagConstraints.NORTHWEST;
        panelMain.add(btnAber, c);
        c.gridx = 2;
        c.insets = new Insets(10, 0, 0, 10);
        c.anchor = GridBagConstraints.NORTHEAST;
        panelMain.add(btnLlandrillo, c);
        c.gridx = 1;
        c.insets = new Insets(10, 0, 0, 0);
        c.anchor = GridBagConstraints.NORTH;
        panelMain.add(lblMain, c);
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.NORTH;
        panelMain.add(btnUK, c);
        c.gridy = 2;
        panelMain.add(btnEngland, c);
        c.gridy = 3;
        panelMain.add(btnScotland, c);
        c.gridy = 4;
        panelMain.add(btnWales, c);
        c.gridy = 5;
        panelMain.add(btnNIre, c);
        c.gridy = 6;
        panelMain.add(btnVarTime, c);
        c.gridx = 0;
//        c.weighty = 5.0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.SOUTHWEST;
        c.insets = new Insets(0, 10, 10, 0);
        panelMain.add(lblEESW, c);
        frameMain.add(panelMain);
        frameMain.setSize(new Dimension(1280, 720));
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);

        btnAber.addActionListener(e -> JOptionPane.showMessageDialog(frameMain, "Prifysgol Aberystwyth University is our company sponsor for this project and has been a massive help in our understanding of how genome sequencing and handling big data works.",
                "INFORMATION", JOptionPane.INFORMATION_MESSAGE));
        btnLlandrillo.addActionListener(e -> JOptionPane.showMessageDialog(frameMain, "We are a group of students from Coleg Meirion-Dwyfor, who have been working on making this application to allow for easy-to-understand representation of data regarding the COVID genome.\nThis application will allow for anyone to read and gain a deeper understanding of how COVID works at any level",
                "INFORMATION", JOptionPane.INFORMATION_MESSAGE));
    }
    public static void UKUiInit(){
        // UK Sub UI Initialization
        frameUK = new JFrame("UK Frame");
        panelUK = new JPanel(new GridBagLayout());
        lblUKPanel = new JLabel("Cases in UK");
        lblUKPanel.setFont(new Font("Courier New", Font.BOLD, 48));
        lblUKTotalCases = new JLabel("Total Cases: "+dataSize);
        lblUKTotalCases.setFont(new Font("Courier New", Font.PLAIN, 26));
        lblUKTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.setFont(new Font("Courier New",Font.PLAIN, 14));
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
        lblEnglandPanel.setFont(new Font("Courier New", Font.BOLD, 48));
        lblEngTotalCases = new JLabel("Total Cases: "+engData);
        lblEngTotalCases.setFont(new Font("Courier New", Font.PLAIN, 26));
        lblEngTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.setFont(new Font("Courier New",Font.PLAIN, 14));
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
        lblWalesPanel.setFont(new Font("Courier New", Font.BOLD, 48));
        lblWalTotalCases = new JLabel("Total Cases: "+walData);
        lblWalTotalCases.setFont(new Font("Courier New", Font.PLAIN, 26));
        lblWalTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.setFont(new Font("Courier New",Font.PLAIN, 14));
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
        lblScotlandPanel.setFont(new Font("Courier New", Font.BOLD, 48));
        lblScoTotalCases = new JLabel("Total Cases: "+scoData);
        lblScoTotalCases.setFont(new Font("Courier New", Font.PLAIN, 26));
        lblScoTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.setFont(new Font("Courier New",Font.PLAIN, 14));
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
        lblNIrePanel.setFont(new Font("Courier New", Font.BOLD, 48));
        lblNIreTotalCases = new JLabel("Total Cases: "+nIreData);
        lblNIreTotalCases.setFont(new Font("Courier New", Font.PLAIN, 26));
        lblNIreTotalCases.setForeground(Color.RED);
        JToggleButton BarORPie = new JToggleButton("Bar");
        BarORPie.setFont(new Font("Courier New",Font.PLAIN, 14));
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
        panelNire.add(BarORPie, c);
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
    public static void varTimeInit(){
        // UK Sub UI Initialization
        icon = new ImageIcon[] {
                new ImageIcon("./Pictures/2021-quart1-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2021-quart2-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2021-quart3-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2021-quart4-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2022-quart1-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2022-quart2-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2022-quart3-VariantTimeBarChart.png"),
                new ImageIcon("./Pictures/2022-quart4-VariantTimeBarChart.png")
        };
        i = 0;
        frameVarTime = new JFrame("Variants over Time 'Frame'");
        JPanel panelVarTime = new JPanel(new GridBagLayout());
        JLabel lblVarTime = new JLabel("Variants over Time");
        lblVarTime.setFont(new Font("Courier New", Font.BOLD, 48));
//        JToggleButton MonthlyorWeekly = new JToggleButton("Weekly");
//        MonthlyorWeekly.setFont(new Font("Courier New",Font.PLAIN, 14));
//        MonthlyorWeekly.addChangeListener(event -> {
//            if (MonthlyorWeekly.isSelected()){
//                MonthlyorWeekly.setText("Monthly");
//            } else {
//                MonthlyorWeekly.setText("Weekly");
//            }
//        });
        btnNext = new JButton(">");
        btnNext.setFont(new Font("Courier New",Font.BOLD, 14));
        btnPrev = new JButton("<");
        btnPrev.setFont(new Font("Courier New",Font.BOLD, 14));
        lblVarTimeChart = new JLabel();
        lblVarTimeChart.setIcon(new ImageIcon("./Pictures/2021-quart1-VariantTimeBarChart.png"));
        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 1;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10,0,0,0);
        panelVarTime.add(lblVarTime,c);
//        c.gridx = 3;
//        c.anchor = GridBagConstraints.NORTHEAST;
//        c.insets = new Insets(10,0,0,10);
//        panelVarTime.add(MonthlyorWeekly,c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0,10, 0, 0);
        c.weightx = GridBagConstraints.REMAINDER;
        panelVarTime.add(btnPrev, c);
        c.gridx = 2;
        c.weightx = 1;
        c.insets = new Insets(0,0,0,0);
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        panelVarTime.add(lblVarTimeChart,c);
        c.gridx = 4;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0,0, 0, 10);
        c.weightx = GridBagConstraints.REMAINDER;
        panelVarTime.add(btnNext, c);
        frameVarTime.add(panelVarTime);
        frameVarTime.setSize(new Dimension(1400,720));

    }
    public static void VarTimeChartChanger(){
        if(i==7)btnNext.setEnabled(false);
        if(i!=7)btnNext.setEnabled(true);
        if(i==0)btnPrev.setEnabled(false);
        if(i!=0)btnPrev.setEnabled(true);
        switch(i){
            default: System.out.println(i);
            case 0: lblVarTimeChart.setIcon(icon[i]);
            case 1: lblVarTimeChart.setIcon(icon[i]);
            case 2: lblVarTimeChart.setIcon(icon[i]);
            case 3: lblVarTimeChart.setIcon(icon[i]);
            case 4: lblVarTimeChart.setIcon(icon[i]);
            case 5: lblVarTimeChart.setIcon(icon[i]);
            case 6: lblVarTimeChart.setIcon(icon[i]);
            case 7: lblVarTimeChart.setIcon(icon[i]);
        }
    }
    public static void main(String[] args) throws IOException,CsvValidationException {
        //Variable Assignment
        varInit();
        PieChartsInit();
        barChartsInit();
        VariantTimeCharts();
        mainUiInit();
        UKUiInit();
        ENGUiInit();
        WALUiInit();
        SCOUiInit();
        NIREUiInit();
        varTimeInit();
        btnUK.addActionListener(e -> frameUK.setVisible(true));
        btnEngland.addActionListener(e -> frameEngland.setVisible(true));
        btnWales.addActionListener(e -> frameWales.setVisible(true));
        btnScotland.addActionListener(e -> frameScotland.setVisible(true));
        btnNIre.addActionListener(e -> frameNIre.setVisible(true));
        btnVarTime.addActionListener(e -> frameVarTime.setVisible(true));
        VarTimeChartChanger();
        if(i<=7) {
            btnNext.addActionListener(e->{
                i++;
                VarTimeChartChanger();
            });
        }
        if(i>=0) {
            btnPrev.addActionListener(e->{
                i=i-1;
                VarTimeChartChanger();
            });
        }
    }
}
