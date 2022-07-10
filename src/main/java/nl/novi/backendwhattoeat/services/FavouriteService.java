package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.controllers.FavouriteController;
import nl.novi.backendwhattoeat.dtos.FavouriteDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Favourite;
import nl.novi.backendwhattoeat.repositories.FavouriteRepository;
import nl.novi.backendwhattoeat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavouriteService {


    private final FavouriteRepository favouriteRepository;
    private final UserRepository userRepository;

    public FavouriteService(FavouriteRepository favouriteRepository,
                            UserRepository userRepository
    ){
        this.favouriteRepository = favouriteRepository;
        this.userRepository = userRepository;
    }

    public List<FavouriteDto> getAllFavourites(){
        List<FavouriteDto> dtos = new ArrayList<>();
        List<Favourite> favourites = favouriteRepository.findAll();
        for (Favourite favourite : favourites) {
           dtos.add(transferToDto(favourite));
        }
        return dtos;
    }

    public FavouriteDto getFavouriteById(long id) {
        Optional<Favourite> favourite = favouriteRepository.findById(id);
        if (favourite.isPresent()){
            return transferToDto(favourite.get());
        } else {
            throw new RecordNotFoundException("geen favoriet gevonden");
        }
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

    public FavouriteDto createFavourite(FavouriteDto dto) {
        Favourite favourite =  transferToFavourite(dto);
        favouriteRepository.save(favourite);

        return dto;
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

    public FavouriteDto transferToDto(Favourite favourite) {
        var dto = new FavouriteDto();

        dto.id = favourite.getId();
        dto.title = favourite.getTitle();
        dto.text = favourite.getText();
        dto.rating = favourite.getRating();

        return dto;
    }

    public Favourite transferToFavourite(FavouriteDto dto){
        var favourite = new Favourite();

        favourite.setId(dto.getId());
        favourite.setTitle(dto.getTitle());
        favourite.setText(dto.getText());
        favourite.setRating(dto.getRating());

        return favourite;
    }



}