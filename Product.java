package model;

import utils.utils;

public class Product {
	
	private static int count= 1;
	
	private int productId;
	private String productName;
	private Double productPrice;
	
	public Product( String productName, Double productPrice) {
		
		this.productId=count;
		this.productName = productName;
		this.productPrice = productPrice;
		
		Product.count+=1;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	public String toString(){
		return "Product Id:" + this.getProductId()+
				"\nProduct name:" + this.getProductName()+
				"\nProduct price" + utils.doubleToString (this.getProductPrice());
				
		
		
	}
}

