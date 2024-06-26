package abe.version3.hrmv3.repository;

import abe.version3.hrmv3.entity.StaffCourse;
import abe.version3.hrmv3.entity.StaffCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffCourseRepository extends JpaRepository<StaffCourse, StaffCourseId> {

    List<StaffCourse> findByStaff_StaffId(Integer staffId);

    List<StaffCourse> findByStatus(String status); // Add this line


}
