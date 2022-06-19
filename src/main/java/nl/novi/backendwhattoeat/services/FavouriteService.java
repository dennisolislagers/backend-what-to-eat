package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.FavouriteDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Favourite;
import nl.novi.backendwhattoeat.repositories.FavouriteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteService {

    private FavouriteRepository favouriteRepository;

    public FavouriteService(FavouriteRepository favouriteRepository){
        this.favouriteRepository = favouriteRepository;
    }

    public List<FavouriteDto> getAllFavourites(){
        List<Favourite> favouriteList = favouriteRepository.findAll();
        List<FavouriteDto> favouriteDtoList = new ArrayList<>();

        for (Favourite favourite : favouriteList) {
            FavouriteDto dto = transferToDto(favourite);
            favouriteDtoList.add(dto);
        }
        return favouriteDtoList;
    }

    public List<FavouriteDto> findAllFavouritesByTitle(String title) {
        List <Favourite> favouriteList = favouriteRepository.findFavouriteByTitleEqualsIgnoreCase(title);
        List <FavouriteDto> favouriteDtoList = new ArrayList<>();

      for(Favourite favourite : favouriteList){
          FavouriteDto dto = transferToDto(favourite);
          favouriteDtoList.add(dto);
      }
      return favouriteDtoList;
    }

    public FavouriteDto getFavouriteById(long id) {
        if (favouriteRepository.findById(id).isPresent()){
            Favourite favourite = favouriteRepository.findById(id).get();
            return transferToDto(favourite);
        } else {
            throw new RecordNotFoundException("geen favoriet gevonden");
        }
    }

    public FavouriteDto createFavourite(FavouriteDto dto) {
        Favourite favourite =  transferToFavourite(dto);
        favouriteRepository.save(favourite);

        return transferToDto(favourite);
    }

    public void deleteFavourite (@RequestBody Long id) {
        favouriteRepository.deleteById(id);
    }

    public FavouriteDto updateFavourite(Long id, FavouriteDto favouriteDto) {

        if (favouriteRepository.findById(id).isPresent()){

            Favourite favourite = favouriteRepository.findById(id).get();

            Favourite favourite1 = transferToFavourite(favouriteDto);
            favourite1.setId(favourite.getId());

            favouriteRepository.save(favourite1);

            return transferToDto(favourite1);

        } else {

            throw new  RecordNotFoundException("geen favoriet gevonden");

        }
        }

    public Favourite transferToFavourite(FavouriteDto dto){
        var favourite = new Favourite();

        dto.id = favourite.getId();
        dto.title = favourite.getTitle();
        dto.text = favourite.getText();
        dto.rating = favourite.getRating();

        return favourite;
    }

    public FavouriteDto transferToDto(Favourite favourite) {
        FavouriteDto dto = new FavouriteDto();

        favourite.setId(dto.getId());
        favourite.setTitle(dto.getTitle());
        favourite.setText(dto.getText());
        favourite.setRating(dto.getRating());

        return dto;
    }
}