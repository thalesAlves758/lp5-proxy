public interface IProduct {
    String getName();
    void setName(String name);
    float getPrice();
    void setPrice(float price);
    IProvider getProvider();
    void setProvider(IProvider provider);
}
