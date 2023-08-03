package id.ten.springdynamicspecquery.search;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchFilter {

    private String property;
    private String operator;
    private Object value;

}
