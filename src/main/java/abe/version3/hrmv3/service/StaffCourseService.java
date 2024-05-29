package abe.version3.hrmv3.service;

import abe.version3.hrmv3.dto.CourseDto;
import abe.version3.hrmv3.dto.StaffCourseDTO;
import abe.version3.hrmv3.entity.Course;
import abe.version3.hrmv3.entity.Staff;
import abe.version3.hrmv3.entity.StaffCourse;
import abe.version3.hrmv3.entity.StaffCourseId;
import abe.version3.hrmv3.repository.CourseRepository;
import abe.version3.hrmv3.repository.StaffCourseRepository;
import abe.version3.hrmv3.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffCourseService {
    private final StaffRepository staffRepository;
    private final CourseRepository courseRepository;
    private final StaffCourseRepository staffCourseRepository;

   

    public List<StaffCourseDTO> getAllStaffCourses() {
        List<StaffCourse> staffCourses = staffCourseRepository.findAll();
        return staffCourses.stream()
                .map(this::mapToStaffCourseDTO)
                .collect(Collectors.toList());
    }

    public List<CourseDto> getCoursesByStaffId(Integer staffId) {
        List<StaffCourse> staffCourses = staffCourseRepository.findByStaff_StaffId(staffId);
        return staffCourses.stream()
                .map(staffCourse -> mapToCourseDTO(staffCourse.getCourse()))
                .collect(Collectors.toList());
    }

    private CourseDto mapToCourseDTO(Course course) {
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName()
                // add other fields as necessary
        );
    }

    public List<StaffCourseDTO> getStaffCoursesByStaffId(Integer staffId) {
        List<StaffCourse> staffCourses = staffCourseRepository.findByStaff_StaffId(staffId);
        return staffCourses.stream()
                .map(this::mapToStaffCourseDTO)
                .collect(Collectors.toList());
    }

    public List<StaffCourseDTO> getStaffCoursesByStatus(String status) {
        List<StaffCourse> staffCourses = staffCourseRepository.findByStatus(status);
        return staffCourses.stream()
                .map(this::mapToStaffCourseDTO)
                .collect(Collectors.toList());
    }

    public StaffCourseDTO getStaffCourseById(Integer staffId, Integer courseId) {
        StaffCourse staffCourse = staffCourseRepository.findById(new StaffCourseId(staffId, courseId))
                .orElseThrow(() -> new RuntimeException("StaffCourse not found"));
        return mapToStaffCourseDTO(staffCourse);
    }

    public void deleteStaffCourse(Integer staffId, Integer courseId) {
        StaffCourse staffCourse = staffCourseRepository.findById(new StaffCourseId(staffId, courseId))
                .orElseThrow(() -> new RuntimeException("StaffCourse not found"));
        staffCourseRepository.delete(staffCourse);
    }

    public StaffCourseDTO updateStaffCourse(Integer staffId,
                                            Integer courseId,
                                            String commentByOcs,
                                            String commentByOcd,
                                            String commentByRpc,
                                            String commentByCommissioner,
                                            byte[] certificateBytes,
                                            String status) {
        StaffCourse staffCourse = staffCourseRepository.findById(new StaffCourseId(staffId, courseId))
                .orElseThrow(() -> new RuntimeException("StaffCourse not found"));

        staffCourse.setCommentByOcs(commentByOcs);
        staffCourse.setCommentByOcd(commentByOcd);
        staffCourse.setCommentByRpc(commentByRpc);
        staffCourse.setCommentByCommissioner(commentByCommissioner);
        if (certificateBytes != null) {
            staffCourse.setCertificate(certificateBytes);
        }
        staffCourse.setStatus(status);

        StaffCourse updatedStaffCourse = staffCourseRepository.save(staffCourse);
        return mapToStaffCourseDTO(updatedStaffCourse);
    }

    private StaffCourseDTO mapToStaffCourseDTO(StaffCourse staffCourse) {
        return new StaffCourseDTO(
                staffCourse.getId().getStaffId(),
                staffCourse.getId().getCourseId(),
                staffCourse.course.getCourseName(), // Add this line

                staffCourse.getCommentByOcs(),
                staffCourse.getCommentByOcd(),
                staffCourse.getCommentByRpc(),
                staffCourse.getCommentByCommissioner(),
                staffCourse.getStatus(),
                staffCourse.getCertificate()
        );
    }

    public StaffCourseDTO saveStaffCourse(Integer staffId,
                                          Integer courseId,
                                          String commentByOcs,
                                          String commentByOcd,
                                          String commentByRpc,
                                          String commentByCommissioner,
                                          byte[] certificateBytes,
                                          String status) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        StaffCourse staffCourse = new StaffCourse();

        StaffCourseId staffCourseId = new StaffCourseId();
        staffCourseId.setStaffId(staffId);
        staffCourseId.setCourseId(courseId);
        staffCourse.setId(staffCourseId);
        staffCourse.setStaff(staff);
        staffCourse.setCourse(course);
        staffCourse.setCommentByOcs(commentByOcs);
        staffCourse.setCommentByOcd(commentByOcd);
        staffCourse.setCommentByRpc(commentByRpc);
        staffCourse.setCommentByCommissioner(commentByCommissioner);
        staffCourse.setCertificate(certificateBytes);
        staffCourse.setStatus(status);

        StaffCourse savedStaffCourse = staffCourseRepository.save(staffCourse);

        return mapToStaffCourseDTO(savedStaffCourse);
    }
}
