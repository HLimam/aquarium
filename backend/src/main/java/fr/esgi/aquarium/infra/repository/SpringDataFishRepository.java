package fr.esgi.aquarium.infra.repository;

/*
@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataFishRepository implements FishRepository {

    private final JPAFishRepository fishRepository;
    private final FishMapper mapper;

    @Override
    public Fish findById(Long typeId) {
        var fish = fishRepository.findById(typeId);
        if(fish.isEmpty()){
            throw new EntityNotFoundException();
        }
        return mapper.toModel(fish.get());
    }

    @Override
    public void deleteById(Long typeId) {
        fishRepository.deleteById(typeId);
    }

    @Override
    public Fish findByName(String name) {
        var fish = fishRepository.findByName(name);
        if(fish.isEmpty()){
            throw new EntityNotFoundException();
        }
        return mapper.toModel(fish.get());
    }

    @Override
    public List<Fish> findAll() {
        return fishRepository.findAll().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Fish save(Fish fish) {
        if(fishRepository.findByName(fish.getName()).isPresent()){
            throw new AquariumException(ExceptionCode.ENTITY_CREATION_ERROR);
        }
        return mapper.toModel(fishRepository.saveAndFlush(mapper.toEntity(fish)));
    }

    @Override
    public Fish update(Fish fish) {
        if(fishRepository.findById(fish.getId()).isEmpty()){
            throw new AquariumException(ExceptionCode.MODIFICATION_IMPOSSIBLE);
        }
        return mapper.toModel(fishRepository.saveAndFlush(mapper.toEntity(fish)));
    }
}*/
