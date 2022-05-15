package fr.esgi.aquarium.infra.web.api;


import fr.esgi.aquarium.infra.service.SpringSpaceService;
import fr.esgi.aquarium.infra.web.mapper.SpaceApiMapper;
import fr.esgi.aquarium.infra.web.request.SpaceRequest;
import fr.esgi.aquarium.infra.web.request.UpdateSpaceRequest;
import fr.esgi.aquarium.infra.web.response.SpaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/space")
public class SpaceController {
    private final SpringSpaceService SpaceService;

    @GetMapping
    public ResponseEntity<List<SpaceResponse>> getAllSpaces(){
        var spaces = SpaceService.findAll().stream().map(SpaceApiMapper::convertToResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(spaces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceResponse> getSpaceById(@PathVariable("id") Long SpaceId){
        var spaceResponse = SpaceApiMapper.convertToResponseDto(SpaceService.findById(SpaceId));
        return ResponseEntity.ok(spaceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpaceById(@PathVariable("id") Long SpaceId){
        SpaceService.deleteById(SpaceId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity addSpace(@Valid @RequestBody SpaceRequest Space) {
        var spaceResponse = SpaceApiMapper.convertToResponseDto(SpaceService.save(SpaceApiMapper.convertToModel(Space)));
        var location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + spaceResponse.getId()
        );
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SpaceResponse> updateSpace(@Valid @RequestBody UpdateSpaceRequest Space) {
        var spaceResponse = SpaceApiMapper.convertToResponseDto(SpaceService.save(SpaceApiMapper.convertToModel(Space)));
        return ResponseEntity.ok(spaceResponse);
    }


}
