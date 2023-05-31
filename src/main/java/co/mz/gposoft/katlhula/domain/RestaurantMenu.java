package co.mz.gposoft.katlhula.domain;

import java.util.Map;

public class RestaurantMenu {

    private long id;
    private UserPhoto menuPhoto;

    private Map<String, Double> menu;

    public RestaurantMenu(UserPhoto menuPhoto, Map<String, Double> menu) {
        this.menuPhoto = menuPhoto;
        this.menu = menu;
    }

    public long getId() {
        return id;
    }

    public UserPhoto getMenuPhoto() {
        return menuPhoto;
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "id=" + id +
                ", menuPhoto=" + menuPhoto +
                ", menu=" + menu +
                '}';
    }
}
