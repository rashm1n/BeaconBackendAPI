package spring.data.neo4j.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import spring.data.neo4j.model.Adjacent;

public interface AdjacentRepository extends Neo4jRepository<Adjacent,Long> {
//    @Query("match (b:Beacon{MAC:\"f:f:f:f\"})-[a:ADJACENT]-(c:Beacon{MAC:\"r:r:r:r\"}) return *")
//    Adjacent findaRelationshipp();

    @Query("MATCH (start:Beacon{MAC:\"b:b:b:b\"}), (end:Beacon{MAC:\"r:r:r:r\"})\n" +
            "CALL algo.shortestPath.stream(start, end, \"cost\")\n" +
            "YIELD nodeId, cost\n" +
            "MATCH (other:Beacon) WHERE id(other) = nodeId\n" +
            "RETURN *")
    Adjacent findaRelationshipp();
}
