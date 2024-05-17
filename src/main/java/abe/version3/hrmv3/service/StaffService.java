package abe.version3.hrmv3.service;

import abe.version3.hrmv3.dto.StaffDto;
import abe.version3.hrmv3.entity.Staff;
import abe.version3.hrmv3.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository repository;

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

    public Staff createStaff(Staff staff) {
        return repository.save(staff);
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
}
