package com.zchangzhi.sell.service.Impl;

import com.zchangzhi.sell.dataobject.Device;
import com.zchangzhi.sell.dto.BdzDTO;
import com.zchangzhi.sell.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DeviceServiceImplTest {
    @Autowired
    private DeviceServiceImpl deviceService;

    @Test
    public void findAll() {
        List<Device> all = deviceService.findAll();
        for (Device list : all) {
            System.out.println(list.getId());
        }
    }
}