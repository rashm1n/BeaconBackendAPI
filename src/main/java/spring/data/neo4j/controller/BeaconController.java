package spring.data.neo4j.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.text.WordUtils;
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
//            beacon.setDescription(b.getDescription());
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

    @ApiOperation(value = "create multiple relationships")
    @PostMapping("/createRels")
    public List<RelationshipRequest> createRels(@RequestBody List<RelationshipRequest> relationshipRequests){
        for (RelationshipRequest r:relationshipRequests){
            adjacentService.createRel(r.getStartMac(),r.getEndMac(),r.getAngle(),r.getCost());
        }

        return relationshipRequests;
    }

    @ApiOperation(value = "create multiple initial relationships")
    @PostMapping("/createInitialRels")
    public List<RelationshipRequest> createInitialRels(@RequestBody List<RelationshipRequest> relationshipRequests){
        for (RelationshipRequest r:relationshipRequests){
            adjacentService.createInitialRel(r.getStartMac(),r.getEndMac(),r.getAngle(),r.getCost());
        }
        return relationshipRequests;
    }

    @ApiOperation(value = "Returns all Destinations in a given building")
    @GetMapping("/getDestinations")
    public List<Beacon> getDestinations(){
        return beaconService.getDestinations();
    }


    @ApiOperation(value = "Returns the shortest path between given two locations")
    @GetMapping("/calculateP")
    public Iterable<Map<String, Object>> getShortestP(@RequestParam String s,@RequestParam String d) {
        return beaconService.findS(s, d);
    }

    @ApiOperation(value = "Returns the shortest path between given two locations")
    @GetMapping("/calculatePath")
    public List<ModelBeaconPathRequest> getShortestPath(@RequestParam String s,@RequestParam String d){
        final char[] delimiters = { ' ', '_' };

        Iterable<Map<String, Object>> mm = beaconService.findS(s,WordUtils.capitalizeFully(d,delimiters));

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(s);


        List<String> result = new ArrayList<String>();
        List<Beacon> beaconList = new ArrayList<>();

        List<ModelBeaconPathRequest> finalList = new ArrayList<>();
        System.out.println(mm);

        for (Map<String, Object> str : mm) {
            Beacon b = (Beacon)str.get("other");
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa"+b.getLocation());
            beaconList.add(b);
            stringArrayList.add(b.getMAC());
//            if (b.getStaricase()!=null){
//                JSONObject jsonObject = new JSONObject(b.getStaricase());
//                System.out.println(jsonObject.getString("msg"));
//            }
        }

        for (Beacon b:beaconList){
            System.out.println(b.getMAC());
        }



        InitialRel initialRel = beaconService.findIniAdj(s,WordUtils.capitalizeFully(beaconList.get(0).getLocation(),delimiters));
        Gson g = new Gson();
        Staircase p = null;
        if (!beaconList.get(0).getStaircase().isEmpty()) {
            p = g.fromJson(beaconList.get(0).getStaircase(), Staircase.class);
        }

        ModelBeaconPathRequest first = new ModelBeaconPathRequest(beaconList.get(0).getMAC(),beaconList.get(0).getEndMsg(),beaconList.get(0).getJuncMsg(),initialRel.getAngle(),p,beaconList.get(0).getIsStaircase(),beaconList.get(0).getMeanNormalize1(),beaconList.get(0).getMeanNormalize2(),beaconList.get(0).getStdNormalize1(),beaconList.get(0).getStdNormalize2(),beaconList.get(0).getLocation());
        finalList.add(first);

        for (int i=0;i<beaconList.size();i++){
            if (i+1<beaconList.size()){
                Beacon b = beaconList.get(i+1);
                Adjacent rel = beaconService.findAdj(WordUtils.capitalizeFully(beaconList.get(i).getLocation(),delimiters),WordUtils.capitalizeFully(beaconList.get(i+1).getLocation(),delimiters));
//                System.out.println(rel.getAngle());
                ModelBeaconPathRequest r = new ModelBeaconPathRequest();

                Staircase pp = null;
                if (!beaconList.get(i+1).getStaircase().isEmpty()) {
                    pp = g.fromJson(beaconList.get(i+1).getStaircase(), Staircase.class);
                }

                r.setAngle(rel.getAngle());
                r.setEndMsg(b.getEndMsg());
                r.setIsStaircase(b.getIsStaircase());
                r.setJuncMsg(b.getJuncMsg());
                r.setLocation(b.getLocation());
                r.setMAC(b.getMAC());
                r.setMeanNormalize1(b.getMeanNormalize1());
                r.setMeanNormalize2(b.getMeanNormalize2());
                r.setStdNormalize1(b.getStdNormalize1());
                r.setStdNormalize2(b.getStdNormalize2());
                r.setStaircase(pp);
//                ModelBeaconPathRequest sec = new ModelBeaconPathRequest(beaconList.get(i).getMAC(),beaconList.get(i).getEndMsg(),beaconList.get(i).getJuncMsg(),rel.getAngle(),beaconList.get(i).getStaricase(),beaconList.get(i).getIsStaircase(),beaconList.get(i).getMeanNormalize1(),beaconList.get(i).getMeanNormalize2(),beaconList.get(i).getStdNormalize1(),beaconList.get(i).getStdNormalize2(),beaconList.get(i).getLocation());
                finalList.add(r);
            }
        }
        return finalList;
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

    @PostMapping("/createStaircase")
    public Beacon cStair(@RequestBody ModelBeaconPathRequest beacon){
        Beacon b = ModelBeaconPathRequest.convertToBeacon(beacon);
        return beaconService.createBeacon(b);
    }

    @DeleteMapping("/beacon")
    public String deleteBeacon(@RequestParam String mac){
        return beaconService.deleteBeacon(mac);
    }
//    @GetMapping("/test3")
//    public List<Adjacent> getR(){
//        return beaconService.findAdj();
//    }

//    @GetMapping("/test4")
//    public Adjacent getRR(){
//        return adjacentService.findAdjj();
//    }
}
