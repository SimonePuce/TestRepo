package it.its.myapp.repositories;


import it.its.myapp.documents.Neighborhood;
import it.its.myapp.documents.Restaurant;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository <Restaurant, String> {
    public List<Restaurant> findByName(String name);

    @Query("{'name':/?0/i}")
    public List<Restaurant> findByNameLike(String name);
    public List<Restaurant> ristorantiInZona(Neighborhood neighborhood);
}
