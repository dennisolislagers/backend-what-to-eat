package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.NewsletterDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Newsletter;
import nl.novi.backendwhattoeat.repositories.NewsletterRepository;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsletterService {

    private NewsletterRepository newsletterRepository;

    public NewsletterService(NewsletterRepository newsletterRepository){
        this.newsletterRepository = newsletterRepository;
    }

    public List<NewsletterDto> getAllNewsletters(){
        List<Newsletter> newsletterList = newsletterRepository.findAll();
        List<NewsletterDto> newsletterDtoList = new ArrayList<>();

        for (Newsletter newsletter : newsletterList) {
            NewsletterDto dto = transferToDto(newsletter);
            newsletterDtoList.add(dto);
        }
        return newsletterDtoList;
    }
    public List<NewsletterDto> findAllNewslettersByTitle(String title) {
        List <Newsletter> newsletterList = newsletterRepository.findNewsletterByTitleEqualsIgnoreCase(title);
        List <NewsletterDto> newsletterDtoList = new ArrayList<>();

        for(Newsletter newsletter : newsletterList){
            NewsletterDto dto = transferToDto(newsletter);
            newsletterDtoList.add(dto);
        }
        return newsletterDtoList;
    }

    public NewsletterDto getNewsletterById(long id) {
        if (newsletterRepository.findById(id).isPresent()){
            Newsletter newsletter = newsletterRepository.findById(id).get();
            return transferToDto(newsletter);
        } else {
            throw new RecordNotFoundException("geen nieuwsbrief gevonden");
        }
    }

    public NewsletterDto createNewsletter(NewsletterDto dto) {
        Newsletter newsletter =  transferToNewsletter(dto);
        newsletterRepository.save(newsletter);

        return transferToDto(newsletter);
    }
    public void deleteNewsletter (@RequestBody Long id) {
        newsletterRepository.deleteById(id);
    }

    public NewsletterDto updateNewsletter(Long id, NewsletterDto newsletterDto) {

        if (newsletterRepository.findById(id).isPresent()) {

            Newsletter newsletter = newsletterRepository.findById(id).get();

            Newsletter newsletter1 = transferToNewsletter(newsletterDto);
            newsletter1.setId(newsletter.getId());

            newsletterRepository.save(newsletter1);

            return transferToDto(newsletter1);

        } else {

            throw new RecordNotFoundException("geen nieuwsbrief gevonden");

        }
    }
        public Newsletter transferToNewsletter(NewsletterDto dto){
            var newsletter = new Newsletter();

            dto.id = newsletter.getId();
            dto.title = newsletter.getTitle();
            dto.text = newsletter.getText();
            dto.postTime = newsletter.getPostTime();

            return newsletter;
        }

        public NewsletterDto transferToDto(Newsletter newsletter) {
            NewsletterDto dto = new NewsletterDto();

            newsletter.setId(dto.getId());
            newsletter.setTitle(dto.getTitle());
            newsletter.setText(dto.getText());
            newsletter.setPostTime(dto.getPostTime());

            return dto;
        }
}
