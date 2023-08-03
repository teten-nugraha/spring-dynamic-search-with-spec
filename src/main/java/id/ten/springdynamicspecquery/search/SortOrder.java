package id.ten.springdynamicspecquery.search;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class SortOrder {

    private List<String> ascendingOrder;

    private List<String> descendingOrder;

}
