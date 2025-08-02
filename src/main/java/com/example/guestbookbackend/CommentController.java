package com.example.guestbookbackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final MySQLCommentDao mySQLCommentDao;

    @Value("${spring.datasource.url}")
    private String dbHost;

    public CommentController(MySQLCommentDao mySQLCommentDao) {
        this.mySQLCommentDao = mySQLCommentDao;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "")
    public ResponseEntity<String> saveComment(@RequestBody SaveComment saveComment){
        System.out.println(saveComment.getComment());
        Comment comment = new Comment(saveComment.getComment());
        mySQLCommentDao.save(comment);
        return ResponseEntity.ok("Saved");
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "")
    public ResponseEntity<Iterable<Comment>> getComments(){
        var comments = mySQLCommentDao.getComments();
        return ResponseEntity.ok(comments);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "hi")
    public ResponseEntity<String> getHi(){
        return ResponseEntity.ok(dbHost);
    }

    // ✅ New method to get comments by user (currently unsupported)
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/user/{username}")
    public ResponseEntity<Iterable<Comment>> getCommentsByUser(@PathVariable String username){
        throw new UnsupportedOperationException("Fetching comments by user is not implemented yet.");
    }
}
