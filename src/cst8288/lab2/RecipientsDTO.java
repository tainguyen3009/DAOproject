/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.lab2;

/**
 *
 * @author Tai Nguyen
 * Student number: 041086103
 * 
 */
public class RecipientsDTO {
    private Integer awardID;
    private String name;
    private Integer year;
    private String city;
    private String category;
    
    public Integer getAwardID(){
        return awardID;
    }
    public void setAwardID(Integer awardID){
        this.awardID = awardID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Integer getYear(){
        return year;
    }
    public void setYear(Integer year){
        this.year = year;
    }
    
    public String getCity(){
        return city;
    }
    public void SetCity(String city){
        this.city = city;
    }
    
    public String getCategory(){
        return category;
    }
    public void SetCategory(String category){
        this.category = category;
    }
   


}
