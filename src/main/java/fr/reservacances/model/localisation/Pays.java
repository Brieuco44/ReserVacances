package fr.reservacances.model.localisation;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pays")
@Getter @Setter
public class Pays {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String nom;
}
