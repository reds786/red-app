package com.redcompany.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Vehicle {

    @Id
    @SequenceGenerator(
            name = "vehicle_id_sequence",
            sequenceName = "vehicle_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_id_sequence"
    )
    private Integer vid;
    private String vname;

}
