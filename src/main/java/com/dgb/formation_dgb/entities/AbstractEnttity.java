package com.dgb.formation_dgb.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass
public class AbstractEnttity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected boolean etat=true;
}
