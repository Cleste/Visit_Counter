package com.kirill.pimenov.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "visitor_id")
    private Long visitorId;

    @Column(name = "visit_date")
    private LocalDate date;

    @Column(name = "page_id")
    private Long pageId;
}
