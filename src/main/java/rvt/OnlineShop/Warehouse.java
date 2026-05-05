package rvt.OnlineShop;

import java.util.*;

public class Warehouse {
    Map<String, Integer> warehousePrices = new HashMap<>();
    Map<String, Integer> warehouseStock = new HashMap<>();

    public void addProduct(String product, int price, int stock) {
        warehousePrices.put(product, price);
        warehouseStock.put(product, stock);
    }

    public int price(String product) {
        if (warehousePrices.containsKey(product)) {
            return warehousePrices.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (warehouseStock.containsKey(product)) {
            return warehouseStock.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {

        if (warehouseStock.containsKey(product)) {
            if (warehouseStock.get(product) > 0) {
                warehouseStock.put(product, warehouseStock.get(product) - 1);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Set<String> products() {
        return warehouseStock.keySet();
    }
}