package com.zchangzhi.sell.service;

import com.zchangzhi.sell.dataobject.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findByIdIn(List<Integer> ideList);
    /** 查询变电站列表. */
    List<Device> findAll();

}
