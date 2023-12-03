package ssf.iss.nus.day16pm.controllers;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path="/api/task", produces="")
public class TaskController {
    
    @PostMapping(consumes="")
    public ResponseEntity<String> getTaskAsJSON() {
        JsonObject resp = Json.createObjectBuilder()
            .add("id", UUID.randomUUID().toString())
            .add("createTime", (new Date().getTime()))
            .build();

        return ResponseEntity.ok(resp.toString());
    }

 
}  
