package abe.version3.hrmv3.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_command")
public class Command {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commandId;
    private String commandName;
}


