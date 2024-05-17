package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.dto.StaffDto;
import abe.version3.hrmv3.entity.Gender;
import abe.version3.hrmv3.entity.Staff;
import abe.version3.hrmv3.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService service;

    @PostMapping
    public Staff createStaff(
            @RequestParam("staffId") Integer staffId,
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName,
            @RequestParam("lastName") String lastName,
            @RequestParam("dateBirth") Date dateBirth,
            @RequestParam("dateEnlist") Date dateEnlist,
            @RequestParam("gender") String gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("image") MultipartFile image)throws IOException {
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
        return service.createStaff(staff);

    }

    @GetMapping
    public List<StaffDto> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public StaffDto getStaffById(@PathVariable("id")Integer staffId){
        return service.findById(staffId);
    }


}



