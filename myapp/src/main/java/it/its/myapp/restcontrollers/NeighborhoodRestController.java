package it.its.myapp.restcontrollers;

import it.its.myapp.documents.Neighborhood;

import it.its.myapp.documents.Restaurant;
import it.its.myapp.exceptions.NeighborhoodNotFoundException;
import it.its.myapp.exceptions.RestaurantNotFoundException;
import it.its.myapp.repositories.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/neighborhood")
public class NeighborhoodRestController {

    @Autowired
    NeighborhoodRepository repo;

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Neighborhood> getAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Neighborhood getById(@PathVariable String id) throws NeighborhoodNotFoundException {
        return repo.findById(id).orElseThrow(()-> new NeighborhoodNotFoundException());
    }

    @GetMapping(value = "/getByName/{name}")
    public List<Neighborhood> getByName(@PathVariable String name){
        return repo.findByName(name);
    }
}
