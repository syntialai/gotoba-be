package com.example.goToba.model;

import com.example.goToba.model.constants.TablesConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = TablesConstant.TABEL_ROLES)
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
