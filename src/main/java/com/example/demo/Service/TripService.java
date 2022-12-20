package com.example.demo.Service;

import com.example.demo.Repo.TripRepo;
import com.example.demo.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;

@Service
public class TripService {

    private final TripRepo tripRepo;

    @Autowired
    public TripService(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    public List<Trip> getTrips() {
        return tripRepo.findAll();
    }

    public void addTrip(Trip trip) {
        tripRepo.save(trip);
        System.out.println(trip);
    }

    public void deleteTrip(Long id) {

        tripRepo.deleteById(id);
    }

   public Trip getTripById(Long Id){
       Optional<Trip> trip = tripRepo.findById(Id);
       if (!trip.isPresent()){
           throw  new RuntimeException("doesn't exited");

       }
       return trip.get();
   }
    public void updateTripById(Long Id , Trip trip){

       Trip getTrip = tripRepo.getById(Id);
        getTrip.setFromStation(trip.getFromStation());
        getTrip.setToStation(trip.getToStation());
        getTrip.setStartTime(trip.getStartTime());
        getTrip.setEndTime(trip.getEndTime());
        Trip updatedTrip = tripRepo.save(getTrip);
    }
}


