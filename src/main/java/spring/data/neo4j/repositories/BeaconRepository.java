package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;

import java.util.List;
import java.util.Map;

public interface BeaconRepository extends Neo4jRepository<Beacon,String> {

    @Query("match (b:Beacon{MAC:\"f:f:f:f\"})-[a:ADJACENT]-(c:Beacon{MAC:\"f:f:f:f\") return b, c")
    Beacon findaBeacon();

    @Query("match (b:Beacon)-[a:ADJACENT]-(c:Beacon) where b.MAC=\"f:f:f:f\" return b, c")
    List<Beacon> findaBeacons();

    @Query("match (b:Beacon)-[a]->(c:Beacon) where c.MAC=\"f:f:f:f\" return a")
    List<Adjacent> findaRelationship();

    @Query("MATCH (start:Beacon{MAC:{0}}),(end:Beacon{MAC:{1}})\n" +
            "CALL algo.shortestPath.stream(start, end, \"cost\")\n" +
            "YIELD nodeId, cost\n" +
            "MATCH (other:Beacon) WHERE id(other) = nodeId\n" +
            "RETURN cost,other")
    Iterable<Map<String, Object>> findashortest(String mac1,String mac2);

    @Query("match (b:Beacon:Endpoint) return b")
    List<Beacon> getAllDestinations();
}
