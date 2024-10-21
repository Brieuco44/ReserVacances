package fr.reservacances.model.vol;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compagnie")
@Getter @Setter
public class Compagnie {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 100, nullable = false)
    private String nom;
}
