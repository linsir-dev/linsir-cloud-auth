package com.linsir.auth.modules.dashboard.controller;

import com.linsir.auth.modules.dashboard.service.DashboardService;
import com.linsir.base.core.controller.BaseController;
import com.linsir.base.core.vo.jsonResults.JsonResult;
import com.linsir.base.core.vo.results.R;
import com.linsir.modules.dashboard.dto.VisitTrendQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linsir
 * @version 1.0.0
 * @title DashboardController
 * @description
 * @create 2024/8/9 15:33
 */

@RestController
@RequestMapping("/dashboard/")
public class DashboardController extends BaseController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("visitTrend")
    public R visitTrend(VisitTrendQuery visitTrendQuery) throws Exception {
        return exec("访问数量",()->{
           return JsonResult.OK(dashboardService.visitTrend(visitTrendQuery));
        });
    }

    @GetMapping("visitStats")
    public R visitStats() throws Exception {
        return exec("访问状态" ,()->{
            return JsonResult.OK(dashboardService.visitStats());
        });
    }
}
