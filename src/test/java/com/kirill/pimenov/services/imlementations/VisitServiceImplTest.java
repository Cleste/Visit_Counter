package com.kirill.pimenov.services.imlementations;

import com.kirill.pimenov.domain.Visit;
import com.kirill.pimenov.repositories.VisitRepository;
import com.kirill.pimenov.services.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class VisitServiceImplTest {

    @Autowired
    private VisitService visitService;

    @MockBean
    private VisitRepository visitRepository;
    @Test
    public void save() {
        ResponseEntity<?> responseEntity = visitService.save( (long) 3, (long) 3, null);
        verify(visitRepository, times(1))
                .save(ArgumentMatchers.any(Visit.class));
    }

    @Test
    @Sql(value = {"/testDB/create_visit_before.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/testDB/delete_visit_after.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getVisitStatsForPeriod() {
        LocalDate dateFrom = LocalDate.of(2020, 1, 17);
        LocalDate dateTo = LocalDate.of(2020, 1, 18);
        ResponseEntity<?> responseEntity = visitService.getVisitStatsForPeriod(dateFrom, dateTo);
        assertEquals(200, responseEntity.getStatusCodeValue());
        verify(visitRepository, times(1))
                .countAllByDateBetween(ArgumentMatchers.any(LocalDate.class), ArgumentMatchers.any(LocalDate.class));
    }
}