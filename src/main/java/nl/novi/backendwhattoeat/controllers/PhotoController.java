package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.PhotoDto;
import nl.novi.backendwhattoeat.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/photos")
    public List<PhotoDto> getAllPhotos() {

        List<PhotoDto> dtos = photoService.getAllPhotos();

        return dtos;
    }

    @GetMapping("/photos/{id}")
    public PhotoDto getRemotecontroller(@PathVariable("id") Long id) {

        PhotoDto dto = photoService.getPhoto(id);

        return dto;
    }

    @PostMapping("/photos")
    public PhotoDto addPhoto(@RequestBody PhotoDto dto) {
       PhotoDto dto1 = photoService.addPhoto(dto);
        return dto1;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable("id") Long id) {
        photoService.deletePhoto(id);
    }

    @PutMapping("/photos/{id}")
    public PhotoDto updateMenu(@PathVariable("id") Long id, @RequestBody PhotoDto dto) {
        photoService.updatePhoto(id, dto);
        return dto;
    }
}
