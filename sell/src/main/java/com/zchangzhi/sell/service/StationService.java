package com.zchangzhi.sell.service;

import com.zchangzhi.sell.dataobject.Station;
import com.zchangzhi.sell.dto.BdzDTO;

import java.util.List;

public interface StationService {
    List<Station> findByIdIn(List<Integer> ideList);
    /** 查询变电站列表. */
    List<BdzDTO> findAll();

}
