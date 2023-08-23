package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;

@Entity
@Table(name = "foto")
public class UserPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private long id;

    @Column(name = "location_dir")
    private String location;

    @Column(name = "photo_decription")
    private String photoDescription;


    @OneToOne
    @JoinColumn(name = "id_utilizador")
    private Utilizador createdBy;

    @OneToOne(mappedBy = "photo")
    private ProductToSell productToSell;

    @OneToOne(mappedBy = "photo")
    Restaurant restaurant;

    @OneToOne(mappedBy = "photo")
    private RestaurantMenu restaurantMenu;

    public UserPhoto(String location, String photoDescription, Utilizador createdBy) {
        this.location = location;
        this.photoDescription = photoDescription;
        this.createdBy = createdBy;
    }

    public UserPhoto() {

    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public Utilizador getCreatedBy() {
        return createdBy;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public void setCreatedBy(Utilizador createdBy) {
        this.createdBy = createdBy;
    }

    public void setProductToSell(ProductToSell productToSell) {
        this.productToSell = productToSell;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    @Override
    public String toString() {
        return "UserPhoto{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", photoDescription='" + photoDescription + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}

