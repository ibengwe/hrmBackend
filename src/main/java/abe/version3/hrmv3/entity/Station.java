package abe.version3.hrmv3.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer stationId;
    private String stationName;
    @ManyToOne
    @JoinColumn(name = "stationDistrict")
    private District district;
}
