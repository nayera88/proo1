package com.example.demo.Controller;


import com.example.demo.Service.TripService;
import com.example.demo.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/trip")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {

        this.tripService = tripService;
    }

    @GetMapping
    public List<Trip> getTrips(){

        return tripService.getTrips();
    }

    @PostMapping (path = "/add")
    public void addTrip (@RequestBody Trip trip){

        tripService.addTrip(trip);
    }
    @DeleteMapping (path = "/delete/{id}")
    public void deleteTrip(@PathVariable Long id){

        tripService.deleteTrip(id);
    }

    @GetMapping(path = "/{id}")
    public Trip getTripById(
            @PathVariable Long id
    ){
        return tripService.getTripById(id);
    }

    @PutMapping(path = "/update/{id}")
    public void updateTrip(
            @PathVariable Long id ,
            @RequestBody Trip trip){
        tripService.updateTripById(id , trip);
    }


}
