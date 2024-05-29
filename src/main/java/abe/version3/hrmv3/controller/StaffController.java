package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.dto.StaffDto;
import abe.version3.hrmv3.entity.Staff;
import abe.version3.hrmv3.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
            @RequestParam("dateBirth")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date dateBirth,
            @RequestParam("dateEnlist")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date dateEnlist,
            @RequestParam("gender") String gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("image") MultipartFile image)throws IOException {
//
        return service.createStaff(staffId,firstName,middleName,lastName,dateBirth,dateEnlist,gender,phoneNumber,image);

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



