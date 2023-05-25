package edu.goit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "planet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"from_planets", "to_planets"})
@EqualsAndHashCode(exclude = {"from_planets", "to_planets"})
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "from_planet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ticket> from_planets;
    @OneToMany(mappedBy = "to_planet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ticket> to_planets;
}
