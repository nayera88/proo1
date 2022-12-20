package com.example.demo.Service;


import com.example.demo.Repo.StationRepo;
import com.example.demo.model.Station;
import com.example.demo.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StationService {

    private final StationRepo stationRepo;
    @Autowired
    public StationService(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public List<Station> getStations(){
        return stationRepo.findAll();
    }
    public void addStation(Station station){
        stationRepo.save(station);
        System.out.println(station);
    }

    public void deleteStation(Long id){
        stationRepo.deleteById(id);
    }

    @Transactional
    public void updateStation(Long id,String name) {
        Station station = stationRepo.findById(id).orElseThrow(() -> new IllegalStateException("doesn't exited"));

        if( name != null && name.length() > 0 && !Objects.equals(station.getName(), name)) {
            station.setName(name);
        }
    }
}
