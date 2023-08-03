package id.ten.springdynamicspecquery.service;

import id.ten.springdynamicspecquery.dto.EmployeeDto;
import id.ten.springdynamicspecquery.model.Employee;
import id.ten.springdynamicspecquery.repository.EmployeeRepository;
import id.ten.springdynamicspecquery.search.SearchQuery;
import id.ten.springdynamicspecquery.search.SpecificationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository empRepo;

    @Transactional
    public void save(Employee emp) {
        empRepo.save(emp);
    }

    public List<EmployeeDto> findAll(SearchQuery searchQuery) {

        Specification<Employee> spec = SpecificationUtil.bySearchQuery(searchQuery, Employee.class);
        PageRequest pageRequest = getPageRequest(searchQuery);

        Page<Employee> page = empRepo.findAll(spec, pageRequest);

        List<EmployeeDto> response = page.getContent()
                .stream()
                .map(data -> {
                    var dto = EmployeeDto.builder()
                            .id(data.getId())
                            .age(data.getAge())
                            .firstName(data.getFirstName())
                            .lastName(data.getLastName())
                            .hobbies(data.getHobbies())
                            .build();
                    return dto;
                })
                .collect(Collectors.toList());

        return response;
    }

    private PageRequest getPageRequest(SearchQuery searchQuery) {

        int pageNumber = searchQuery.getPageNumber();
        int pageSize = searchQuery.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();

        List<String> ascProps = searchQuery.getSortOrder().getAscendingOrder();

        if (ascProps != null && !ascProps.isEmpty()) {
            for (String prop : ascProps) {
                orders.add(Sort.Order.asc(prop));
            }
        }

        List<String> descProps = searchQuery.getSortOrder().getDescendingOrder();

        if (descProps != null && !descProps.isEmpty()) {
            for (String prop : descProps) {
                orders.add(Sort.Order.desc(prop));
            }

        }

        Sort sort = Sort.by(orders);

        return PageRequest.of(pageNumber, pageSize, sort);

    }
}
