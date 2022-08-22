package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.CuisineTypeDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.CuisineType;
import nl.novi.backendwhattoeat.repositories.CuisineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuisineTypeService {

    @Autowired
    private CuisineTypeRepository cuisineTypeRepository;

    public List<CuisineTypeDto> getAllCuisineTypes() {
        List<CuisineTypeDto> dtos = new ArrayList<>();
        List<CuisineType> cuisineTypes = cuisineTypeRepository.findAll();
        for (CuisineType ct : cuisineTypes) {
            dtos.add(transferToDto(ct));
        }
        return dtos;
    }

    public CuisineTypeDto getCuisineType(long id) {
        Optional<CuisineType> cuisineType = cuisineTypeRepository.findById(id);
        if(cuisineType.isPresent()) {
            return transferToDto(cuisineType.get());
        } else {
            throw new RecordNotFoundException("No cuisinetype found");
        }
    }
    public CuisineTypeDto addCuisineType(CuisineTypeDto cuisineTypeDto) {
        CuisineType ct =  transferToCuisineType(cuisineTypeDto);
        cuisineTypeRepository.save(ct);
        return cuisineTypeDto;
    }
    public void deleteCuisineType(Long id) {
        cuisineTypeRepository.deleteById(id);
    }

    public void updateCuisineType(Long id, CuisineTypeDto cuisineTypeDto) {
        if (!cuisineTypeRepository.existsById(id)) {
            throw new RecordNotFoundException("No cuisinetype found");
        }
        CuisineType storedCuisineType = cuisineTypeRepository.findById(id).orElse(null);
        storedCuisineType.setId(cuisineTypeDto.getId());
        storedCuisineType.setName(cuisineTypeDto.getName());
        storedCuisineType.setDescription(cuisineTypeDto.getDescription());
        cuisineTypeRepository.save(storedCuisineType);
    }
    public CuisineTypeDto transferToDto (CuisineType cuisineType){
        var dto = new CuisineTypeDto();

        dto.id = cuisineType.getId();
        dto.getName = cuisineType.getName();
        dto.getDescription = cuisineType.getDescription();

        return dto;
    }
    public CuisineType transferToCuisineType (CuisineType Dto){
        var cuisineType = new CuisineType();

        cuisineTypoe.setId(dto.getId());
        cuisineType.setName(dto.getName());
        cuisineType.setDescription(dto.getDescription());

        return cuisineType
    }
}
