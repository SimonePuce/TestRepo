package it.its.myapp.repositories;


import it.its.myapp.documents.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository <Restaurant, String> {
    public List<Restaurant> findByName(String name);
}
