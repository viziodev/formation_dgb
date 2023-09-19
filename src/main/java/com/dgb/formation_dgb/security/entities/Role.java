package com.dgb.formation_dgb.security.entities;

import com.dgb.formation_dgb.entities.AbstractEnttity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
@Builder
@SQLDelete(sql = "update roles set etat=0 where id=? ")
public class Role  extends AbstractEnttity {
     @Column(unique = true)
     private String roleName;
}
