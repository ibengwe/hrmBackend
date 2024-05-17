package abe.version3.hrmv3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StationDto {
    private Integer stationId;
    private String stationName;
    private Integer districtId;
    private String districtName;
}
