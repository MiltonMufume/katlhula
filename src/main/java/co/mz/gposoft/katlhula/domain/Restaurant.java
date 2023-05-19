package co.mz.gposoft.katlhula.domain;

public class Restaurant {

    private long id;

    private String description;

    private String location;

    private String attendanceTime;

    //this might be an ENUM with punctuation rate from 1 to 5
    private String classification;

    //this might be an ENUM with the categories
    private String category;

    private UserPhoto photo;

    private RestaurantMenu menu;

    private User createdBy;

    /*
     * then a set of business and other (CRUD) methods
     * */
}
