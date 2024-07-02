package org.itformacion.apicourse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Table(name = "COURSE_STUDENT")
public class CourseStudent {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_STUDENT_ID", unique = true, nullable = false)
    private Long courseStudentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COURSE_ID", nullable = false, referencedColumnName = "COURSE_ID"
            , foreignKey = @ForeignKey(name = "fk_CourseStudent_Course"))
    @JsonIgnore
    private Course course;

    @Column(name = "STUDENT_ID", nullable = false)
    private Long studentId;

    public CourseStudent() {
    }

    public CourseStudent(Long courseStudentId, Course course, Long studentId) {
        this.courseStudentId = courseStudentId;
        this.course = course;
        this.studentId = studentId;
    }

    public CourseStudent(Long courseStudentId, Long studentId) {
        this.courseStudentId = courseStudentId;
        this.studentId = studentId;
    }

    public Long getCourseStudentId() {
        return courseStudentId;
    }

    public Course getCourse() {
        return course;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setCourseStudentId(Long courseStudentId) {
        this.courseStudentId = courseStudentId;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
