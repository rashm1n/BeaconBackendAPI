package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;

import java.util.List;

public interface BeaconRepository extends Neo4jRepository<Beacon,String> {

    @Query("match (b:Beacon{MAC:\"f:f:f:f\"})-[a:ADJACENT]-(c:Beacon{MAC:\"f:f:f:f\") return b, c")
    Beacon findaBeacon();

    @Query("match (b:Beacon)-[a:ADJACENT]-(c:Beacon) where b.MAC=\"f:f:f:f\" return b, c")
    List<Beacon> findaBeacons();

    @Query("match (b:Beacon)-[a]->(c:Beacon) where c.MAC=\"f:f:f:f\" return a")
    List<Adjacent> findaRelationship();

    @QueryResult
    public class UserQueryResult{
        Beacon b;
        String s;
        int i;
    }

    @Query("MATCH (start:Beacon{MAC:\"b:b:b:b\"}), (end:Beacon{MAC:\"r:r:r:r\"})\n" +
            "CALL algo.shortestPath.stream(start, end, \"cost\")\n" +
            "YIELD nodeId, cost\n" +
            "MATCH (other:Beacon) WHERE id(other) = nodeId\n" +
            "RETURN *")
    List<Beacon> findashortest();


}
