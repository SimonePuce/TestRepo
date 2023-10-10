package it.its.myapp.repositories;

import it.its.myapp.documents.Neighborhood;
import it.its.myapp.documents.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeighborhoodRepository extends MongoRepository<Neighborhood, String> {

    public List<Neighborhood> findByName(String name);

    @Query("{'name':/?0/i}")
    public List<Neighborhood> findByNameLike(String name);

}
