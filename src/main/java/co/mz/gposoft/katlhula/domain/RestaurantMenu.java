package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "restaurant_menu")
public class RestaurantMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurant_menu")
    private long id;

    @OneToOne
    @JoinColumn(name = "id_foto")
    private UserPhoto photo;

    @Column(name = "restaurant_menu")
    @ElementCollection
    private Map<String, Double> menu;

    @OneToOne(mappedBy = "menu")
    private Restaurant restaurant;

    public RestaurantMenu(UserPhoto menuPhoto, Map<String, Double> menu) {
        this.photo = menuPhoto;
        this.menu = menu;
    }

    public RestaurantMenu() {

    }

    public long getId() {
        return id;
    }

    public UserPhoto getPhoto() {
        return photo;
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void setPhoto(UserPhoto photo) {
        this.photo = photo;
    }

    public void setMenu(Map<String, Double> menu) {
        this.menu = menu;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "id=" + id +
                ", menuPhoto=" + photo +
                ", menu=" + menu +
                '}';
    }
}
