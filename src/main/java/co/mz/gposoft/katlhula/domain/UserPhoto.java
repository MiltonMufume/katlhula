package co.mz.gposoft.katlhula.domain;

public class UserPhoto {

    private long id;
    private String location;

    private String photoDescription;

    private User createdBy;

    public UserPhoto(String location, String photoDescription, User createdBy) {
        this.location = location;
        this.photoDescription = photoDescription;
        this.createdBy = createdBy;
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

