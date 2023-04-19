public class ProductProxy implements IProduct {
    private Product product;
    private IProvider provider;
    private User user;

    public ProductProxy(String name, float price, String providerName, User user) {
        this.product = new Product(name, price, providerName);
        this.user = user;
    }

    public String getName() {
        return this.product.getName();
    }

    public void setName(String name) {
        if(!this.user.isAdmin()) {
            throw new UnsupportedOperationException("Only adm users can set an attribute in Product");
        }

        this.product.setName(name);
    }

    public float getPrice() {
        return this.product.getPrice();
    }

    public void setPrice(float price) throws UnsupportedOperationException {
        if(!this.user.isAdmin()) {
            throw new UnsupportedOperationException("Only adm users can set an attribute in Product");
        }

        this.product.setPrice(price);
    }

    public IProvider getProvider() {
        if(this.provider == null) {
            this.provider = new Provider(this.product.getProvider().getName());
        }

        return this.provider;
    }

    public void setProvider(IProvider provider) {
        if(!this.user.isAdmin()) {
            throw new UnsupportedOperationException("Only adm users can set an attribute in Product");
        }

        this.product.setProvider(provider);
    }
}
