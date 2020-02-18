package com.dsunsoft.module.business.dao;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.business.entity.Device;

public interface DeviceMapper extends BaseMapper<Device, String>{

    Integer getDeviceCount(Device device);

}
