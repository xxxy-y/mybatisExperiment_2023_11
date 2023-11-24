package cn.edu.tyut.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 羊羊
 * @ClassName Student
 * @SubmitTime 周五
 * @DATE 2023/11/24
 * @Time 8:40
 * @Package_Name cn.edu.tyut.entity
 */
@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer number;
    private String address;
    private String status;
}
