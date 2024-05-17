package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.dto.StationDto;
import abe.version3.hrmv3.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/station")
@RequiredArgsConstructor
public class StationController {
    private final StationService service;

    @PostMapping
    public StationDto createStation(@RequestBody StationDto stationDto){
        return service.create(stationDto);
    }

    @GetMapping
    public List<StationDto> findAllStation(){
        return service.findAll();
    }
    @GetMapping("{id}")
    public StationDto findStationById(@PathVariable("id")Integer stationId){
        return service.findStationById(stationId);
    }

    @DeleteMapping("{id}")
    public void deleteStationById(@PathVariable("id")Integer stationId){
        service.deleteStationById(stationId);
    }
    @PutMapping("{id}")
    public StationDto updateStation(@RequestBody StationDto stationDto,
                                    @PathVariable("id")Integer stationId){
        stationDto.setStationId(stationId);
        return service.create(stationDto);
    }
}
