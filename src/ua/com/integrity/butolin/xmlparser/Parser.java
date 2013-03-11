package ua.com.integrity.butolin.xmlparser;

import java.io.File;
import java.util.Scanner;

import ua.com.integrity.butolin.xmlparser.exporter.CSVExporter;
import ua.com.integrity.butolin.xmlparser.importer.XMLImporter;

public class Parser {

    private Scanner scanner;
    private File xmlFile;

    public static void main(String[] args) {

	Parser parser = new Parser();
	System.out.println("Enter the file name");
	String xmlFileName = parser.getFileName();
	parser.xmlFile = parser.testFileToExist(xmlFileName);

	XMLImporter importer = new XMLImporter();
	String stringToCSV = importer.parsingXMLToString(parser.xmlFile);

	CSVExporter exporter = new CSVExporter();
	exporter.saveStringToCSV(stringToCSV);
	System.out.println("Created result.csv file");

    }

    private File testFileToExist(String xmlFileString) {
	xmlFile = new File(xmlFileString);
	if (!xmlFile.exists()) {
	    System.out
		    .println("The file does not exist, re-enter the file name:");
	    xmlFileString = getFileName();
	    testFileToExist(xmlFileString);
	}
	return xmlFile;
    }

    private String getFileName() {
	if (scanner == null) {
	    scanner = new Scanner(System.in);
	}
	String file = scanner.nextLine();
	return file;
    }

}
