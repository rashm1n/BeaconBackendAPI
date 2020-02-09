package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import spring.data.neo4j.model.IniBeacon;

import java.util.List;

public interface IniBeaconRepository extends Neo4jRepository<IniBeacon,String> {
    @Query("MATCH (n:IniBeacon) return n")
    List<IniBeacon> initialBeaconList();


    //create a initialization beacon
    @Query("CREATE (n:IniBeacon { MAC: {0}, description: {1}}) RETURN n")
    IniBeacon createIniBeacon(String MAC, String description);
}
