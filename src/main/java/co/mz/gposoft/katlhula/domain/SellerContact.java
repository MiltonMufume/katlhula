package co.mz.gposoft.katlhula.domain;

import java.util.List;

public class SellerContact {


    private long id;
    private String email;

    private List<String> cellphones;

    private String name;

    public SellerContact(String email, List<String> cellphones, String name) {
        this.email = email;
        this.cellphones = cellphones;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getCellphones() {
        return cellphones;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SellerContact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", cellphones=" + cellphones +
                ", name='" + name + '\'' +
                '}';
    }
}
