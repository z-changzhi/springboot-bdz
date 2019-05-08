package com.zchangzhi.sell.service.Impl;

import com.zchangzhi.sell.dto.BdzDTO;
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
public class StationServiceImplTest {
    @Autowired
    private StationServiceImpl stationService;
    @Test
    public void findAll() {
        List<BdzDTO> all = stationService.findAll();
        for (BdzDTO list : all) {
            System.out.println(list.getName());
        }
    }
}