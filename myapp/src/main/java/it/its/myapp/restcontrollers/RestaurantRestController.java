package it.its.myapp.restcontrollers;

import it.its.myapp.documents.Restaurant;
import it.its.myapp.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController {
    @Autowired
    RestaurantRepository repo;

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        return repo.findAll();
    }
}
