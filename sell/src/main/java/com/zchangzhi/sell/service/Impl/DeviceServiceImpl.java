package com.zchangzhi.sell.service.Impl;

import com.zchangzhi.sell.converter.Station2BdzDTOConverter;
import com.zchangzhi.sell.dataobject.Device;
import com.zchangzhi.sell.dataobject.Station;
import com.zchangzhi.sell.dto.BdzDTO;
import com.zchangzhi.sell.repository.DeviceRepository;
import com.zchangzhi.sell.repository.StationRepository;
import com.zchangzhi.sell.service.DeviceService;
import com.zchangzhi.sell.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findByIdIn(List<Integer> ideList) {
        return deviceRepository.findByIdIn(ideList);
    }

    @Override
    public List<Device> findAll() {
        List<Device> all = deviceRepository.findAll();
        return all;
    }
}
