package spring.data.neo4j.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ADJACENT_TO")
public class Adjacent {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "angle")
    private int angle;

    @Property(name = "cost")
    private int cost;

    @StartNode
    private Beacon startBeacon;

    @EndNode
    private Beacon endBeacon;

    public Adjacent() {
    }

    public Adjacent(int angle, int cost, Beacon startBeacon, Beacon endBeacon) {
        this.angle = angle;
        this.cost = cost;
        this.startBeacon = startBeacon;
        this.endBeacon = endBeacon;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Beacon getStartBeacon() {
        return startBeacon;
    }

    public void setStartBeacon(Beacon startBeacon) {
        this.startBeacon = startBeacon;
    }

    public Beacon getEndBeacon() {
        return endBeacon;
    }

    public void setEndBeacon(Beacon endBeacon) {
        this.endBeacon = endBeacon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
