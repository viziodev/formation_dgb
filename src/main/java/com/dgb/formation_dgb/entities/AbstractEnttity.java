package com.dgb.formation_dgb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEnttity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected boolean etat=true;

    public AbstractEnttity(Long id) {
        this.id = id;
    }
}
