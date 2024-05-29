package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.dto.CourseDto;
import abe.version3.hrmv3.dto.StaffCourseDTO;
import abe.version3.hrmv3.entity.StaffCourse;
import abe.version3.hrmv3.service.StaffCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/auth/staffCourse")
@RequiredArgsConstructor
public class StaffCourseController {

    private final StaffCourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StaffCourseDTO createStaffCourse(@RequestParam("staffId") Integer staffId,
                                            @RequestParam("courseId") Integer courseId,
                                            @RequestParam(required = false) String commentByOcs,
                                            @RequestParam(required = false) String commentByOcd,
                                            @RequestParam(required = false) String commentByRpc,
                                            @RequestParam(required = false) String commentByCommissioner,
                                            @RequestParam(required = false) String status,
                                            @RequestParam("certificate") MultipartFile certificate) throws IOException {
        byte[] certificateBytes = certificate.getBytes();
        return service.saveStaffCourse(staffId, courseId, commentByOcs, commentByOcd, commentByRpc, commentByCommissioner, certificateBytes, status);
    }

    @GetMapping
    public List<StaffCourseDTO> getAllStaffCourses() {
        return service.getAllStaffCourses();
    }

    @GetMapping("/{staffId}/{courseId}")
    public StaffCourseDTO getStaffCourseById(@PathVariable Integer staffId, @PathVariable Integer courseId) {
        return service.getStaffCourseById(staffId, courseId);
    }

    @GetMapping("/courses/{staffId}")
    public List<CourseDto> getCoursesByStaffId(@PathVariable Integer staffId) {
        return service.getCoursesByStaffId(staffId);
    }

    @GetMapping("/staff/{staffId}")
    public List<StaffCourseDTO> getStaffCoursesByStaffId(@PathVariable Integer staffId) {
        return service.getStaffCoursesByStaffId(staffId);
    }

    @GetMapping("/status/pending")
    public List<StaffCourseDTO> getAllPendingStaffCourses() {
        return service.getStaffCoursesByStatus("pending");
    }

    @GetMapping("/status/ocs")
    public List<StaffCourseDTO> getAllOcsStaffCourses() {
        return service.getStaffCoursesByStatus("ocs");
    }

    @GetMapping("/status/ocd")
    public List<StaffCourseDTO> getAllOcdStaffCourses() {
        return service.getStaffCoursesByStatus("ocd");
    }

    @GetMapping("/status/rpc")
    public List<StaffCourseDTO> getAllRpcStaffCourses() {
        return service.getStaffCoursesByStatus("rpc");
    }

    @GetMapping("/status/commissioner")
    public List<StaffCourseDTO> getAllCommissionerStaffCourses() {
        return service.getStaffCoursesByStatus("commissioner");
    }

    @DeleteMapping("/{staffId}/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStaffCourse(@PathVariable Integer staffId, @PathVariable Integer courseId) {
        service.deleteStaffCourse(staffId, courseId);
    }

    @PutMapping("/{staffId}/{courseId}")
    public StaffCourseDTO updateStaffCourse(@PathVariable Integer staffId,
                                            @PathVariable Integer courseId,
                                            @RequestParam(required = false) String commentByOcs,
                                            @RequestParam(required = false) String commentByOcd,
                                            @RequestParam(required = false) String commentByRpc,
                                            @RequestParam(required = false) String commentByCommissioner,
                                            @RequestParam(required = false) String status,
                                            @RequestParam(required = false) MultipartFile certificate) throws IOException {
        byte[] certificateBytes = (certificate != null) ? certificate.getBytes() : null;
        return service.updateStaffCourse(staffId, courseId, commentByOcs, commentByOcd, commentByRpc, commentByCommissioner, certificateBytes, status);
    }



}





