package com.redcompany.app.service;

import com.redcompany.app.model.Department;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service("join-service")
//@AllArgsConstructor
public class JoinsService {

     @PersistenceContext
     private EntityManager entityManager;
    public void whenPathExpressionIsUsedForSingleValuedAssociation_thenCreatesImplicitInnerJoin() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT e.department FROM Employee e", Department.class);
        List<Department> resultList = query.getResultList();
        resultList.stream().forEach(System.out::println);
        log.info("{}", Arrays.toString(resultList.toArray()));

    }


}
