package ua.com.integrity.butolin.xmlparser.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import ua.com.integrity.butolin.xmlparser.exporter.CSVExporter;

public class CSVExporterTest {
    String actualStringFromCsv = null;

    public String readCSVFile() {
	BufferedReader reader;

	try {
	    reader = new BufferedReader(new FileReader(
		    CSVExporter.CSV_FILE_NAME));
	    actualStringFromCsv = reader.readLine();
	    reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return actualStringFromCsv;
    }

    @Test
    public void testSaveStringToCSV() {
	File file = new File(CSVExporter.CSV_FILE_NAME);
	if (file.exists())
	    file.delete();
	String strToCSV = "Иван,Иванов,01-12-2000,м";
	CSVExporter csvExporter = new CSVExporter();
	csvExporter.saveStringToCSV(strToCSV);
	assertTrue(file.exists());
	actualStringFromCsv = readCSVFile();
	assertEquals(strToCSV, actualStringFromCsv);
    }

}
