package com.zchangzhi.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Station {
    @Id
    private Integer id;
    /** 变电站id. */
    private String name;
    /** 变电站名称. */
    private String address;
    /** 变电站地址. */
    private String region;
    /** 变电站所在的省. */
    private String province;
    private Integer lon;
    private Integer lat;

}
