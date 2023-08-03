package id.ten.springdynamicspecquery.dto;

import id.ten.springdynamicspecquery.model.Hobby;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@Builder
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Set<Hobby> hobbies;
}
