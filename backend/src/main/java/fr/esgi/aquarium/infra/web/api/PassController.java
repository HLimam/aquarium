package fr.esgi.aquarium.infra.web.api;


import fr.esgi.aquarium.domain.service.PassService;
import fr.esgi.aquarium.infra.service.SpringPassService;
import fr.esgi.aquarium.infra.web.mapper.PassApiMapper;
import fr.esgi.aquarium.infra.web.request.PassRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassRequest;
import fr.esgi.aquarium.infra.web.response.PassResponse;
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
@RequestMapping("/api/v1/pass")
public class PassController {
    private final SpringPassService passService;

    @GetMapping
    public ResponseEntity<List<PassResponse>> getAllPasss(){
        var Passs = passService.findAll().stream().map(PassApiMapper::convertToResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(Passs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassResponse> getPassById(@PathVariable("id") Long passId){
        var Pass = PassApiMapper.convertToResponseDto(passService.findById(passId));
        return ResponseEntity.ok(Pass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePassById(@PathVariable("id") Long passId){
        passService.deleteById(passId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity createPass(@Valid @RequestBody PassRequest Pass) {
        var PassResponse = PassApiMapper.convertToResponseDto(passService.save(PassApiMapper.convertToModel(Pass)));
        var location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + PassResponse.getId()
        );
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PassResponse> checkAvailability(@PathVariable Long passId, @RequestParam(value = "availability") Boolean availability) {
        var PassResponse = PassApiMapper.convertToResponseDto(passService.checkAvailability(passId));
        return ResponseEntity.ok(PassResponse);
    }

}
