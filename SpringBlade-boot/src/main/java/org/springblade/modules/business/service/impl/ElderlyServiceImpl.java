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
import org.springblade.modules.business.entity.Elderly;
import org.springblade.modules.business.vo.ElderlyVO;
import org.springblade.modules.business.mapper.ElderlyMapper;
import org.springblade.modules.business.service.IElderlyService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * 老人表 服务实现类
 *
 * @author Blade
 * @since 2024-05-22
 */
@Service
public class ElderlyServiceImpl extends BaseServiceImpl<ElderlyMapper, Elderly> implements IElderlyService {

	@Override
	public IPage<ElderlyVO> selectElderlyPage(IPage<ElderlyVO> page, ElderlyVO elderly) {
		return page.setRecords(baseMapper.selectElderlyPage(page, elderly));
	}

	@Override
	public List<Map<String, Object>> countByAgeGroups() {
		LocalDate now = LocalDate.now();

		// Calculate the date range for each age group
		LocalDate date60 = now.minus(60, ChronoUnit.YEARS);
		LocalDate date70 = now.minus(70, ChronoUnit.YEARS);
		LocalDate date80 = now.minus(80, ChronoUnit.YEARS);
		LocalDate date90 = now.minus(90, ChronoUnit.YEARS);

		// Query each age group
		Long count60to70 = count(new QueryWrapper<Elderly>().ge("birth_date", date70).lt("birth_date", date60));
		Long count70to80 = count(new QueryWrapper<Elderly>().ge("birth_date", date80).lt("birth_date", date70));
		Long count80to90 = count(new QueryWrapper<Elderly>().ge("birth_date", date90).lt("birth_date", date80));
		Long count90plus = count(new QueryWrapper<Elderly>().lt("birth_date", date90));

		// Prepare the result map
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> data3 = new LinkedHashMap<>(2);
		data3.put("name","90岁以上");
		data3.put("value",count90plus);
		result.add(data3);
		Map<String, Object> data2 = new LinkedHashMap<>(2);
		data2.put("name","80-90岁");
		data2.put("value",count80to90);
		result.add(data2);
		Map<String, Object> data1 = new LinkedHashMap<>(2);
		data1.put("name","70-80岁");
		data1.put("value",count70to80);
		result.add(data1);
		Map<String, Object> data = new LinkedHashMap<>(2);
        data.put("name","60-70岁");
		data.put("value",count60to70);
		result.add(data);



		return result;
	}

}
