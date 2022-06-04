package com.yasemindmrts.odev1.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

    List<UserComment> comments = new ArrayList<>();

    @GetMapping("/comments")
    public ResponseEntity<List<UserComment>> findAllComment() {
        User user = new User(1L,"Yasemin", "Demirtas", "ysmdmr@gmail","54363252", new Date(), true);
        UserComment userComment = new UserComment(1,"thats nice", new Date(), 23, user);

        comments.add(userComment);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/comments/save")
    public ResponseEntity<UserComment> saveComment(@RequestBody UserComment userComment){
        comments.add(userComment);
        return ResponseEntity.ok(userComment);
    }

    @PostMapping("/comments/delete")
    public ResponseEntity<UserComment> deleteComment(@RequestParam Long id){
        for(UserComment userComment: comments){
            if(userComment.getId() == id) {
                comments.remove(userComment);
                return ResponseEntity.ok(userComment);
            }
        }

        return ResponseEntity.ok(null);
    }

    @PostMapping("/comments/update")
    public ResponseEntity<UserComment> updateComment(@RequestParam long id, @RequestParam String comment) {
        for(UserComment userComment: comments){
            if(userComment.getId() == id) {
                userComment.setComment(comment);
                return ResponseEntity.ok(userComment);
            }
        }
        return ResponseEntity.ok(null);
    }
}
