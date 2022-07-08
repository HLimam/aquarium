package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.service.StringSearchMatching;
import fr.esgi.aquarium.infra.web.response.fish.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpringFishService {
    private final RestTemplate restTemplate;

    public Root[] findByName(String name) {
        var response = this.findAll();

        var fishNames = Arrays.stream(response).map(fish -> fish.speciesName).collect(Collectors.toList());
        var fishNameWithFuzzyMatching = fishNames.stream().filter((fishName)->StringSearchMatching.isFuzzyMatching(fishName,name,60)).collect(Collectors.joining(","));;


        var fishResponse = restTemplate.getForObject("https://www.fishwatch.gov/api/species/{fishName}", Root[].class, fishNameWithFuzzyMatching);
        return fishResponse;

    }

    public Root[] findAll() {
        var fishResponse = restTemplate.getForObject("https://www.fishwatch.gov/api/species", Root[].class);
        return fishResponse;
    }



}
