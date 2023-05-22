package edu.goit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "CLIENT_ID_FK"))
    private Client client;
    @ManyToOne
    @JoinColumn(name = "from_planet_id", foreignKey = @ForeignKey(name = "FROM_PLANET_ID_FK"))
    private Planet from_planet_id;
    @ManyToOne
    @JoinColumn(name = "to_planet_id", foreignKey = @ForeignKey(name = "TO_PLANET_ID_FK"))
    private Planet to_planet_id;

}
