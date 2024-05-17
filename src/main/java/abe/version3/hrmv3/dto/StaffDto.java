package abe.version3.hrmv3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDto {
    public Integer staffId;
    public String firstName;
    public String middleName;
    public String lastName;
    public Date dateBirth;
    public Date dateEnlist;
    public String gender;
    public String phoneNumber;
    private byte[] image;

}
