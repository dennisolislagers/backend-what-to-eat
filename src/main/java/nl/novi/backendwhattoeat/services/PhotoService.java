package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.PhotoDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Photo;
import nl.novi.backendwhattoeat.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<PhotoDto> getAllPhotos() {
        List<PhotoDto> dtos = new ArrayList<>();
        List<Photo> photos = photoRepository.findAll();
        for (Photo ph : photos) {
            dtos.add(transferToDto(ph));
        }
        return dtos;
    }
    public PhotoDto getPhoto(long id) {
        Optional<Photo> photo = photoRepository.findById(id);
        if(photo.isPresent()) {
            return transferToDto(photo.get());
        } else {
            throw new RecordNotFoundException("No photo found");
        }
    }
    public PhotoDto addPhoto(PhotoDto photoDto) {
        Photo ph =  transferToPhoto(photoDto);
        photoRepository.save(ph);
        return photoDto;
    }
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }

    public static PhotoDto transferToDto(Photo photo){
        var dto = new PhotoDto();

        dto.id = photo.getId();
        dto.title = photo.getTitle();
        dto.fileName = photo.getFileName();
        dto.imageSize = photo.getImageSize();
        dto.dimensions = photo.getDimensions();

        return dto;
    }

    public static Photo transferToPhoto(PhotoDto dto){
        var photo = new Photo();

        photo.setId(dto.getId());
        photo.setTitle(dto.getTitle());
        photo.setFileName(dto.getFileName());
        photo.setImageSize(dto.getImageSize());
        photo.setDimensions(dto.getDimensions());

        return photo;
    }

}
