package spring.data.neo4j.model;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Beacon {
    @Id @GeneratedValue
    private Long id;

    @Property(name = "MAC")
    private String MAC;
    private String endMsg;
    private String juncMsg;
    private String staircase;
    private int isStaircase;
    private float meanNormalize1;
    private float meanNormalize2;
    private float stdNormalize1;
    private float stdNormalize2;
    private String location;



    public Beacon(String MAC, String endMsg, String juncMsg, String staircase, int isStaircase, float meanNormalize1, float meanNormalize2, float stdNormalize1, float stdNormalize2, String location) {
        this.MAC = MAC;
        this.endMsg = endMsg;
        this.juncMsg = juncMsg;
        this.staircase = staircase;
        this.isStaircase = isStaircase;
        this.meanNormalize1 = meanNormalize1;
        this.meanNormalize2 = meanNormalize2;
        this.stdNormalize1 = stdNormalize1;
        this.stdNormalize2 = stdNormalize2;
        this.location = location;
    }

    public float getMeanNormalize1() {
        return meanNormalize1;
    }

    public void setMeanNormalize1(float meanNormalize1) {
        this.meanNormalize1 = meanNormalize1;
    }

    public float getMeanNormalize2() {
        return meanNormalize2;
    }

    public void setMeanNormalize2(float meanNormalize2) {
        this.meanNormalize2 = meanNormalize2;
    }

    public float getStdNormalize1() {
        return stdNormalize1;
    }

    public void setStdNormalize1(float stdNormalize1) {
        this.stdNormalize1 = stdNormalize1;
    }

    public float getStdNormalize2() {
        return stdNormalize2;
    }

    public void setStdNormalize2(float stdNormalize2) {
        this.stdNormalize2 = stdNormalize2;
    }

    public Beacon(String MAC, String endMsg, String juncMsg, String staircase, int isStaircase, String location) {
        this.MAC = MAC;
        this.endMsg = endMsg;
        this.juncMsg = juncMsg;
        this.staircase = staircase;
        this.isStaircase = isStaircase;
        this.location = location;
    }

    public String getEndMsg() {
        return endMsg;
    }

    public void setEndMsg(String endMsg) {
        this.endMsg = endMsg;
    }

    public String getJuncMsg() {
        return juncMsg;
    }

    public void setJuncMsg(String juncMsg) {
        this.juncMsg = juncMsg;
    }

    public String getStaircase() {
        return staircase;
    }

    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    public int getIsStaircase() {
        return isStaircase;
    }

    public void setIsStaircase(int isStaircase) {
        this.isStaircase = isStaircase;
    }

    public Beacon(Long id, String MAC, String endMsg, String juncMsg, String staircase, int isStaircase, String location, List<Adjacent> adjacentList) {
        this.id = id;
        this.MAC = MAC;
        this.endMsg = endMsg;
        this.juncMsg = juncMsg;
        this.staircase = staircase;
        this.isStaircase = isStaircase;
        this.location = location;
        this.adjacentList = adjacentList;
    }



    public void setAdjacentList(List<Adjacent> adjacentList) {
        this.adjacentList = adjacentList;
    }

    //    @Relationship(type = "ADJACENT")
//    private List<Beacon> adjacentBeaconsOutgoing = new ArrayList<>();
//
//    @Relationship(type = "ADJACENT",direction = Relationship.INCOMING)
//    private List<Beacon> adjacentBeaconsIncoming = new ArrayList<>();

    @Relationship(type = "ADJACENT")
    private List<Adjacent> adjacentList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public Beacon() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
