package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seller_contact")
public class SellerContact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seller_contact")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "cellphones")
    @ElementCollection
    private List<String> cellphones;

    @OneToOne(mappedBy = "contacts")
    private ProductToSell productToSell;

    @Column(name = "seller_name")
    private String name;

    public SellerContact(String email, List<String> cellphones, String name) {
        this.email = email;
        this.cellphones = cellphones;
        this.name = name;
    }

    public SellerContact() {

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
