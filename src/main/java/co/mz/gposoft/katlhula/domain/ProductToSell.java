package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;

@Entity
@Table(name = "product_to_sell")
public class ProductToSell {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_to_sell")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;


    @OneToOne
    @JoinColumn(name = "id_seller_contact")
    private SellerContact contacts;

    //this might be an ENUM with punctuation rate from 1 to 5
    @Column(name = "classification")
    private ProductClassification classification;

    //this might be an ENUM with the categories
    @Column(name = "category")
    private ProductCategory category;

    @OneToOne
    @JoinColumn(name = "id_foto")
    private UserPhoto photo;

    @Column(name = "product_status")
    private ProductStatus status;

    public ProductToSell(String description, String location, SellerContact contacts, ProductClassification classification, ProductCategory category, UserPhoto photo, ProductStatus status) {

        this.description = description;
        this.location = location;
        this.contacts = contacts;
        this.classification = classification;
        this.category = category;
        this.photo = photo;
        this.status = status;
    }

    public ProductToSell() {

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

    public ProductClassification getClassification() {
        return classification;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public UserPhoto getPhoto() {
        return photo;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContacts(SellerContact contacts) {
        this.contacts = contacts;
    }

    public void setClassification(ProductClassification classification) {
        this.classification = classification;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setPhoto(UserPhoto photo) {
        this.photo = photo;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */
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
                ", status=" + status +
                '}';
    }

    public void remove() {
        this.status = ProductStatus.INACTIVO;
    }

    public void productSold() {

        this.status = ProductStatus.VENDIDO;
    }
}
