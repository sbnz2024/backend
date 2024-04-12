package demo.dto;

import demo.model.Arrangement;

import java.util.List;

public class ArrangementDTO {
    private String name;
    private String description;
    private Double price;
    private String image;
    private Arrangement.ArrangementType type;
    private List<TourDTO> tours;

    public ArrangementDTO(Arrangement arrangement) {
        this.name = arrangement.getName();
        this.description = arrangement.getDescription();
        this.price = arrangement.getPrice();
        this.image = arrangement.getImage();
        this.type = arrangement.getType();
        // Ako želite mapirati ture iz Arrangement na TourDTO, možete to učiniti ovde
        // this.tours = arrangement.getTours().stream().map(TourDTO::new).collect(Collectors.toList());
    }


    public ArrangementDTO() {
    }

    public ArrangementDTO(String name, String description, Double price, String image, Arrangement.ArrangementType type, List<TourDTO> tours) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.type = type;
        this.tours = tours;
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

    public Arrangement.ArrangementType getType() {
        return type;
    }

    public void setType(Arrangement.ArrangementType type) {
        this.type = type;
    }

    public List<TourDTO> getTours() {
        return tours;
    }

    public void setTours(List<TourDTO> tours) {
        this.tours = tours;
    }
}
