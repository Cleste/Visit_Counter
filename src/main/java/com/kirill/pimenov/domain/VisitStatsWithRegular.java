package com.kirill.pimenov.domain;


import lombok.Data;

@Data
public class VisitStatsWithRegular {
    private Long uniqVisitors;
    private Long totalVisitors;
    private Long regularVisitors;
}
