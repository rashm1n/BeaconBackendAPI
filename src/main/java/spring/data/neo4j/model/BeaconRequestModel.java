package spring.data.neo4j.model;

public class BeaconRequestModel {
    String description;
    String mac;
    String location;

    public BeaconRequestModel() {
    }

    public BeaconRequestModel(String description, String mac, String location) {
        this.description = description;
        this.mac = mac;
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
