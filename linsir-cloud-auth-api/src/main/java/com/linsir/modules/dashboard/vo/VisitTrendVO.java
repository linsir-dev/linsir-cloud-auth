package com.linsir.modules.dashboard.vo;

import lombok.Data;

/**
 * @author linsir
 * @version 1.0.0
 * @title VisitTrendVO
 * @description
 * @create 2024/8/9 16:23
 */

@Data
public class VisitTrendVO {

    private String[] dates;

    private int[] pvList;

    private int[] uvList;

    private int[] ipList;
}
