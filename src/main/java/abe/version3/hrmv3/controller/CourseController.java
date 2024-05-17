package abe.version3.hrmv3.controller;

import abe.version3.hrmv3.dto.CourseDto;
import abe.version3.hrmv3.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto ){
        return service.create(courseDto);
    }

    @GetMapping
    public List<CourseDto> findAllStation(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public CourseDto findCourseById(@PathVariable ("id") Integer courseId){
        return service.findCourseById(courseId);
    }

    @PutMapping("{id}")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto,@PathVariable ("id") Integer courseId){
        courseDto.setCourseId(courseId);
        return service.create(courseDto);
    }
    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable ("id") Integer courseId){
        service.deleteCourse(courseId);
    }
}
