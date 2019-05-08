package com.zchangzhi.sell.controller;

import com.zchangzhi.sell.VO.*;
import com.zchangzhi.sell.dataobject.Device;
import com.zchangzhi.sell.dataobject.Report;
import com.zchangzhi.sell.dataobject.Station;
import com.zchangzhi.sell.service.DeviceService;
import com.zchangzhi.sell.service.ReportService;
import com.zchangzhi.sell.service.StationService;
import com.zchangzhi.sell.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/region/bdz")
public class RegionBdzController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private DeviceService deviceService;
    //private ProductService productService;

    @Autowired
    private StationService stationService;
    //private CategoryService categoryService;



    @GetMapping("/list")
    public ResultVO list() {
        List<Device> deviceInfoList = deviceService.findAll();// 找到所有的设备
        List<Integer> idList = deviceInfoList.stream() // 将它所有变电站的id作为一个列表
                .map(e -> e.getStationId())
                .collect(Collectors.toList());

        List<Report> reportList = reportService.findAll();// 找到所有的详情
        /*List<Integer> reportIdList = reportList.stream() // 将它所有变电站的id作为一个列表
                .map(e -> e.getDeviceId())
                .collect(Collectors.toList());*/

        List<Station> stationList = stationService.findByIdIn(idList);// 拿这个id列表去找我所需要的变电站

       // List<Device> deviceList = deviceService.findByIdIn(reportIdList);// 拿这个设备id列表 去找我们需要的设备



        List<StationVO> stationVOList = new ArrayList<>();
        for (Station station: stationList) {// 遍历所有的类型 添加详情
            // 设备
            StationVO stationVO = new StationVO();
            stationVO.setId(station.getId());
            stationVO.setName(station.getName());
            stationVO.setAddress(station.getAddress());
            stationVO.setRegion(station.getRegion());
            stationVO.setProvince(station.getProvince());
            stationVO.setLon(station.getLon());
            stationVO.setLat(station.getLat());

            List<DeviceVO> deviceVOList = new ArrayList<>();
            for (Device device: deviceInfoList) {
                if (device.getStationId().equals(station.getId())) {
                    DeviceVO deviceVO = new DeviceVO();
                    BeanUtils.copyProperties(device, deviceVO);


                    List<ReportVO> reportVOList = new ArrayList<>();
                    for (Report report: reportList){
                        if (report.getDeviceId().equals(device.getId())) {
                            ReportVO reportVO = new ReportVO();
                            BeanUtils.copyProperties(report, reportVO);
                            reportVOList.add(reportVO);
                        }
                    }
                    deviceVO.setReportsVOList(reportVOList);
                    deviceVOList.add(deviceVO);
                }
            }
            stationVO.setDevicesVOList(deviceVOList);
            stationVOList.add(stationVO);
        }
        return ResultVOUtil.success(stationVOList);
    }
}
