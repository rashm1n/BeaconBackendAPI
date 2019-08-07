package spring.data.neo4j.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Beacon {
    @Id
    private String MAC;
    private String description;
    private String location;

//    @Relationship(type = "ADJACENT")
//    private List<Beacon> adjacentBeaconsOutgoing = new ArrayList<>();
//
//    @Relationship(type = "ADJACENT",direction = Relationship.INCOMING)
//    private List<Beacon> adjacentBeaconsIncoming = new ArrayList<>();

    @Relationship(type = "ADJACENT")
    private List<Adjacent> adjacentList = new ArrayList<>();

    public Beacon() {
    }

    public Beacon(String MAC, String description, String location) {
        this.MAC = MAC;
        this.description = description;
        this.location = location;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public void addAdjacency(Adjacent adjacent){
        if (this.adjacentList==null){
            this.adjacentList=new ArrayList<>();
        }
        this.adjacentList.add(adjacent);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
