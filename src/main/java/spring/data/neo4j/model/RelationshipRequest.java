package spring.data.neo4j.model;

public class RelationshipRequest {
    String startMac;
    String endMac;
    int angle;
    int cost;

    public RelationshipRequest(String startMac, String endMac, int angle, int cost) {
        this.startMac = startMac;
        this.endMac = endMac;
        this.angle = angle;
        this.cost = cost;
    }

    public RelationshipRequest() {
    }

    public String getStartMac() {
        return startMac;
    }

    public void setStartMac(String startMac) {
        this.startMac = startMac;
    }

    public String getEndMac() {
        return endMac;
    }

    public void setEndMac(String endMac) {
        this.endMac = endMac;
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
}
