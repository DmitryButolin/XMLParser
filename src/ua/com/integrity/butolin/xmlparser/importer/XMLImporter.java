package ua.com.integrity.butolin.xmlparser.importer;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ua.com.integrity.butolin.xmlparser.model.Item;

public class XMLImporter {

    public XMLImporter() {

    }

    public String parsingXMLToString(File xmlFile) {
	String stringCSV = null;
	JAXBContext context;
	try {
	    context = JAXBContext.newInstance(Item.class);
	    Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
	    Item item = (Item) jaxbUnmarshaller.unmarshal(xmlFile);
	    stringCSV = item.getFirstName() + "," + item.getLastName() + ","
		    + reverseDate(item.getBirthDate()) + ","
		    + reverseGender(item.getGender());
	} catch (JAXBException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return stringCSV;
    }

    private String reverseDate(String oldDate) {
	String newDate = null;
	SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	SimpleDateFormat df2 = new SimpleDateFormat("MM-dd-yyyy");
	Date date;
	try {
	    date = df.parse(oldDate);
	    newDate = df2.format(date);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return newDate;
    }

    private String reverseGender(String gender) {
	String newGender = null;
	if (gender.equals("1")) {
	    newGender = "м";
	} else
	    newGender = "ж";
	return newGender;
    }

}
