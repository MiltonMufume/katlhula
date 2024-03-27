package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cultural_event")
public class CulturalEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cultural_event")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "event_place")
    private String eventPlace;

    @Column(name = "event_time")
    private String eventTime;

    @Column(name = "event_organizer")
    private String organizer;


    @OneToOne
    @JoinColumn(name = "id_utilizador")
    private Utilizador createdBy;

    @Column(name = "status")
    private Status status;

    public CulturalEvent(String description, LocalDate eventDate, String eventPlace, String eventTime, String organizer, Utilizador createdBy) {

        this.description = description;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.eventTime = eventTime;
        this.organizer = organizer;
        this.createdBy = createdBy;


        updateEventStatus(this.eventDate);


    }

    public CulturalEvent() {

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

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;

        updateEventStatus(this.eventDate);


    }

    public String getEventPlace() {
        return eventPlace;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getOrganizer() {
        return organizer;
    }

    public Utilizador getCreatedBy() {
        return createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setCreatedBy(Utilizador createdBy) {
        this.createdBy = createdBy;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "CulturalEvent{" + "id=" + id + ", description='" + description + '\'' + ", eventDate=" + eventDate + ", eventPlace='" + eventPlace + '\'' + ", EventTime='" + eventTime + '\'' + ", organizer='" + organizer + '\'' + ", createdBy=" + createdBy + ", status=" + status + '}';
    }

    public void remove() {
        this.status = Status.INACTIVE;
    }

    private void updateEventStatus(LocalDate eventDate) {

        if (eventDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot pass past values to the Event Dates");
        }

        if (eventDate.isAfter(LocalDate.now())) {

            this.status = Status.FOR_HAPPEN;
        } else if (eventDate.isEqual(LocalDate.now())) {
            this.status = Status.ACTIVE;
        }
    }
}
