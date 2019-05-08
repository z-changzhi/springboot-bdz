package com.zchangzhi.sell.repository;

import com.zchangzhi.sell.dataobject.Device;
import com.zchangzhi.sell.dataobject.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceRepositoryTest {
    @Autowired
    private DeviceRepository deviceRepository;
    @Test
    public void findById() {
        List<Device> result = deviceRepository.findAll();
        for (Device list : result) {
            System.out.println(list.getId());
        }
    }
}