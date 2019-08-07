package spring.data.neo4j.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ADJACENT")
public class Adjacent {
    @Id
    @GeneratedValue
    private Long id;

    private Double angle;
    private Double cost;

    @StartNode
    private Beacon startBeacon;

    @EndNode
    private Beacon endBeacon;

    public Adjacent() {
    }

    public Adjacent(Double angle, Double cost, Beacon startBeacon, Beacon endBeacon) {
        this.angle = angle;
        this.cost = cost;
        this.startBeacon = startBeacon;
        this.endBeacon = endBeacon;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
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
}
