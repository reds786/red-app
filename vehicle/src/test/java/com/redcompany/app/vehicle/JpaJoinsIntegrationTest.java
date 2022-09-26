package com.redcompany.app.vehicle;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.redcompany.app.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = true)
@ActiveProfiles("joins")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaJoinsIntegrationTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void whenPathExpressionIsUsedForSingleValuedAssociation_thenCreatesImplicitInnerJoin() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT e.department FROM Employee e", Department.class);

        List<Department> resultList = query.getResultList();

        assertThat(resultList).hasSize(3);
        assertThat(resultList).extracting("name")
                .containsOnly("Infra", "Accounting", "Accounting");
    }

    @Test
    public void whenJoinKeywordIsUsed_thenCreatesExplicitInnerJoin() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Employee e JOIN e.department d", Department.class);

        List<Department> resultList = query.getResultList();

        assertThat(resultList).hasSize(3);
        assertThat(resultList).extracting("name")
                .containsOnly("Infra", "Accounting", "Accounting");
    }

    @Test
    public void whenInnerJoinKeywordIsUsed_thenCreatesExplicitInnerJoin() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Employee e INNER JOIN e.department d", Department.class);

        List<Department> resultList = query.getResultList();

        assertThat(resultList).hasSize(3);
        assertThat(resultList).extracting("id")
                .containsOnly(1L, 2L, 2L);
    }



}
