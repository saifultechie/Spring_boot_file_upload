package student.portal.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_age")
    private int studentAge;
    @Column(name = "student_dept")
    private String studentDept;
    @Column(name = "student_dist")
    private String studentDist;

    public Student(int id, String studentName, int studentAge, String studentDept, String studentDist) {
        this.id = id;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentDept = studentDept;
        this.studentDist = studentDist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public String getStudentDist() {
        return studentDist;
    }

    public void setStudentDist(String studentDist) {
        this.studentDist = studentDist;
    }
}
