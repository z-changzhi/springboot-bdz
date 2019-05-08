package com.zchangzhi.sell.service.Impl;

import com.zchangzhi.sell.converter.Station2BdzDTOConverter;

import com.zchangzhi.sell.dataobject.Station;
import com.zchangzhi.sell.dto.BdzDTO;

import com.zchangzhi.sell.repository.StationRepository;

import com.zchangzhi.sell.service.StationService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StationServiceImpl implements StationService {
    @Autowired
    private StationRepository stationRepository;


    @Override
    public List<Station> findByIdIn(List<Integer> ideList) {
        return stationRepository.findByIdIn(ideList);
    }

    @Override
    public List<BdzDTO> findAll() {
        List<Station> result = stationRepository.findAll();
        // 查到了没有东西也没有错
        // 将Page<OrderMaster> 转成 Page<OrderDTO>
        List<BdzDTO> BdzDTOList = Station2BdzDTOConverter.convert(result);
        return BdzDTOList;
    }
}
