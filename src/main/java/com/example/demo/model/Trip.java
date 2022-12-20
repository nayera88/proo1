package com.example.demo.model;




import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String StartTime;
    private String EndTime;
    private String FromStation;
    private String ToStation;

    public Trip() {
    }

    public Trip(Long id, String startTime, String endTime, String fromStation, String toStation) {
        this.id = id;
        StartTime = startTime;
        EndTime = endTime;
        FromStation = fromStation;
        ToStation = toStation;
    }

    public Trip( String startTime, String endTime, String fromStation, String toStation) {
        StartTime = startTime;
        EndTime = endTime;
        FromStation = fromStation;
        ToStation = toStation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getFromStation() {
        return FromStation;
    }

    public void setFromStation(String fromStation) {
        FromStation = fromStation;
    }

    public String getToStation() {
        return ToStation;
    }

    public void setToStation(String toStation) {
        ToStation = toStation;
    }

}
