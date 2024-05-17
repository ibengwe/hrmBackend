package abe.version3.hrmv3.service;

import abe.version3.hrmv3.dto.StationDto;
import abe.version3.hrmv3.entity.District;
import abe.version3.hrmv3.entity.Station;
import abe.version3.hrmv3.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {
    private final StationRepository repository;

//    mapToDto
    public StationDto mapToDto(Station station){
        return new StationDto(
                station.getStationId(),
                station.getStationName(),
                station.getDistrict().getDistrictId(),
                station.getDistrict().getDistrictName()
        );
    }

//    mapToEntity

    public Station mapToEntity(StationDto stationDto){
        District district=new District();
        district.setDistrictId(stationDto.getDistrictId());
        return new Station(
                stationDto.getStationId(),
                stationDto.getStationName(),
                district
        );
    }

    public StationDto create(StationDto stationDto) {
        Station station=mapToEntity(stationDto);
        return mapToDto(repository.save(station));
    }

    public List<StationDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public StationDto findStationById(Integer stationId) {
        return repository.findById(stationId)
                .map(this::mapToDto)
                .orElseThrow(null);
    }

    public void deleteStationById(Integer stationId) {
        repository.deleteById(stationId);
    }
}
