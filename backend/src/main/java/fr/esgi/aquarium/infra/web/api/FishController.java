package fr.esgi.aquarium.infra.web.api;


import fr.esgi.aquarium.domain.model.Fish;
import fr.esgi.aquarium.infra.service.SpringFishService;
import fr.esgi.aquarium.infra.web.mapper.FishApiMapper;
import fr.esgi.aquarium.infra.web.mapper.SpaceApiMapper;
import fr.esgi.aquarium.infra.web.request.FishRequest;
import fr.esgi.aquarium.infra.web.request.SpaceRequest;
import fr.esgi.aquarium.infra.web.request.UpdateSpaceRequest;
import fr.esgi.aquarium.infra.web.response.FishResponse;
import fr.esgi.aquarium.infra.web.response.SpaceResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fish")
public class FishController {
    private final SpringFishService springFishService;

    @GetMapping
    public ResponseEntity<List<FishResponse>> getAllFishes(){
        var fishes = springFishService.findAll().stream().map(FishApiMapper::convertToResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(fishes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FishResponse> getFishById(@PathVariable("id") Long SpaceId){
        var fishResponse = FishApiMapper.convertToResponseDto(springFishService.findById(SpaceId));
        return ResponseEntity.ok(fishResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFishById(@PathVariable("id") Long SpaceId){
        springFishService.deleteById(SpaceId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity addFish(@Valid @RequestBody FishRequest fish) {
        var fishResponse = FishApiMapper.convertToResponseDto(springFishService.save(FishApiMapper.convertToModel(fish)));
        var location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + fishResponse.getId()
        );
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<FishResponse> updateFish(@Valid @RequestBody FishRequest fishRequest) {
        var fishResponse = FishApiMapper.convertToResponseDto(springFishService.save(FishApiMapper.convertToModel(fishRequest)));
        return ResponseEntity.ok(fishResponse);
    }


}
