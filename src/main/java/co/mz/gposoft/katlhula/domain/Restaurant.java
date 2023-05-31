package co.mz.gposoft.katlhula.domain;

public class Restaurant {

    private long id;

    private String description;

    private String location;

    private String attendanceTime;

    //this might be an ENUM with punctuation rate from 1 to 5
    private ServiceClassification classification;

    //this might be an ENUM with the categories
    private RestaurantCategory category;

    private UserPhoto photo;

    private RestaurantMenu menu;

    private User createdBy;

    public Restaurant(String description, String location, String attendanceTime, ServiceClassification classification, RestaurantCategory category, UserPhoto photo, RestaurantMenu menu, User createdBy) {
        this.description = description;
        this.location = location;
        this.attendanceTime = attendanceTime;
        this.classification = classification;
        this.category = category;
        this.photo = photo;
        this.menu = menu;
        this.createdBy = createdBy;
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

    public User getCreatedBy() {
        return createdBy;
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
