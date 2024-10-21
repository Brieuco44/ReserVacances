package fr.reservacances.model.voiture;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marque")
@Getter @Setter
public class Marque {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 50, nullable = false)
    private String nom;
}
