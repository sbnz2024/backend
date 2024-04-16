package demo.model;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="arrangement")
public class Arrangement {

    public enum ArrangementType {
        FAMILY, GROUP, INDIVIDUAL
    }

    public enum Grade {
        GOOD,BAD,NEUTRAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image")
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ArrangementType type;

    @Column(name="state")
    private  Boolean state;

    @Column(name="dateAdded")
    private Date dateAdded;

    @Column(name="popular")
    private Boolean popular;

    @Enumerated(EnumType.STRING)
    @Column(name="grade")
    private Grade grade;

    @Column(name="averangeRating")
    private Double averangeRating;

    @OneToMany(mappedBy = "arrangement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tour> tours;

    @OneToMany(mappedBy = "arrangement", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    public Arrangement() {
    }

    public Arrangement(Integer id, String name, String description, Double price, String image, ArrangementType type, List<Tour> tours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.type = type;
        this.tours = tours;
        this.ratings = null;
        this.state=null;
        this.dateAdded=null;
        this.popular=null;
        this.grade=null;
        this.averangeRating=0.0;
    }

    public Double calculateAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0; // Ako nema ocena, prosečna ocena je 0
        }

        double sum = 0.0;
        for (Rating rating : ratings) {
            sum += rating.getRatingValue();
        }
        return sum / ratings.size();
    }



    public Double getAverangeRating() {
        return averangeRating;
    }

    public void setAverangeRating(Double averangeRating) {
        this.averangeRating = averangeRating;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    // Getteri i setteri
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrangementType getType() {
        return type;
    }

    public void setType(ArrangementType type) {
        this.type = type;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Boolean getPopular() {
        return popular;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
