package rvt.OnlineShop;

import java.util.*;

public class ShoppingCart {
    int cartprice = 0;
    Map<String, Item> cartMap = new HashMap<>();

    public void add(String product, int price) {
        if (cartMap.containsKey(product)) {
            cartMap.get(product).increaseQuantity();
        } else {
            Item item = new Item(product, 1, price);
            cartMap.put(product, item);
        }
        cartprice += price;  
    }

    public int price() {
        return cartprice;
    }

    public void print() {
        Collection<Item> values = cartMap.values();
        String formatted = values.toString().replace("[", "").replace("]", "").replace(",", "\n");
        System.out.println(formatted);
    }
}