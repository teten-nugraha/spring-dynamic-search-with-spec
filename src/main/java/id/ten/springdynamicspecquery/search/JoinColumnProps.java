package id.ten.springdynamicspecquery.search;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JoinColumnProps {

    private String joinColumnName;
    private SearchFilter searchFilter;

}
