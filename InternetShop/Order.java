package InternetShop;

public class Order {

    private Customer customer;
    private Product product;
    private int amount;
    private float totalCost;

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.totalCost = product.getPrice() * amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "CUSTOMER: " + customer.toString() +
                ", PRODUCT: " + product.toString() +
                ", AMOUNT: " + amount +
                ", TOTAL COST: " + totalCost +
                '}';
    }
}
