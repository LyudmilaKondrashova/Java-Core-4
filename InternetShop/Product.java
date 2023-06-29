package InternetShop;

public class Product {

    private String title;
    private float price;
    private Enums.category category;

    public Product(String title, float price, Enums.category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Enums.category getCategory() {
        return category;
    }

    public void setCategory(Enums.category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return title +
                ", price: " + price;
    }
}
