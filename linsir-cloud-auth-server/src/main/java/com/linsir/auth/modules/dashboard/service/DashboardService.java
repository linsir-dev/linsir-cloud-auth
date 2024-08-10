package com.linsir.auth.modules.dashboard.service;

import com.linsir.modules.dashboard.dto.VisitTrendQuery;
import com.linsir.modules.dashboard.vo.VisitStatsVO;
import com.linsir.modules.dashboard.vo.VisitTrendVO;

import java.util.List;

/**
 * @author linsir
 * @version 1.0.0
 * @title DashboardService
 * @description
 * @create 2024/8/9 15:59
 */
public interface DashboardService {

    VisitTrendVO visitTrend(VisitTrendQuery visitTrendQuery);

    List<VisitStatsVO> visitStats();
}
