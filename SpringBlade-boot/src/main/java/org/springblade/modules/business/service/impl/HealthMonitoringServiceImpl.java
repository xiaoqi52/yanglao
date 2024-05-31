/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springblade.modules.business.entity.HealthMonitoring;
import org.springblade.modules.business.vo.HealthMonitoringVO;
import org.springblade.modules.business.mapper.HealthMonitoringMapper;
import org.springblade.modules.business.service.IHealthMonitoringService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.*;

/**
 * 健康监测表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class HealthMonitoringServiceImpl extends BaseServiceImpl<HealthMonitoringMapper, HealthMonitoring> implements IHealthMonitoringService {

	@Override
	public IPage<HealthMonitoringVO> selectHealthMonitoringPage(IPage<HealthMonitoringVO> page, HealthMonitoringVO healthMonitoring) {
		return page.setRecords(baseMapper.selectHealthMonitoringPage(page, healthMonitoring));
	}

	@Override
	public List<Map<String, Object>> countByHeightGroups() {
		Long count150to160 = count(new QueryWrapper<HealthMonitoring>().ge("height", 150).lt("height", 160));
		Long count160to170 = count(new QueryWrapper<HealthMonitoring>().ge("height", 160).lt("height", 170));
		Long count170to180 = count(new QueryWrapper<HealthMonitoring>().ge("height", 170).lt("height", 180));
		Long count180plus = count(new QueryWrapper<HealthMonitoring>().ge("height", 180));

		// Prepare the result map
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> data3 = new LinkedHashMap<>(2);
		data3.put("name","180cm以上");
		data3.put("value",count180plus);
		result.add(data3);
		Map<String, Object> data2 = new LinkedHashMap<>(2);
		data2.put("name","170-180cm");
		data2.put("value",count170to180);
		result.add(data2);
		Map<String, Object> data1 = new LinkedHashMap<>(2);
		data1.put("name","160-170cm");
		data1.put("value",count160to170);
		result.add(data1);
		Map<String, Object> data = new LinkedHashMap<>(2);
		data.put("name","150-160cm");
		data.put("value",count150to160);
		result.add(data);
		return result;
	}

	@Override
	public List<Map<String, Object>> countByWeightGroups() {
		// Query each weight group
		Long count50to60 = count(new QueryWrapper<HealthMonitoring>().ge("weight", 50).lt("weight", 60));
		Long count60to70 = count(new QueryWrapper<HealthMonitoring>().ge("weight", 60).lt("weight", 70));
		Long count70to80 = count(new QueryWrapper<HealthMonitoring>().ge("weight", 70).lt("weight", 80));
		Long count80plus = count(new QueryWrapper<HealthMonitoring>().ge("weight", 80));
		// Prepare the result map
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> data3 = new LinkedHashMap<>(2);
		data3.put("name","80kg以上");
		data3.put("value",count80plus);
		result.add(data3);
		Map<String, Object> data2 = new LinkedHashMap<>(2);
		data2.put("name","70-80kg");
		data2.put("value",count70to80);
		result.add(data2);
		Map<String, Object> data1 = new LinkedHashMap<>(2);
		data1.put("name","60-70kg");
		data1.put("value",count60to70);
		result.add(data1);
		Map<String, Object> data = new LinkedHashMap<>(2);
		data.put("name","50-60kg");
		data.put("value",count50to60);
		result.add(data);
		return result;
	}

}
