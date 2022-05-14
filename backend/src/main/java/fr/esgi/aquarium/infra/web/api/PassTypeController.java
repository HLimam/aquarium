package fr.esgi.aquarium.infra.web.api;


import fr.esgi.aquarium.domain.service.PassTypeService;
import fr.esgi.aquarium.infra.web.mapper.PassTypeApiMapper;
import fr.esgi.aquarium.infra.web.request.PassRequest;
import fr.esgi.aquarium.infra.web.request.PassTypeRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassTypeRequest;
import fr.esgi.aquarium.infra.web.response.PassResponse;
import fr.esgi.aquarium.infra.web.response.PassTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pass-type")
public class PassTypeController {
    private final PassTypeService passTypeService;

    @GetMapping
    public ResponseEntity<List<PassTypeResponse>> getAllPassTypes(){
        var passTypes = passTypeService.findAll().stream().map(PassTypeApiMapper::convertToResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(passTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassTypeResponse> getPassTypeById(@PathVariable("id") Long passTypeId){
        var passType = PassTypeApiMapper.convertToResponseDto(passTypeService.findById(passTypeId));
        return ResponseEntity.ok(passType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePassTypeById(@PathVariable("id") Long passTypeId){
        passTypeService.deleteById(passTypeId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity addPassType(@Valid @RequestBody PassTypeRequest passType) {
        var passTypeResponse = PassTypeApiMapper.convertToResponseDto(passTypeService.save(PassTypeApiMapper.convertToModel(passType)));
        var location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + passTypeResponse.getId()
        );
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PassTypeResponse> updatePassType(@Valid @RequestBody UpdatePassTypeRequest passType) {
        var passTypeResponse = PassTypeApiMapper.convertToResponseDto(passTypeService.save(PassTypeApiMapper.convertToModel(passType)));
        return ResponseEntity.ok(passTypeResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PassTypeResponse> updatePassTypeAvailability(@PathVariable Long passTypeId, @RequestParam(value = "availability") Boolean availability) {
        var passTypeResponse = PassTypeApiMapper.convertToResponseDto(passTypeService.updateAvailability(passTypeId,availability));
        return ResponseEntity.ok(passTypeResponse);
    }

}
