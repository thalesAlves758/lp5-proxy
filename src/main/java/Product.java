public class Product implements IProduct {
    private String name;
    private float price;
    private IProvider provider;

    public Product(String name, float price, String providerName) {
        this.name = name;
        this.price = price;
        this.provider = new Provider(providerName);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public void setProvider(IProvider provider) {
        this.provider = provider;
    }
}
