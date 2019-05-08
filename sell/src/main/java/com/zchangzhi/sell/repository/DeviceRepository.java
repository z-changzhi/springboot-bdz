package com.zchangzhi.sell.repository;


import com.zchangzhi.sell.dataobject.Device;
import com.zchangzhi.sell.dataobject.Report;
import com.zchangzhi.sell.dataobject.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,String>{
    List<Device> findByIdIn(List<Integer> idList);
}