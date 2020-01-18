package com.kirill.pimenov.services.imlementations;

import com.kirill.pimenov.domain.Visit;
import com.kirill.pimenov.domain.VisitStats;
import com.kirill.pimenov.domain.VisitStatsWithRegular;
import com.kirill.pimenov.repositories.VisitRepository;
import com.kirill.pimenov.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    VisitRepository visitRepository;

    @Override
    public Long countAllByDate(LocalDate date) {
        return visitRepository.countAllByDate(date);
    }

    @Override
    public ResponseEntity<?> save(Long pageId, Long visitorId) {
        Visit newVisit = new Visit();
        newVisit.setDate(LocalDate.now());
        newVisit.setPage(pageId);
        newVisit.setVisitorId(visitorId);
        visitRepository.save(newVisit);
        VisitStats visitStats = new VisitStats();
        visitStats.setTotalVisitors(visitRepository.countAllByDate(LocalDate.now()));
        visitStats.setUniqVisitors(visitRepository.countVisitorIdDistinctByDate(LocalDate.now()));
        return ResponseEntity.ok().body(visitStats);
    }

    @Override
    public ResponseEntity<?> save(Long pageId, Long visitorId, LocalDate localDate) {
        Visit newVisit = new Visit();
        newVisit.setDate(localDate);
        newVisit.setPage(pageId);
        newVisit.setVisitorId(visitorId);
        visitRepository.save(newVisit);
        VisitStats visitStats = new VisitStats();
        visitStats.setTotalVisitors(visitRepository.countAllByDate(LocalDate.now()));
        visitStats.setUniqVisitors(visitRepository.countVisitorIdDistinctByDate(LocalDate.now()));
        return ResponseEntity.ok().body(visitStats);
    }

    @Override
    public ResponseEntity<?> getVisitStatsForPeriod(LocalDate dateFrom, LocalDate dateTo) {
        VisitStatsWithRegular visitStats = new VisitStatsWithRegular();
        visitStats.setTotalVisitors(visitRepository.countAllByDateBetween(dateFrom, dateTo));
        visitStats.setUniqVisitors(visitRepository.countVisitorIdDistinctInRange(dateFrom, dateTo));
        Set<Long> visitorsInRange = visitRepository.countRegularVisitorsInRange(dateFrom, dateTo);
        long regularVisitorCounter = 0;
        for (Long visitorId: visitorsInRange){
            if(visitRepository.countPages(visitorId, dateFrom, dateTo) >= 10)
                regularVisitorCounter++;
        }
        visitStats.setRegularVisitors(regularVisitorCounter);
        return ResponseEntity.ok().body(visitStats);
    }
}
