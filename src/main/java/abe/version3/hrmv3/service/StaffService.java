package abe.version3.hrmv3.service;

import abe.version3.hrmv3.dto.StaffDto;
import abe.version3.hrmv3.entity.Staff;
import abe.version3.hrmv3.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffService {
    @Autowired
    private  StaffRepository repository;

    public StaffDto mapToDto(Staff staff){
        return new StaffDto(
                staff.getStaffId(),
                staff.getFirstName(),
                staff.getMiddleName(),
                staff.getLastName(),
                staff.getDateBirth(),
                staff.getDateEnlist(),
                staff.getGender(),
                staff.getPhoneNumber(),
                staff.getImage()
        );
    }

    

    public List<StaffDto> findAll() {
        List<Staff> staffs=repository.findAll();
        return staffs
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public StaffDto findById(Integer staffId) {
        return repository.findById(staffId)
                .map(this::mapToDto)
                .orElse(null);
    }


    public Staff createStaff(Integer staffId, String firstName, String middleName, String lastName, Date dateBirth, Date dateEnlist, String gender, String phoneNumber, MultipartFile image) throws IOException {
        Staff staff=new Staff();
        staff.setStaffId(staffId);
        staff.setFirstName(firstName);
        staff.setMiddleName(middleName);
        staff.setLastName(lastName);
        staff.setDateBirth(dateBirth);
        staff.setDateEnlist(dateEnlist);
        staff.setGender(gender);
        staff.setPhoneNumber(phoneNumber);
        staff.setImage(image.getBytes());

        return repository.save(staff);
    }
}
