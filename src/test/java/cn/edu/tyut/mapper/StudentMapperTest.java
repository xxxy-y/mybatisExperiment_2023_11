package cn.edu.tyut.mapper;

import cn.edu.tyut.entity.Student;
import cn.edu.tyut.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author 羊羊
 * @ClassName StudentMapperTest
 * @SubmitTime 周五
 * @DATE 2023/11/24
 * @Time 9:15
 * @Package_Name cn.edu.tyut.mapper
 */
class StudentMapperTest {

    @Test
    void selectStudents() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectStudents();
            System.out.println(students);
        }
    }

    @Test
    void selectStudentById() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectStudentById(1);
            System.out.println(student);
        }
    }

    @Test
    void selectStudentByNameConcat() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectStudentByNameConcat("w");
            students.forEach(System.out::println);
        }
    }

    @Test
    void selectStudentByAddressOrName() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
//            student.setName("wqt");
            student.setAddress("dwadasdaw");
            List<Student> students = studentMapper.selectStudentByAddressOrName(student);
            students.forEach(System.out::println);
        };
    }

    @Test
    void deleteStudent() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int i = studentMapper.deleteStudent(2);
            if (i > 0) {
                System.out.println("删除学生信息成功");
            } else {
                System.out.println("删除学生信息失败");
            }
        }
    }

    @Test
    void insertStudent() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setId(2);
            student.setName("student2");
            student.setAge(18);
            student.setNumber(9999);
            student.setGender("second gender");
            student.setAddress("shanXi");
            student.setStatus("2");
            int i = studentMapper.insertStudent(student);
            if (i > 0) {
                System.out.println("新增学生信息成功");
            } else {
                System.out.println("新增学生信息失败");
            }
        }
    }

    @Test
    void updateStudent() {
        try (SqlSession sqlSession = MybatisUtils.getSqlsession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setId(2);
            student.setName("yy");
            student.setAge(20);
            int i = studentMapper.updateStudent(student);
            if (i > 0) {
                System.out.println("更新学生信息成功");
            } else {
                System.out.println("更新学生信息失败");
            }
        }
    }
}