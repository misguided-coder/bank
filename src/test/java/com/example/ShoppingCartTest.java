package com.example;

import org.junit.After;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
	

	ShoppingCart shoppingCart = null;

	@Before
	public void init() {
		shoppingCart = new ShoppingCart();
	}

	@After
	public void clean() {
		shoppingCart = null;
	}

	@Test(timeout=5000)
	public void placingOrderShouldTakeOnlyFiveSecondsAsPerSLA() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);

		shoppingCart.placeOrder();
	}
	
	@Test
	public void emptyingCartShouldDecreaseCartSizeToBeZero() {
		
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);
		
		shoppingCart.emptyCart();

		assertEquals(0,shoppingCart.countItems());
		
	
	}

	@Test
	public void emptyCartShouldProductNonNullResult() {
		assertNotNull(shoppingCart.cartDetails());

	}

	@Test
	public void emptyCartShouldHaveZeroItems() {
		assertEquals(0, shoppingCart.countItems());

	}
	

	@Test
	public void placingOrderShouldGenerateOrderNumber() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);

		assertNotNull(shoppingCart.placeOrder());
		assertTrue(shoppingCart.placeOrder().length() > 10);
		assertTrue(shoppingCart.placeOrder().startsWith("O"));
	}

	
	@Test
	public void checkCartPriceShouldBeAccurate() {
		
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);

		assertEquals(98500.00,shoppingCart.totalPrice(),2);
		
	
	}


	@Test(expected=InvalidProductException.class)
	public void removingNonExistantProductShouldThrowException() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);

		shoppingCart.removeItem(400);
		
	
	}

	@Test
	public void removingWatchFromCartShouldRemoveWatchOnly() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);

		try {
			shoppingCart.removeItem(300);
			Collection<Product> products = shoppingCart.cartDetails();
			for (Product product : products) {
				assertNotEquals(300, product.getId());
			}
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void removingOnlyItemShouldRemoveItFromCart() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		shoppingCart.addItem(laptop);

		try {
			shoppingCart.removeItem(100);
			assertEquals(0, shoppingCart.countItems());
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void removingItemShouldDecreaseCartSize() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(laptop);

		try {
			int oldSize = shoppingCart.countItems();
			shoppingCart.removeItem(100);
			int newSize = shoppingCart.countItems();
			// assertEquals(1, (oldSize-newSize));
			assertTrue(newSize < oldSize);
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void addingDuplicateItemShouldIncreaseItemQuantity() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(laptop);
		Collection<Product> products = shoppingCart.cartDetails();
		for (Product product : products) {
			assertEquals(2, product.getQty());
		}

	}

	@Test
	public void addingLaptopShouldAddLaptopOnly() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		shoppingCart.addItem(laptop);
		Collection<Product> products = shoppingCart.cartDetails();
		for (Product product : products) {
			assertEquals(100, product.getId());
			assertTrue(product.getTitle().equals("HP Laptop"));
		}
	}

	@Test
	public void addingFiveItemsShouldMakeCartSizeToBeFive() {
		Product laptop = new Product(100, "HP Laptop", 1500.00, 1);
		Product mobile = new Product(200, "Oppo Mobile", 8500.00, 1);
		Product watch = new Product(300, "Rolax Watch", 80000.00, 1);
		Product glass = new Product(400, "Sun Glass", 10000.00, 1);
		Product shoe = new Product(500, "Shoe", 4500.00, 1);

		shoppingCart.addItem(laptop);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(glass);
		shoppingCart.addItem(shoe);

		int rs = shoppingCart.countItems();
		assertEquals(5, rs);

	}

	@Test
	public void addingOneItemShouldIncreaseCartSize() {
		Product product = new Product(100, "HP Laptop", 1500.00, 1);
		shoppingCart.addItem(product);
		int rs = shoppingCart.countItems();
		assertEquals(1, rs);

	}

	@Test
	public void addingDuplicateItemShouldAlsoBeAddedToCart() {
		Product product = new Product(100, "HP Laptop", 1500.00, 1);
		shoppingCart.addItem(product);
		shoppingCart.addItem(product);
		int rs = shoppingCart.countItems();
		assertEquals(2, rs);

	}

}