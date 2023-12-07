package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    public static final String URL = "http://localhost:8080/api/employees";

    public List<Employee> getAllEmployee() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });
        return responseEntity.getBody();
    }

    public Employee getEmployee(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to BD");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was update");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }
}
