package com.zchangzhi.sell.service.Impl;

import com.zchangzhi.sell.dataobject.Report;
import com.zchangzhi.sell.repository.ReportRepository;
import com.zchangzhi.sell.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportRepository reportRepository;

    /*@Override
    public List<Report> findByIdIn(List<Integer> idList) {
        return null;
    }*/

    @Override
    public List<Report> findAll() {
        List<Report> all = reportRepository.findAll();
        return all;
    }
}
