package spring.data.neo4j.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class IniBeacon {
    @Id
    private String MAC;
    private String description;

    @Relationship(type = "ADJACENT")
    private List<Adjacent> adjacentList = new ArrayList<>();

    @Relationship(type = "HAS")
    private Busyness busyness;

    public IniBeacon() {
    }

    public IniBeacon(String MAC, String description, List<Adjacent> adjacentList, Busyness busyness) {
        this.MAC = MAC;
        this.description = description;
        this.adjacentList = adjacentList;
        this.busyness = busyness;
    }

    public IniBeacon(String MAC, String description, List<Adjacent> adjacentList) {
        this.MAC = MAC;
        this.description = description;
        this.adjacentList = adjacentList;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Adjacent> getAdjacentList() {
        return adjacentList;
    }

    public void setAdjacentList(List<Adjacent> adjacentList) {
        this.adjacentList = adjacentList;
    }

    public void addBeacon(Adjacent adjacent){
        if (this.adjacentList==null){
            this.adjacentList = new ArrayList<>();
        }

        this.adjacentList.add(adjacent);
    }
}
