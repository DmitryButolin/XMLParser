package ua.com.integrity.butolin.xmlparser.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVExporter {
    public static String CSV_FILE_NAME = "result.csv";

    public void SaveStringToCSV(String strToFile) {
	Writer resultCsv = null;
	try {
	    resultCsv = new FileWriter(CSV_FILE_NAME);
	    resultCsv.write(strToFile);
	    resultCsv.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (resultCsv != null)
		try {
		    resultCsv.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
    }
}