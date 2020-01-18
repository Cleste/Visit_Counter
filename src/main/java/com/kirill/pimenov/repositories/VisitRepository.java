package com.kirill.pimenov.repositories;

import com.kirill.pimenov.domain.Visit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
    //count today visitors
    Long countAllByDate(LocalDate date);
    @Query("SELECT COUNT (DISTINCT visit.visitorId) " +
            "from Visit visit where visit.date = :date")
    Long countVisitorIdDistinctByDate(LocalDate date);
    //count visitors in range
    Long countAllByDateBetween(LocalDate dateFrom, LocalDate dateTo);
    @Query("SELECT COUNT (DISTINCT visit.visitorId) " +
            "from Visit visit where visit.date between :dateFrom and :dateTo")
    Long countVisitorIdDistinctInRange(LocalDate dateFrom, LocalDate dateTo);

    @Query("SELECT visit.visitorId " +
            "from  Visit visit where visit.date between :dateFrom and :dateTo ")
    Set<Long> countRegularVisitorsInRange(LocalDate dateFrom, LocalDate dateTo);

    @Query("SELECT COUNT (DISTINCT visit.page) " +
            "from  Visit visit " +
            "where (visit.date between :dateFrom and :dateTo) and visit.visitorId = :visitorId")
    Long countPages(Long visitorId, LocalDate dateFrom, LocalDate dateTo);
}
