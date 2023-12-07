package nus.iss.day19demo.repo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;
import nus.iss.day19demo.model.Employee;

@Repository
public class EmployeeRepo {
    
    private String hashRef = "employees";

    @Resource(name="redisEmployeeTemplate")
    private HashOperations<String, String, Employee> hashOps;

    // if youre using the ListOperations to access redis data in a list:
    // private ListOperations<String, Employee> ListOps;

    public void saveRecord(Employee e) {
        hashOps.put(hashRef, e.getEmployeeId().toString(), e);
    }

    public Employee getRecord(Object id) {
        Employee e = hashOps.get(hashRef, String.valueOf(id));
        return e;
    }
}
