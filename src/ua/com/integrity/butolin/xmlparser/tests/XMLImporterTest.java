package ua.com.integrity.butolin.xmlparser.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import ua.com.integrity.butolin.xmlparser.importer.XMLImporter;

public class XMLImporterTest {

    @Test
    public void testParsingXMLToString() {
	XMLImporter importer = new XMLImporter();
	String testString = "Иван,Иванов,01-12-2000,м";
	String stringXML = importer.parsingXMLToString(new File("Item.xml"));
	assertEquals(testString, stringXML);
    }

}
