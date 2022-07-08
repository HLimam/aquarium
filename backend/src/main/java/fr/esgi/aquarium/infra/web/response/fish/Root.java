package fr.esgi.aquarium.infra.web.response.fish;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
public class Root{
    @JsonProperty("Fishery Management")
    public String fisheryManagement;
    @JsonProperty("Habitat")
    public String habitat;
    @JsonProperty("Habitat Impacts")
    public String habitatImpacts;
    @JsonProperty("Image Gallery")
    public Object imageGallery;
    @JsonProperty("Location")
    public String location;
    @JsonProperty("Management")
    public String management;
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
    public String animalHealth;
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
    public String diseasesInSalmon;
    @JsonProperty("Displayed Seafood Profile Illustration")
    public Object displayedSeafoodProfileIllustration;
    @JsonProperty("Ecosystem Services")
    public String ecosystemServices;
    @JsonProperty("Environmental Considerations")
    public String environmentalConsiderations;
    @JsonProperty("Environmental Effects")
    public String environmentalEffects;
    @JsonProperty("Farming Methods")
    public String farmingMethods;

    @JsonProperty("Fat, Total")
    public String fatTotal;
    @JsonProperty("Feeds_")
    public String feeds_;
    @JsonProperty("Feeds")
    public String feeds;
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
    public String human_Health_;
    @JsonProperty("Human Health")
    public String humanHealth;
    @JsonProperty("Physical Description")
    public String physicalDescription;
    @JsonProperty("Production")
    public String production;
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



