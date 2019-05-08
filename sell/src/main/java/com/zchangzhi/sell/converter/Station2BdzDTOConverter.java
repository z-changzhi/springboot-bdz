package com.zchangzhi.sell.converter;

import com.zchangzhi.sell.dataobject.Station;
import com.zchangzhi.sell.dto.BdzDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Station2BdzDTOConverter {

    public static BdzDTO convert(Station station) {

        BdzDTO bdzDTO = new BdzDTO();
        BeanUtils.copyProperties(station, bdzDTO);
        return bdzDTO;
    }

    public static List<BdzDTO> convert(List<Station> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}