package com.example.TwitchBudgetTool.Streams;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "streams")
public class Streams {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="author_id", nullable = false, length = 10)
    private Long author_id;

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    @Column(name = "day", nullable = false, length = 50)
    private String day;

    @Column(name = "earnings", nullable = false, length = 20)
    private Double earnings;

    @Column(name = "time", nullable = false)
    private String time;



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

