package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.CommentDto;
import nl.novi.backendwhattoeat.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDto> getAllComments() {

        List<CommentDto> comments = commentService.getAllComments();

        return comments;
    }

    @GetMapping("{id}")
    public CommentDto getCommentById(@PathVariable("id") Long id) {

        CommentDto comment = commentService.getCommentById(id);

        return comment;

    }

    @PostMapping
    public CommentDto createComment(@RequestBody CommentDto commentDto){

        CommentDto comment = commentService.createComment(commentDto);

        return comment;

    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
    }

    @PutMapping("{id}")
    public CommentDto updateComment(@PathVariable("id") Long id, @RequestBody CommentDto commentDto){
        commentService.updateComment(id, commentDto);
        return commentDto;
    }
}
