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
    public PhotoController (PhotoService photoService){
        this.photoService = photoService;
    }

    @GetMapping
    public List<PhotoDto> getAllPhotos() {
        List<PhotoDto> photos = photoService.getAllPhotos();
        return photos;
    }

    @GetMapping("{id}")
    public PhotoDto getPhotoById(@PathVariable("id") Long id) {
        PhotoDto photo = photoService.getPhotoById(id);
        return photo;
    }

    @PostMapping
    public PhotoDto addPhoto(@RequestBody PhotoDto photoDto){
        PhotoDto photo = photoService.addPhoto(photoDto);
        return photo;
    }

    @DeleteMapping("{id}")
    public void deletePhoto(@PathVariable("id") Long id) {
        photoService.deletePhoto(id);
    }
}
