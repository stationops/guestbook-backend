package com.example.guestbookbackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GreetingController {





    @CrossOrigin(origins = "*")
    @GetMapping(value = "")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("greeeting");
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "greeting")
    public ResponseEntity<String> getComments(){
        return ResponseEntity.ok("greeeting");
    }
}
