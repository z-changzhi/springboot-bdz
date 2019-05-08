package com.zchangzhi.sell.repository;


import com.zchangzhi.sell.dataobject.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,String>{
    List<Station> findByIdIn(List<Integer> idList);
}
