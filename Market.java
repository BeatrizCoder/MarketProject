package main;

import model.Product;
import utils.utils;

import java.util.*;


public class Market {
	
	private static Scanner input= new Scanner(System.in);
	
	private static ArrayList<Product> products;
	
	private static Map<Product, Integer> cart;
	
	
	public static void main (String[] args) {
		products = new ArrayList<>();
		cart= new HashMap<Product, Integer>();
		menu();
	}
	
	private static void menu() {

		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Welcome to Testing Market project");
		System.out.println("-----------------------------------------------------------");
		System.out.println("***Please, select one of operations below***");
		System.out.println("-----------------------------------------------------------");
		System.out.println("| Option 1- Register      |");
		System.out.println("| Option 2- To List       |");
		System.out.println("| Option 3- To Buy        |");
		System.out.println("| Option 4- Add to Cart   |");
		System.out.println("| Option 5- Exit          |");
		
		
		
		int option=input.nextInt();
	
	
	switch(option) {
	
	case 1:
		registerProducts();
		
		break;
		
	case 2:
		
		listProducts();
		
		break;
		
	case 3:
		
		buyProducts();
		
		break;
		
	case 4:
		
		AddtToCart();
		
		break;
		
	case 5:
		
		System.out.println("Thank you for your visit");
		
		System.exit(0);
		
		break;
		
		default:
			
			System.out.println("Invalid option");
			
			
			break;
		
		
	}
		
	}

private static void registerProducts() {
	System.out.println("Name of product:");

	String name= input.next();
	
	System.out.println("Product price");
	
	Double price= input.nextDouble();
	
	Product product = new Product(name, price);
	products.add(product);
	
	System.out.println(product.getProductName()+("Product has been rigistred successfully"));
	menu();
}

	private static void listProducts() {
	if(products.size()>0)	{
		System.out.println("Products list\n");
		
		for (Product p: products) {
			System.out.println(p);
		}
	}else{	
			System.out.println	("There are no registered products yet");
		
	}
	
	menu();
	}
	
	private static void buyProducts() {
		if (products.size()>0) {
			System.out.println("Product ID:\n");
			
			System.out.println("***Products available***");
			
			for (Product p: products) {
				
				System.out.println(p + "\n");
				
				
		}
			
			int Id= Integer.parseInt(input.next());
			
			boolean isPresent=false;
			
			for (Product p: products) {
				 if(p.getProductId()==Id) {
					 
					int qtd=0;
					 try {
						 qtd=cart.get(p);
						 cart.put(p, qtd+1);
					 }catch(NullPointerException e) {
						 // If the product be the first added to the cart
						  cart.put(p, 1);
					 }
				System.out.println(p.getProductName()+("Adding to the cart"));
				isPresent=true;
				
				if (isPresent) {
					System.out.println("Do you want to add other products to the cart?");
					System.out.println("Press 1 if you wish to add more products to the cart or press 0 to finish the purchase");
					
					
					int option=Integer.parseInt(input.next());
					
					if (option == 1) {
						buyProducts();
						
					}else {
						checkout ();
						
					}
				}
	

				
				 }else {
					 System.out.println("Product not found.");
					 
					 menu();
				 }
				 }
			}else {
				 System.out.println("There are no products registered");
			menu();
			}
			
			
		}


		// TODO Auto-generated method stub
		
	

	
	
private static void AddtToCart() {
	System.out.println("***Products added to the cart***");
	if(cart.size()>0) {
		for( Product p : cart.keySet()) {
			System.out.println("Product: " + p + "\nQuantidade:  "+ cart.get(p));
	}
}else {
	System.out.println("Empty cart");
	
}
	menu();
}

	
	@SuppressWarnings("null")
	private static void checkout() {
		Double purchasePrice=0.0;
		
		System.out.println("Your product added to the cart");
		
		for(Product p : cart.keySet()) {
			@SuppressWarnings("unused")
			int qnt=cart.get(p);
			Double qtd = null;
			purchasePrice+= p.getProductPrice()* qtd;
			System.out.println(p);
			System.out.println("Amount: " + qtd);
			System.out.println("----------------");
		}
		
		System.out.println("The total price of you purchase: " + utils.doubleToString(purchasePrice));
		
		cart.clear();
		System.out.println("Thanks for visiying us!");
		menu();
}
}
	


