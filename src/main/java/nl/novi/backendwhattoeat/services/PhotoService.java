package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    public List<PhotoDto> getAllPhotosByFileName(String s) {
        return null;
    }

    public PhotoDto getPhotoById(Long id) {
        return null;
    }

    public PhotoDto addPhoto(PhotoDto photoDto) {
        return null;
    }

    public void deletePhoto(Long id) {
    }

    public List<PhotoDto> getAllPhotos() {
    }
}
