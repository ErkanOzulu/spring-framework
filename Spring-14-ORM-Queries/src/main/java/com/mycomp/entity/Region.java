package com.mycomp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region extends BaseEntity {

    private String region;
    private String country;
}
