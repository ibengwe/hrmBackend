package abe.version3.hrmv3.service;

import abe.version3.hrmv3.dto.CourseDto;
import abe.version3.hrmv3.entity.Course;
import abe.version3.hrmv3.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

//    mapToDto

    public CourseDto mapToDto(Course course){
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName()
        );
    }

//    mapToEntity

    public Course mapToEntity(CourseDto courseDto){
        return new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName()
        );
    }

    private final CourseRepository repository;

    public CourseDto create(CourseDto courseDto) {
        Course course=mapToEntity(courseDto);
        return mapToDto(repository.save(course));
    }

    public List<CourseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public CourseDto findCourseById(Integer courseId) {
        return repository.findById(courseId)
                .map(this::mapToDto)
                .orElse(null);

    }

    public void deleteCourse(Integer courseId) {
        repository.deleteById(courseId);
    }
}
