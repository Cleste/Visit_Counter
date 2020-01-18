package com.kirill.pimenov.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface VisitService {
    Long countAllByDate(LocalDate date);

    ResponseEntity<?> save(Long pageId, Long visitorId);

    ResponseEntity<?> save(Long pageId, Long visitorId, LocalDate localDate);

    ResponseEntity<?> getVisitStatsForPeriod(LocalDate dateFrom, LocalDate dateTo);
}
