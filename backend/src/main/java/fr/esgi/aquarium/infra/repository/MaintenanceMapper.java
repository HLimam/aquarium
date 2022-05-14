package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.infra.repository.entity.MaintenanceEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MaintenanceMapper {

    private final ModelMapper modelMapper;

    public Maintenance toModel(MaintenanceEntity entity) {
        return modelMapper.map(entity, Maintenance.class);
    }

    public MaintenanceEntity toEntity(Maintenance maintenance) {
        return modelMapper.map(maintenance, MaintenanceEntity.class);
    }
}
