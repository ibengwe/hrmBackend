package abe.version3.hrmv3.service;

import abe.version3.hrmv3.dto.PoliceDistrictDto;
import abe.version3.hrmv3.entity.Command;
import abe.version3.hrmv3.entity.District;
import abe.version3.hrmv3.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository repository;

    public PoliceDistrictDto  mapToDto(District district){
        return new PoliceDistrictDto(
                district.getDistrictId(),
                district.getDistrictName(),
                district.getCommand().getCommandId(),
                district.getCommand().getCommandName()
        );
    }

    public District mapToEntity(PoliceDistrictDto districtDto){
        Command command=new Command();
        command.setCommandId(districtDto.getCommandId());

        return new District(
                districtDto.getDistrictId(),
                districtDto.getDistrictName(),
                command
        );
    }

    public PoliceDistrictDto create(PoliceDistrictDto policeDistrictDto) {
        District district=mapToEntity(policeDistrictDto);
        return mapToDto(repository.save(district));
    }

    public List<PoliceDistrictDto> findAll(){
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public PoliceDistrictDto findById(Integer districtId) {
        return repository.findById(districtId)
                .map(this::mapToDto)
                .orElse(null);
    }

    public void deleteById(Integer districtId) {
        repository.deleteById(districtId);
    }
}


