package spring.data.neo4j.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.model.Busyness;
import spring.data.neo4j.model.IniBeacon;
import spring.data.neo4j.services.AdjacentService;
import spring.data.neo4j.services.BeaconService;
import spring.data.neo4j.services.InitialBeaconService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BeaconController {

    private final BeaconService beaconService;
    private final AdjacentService adjacentService;
    private final InitialBeaconService initialBeaconService;

    public BeaconController(BeaconService beaconService, AdjacentService adjacentService, InitialBeaconService initialBeaconService) {
        this.beaconService = beaconService;
        this.adjacentService = adjacentService;
        this.initialBeaconService = initialBeaconService;
    }

//    @GetMapping("/test")
//    public UserQueryResult getB(){
//        return beaconService.findBeacon();
//    }

    @ApiOperation(value = "Returns all Initialization Beacons in The Beacon Database",
    notes = "This is called when a user is entered to a building to determine if he is in a building which has implmented our system")
    @GetMapping("/getAllInitial")
    public List<IniBeacon> getAllInitializatioBeacons()
    {
        return initialBeaconService.getIniBeacons();
    }

    @ApiOperation(value = "Returns the busyness of a given building")
    @GetMapping("/getBusyness")
    public Busyness getBusyness()
    {
        return initialBeaconService.getBusyness();
    }

    @ApiOperation(value = "Returns all Destinations in a given building")
    @GetMapping("/getDestinations")
    public List<Beacon> getDestinations(){
        return beaconService.getDestinations();
    }

    @ApiOperation(value = "Returns the shortest path between given two MAC addresses")
    @GetMapping("/calculatePath")
    public Iterable<Map<String, Object>> getShortestPath(@RequestParam String s,@RequestParam String d){
        return beaconService.findS(s,d);
    }

//    @GetMapping("/test3")
//    public List<Adjacent> getR(){
//        return beaconService.findAdj();
//    }
//
//    @GetMapping("/test4")
//    public Adjacent getRR(){
//        return adjacentService.findAdjj();
//    }
}
