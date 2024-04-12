package demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tour")
public class Tour {

    public enum TourCategory {
        HISTORICAL, CULTURAL, ADVENTURE, NATURE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTour;

    @Column(name = "tour_name", nullable = false)
    private String tourName;

    @Column(name = "tour_description", nullable = false)
    private String tourDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "participants_count")
    private Integer participantsCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private TourCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrangement_id", nullable = false)
    private Arrangement arrangement;




    public Tour() {
    }

    public Tour(Integer idTour, String tourName, String tourDescription, Double price, Double totalPrice, Integer participantsCount, TourCategory category, Arrangement arrangement) {
        this.idTour = idTour;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.price = price;
        this.totalPrice = totalPrice;
        this.participantsCount = participantsCount;
        this.category = category;
        this.arrangement = arrangement;
    }

    // Getteri i setteri
    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public TourCategory getCategory() {
        return category;
    }

    public void setCategory(TourCategory category) {
        this.category = category;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }
}
