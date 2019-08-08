package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import spring.data.neo4j.model.Busyness;
import spring.data.neo4j.model.IniBeacon;

import java.util.List;
import java.util.Map;

public interface IniBeaconRepository extends Neo4jRepository<IniBeacon,String> {
    @Query("MATCH (n:IniBeacon) return n")
    List<IniBeacon> initialBeaconList();

    @Query("MATCH (n:IniBeacon)-[:HAS]->(b) return b")
    Busyness business();
}
