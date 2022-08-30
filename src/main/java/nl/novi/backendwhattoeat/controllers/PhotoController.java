package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.PhotoDto;
import nl.novi.backendwhattoeat.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("photos")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping
    public List<PhotoDto> getAllPhotos() {

        List<PhotoDto> dtos = photoService.getAllPhotos();

        return dtos;
    }

    @GetMapping("{id}")
    public PhotoDto getPhotoById(@PathVariable("id") Long id) {

        PhotoDto dto = photoService.getPhoto(id);

        return dto;
    }

    @PostMapping
    public PhotoDto addPhoto(@RequestBody PhotoDto photoDto) {
       PhotoDto dto = photoService.addPhoto(photoDto);
        return dto;
    }

    @DeleteMapping("{id}")
    public void deletePhoto(@PathVariable("id") Long id) {
        photoService.deletePhoto(id);
    }

}
