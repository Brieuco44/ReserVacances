package fr.reservacances.model.hotel;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "chambre")
@Getter @Setter
public class Chambre {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String numero; 

    @Column(nullable = false)
    private int nbPlace; 

    @Column(nullable = false)
    private double prix;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

}
