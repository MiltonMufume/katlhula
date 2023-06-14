package co.mz.gposoft.katlhula.domain;

import java.time.LocalDate;

public class CulturalEvent {

    private long id;

    private String description;

    private LocalDate eventDate;

    private String eventPlace;

    private String EventTime;

    private String organizer;

    private User createdBy;

    private Status status;

    public CulturalEvent(String description, LocalDate eventDate, String eventPlace, String eventTime, String organizer, User createdBy, Status status) {

        this.description = description;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        EventTime = eventTime;
        this.organizer = organizer;
        this.createdBy = createdBy;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public String getEventTime() {
        return EventTime;
    }

    public String getOrganizer() {
        return organizer;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Status getStatus() {
        return status;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "CulturalEvent{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", eventDate=" + eventDate +
                ", eventPlace='" + eventPlace + '\'' +
                ", EventTime='" + EventTime + '\'' +
                ", organizer='" + organizer + '\'' +
                ", createdBy=" + createdBy +
                ", status=" + status +
                '}';
    }

    public void remove() {
        this.status = Status.INACTIVE;
    }
}
