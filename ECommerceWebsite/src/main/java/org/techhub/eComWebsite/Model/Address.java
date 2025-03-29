package org.techhub.eComWebsite.Model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Address {
	private int houseNo;
	private String street;
	private String area;
	private String city;
	private int pincode;
	private String state;
	private String country;
}
