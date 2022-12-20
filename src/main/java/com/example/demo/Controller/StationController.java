package com.example.demo.Controller;


import com.example.demo.Service.StationService;
import com.example.demo.model.Station;
import com.example.demo.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/station")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }
    @GetMapping
    public List<Station> getStations(){

        return stationService.getStations();
    }

    @PostMapping (path = "/add")
    public void addStation(@RequestBody Station station){

        stationService.addStation(station);
    }
    @DeleteMapping (path = "/delete/{id}")
    public void deleteStation(@PathVariable Long id){

        stationService.deleteStation(id);
    }

    @PutMapping (path = "/update/{id}")
    public void updateStation(@PathVariable("id") Long id,
                           @RequestParam(required = false) String name){
      stationService.updateStation(id,name);
    }

}


