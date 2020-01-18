package com.kirill.pimenov.controllers;


import com.kirill.pimenov.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/visit")
public class VisitController  {

    @Autowired
    VisitService visitService;

    @GetMapping
    public ResponseEntity<?> visitStats(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo
    ){
        return visitService.getVisitStatsForPeriod(dateFrom, dateTo);
    }

    @PostMapping
    public ResponseEntity<?> addVisit(
            @RequestParam Long pageId,
            @RequestParam Long visitorId
    ){
        return visitService.save(pageId, visitorId, null);
    }

    @PostMapping("/withDate")
    public ResponseEntity<?> addVisitWithDate(
            @RequestParam Long pageId,
            @RequestParam Long visitorId,
             @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate
    ){
        return  visitService.save(pageId, visitorId, localDate);
    }
}
