package co.mz.gposoft.katlhula.domain;

public class ProductToSell {


    private long id;

    private String description;

    private String location;

    private SellerContact contacts;

    //this might be an ENUM with punctuation rate from 1 to 5
    private String classification;

    //this might be an ENUM with the categories
    private ProductCategory category;

    private UserPhoto photo;

    public ProductToSell(String description, String location, SellerContact contacts, String classification, ProductCategory category, UserPhoto photo) {
        this.description = description;
        this.location = location;
        this.contacts = contacts;
        this.classification = classification;
        this.category = category;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public SellerContact getContacts() {
        return contacts;
    }

    public String getClassification() {
        return classification;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public UserPhoto getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "ProductToSell{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", contacts=" + contacts +
                ", classification='" + classification + '\'' +
                ", category=" + category +
                ", photo=" + photo +
                '}';
    }
}
