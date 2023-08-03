package id.ten.springdynamicspecquery.search;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class SearchQuery {

    private List<SearchFilter> searchFilter;

    private int pageNumber;
    private int pageSize;

    private SortOrder sortOrder;

    private List<JoinColumnProps> joinColumnProps;

}
