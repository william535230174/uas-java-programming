package app.service;

import app.model.CartItem;
import app.model.MenuItem;
import java.util.*;

public class CartService {

    private final Map<String, CartItem> cart = new HashMap<>();

    public void add(MenuItem item, int qty) {
        if (cart.containsKey(item.getId())) {
            CartItem existing = cart.get(item.getId());
            existing.setQuantity(existing.getQuantity() + qty);
        } else {
            cart.put(item.getId(), new CartItem(item, qty)); 
        }
    }

    public void update(String id, int qty) {
        if (qty <= 0) cart.remove(id);
        else cart.get(id).setQuantity(qty);
    }

    public void remove(String id) { cart.remove(id); }

    public Map<String,Object> summary() {
        int totalQty = 0;
        double total = 0;

        for (CartItem c : cart.values()) {
            totalQty += c.getQuantity();
            total += c.getTotal(); 
        }

        Map<String,Object> out = new HashMap<>();
        out.put("items", cart.values());
        out.put("totalQty", totalQty);
        out.put("total", total);
        return out;
    }
}
