package spring.data.neo4j.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.repositories.BeaconRepository;

@Service
public class BeaconService {

    private final BeaconRepository beaconRepository;

    public BeaconService(BeaconRepository beaconRepository) {
        this.beaconRepository = beaconRepository;
    }

    @Transactional(readOnly = true)
    public Beacon findBeacon(){
        Beacon b = beaconRepository.findaBeacon();
        return b;
    }
}
