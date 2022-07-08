package fr.esgi.aquarium.infra.web.api;


import fr.esgi.aquarium.infra.service.SpringFishService;
import fr.esgi.aquarium.infra.web.response.fish.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fish")
public class FishController {
    private final SpringFishService springFishService;
/*
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
*/
    @GetMapping("/{name}")
    public Root[] getFishByName(@PathVariable("name") String name){
        var fish = springFishService.findByName(name);
        return fish;
        //var fishResponse = FishApiMapper.convertToResponseDto(fish);
        //var fishResponse = FishApiMapper.convertToResponseDto(springFishService.findByName(name));
        //return ResponseEntity.ok(fishResponse);
    }

    @GetMapping("/all")
    public Root[] getAllFishes(){
        var fish = springFishService.findAll();
        return fish;
        //var fishResponse = FishApiMapper.convertToResponseDto(fish);
        //var fishResponse = FishApiMapper.convertToResponseDto(springFishService.findAll());
        //return ResponseEntity.ok(fishResponse);
    }
/*

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

*/
}
