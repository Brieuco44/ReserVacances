package fr.reservacances.model.utilisateur;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter @Setter
public class Role {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 50, nullable = false)
    private String nom;
}
