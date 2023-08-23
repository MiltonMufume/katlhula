package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "attendance_time")
    private String attendanceTime;

    //this might be an ENUM with punctuation rate from 1 to 5
    @Column(name = "service_classification")
    private ServiceClassification classification;

    //this might be an ENUM with the categories
    @Column(name = "restaurant_category")
    private RestaurantCategory category;

    @OneToOne
    @JoinColumn(name = "id_foto")
    private UserPhoto photo;


    @OneToOne
    @JoinColumn(name = "id_restaurant_menu")
    private RestaurantMenu menu;


    @OneToOne
    @JoinColumn(name = "id_utilizador")
    private Utilizador createdBy;

    public Restaurant(String description, String location, String attendanceTime, ServiceClassification classification, RestaurantCategory category, UserPhoto photo, RestaurantMenu menu, Utilizador createdBy) {
        this.description = description;
        this.location = location;
        this.attendanceTime = attendanceTime;
        this.classification = classification;
        this.category = category;
        this.photo = photo;
        this.menu = menu;
        this.createdBy = createdBy;
    }

    public Restaurant() {

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

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public ServiceClassification getClassification() {
        return classification;
    }

    public RestaurantCategory getCategory() {
        return category;
    }

    public UserPhoto getPhoto() {
        return photo;
    }

    public RestaurantMenu getMenu() {
        return menu;
    }

    public Utilizador getCreatedBy() {
        return createdBy;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public void setClassification(ServiceClassification classification) {
        this.classification = classification;
    }

    public void setCategory(RestaurantCategory category) {
        this.category = category;
    }

    public void setPhoto(UserPhoto photo) {
        this.photo = photo;
    }

    public void setMenu(RestaurantMenu menu) {
        this.menu = menu;
    }

    public void setCreatedBy(Utilizador createdBy) {
        this.createdBy = createdBy;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", attendanceTime='" + attendanceTime + '\'' +
                ", classification=" + classification +
                ", category=" + category +
                ", photo=" + photo +
                ", menu=" + menu +
                ", createdBy=" + createdBy +
                '}';
    }
}
