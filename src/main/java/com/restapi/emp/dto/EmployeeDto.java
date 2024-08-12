package com.restapi.emp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    @NotEmpty(message = "firstName은 필수입력 항목입니다.")
    private String firstName;

    @NotEmpty// (message = "lastName은 필수입력 항목입니다.")
    private String lastName;

    @NotBlank(message =  "email은 필수입력 항목입니다.")
    @Email
    private String email;

    // 숫자는 @NotBlank, @NotEmpty 가 안됨
    @Digits(message = "departmentId는 필수입력 항목입니다.", integer = 3, fraction = 0)
    private Long departmentId;

    private DepartmentDto departmentDto;

    public EmployeeDto(Long id,String firstName,String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public EmployeeDto(Long id,String firstName,String lastName, String email, Long departmentId) {
        this(id,firstName,lastName,email);
        this.departmentId = departmentId;
    }


    public EmployeeDto(Long id,String firstName,String lastName, String email, DepartmentDto departmentDto) {
        this(id,firstName,lastName,email);
        this.departmentDto = departmentDto;
    }
}