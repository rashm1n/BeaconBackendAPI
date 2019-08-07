package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import spring.data.neo4j.model.Beacon;

public interface BeaconRepository extends Neo4jRepository<Beacon,String> {

    @Query("MATCH (b:Beacon) WHERE b.MAC=\"b:b:b:b\" RETURN b")
    Beacon findaBeacon();

}
