package com.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ShoppingCart {

	private Map<Integer, Product> cart = new HashMap<>();

	public void addItem(Product product) {
		int pid = product.getId();
		if (cart.containsKey(pid)) {
			Product existingProduct = cart.get(pid);
			existingProduct.setQty(existingProduct.getQty() + 1);
		} else {
			cart.put(pid, product);
		}
	}

	public int countItems() {
		int count = 0;
		Collection<Product> products = cart.values();
		for (Product product : products) {
			count = count + product.getQty();
		}
		return count;
	}

	public Collection<Product> cartDetails() {
		return cart.values();
	}

	public void removeItem(int pid)  {
		if (cart.containsKey(pid)) {
			Product existingProduct = cart.get(pid);
			if (existingProduct.getQty() == 1) {
				cart.remove(pid);
			} else {
				existingProduct.setQty(existingProduct.getQty() - 1);
			}
		} else {
			throw new InvalidProductException("Product does not exist in cart!!!!");
		}
	}
	
	
	public double totalPrice() {
		double total = 0;
		Collection<Product> products = cart.values();
		for (Product product : products) {
			double singlePrice = product.getPrice() * product.getQty();
			total = total + singlePrice;
		}
		System.out.println("");
		return total;
	}
	
	public void emptyCart() {
		cart.clear();
	}
	
	/**
	 * placeOrder will save items purchased in db
	 */
	public String placeOrder() {
		//DB calls
		/*try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		String orderId = "O" + System.nanoTime();
		return orderId;
	}

}
