package kc.studentcontroller;

import java.util.ArrayList;
import java.util.List;
import kc.student.Student;

public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    // 모든 학생 목록 반환
    public List<Student> All() {
        return studentList;
    }

    // 학생 추가
    public int addStudent(Student student) {
        studentList.add(student);
        return 1; // 성공 시 1 반환
    }

    // 학생 검색 (이름으로)
    public Student searchStudent(String name) {
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null; // 찾지 못하면 null 반환
    }

    // 학생 수정 (이름으로 검색 후 수정)
    public int updateStudent(String name, int firstScore, int secondScore, int finalScore) {
        Student student = searchStudent(name);
        if (student != null) {
            student.setFirstScore(firstScore);
            student.setSecondScore(secondScore);
            student.setFinalScore(finalScore);
            int sumScore = firstScore + secondScore + finalScore;
            student.setSumScore(sumScore);
            student.setAverage(sumScore / 3);
            return 1; // 수정 성공 시 1 반환
        }
        return 0; // 수정 실패 시 0 반환
    }
}
