package com.zchangzhi.sell.repository;

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
public class StationRepositoryTest {
    @Autowired
    private StationRepository stationRepository;

    @Test
    public void findByOrderId() {
        List<Station> result = stationRepository.findAll();
        for (Station list : result) {
            System.out.println(list.getName());
        }
    }
}