package abe.version3.hrmv3.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffCourseDTO {
    private Integer staffId;
    private Integer courseId;

    private String commentByOcs;

    private String commentByOcd;

    private String commentByRpc;

    private String commentByCommissioner;

    private String status;
    private byte[] certificate;
}