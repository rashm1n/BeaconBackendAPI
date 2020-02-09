package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import spring.data.neo4j.model.*;

import java.util.List;
import java.util.Map;

public interface BeaconRepository extends Neo4jRepository<Beacon,String> {

    @Query("CREATE (n:Beacon { MAC: {0}, description: {1}, location: {3}}) RETURN n")
    Beacon createBeacon(String MAC, String description, String location);

    @Query("match (b:Beacon{MAC:{0}}) return b")
    Beacon findaBeacon(String m);


    Beacon findByMAC(@Param("MAC") String MAC);

    @Query("match (b:Beacon)-[a:ADJACENT]-(c:Beacon) where b.MAC=\"f:f:f:f\" return b, c")
    List<Beacon> findaBeacons();

    @Query("MATCH (b:Beacon{MAC:{0}})-[a:ADJACENT]->(c:Beacon{MAC:{1}}) return *")
    Adjacent findaRelationship(String m1,String m2);

    @Query("MATCH (b:IniBeacon{MAC:{0}})-[a:INITIAL_REL]->(c:Beacon{MAC:{1}}) return *")
    InitialRel findaIniRelationship(String m1, String m2);

    @Query("MATCH (start:IniBeacon{MAC:{0}}),(end:Beacon{MAC:{1}})\n" +
            "CALL algo.shortestPath.stream(start, end, \"cost\")\n" +
            "YIELD nodeId, cost\n" +
            "MATCH (other:Beacon) WHERE id(other) = nodeId\n" +
            "RETURN cost,other")
    Iterable<Map<String, Object>> findashortest(String mac1,String mac2);

//    MATCH (start:IniBeacon{MAC:"C2:B6:6E:70:FA:F7"}), (end:Beacon{MAC:"e:r:e:r"})
//    CALL algo.shortestPath.stream(start, end, "cost")
//    YIELD nodeId, cost
//    MATCH (other:Beacon) WHERE id(other) = nodeId
//    RETURN other.MAC AS name, cost



    @Query("match (b:Beacon:Endpoint) return b") //b:Beacon:Endpoint
    List<Beacon> getAllDestinations();

}
