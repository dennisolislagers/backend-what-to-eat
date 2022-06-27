package nl.novi.backendwhattoeat.controllers;


import nl.novi.backendwhattoeat.dtos.NewsletterDto;
import nl.novi.backendwhattoeat.services.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("newsletters")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @Autowired
    public NewsletterController (NewsletterService newsletterService){
        this.newsletterService = newsletterService;
    }

    @GetMapping
    public ResponseEntity<List<NewsletterDto>> getAllNewsletters(@RequestParam(value = "title", required = false) Optional<String> title){
        List<NewsletterDto> dtos;
        if (title.isEmpty()){
            dtos = newsletterService.getAllNewsletters();
        }else {
            dtos = newsletterService.findAllNewslettersByTitle (title.get());
        }
        return ResponseEntity.ok().body(dtos);
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

    @PutMapping("{id}")
    public ResponseEntity<Object> updateNewsletter(@PathVariable Long id, @RequestBody NewsletterDto newNewsletter) {

        NewsletterDto dto = newsletterService.updateNewsletter(id, newNewsletter);

        return ResponseEntity.ok().body(dto);
    }

}
