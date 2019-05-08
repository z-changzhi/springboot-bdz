package com.zchangzhi.sell.service;



import com.zchangzhi.sell.dataobject.Report;

import java.util.List;

public interface ReportService {
    //List<Report> findByIdIn(List<Integer> idList);
    /** 查询变电站列表. */
    List<Report> findAll();

}
