package com.example.TwitchBudgetTool.Equipmment;


import javax.persistence.*;


@Entity
@Table(name = "equipment")
public class Equipment {


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

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Cost", nullable = false, length = 20)
    private Double cost;


    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Column(name = "progress", columnDefinition = "varchar(50) default 'waiting'")
    private String progress;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}

