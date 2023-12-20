package cn.edu.tyut.mapper;

import cn.edu.tyut.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author 羊羊
 * @ClassName StudentMapper
 * @SubmitTime 周五
 * @DATE 2023/11/24
 * @Time 8:51
 * @Package_Name cn.edu.tyut.mapper
 */
@CacheNamespace()
public interface StudentMapper {
    /**
     * >
     *
     * @return >
     */
    @Select("SELECT * FROM students")
    List<Student> selectStudents();

    /**
     * 根据学生ID查询
     *
     * @param id >
     * @return 查询到的学生信息
     */
    @Select("SELECT * FROM students WHERE id=#{id}")
    Student selectStudentById(int id);

    /**
     * 学生名称模糊查询
     * @param name >
     * @return >
     */
    @Select("SELECT * FROM students WHERE NAME LIKE CONCAT('%', #{name}, '%')")
    List<Student> selectStudentByNameConcat(String name);

    /**
     * >
     * @param student >
     * @return >
     */
    List<Student> selectStudentByAddressOrName(Student student);

    /**
     * >
     *
     * @param id >
     * @return >
     */
    @Delete("DELETE FROM students WHERE id = #{id}")
    int deleteStudent(int id);

    /**
     * >
     *
     * @param student >>
     * @return >>
     */
    @Insert("INSERT INTO students(id, NAME, age, gender, number, address, STATUS) VALUES (#{id}, #{name}, #{age}, #{gender}, #{number}, #{address}, #{status})")
    int insertStudent(Student student);

    /**
     * name
     * age
     * 根据id
     *
     * @param student >>
     * @return >>
     */
    @Update("UPDATE students SET NAME=#{name}, age=#{age} WHERE id=#{id}")
    int updateStudent(Student student);
}