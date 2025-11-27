package app.model;


public class MenuItem {
    private String id;
    private String name;
    private String category; 
    private String description;
    private double price;
    private String image; 

    public MenuItem(String id, String name, String category, String description, double price, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getId(){ return id; }
    public String getName(){ return name; }
    public String getCategory(){ return category; }
    public String getDescription(){ return description; }
    public double getPrice(){ return price; }
    public String getImage(){ return image; }
}
