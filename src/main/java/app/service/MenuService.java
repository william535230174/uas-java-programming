package app.service;
import app.model.MenuItem;
import java.util.*;

public class MenuService {
    private final List<MenuItem> items = new ArrayList<>();

    public MenuService() {
        items.add(new MenuItem("m1","Nasi Goreng Spesial","Makanan","Nasi goreng dengan telur & ayam", 22000, "/images/nasi_goreng.jpg"));
        items.add(new MenuItem("m2","Mie Ayam Bakso","Makanan","Mie ayam lengkap dengan bakso", 20000, "/images/mie_ayam.jpg"));
        items.add(new MenuItem("d1","Es Teh Manis","Minuman","Es teh segar", 5000, "/images/es_teh.jpg"));
        items.add(new MenuItem("s1","Kentang Goreng","Snack","Porsi kentang goreng", 12000, "/images/kentang.jpg"));
        items.add(new MenuItem("p1","Paket Hemat 1","Paket","Nasi+Ayam+Teh", 30000, "/images/paket1.jpg"));
        items.add(new MenuItem("promo1","Burger Promo","Promo","Burger diskon 20%", 18000, "/images/burger.jpg"));
    }

    public List<MenuItem> getAll() {
        return Collections.unmodifiableList(items);
    }

    public List<MenuItem> getByCategory(String category) {
        List<MenuItem> out = new ArrayList<>();
        for (MenuItem i : items) {
            if (i.getCategory().equalsIgnoreCase(category)) out.add(i);
        }
        return out;
    }

    public MenuItem findById(String id) {
        for (MenuItem i : items) if (i.getId().equals(id)) return i;
        return null;
    }
}
