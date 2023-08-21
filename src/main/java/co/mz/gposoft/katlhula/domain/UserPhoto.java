package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_photo")
public class UserPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo")
    private long id;

    @Column(name = "location_dir")
    private String location;

    @Column(name = "photo_decription")
    private String photoDescription;

    @Column(name = "created_by")
    @OneToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @OneToOne(mappedBy = "photo")
    private ProductToSell productToSell;

    public UserPhoto(String location, String photoDescription, User createdBy) {
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

    public User getCreatedBy() {
        return createdBy;
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

