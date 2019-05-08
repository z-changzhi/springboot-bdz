package com.zchangzhi.sell.repository;


import com.zchangzhi.sell.dataobject.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,String>{
    List<Report> findByIdIn(List<Integer> idList);
}
