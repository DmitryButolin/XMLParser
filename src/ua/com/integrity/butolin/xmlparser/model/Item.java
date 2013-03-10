package ua.com.integrity.butolin.xmlparser.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Item {

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String gender;

    public Item() {
	super();
    }

    public String getFirstName() {
	return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Date getBirthDate() {
	return birthDate;
    }

    @XmlElement
    @XmlJavaTypeAdapter(ShortDateFormatter.class)
    public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
    }

    public String getGender() {
	return gender;
    }

    @XmlElement
    public void setGender(String gender) {
	this.gender = gender;
    }

}
