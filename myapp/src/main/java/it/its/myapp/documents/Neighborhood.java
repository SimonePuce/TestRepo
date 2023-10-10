package it.its.myapp.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "neighborhoods")
public class Neighborhood {

    @Id
    private String id;
    private String name;
    private GeoJson geometry;

    public Neighborhood(String id, String name, GeoJson geometry) {
        this.id = id;
        this.name = name;
        this.geometry = geometry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoJson getGeometry() {
        return geometry;
    }

    public void setGeometry(GeoJsonPolygon geometry) {
        this.geometry = geometry;
    }
}
