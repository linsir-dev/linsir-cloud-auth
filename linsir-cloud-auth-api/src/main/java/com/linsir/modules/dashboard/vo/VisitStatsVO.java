package com.linsir.modules.dashboard.vo;

import lombok.Data;

/**
 * @author linsir
 * @version 1.0.0
 * @title VisitStatsVO
 * @description
 * @create 2024/8/9 16:00
 */

@Data
public class VisitStatsVO {

    private String title;

    private String type;

    private int todayCount;

    private int totalCount;

    private int growthRate;

    private int totalCountOutput;

    public VisitStatsVO(String title, String type, int todayCount, int totalCount, int growthRate, int totalCountOutput) {
        this.title = title;
        this.type = type;
        this.todayCount = todayCount;
        this.totalCount = totalCount;
        this.growthRate = growthRate;
        this.totalCountOutput = totalCountOutput;
    }
}
