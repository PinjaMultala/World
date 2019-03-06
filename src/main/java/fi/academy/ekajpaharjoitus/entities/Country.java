package fi.academy.ekajpaharjoitus.entities;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity
public class Country {
    @SequenceGenerator(name="seq-gen",sequenceName="maa_id_seq", initialValue=10, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private Integer population;
    private String head_of_state;
    private Integer indep_year;

    public Country() {
    }

    public Country(Integer id, String name, Integer population, String head_of_state, Integer indep_year) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.head_of_state = head_of_state;
        this.indep_year = indep_year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getHead_of_state() {
        return head_of_state;
    }

    public void setHead_of_state(String head_of_state) {
        this.head_of_state = head_of_state;
    }

    public Integer getIndep_year() {
        return indep_year;
    }

    public void setIndep_year(Integer indep_year) {
        this.indep_year = indep_year;
    }
}
