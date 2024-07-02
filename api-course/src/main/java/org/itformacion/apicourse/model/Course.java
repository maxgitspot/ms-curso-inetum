package org.itformacion.apicourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", unique = true, nullable = false)
    private Long courseId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CourseStudent> students = new ArrayList<>();

    public Course() {
    }

    public Course(Long courseId, String name, List<CourseStudent> students) {
        this.courseId = courseId;
        this.name = name;
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public List<CourseStudent> getStudents() {
        return students;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<CourseStudent> students) {
        this.students = students;
    }
}
