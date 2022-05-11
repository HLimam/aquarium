package fr.esgi.aquarium.infra.web.response.animal;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class ImageGallery {
    public String src;
    public String alt;
    public String title;
}
