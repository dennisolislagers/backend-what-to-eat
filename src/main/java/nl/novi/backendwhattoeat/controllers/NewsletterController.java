package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.NewsletterDto;
import nl.novi.backendwhattoeat.services.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("newsletters")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @Autowired
    public NewsletterController (NewsletterService newsletterService){
        this.newsletterService = newsletterService;
    }

    @GetMapping
    public List<NewsletterDto> getAllNewsletters() {

        List<NewsletterDto> dtos = newsletterService.getAllNewsletters();

        return dtos;
    }
    @GetMapping("{id}")
    public ResponseEntity<NewsletterDto> getNewsletterById(@PathVariable("id") Long id) {

        NewsletterDto newsletter = newsletterService.getNewsletterById(id);

        return ResponseEntity.ok().body(newsletter);

    }

    @PostMapping
    public ResponseEntity<NewsletterDto> createNewsletter(@RequestBody NewsletterDto newsletterDto){

        NewsletterDto newsletter = newsletterService.createNewsletter(newsletterDto);

        final URI location = URI.create("/newsletters/" + newsletter.getId());
        return ResponseEntity.created(location).body(newsletter);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNewsletter(@PathVariable("id") Long id){
        newsletterService.deleteNewsletter(id);

        return ResponseEntity.noContent().build();
    }

}


