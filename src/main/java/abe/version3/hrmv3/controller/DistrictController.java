package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.dto.PoliceDistrictDto;
import abe.version3.hrmv3.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/district")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService service;

    @PostMapping
    public PoliceDistrictDto createDistrict(@RequestBody PoliceDistrictDto policeDistrictDto){
        return service.create(policeDistrictDto);
    }
    @GetMapping
    public List<PoliceDistrictDto> findAllDistrict(){
        return service.findAll();
    }
    @GetMapping("{id}")
    public PoliceDistrictDto findDistrictById(@PathVariable("id")Integer districtId){
        return service.findById(districtId);
    }
    @DeleteMapping("{id}")
    public void deleteDistrict(@PathVariable("id")Integer districtId){
        service.deleteById(districtId);
    }
    @PutMapping("{id}")
    public PoliceDistrictDto upDateDistrict(@RequestBody PoliceDistrictDto policeDistrictDto,
                                            @PathVariable("id")Integer districtId
                                            ){
        policeDistrictDto.setDistrictId(districtId);
        return service.create(policeDistrictDto);
    }
}
