package com.project.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<BikeEntity> bikes;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BikeEntity> getBikes() {
        return bikes;
    }

    public void setBikes(List<BikeEntity> bikes) {
        this.bikes = bikes;
    }
}
