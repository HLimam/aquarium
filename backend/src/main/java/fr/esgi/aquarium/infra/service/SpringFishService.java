package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.infra.web.response.fish.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class SpringFishService {
    private final RestTemplate restTemplate;

    public Root[] findByName(String name) {
        var fishResponse = restTemplate.getForObject("https://www.fishwatch.gov/api/species/{fishName}", Root[].class, name);
        return fishResponse;
    }

    public Root[] findAll() {
        var fishResponse = restTemplate.getForObject("https://www.fishwatch.gov/api/species", Root[].class);
        return fishResponse;
    }



}
