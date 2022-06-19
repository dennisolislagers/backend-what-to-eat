package nl.novi.backendwhattoeat.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class NewsletterDto {

    public Long id;
    public String title;
    public String text;
    public String postTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        LocalDate localDate = LocalDate.now();
        postTime = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        this.postTime = postTime;
    }
}
