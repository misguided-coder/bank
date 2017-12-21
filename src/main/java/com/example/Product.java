package com.example;

public class Product {

	int id;
	String title;
	double price;
	int qty;

	public Product() {
	}

	public Product(int id, String title, double price, int qty) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", qty=" + qty + "]";
	}

}
