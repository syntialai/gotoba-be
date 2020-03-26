package com.example.goToba.model;

import com.example.goToba.model.constants.SequenceConstantField;
import com.example.goToba.model.constants.TablesConstant;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/03/2020.
 */
@Entity
@AllArgsConstructor
@Table(name = TablesConstant.TABEL_SEQUENCE_USERS)
public class SequenceUsers {
    @Id
    @Column(name = SequenceConstantField.SEQUENCE_KEY)
    private String key;

    @Column(name = SequenceConstantField.SEQUENCE_LAST_SEQUENCE)
    private String last_seq;

    public SequenceUsers(String key, String last_seq) {
        this.key = key;
        this.last_seq = last_seq;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLast_seq() {
        return last_seq;
    }

    public void setLast_seq(String last_seq) {
        this.last_seq = last_seq;
    }
}
