package com.zchangzhi.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zchangzhi.sell.dataobject.Device;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-06-11 18:30
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BdzDTO {

    private Integer id;
    /** 变电站id. */
    private String name;
    /** 变电站名称. */
    private String address;
    /** 变电站地址. */
    private String province;
    /** 变电站所在的省. */
    private String region;

    List<Device> deviceList;
    /*
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }*/
}
