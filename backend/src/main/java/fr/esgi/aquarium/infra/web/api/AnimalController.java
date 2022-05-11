package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.infra.service.AnimalService;
import fr.esgi.aquarium.infra.web.response.animal.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/animal")
public class AnimalController {
    private final AnimalService animalService;
    @GetMapping("/{name}")
    public Root[] findByName(@PathVariable String name) {
        var fishResponse = animalService.findByName(name);
        //AnimalResponse animalResponse  =restTemplate.getForObject("http://localhost:8083/api/v1/fraud-check/%7BcustomerId%7D%22,FraudCheckResponse.class,customer.getId());
       // var animalResponse  = restTemplate.getForObject("https://www.fishwatch.gov/api/species/{fishName}",Root[].class,"red-snapper");
        return fishResponse;
    }
}


