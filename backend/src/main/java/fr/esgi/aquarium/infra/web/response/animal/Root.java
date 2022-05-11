package fr.esgi.aquarium.infra.web.response.animal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root {
    @JsonProperty("Fishery Management")
    public String fisheryManagement;
    @JsonProperty("Habitat")
    public String habitat;
    @JsonProperty("Habitat Impacts")
    public String habitatImpacts;
    @JsonProperty("Image Gallery")
    public ArrayList<ImageGallery> imageGallery;
    @JsonProperty("Location")
    public String location;
    @JsonProperty("Management")
    public Object management;
    @JsonProperty("NOAA Fisheries Region")
    public String nOAAFisheriesRegion;
    @JsonProperty("Population")
    public String population;
    @JsonProperty("Population Status")
    public String populationStatus;
    @JsonProperty("Scientific Name")
    public String scientificName;
    @JsonProperty("Species Aliases")
    public String speciesAliases;
    @JsonProperty("Species Illustration Photo")
    public SpeciesIllustrationPhoto speciesIllustrationPhoto;
    @JsonProperty("Species Name")
    public String speciesName;
    @JsonProperty("Animal Health")
    public Object animalHealth;
    @JsonProperty("Availability")
    public String availability;
    @JsonProperty("Biology")
    public String biology;
    @JsonProperty("Bycatch")
    public String bycatch;
    @JsonProperty("Calories")
    public String calories;
    @JsonProperty("Carbohydrate")
    public String carbohydrate;
    @JsonProperty("Cholesterol")
    public String cholesterol;
    @JsonProperty("Color")
    public String color;
    @JsonProperty("Disease Treatment and Prevention")
    public Object diseaseTreatmentAndPrevention;
    @JsonProperty("Diseases in Salmon")
    public Object diseasesInSalmon;
    @JsonProperty("Displayed Seafood Profile Illustration")
    public Object displayedSeafoodProfileIllustration;
    @JsonProperty("Ecosystem Services")
    public Object ecosystemServices;
    @JsonProperty("Environmental Considerations")
    public Object environmentalConsiderations;
    @JsonProperty("Environmental Effects")
    public Object environmentalEffects;
    @JsonProperty("Farming Methods")
    public Object farmingMethods;
    @JsonProperty("Fat, Total")
    public String fatTotal;
    @JsonProperty("Feeds_")
    public Object feeds_;
    @JsonProperty("Feeds")
    public Object feeds;
    @JsonProperty("Fiber, Total Dietary")
    public String fiberTotalDietary;
    @JsonProperty("Fishing Rate")
    public String fishingRate;
    @JsonProperty("Harvest")
    public String harvest;
    @JsonProperty("Harvest Type")
    public String harvestType;
    @JsonProperty("Health Benefits")
    public String healthBenefits;
    @JsonProperty("Human_Health_")
    public Object human_Health_;
    @JsonProperty("Human Health")
    public Object humanHealth;
    @JsonProperty("Physical Description")
    public String physicalDescription;
    @JsonProperty("Production")
    public Object production;
    @JsonProperty("Protein")
    public String protein;
    @JsonProperty("Quote")
    public String quote;
    @JsonProperty("Quote Background Color")
    public String quoteBackgroundColor;
    @JsonProperty("Research")
    public String research;
    @JsonProperty("Saturated Fatty Acids, Total")
    public String saturatedFattyAcidsTotal;
    @JsonProperty("Selenium")
    public String selenium;
    @JsonProperty("Serving Weight")
    public String servingWeight;
    @JsonProperty("Servings")
    public String servings;
    @JsonProperty("Sodium")
    public String sodium;
    @JsonProperty("Source")
    public String source;
    @JsonProperty("Sugars, Total")
    public String sugarsTotal;
    @JsonProperty("Taste")
    public String taste;
    @JsonProperty("Texture")
    public String texture;
    @JsonProperty("Path")
    public String path;
    public String last_update;
}
