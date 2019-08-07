package spring.data.neo4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.services.BeaconService;

@RestController
@RequestMapping("/")
public class BeaconController {

    private final BeaconService beaconService;

    public BeaconController(BeaconService beaconService) {
        this.beaconService = beaconService;
    }

    @GetMapping("/test")
    public Beacon getB(){
        return beaconService.findBeacon();
    }
}
