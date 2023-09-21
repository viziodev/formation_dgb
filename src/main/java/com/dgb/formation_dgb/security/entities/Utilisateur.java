package com.dgb.formation_dgb.security.entities;


import com.dgb.formation_dgb.entities.AbstractEnttity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
@SQLDelete(sql = "update utilisateurs set etat=0 where id=? ")
@Builder
public class Utilisateur extends AbstractEnttity {
    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles ;

}
