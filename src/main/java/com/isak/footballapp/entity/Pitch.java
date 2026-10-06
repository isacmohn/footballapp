package com.isak.footballapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "pitches")
public class Pitch {
    //Primary key i databasen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Datafields tilsvarer egenskaper (pitchname, adresse, størrelse,  )
    private String pitchName;
    private String district;

    private Double latitude;
    private Double longitude;

    private String size;
    private Double pricePerHour;
    private String contactNumber;

    //Konstruktør som er tom
    public Pitch(){

    }
    //konstruktør med argumenter
    public Pitch(String pitchName, String district, Double latitude, Double longitude, String size, Double pricePerHour, String contactNumber){
        this.pitchName = pitchName;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.size = size;
        this.pricePerHour = pricePerHour;
        this.contactNumber = contactNumber;
    }

    //Gettere(+return, + sammedatatype) og settere(+void, + innargs)
    public Long getPitchId(){return id;} public void setPitchId(Long id){this.id = id;}
    public String getPitchName(){return pitchName;} public void setPitchName(String pitchName){this.pitchName = pitchName;}
    public String getDistrict(){return district;} public void setDistrict(String district){this.district = district;}
    public Double getLatitude(){return latitude;} public void setLatitude(Double latitude){this.latitude = latitude;}
    public Double getLongitude(){return longitude;} public void setLongitude(Double longitude){this.longitude = longitude;}
    public String getSize(){return size;} public void setSize(String size){this.size = size;}
    public Double getPricePerHour(){return pricePerHour;} public void setPricePerHour(Double pricePerHour){this.pricePerHour = pricePerHour;}
    public String getContactNumber(){return contactNumber;} public void setContactNumber(String contactNumber){this.contactNumber = contactNumber;}


}
