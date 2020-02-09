package spring.data.neo4j.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.data.neo4j.model.*;
import spring.data.neo4j.services.AdjacentService;
import spring.data.neo4j.services.BeaconService;
import spring.data.neo4j.services.InitialBeaconService;

import java.util.ArrayList;
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
        //emailService.sendMail("hashmdesilva@gmail.com", "Test subject", "Test mail");
        return initialBeaconService.getIniBeacons();
    }


    @ApiOperation(value = "Creates a new Initialization Node")
    @GetMapping("/createIniBeacon")
    public IniBeacon createIniBeacon(@RequestParam String MAC, @RequestParam String description){
        return initialBeaconService.createIniBeacon(MAC, description);
    }

    @ApiOperation(value = "Creates a new Beacon Node")
    @GetMapping("/createBeacon")
    public Beacon createBeacon(@RequestParam String MAC, @RequestParam String description, @RequestParam String location){
        return beaconService.createBeacon(MAC, description, location);
    }

    @ApiOperation(value = "Creates a new Beacon Node")
    @PostMapping("/createBeacons")
    public ResponseEntity<List<BeaconRequestModel>> createBeacons(@RequestBody List<BeaconRequestModel> beacons){
        List<Beacon> beaconList = new ArrayList<>();
        for (BeaconRequestModel b:beacons){
            Beacon beacon = new Beacon();
            beacon.setMAC(b.getMac());
            System.out.println(b.getMac());
            beacon.setDescription(b.getDescription());
            beacon.setLocation(b.getLocation());
            beacon.setAdjacentList(new ArrayList<>());
            beaconList.add(beacon);
        }
        beaconService.createBeacons(beaconList);
        return ResponseEntity.ok(beacons);
    }


    @ApiOperation(value = "Create a Relationship between two nodes")
    @GetMapping("/createRel")
    public Adjacent createRel(@RequestParam String m1, @RequestParam String m2, @RequestParam int a,@RequestParam int c){
        return adjacentService.createRel(m1, m2, a, c);
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

    @GetMapping("/getBeacon")
    public Beacon getBeacon(@RequestParam String m){
        return beaconService.getBeacon(m);
    }

    @GetMapping("/findBeacon")
    public Beacon findBeacon(@RequestParam String m){
        return beaconService.findBeacon(m);
    }

    @GetMapping("/getRel")
    public Adjacent findRel(@RequestParam String m1,@RequestParam String m2)
    {
        Adjacent adjacent = beaconService.findAdj(m1, m2);
        System.out.println(adjacent.getAngle());
        return adjacent;
    }

    @GetMapping("/getIniRel")
    public InitialRel findIniRel(@RequestParam String m1, @RequestParam String m2)
    {
        //        System.out.println(adjacent.getAngle());
        return beaconService.findIniAdj(m1, m2);
    }

    @PostMapping("/cb")
    public IniBeacon cb(@RequestBody IniBeacon iniBeacon){
        System.out.println(iniBeacon.getMAC());
        return initialBeaconService.cb(iniBeacon);
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
