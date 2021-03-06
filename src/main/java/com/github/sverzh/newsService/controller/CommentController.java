package com.github.sverzh.newsService.controller;

import com.github.sverzh.newsService.model.Comment;
import com.github.sverzh.newsService.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/news/")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{newsId}/comments")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long newsId) {
        List<Comment> result = commentService.getAllCommentsByNewsId(newsId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{newsId}/comments/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId, @PathVariable Long newsId) {
        Comment result = commentService.getComment(commentId, newsId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{newsId}/comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, @PathVariable Long newsId) {
        Comment result = commentService.createComment(comment, newsId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{newsId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @PathVariable Long newsId, @RequestBody Comment source) {
        Comment result = commentService.updateComment(source,commentId,newsId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{newsId}/comments/{commentId}")
    public ResponseEntity<String> deleteNews(@PathVariable Long commentId,  @PathVariable Long newsId){
        return new ResponseEntity<>(commentService.deleteComment(commentId, newsId), HttpStatus.OK);
    }
}

