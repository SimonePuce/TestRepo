package it.its.myapp.restcontrollers;

import it.its.myapp.documents.Neighborhood;
import it.its.myapp.documents.Restaurant;
import it.its.myapp.exceptions.RestaurantNotFoundException;
import it.its.myapp.repositories.NeighborhoodRepository;
import it.its.myapp.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController {
    @Autowired
    RestaurantRepository repo;
    @Autowired
    NeighborhoodRepository repoVicinati;

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Restaurant getById(@PathVariable String id) throws RestaurantNotFoundException {
        return repo.findById(id).orElseThrow(()-> new RestaurantNotFoundException());
    }

    @GetMapping(value = "/getByName/{name}")
    public List<Restaurant> getByName(@PathVariable String name){
        return repo.findByName(name);
    }

    @GetMapping(value = "/getByNameLike/{name}")
    public List<Restaurant> getByNameLike(@PathVariable String name){
        return repo.findByNameLike(name);
    }

    @GetMapping(value="/getRistorantiInZona/{name}")
    public List<Restaurant> ristorantiInZona(@PathVariable String name) throws RestaurantNotFoundException{
        List<Neighborhood> neighborhoods = repoVicinati.findByName(name);
        Neighborhood checkZone = neighborhoods.get(0);
        GeoJson coordinate = checkZone.getGeometry();
        return repo.ristorantiInZona(coordinate);
    }
}
