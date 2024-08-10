package com.linsir.auth.modules.dashboard.service.impl;

import com.linsir.auth.modules.dashboard.service.DashboardService;
import com.linsir.modules.dashboard.dto.VisitTrendQuery;
import com.linsir.modules.dashboard.vo.VisitStatsVO;
import com.linsir.modules.dashboard.vo.VisitTrendVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsir
 * @version 1.0.0
 * @title DashboardServiceImpl
 * @description
 * @create 2024/8/9 16:06
 */

@Service
public class DashboardServiceImpl implements DashboardService {
    @Override
    public VisitTrendVO visitTrend(VisitTrendQuery visitTrendQuery) {
        VisitTrendVO visitTrendVO = new VisitTrendVO();

        String[] dates = {"2024-06-30",
                "2024-07-01",
                "2024-07-02",
                "2024-07-03",
                "2024-07-04",
                "2024-07-05",
                "2024-07-06",
                "2024-07-07",};

        int[] pvList = {1751, 5168, 4882, 5301, 4721, 4885, 1901, 1003};

        int[] uvList = null;

        int[] ipList = {207, 566, 565, 631, 579, 496, 222, 152};


        visitTrendVO.setDates(dates);
        visitTrendVO.setPvList(pvList);
        visitTrendVO.setUvList(uvList);
        visitTrendVO.setIpList(ipList);
        return visitTrendVO;
    }

    @Override
    public List<VisitStatsVO> visitStats() {
        List<VisitStatsVO> visitStatsVOList = new ArrayList<>();
        VisitStatsVO visitStatsVO1 = new VisitStatsVO("访客数","uv",100,2000,10,3000);
        VisitStatsVO visitStatsVO2 = new VisitStatsVO("IP数","ip",152,3234,2,3000);
        VisitStatsVO visitStatsVO3 = new VisitStatsVO("浏览量","pv",1003,36193,10,36193);
        visitStatsVOList.add(visitStatsVO1);
        visitStatsVOList.add(visitStatsVO2);
        visitStatsVOList.add(visitStatsVO3);
        return visitStatsVOList;
    }


}
