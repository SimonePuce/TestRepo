package it.its.myapp.repositories;


import it.its.myapp.documents.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository <Restaurant, ObjectId> {
}