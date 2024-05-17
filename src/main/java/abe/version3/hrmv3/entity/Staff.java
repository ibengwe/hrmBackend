package abe.version3.hrmv3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Staff {
    @Id
    public Integer staffId;
    public String firstName;
    public String middleName;
    public String lastName;
    public Date dateBirth;
    public Date dateEnlist;
    public String gender;
    public String phoneNumber;
    @Lob
    @Column(length = 900000000)
    public byte[] image;

    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<StaffCourse> staffCourses;

}

