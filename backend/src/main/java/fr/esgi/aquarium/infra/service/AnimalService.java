package fr.esgi.aquarium.infra.service;

import fr.esgi.aquarium.infra.web.response.animal.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final RestTemplate restTemplate;

    public Root[] findByName(String name) {
        //AnimalResponse animalResponse  =restTemplate.getForObject("http://localhost:8083/api/v1/fraud-check/%7BcustomerId%7D%22,FraudCheckResponse.class,customer.getId());
        var animalResponse = restTemplate.getForObject("https://www.fishwatch.gov/api/species/{fishName}", Root[].class, name);
        return animalResponse;
    }

}
