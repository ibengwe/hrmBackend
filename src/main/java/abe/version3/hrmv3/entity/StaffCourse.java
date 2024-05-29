package abe.version3.hrmv3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class StaffCourse {
    @EmbeddedId
    public StaffCourseId id;

    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "staff_id")
    public Staff  staff;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    public Course  course;

    @Column(nullable = true)
    private String commentByOcs= "pending";;

    @Column(nullable = true)
    private String commentByOcd= "pending";;

    @Column(nullable = true)
    private String commentByRpc= "pending";;

    @Column(nullable = true)
    private String commentByCommissioner="pending";

    @Column(nullable = true)
    private String status = "pending"; // Default value is "pending"

    @Lob
    @Column(length = 900000000)
    public byte[] certificate;

    @PrePersist
    protected void onPrePersist() {
        if (this.commentByOcs == null) {
            this.commentByOcs = "pending";
        }
        if (this.commentByOcd == null) {
            this.commentByOcd = "pending";
        }
        if (this.commentByRpc == null) {
            this.commentByRpc = "pending";
        }
        if (this.commentByCommissioner == null) {
            this.commentByCommissioner = "pending";
        }
        if (this.status == null) {
            this.status = "pending";
        }
    }


}
