package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.CuisineTypeDto;
import nl.novi.backendwhattoeat.services.CuisineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuisineTypeController {
    private final CuisineTypeService cuisineTypeService;

    @Autowired
    public CuisineTypeController(CuisineTypeService cuisineTypeService) {
        this.cuisineTypeService = cuisineTypeService;
    }


    @GetMapping("/cuisinetypes")
    public List<CuisineTypeDto> getAllCuisineTypes() {

        List<CuisineTypeDto> dtos = cuisineTypeService.getAllCuisineTypes();

        return dtos;
    }

    @GetMapping("/cuisinetypes/{id}")
    public CuisineTypeDto getCuisineType(@PathVariable("id") Long id) {

        CuisineTypeDto cuisineTypeDto = cuisineTypeService.getCuisineType(id);

        return cuisineTypeDto;
    }

    @PostMapping("/cuisinetypes")
    public CuisineTypeDto addCuisineType(@RequestBody CuisineTypeDto dto) {
        CuisineTypeDto cuisineTypeDto = cuisineTypeService.addCuisineType(dto);
        return cuisineTypeDto;
    }

    @DeleteMapping("/cuisinetypes/{id}")
    public void deleteCuisineType(@PathVariable("id") Long id) {
        cuisineTypeService.deleteCuisineType(id);
    }

    @PutMapping("/cuisinetypes/{id}")
    public CuisineTypeDto updateCuisineType(@PathVariable("id") Long id, @RequestBody CuisineTypeDto cuisineTypeDto) {
        cuisineTypeService.updateCuisineType(id, cuisineTypeDto);
        return cuisineTypeDto;
    }
}
