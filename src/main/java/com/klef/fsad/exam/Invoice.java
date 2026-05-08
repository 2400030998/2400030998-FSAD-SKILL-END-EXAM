package com.klef.fsad.exam;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String status;
    private double amount;
    
    public Invoice() {}
    public Invoice(String name, Date date, String status, double amount) 
    {
        this.name = name;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }
    public double getAmount() { return amount; }
    public void setName(String name) { this.name = name; }
    public void setDate(Date date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
    public void setAmount(double amount) { this.amount = amount; }
}