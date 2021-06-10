package com.example.TwitchBudgetTool;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "streams")
public class Streams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day", nullable = false, length = 50)
    private String day;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "earnings", nullable = false, length = 20)
    private Double earnings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }
}

