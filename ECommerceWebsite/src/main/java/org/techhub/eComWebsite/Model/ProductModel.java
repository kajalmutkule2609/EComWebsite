package org.techhub.eComWebsite.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private int pid;
	private String prodName;
	private double price;
	private int quantity;
	private String description;
}
