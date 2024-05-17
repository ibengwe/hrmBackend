package abe.version3.hrmv3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_district")
public class District {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer districtId;
    private String districtName;
    @ManyToOne
    private Command command;
}


