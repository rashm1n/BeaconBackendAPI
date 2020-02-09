package spring.data.neo4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.IniBeacon;
import spring.data.neo4j.repositories.IniBeaconRepository;

import java.util.List;

@Service
public class InitialBeaconService {
    @Autowired
    private IniBeaconRepository iniBeaconRepository;

    @Transactional
    public List<IniBeacon> getIniBeacons(){
        return iniBeaconRepository.initialBeaconList();
    }


    @Transactional
    public IniBeacon createIniBeacon(String s1,String s2){return iniBeaconRepository.createIniBeacon(s1,s2);}

    @Transactional
    public IniBeacon cb(IniBeacon iniBeacon){return iniBeaconRepository.save(iniBeacon);}

}
