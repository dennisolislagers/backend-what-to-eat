package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.CommentDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Comment;
import nl.novi.backendwhattoeat.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDto> getAllComments(){
        List<CommentDto> dtos = new ArrayList<>();
        List<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            dtos.add(transferToDto(comment));
        }
        return dtos;
    }

    public List<CommentDto> getAllCommentsByTitle(String title) {
        Optional<Comment> comment = commentRepository.findCommentByTitleEqualsIgnoreCase(title);
        if(comment.isPresent()) {
            return (List<CommentDto>) transferToDto(comment.get());
        } else {
            throw new RecordNotFoundException("No comment with title" + title + " found");
        }
    }

    public CommentDto createComment(CommentDto commentDto) {
        Comment comment =  transferToComment(commentDto);
        commentRepository.save(comment);
        return commentDto;
    }


    public CommentDto getCommentById(long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            return transferToDto(comment.get());
        } else {
            throw new RecordNotFoundException("No comments found");
        }
    }

    public void deleteComment (Long id) {
        commentRepository.deleteById(id);
    }

    public void updateComment(Long id, CommentDto commentDto) {
        if(!commentRepository.existsById(id)) {
            throw new RecordNotFoundException("No comments found");
        }
        Comment savedComment = commentRepository.findById(id).orElse(null);
        savedComment.setId(commentDto.getId());
        savedComment.setTitle(commentDto.getTitle());
        savedComment.setText(commentDto.getText());
        savedComment.setPostTime(commentDto.getPostTime());
        commentRepository.save(savedComment);
    }

    public CommentDto transferToDto(Comment comment) {
        var dto = new CommentDto();

        dto.id = comment.getId();
        dto.title = comment.getTitle();
        dto.text = comment.getText();
        dto.postTime = comment.getPostTime();

        return dto;
    }

    public Comment transferToComment(CommentDto dto){
        var comment = new Comment();

        comment.setId(dto.getId());
        comment.setTitle(dto.getTitle());
        comment.setText(dto.getText());
        comment.setPostTime(dto.getPostTime());


        return comment;
    }

}