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
import org.springblade.modules.business.entity.EmployeeReview;
import org.springblade.modules.business.vo.EmployeeReviewVO;
import org.springblade.modules.business.mapper.EmployeeReviewMapper;
import org.springblade.modules.business.service.IEmployeeReviewService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.*;

/**
 * 员工评价表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class EmployeeReviewServiceImpl extends BaseServiceImpl<EmployeeReviewMapper, EmployeeReview> implements IEmployeeReviewService {

	@Override
	public IPage<EmployeeReviewVO> selectEmployeeReviewPage(IPage<EmployeeReviewVO> page, EmployeeReviewVO employeeReview) {
		return page.setRecords(baseMapper.selectEmployeeReviewPage(page, employeeReview));
	}

	@Override
	public List<Map<String, Object>> countByScoreGroups() {


		Long count1to2 = count(new QueryWrapper<EmployeeReview>().ge("score", 1).le("score", 2));
		Long count3to4 = count(new QueryWrapper<EmployeeReview>().ge("score", 3).le("score", 4));
		Long count5to6 = count(new QueryWrapper<EmployeeReview>().ge("score", 5).le("score", 6));
		Long count7to8 = count(new QueryWrapper<EmployeeReview>().ge("score", 7).le("score", 8));
		Long count9to10 = count(new QueryWrapper<EmployeeReview>().ge("score", 9).le("score", 10));

		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> data4 = new LinkedHashMap<>(2);
		data4.put("name","9-10分");
		data4.put("value",count9to10);
		result.add(data4);
		Map<String, Object> data3 = new LinkedHashMap<>(2);
		data3.put("name","7-8分");
		data3.put("value",count7to8);
		result.add(data3);
		Map<String, Object> data2 = new LinkedHashMap<>(2);
		data2.put("name","5-6分");
		data2.put("value",count5to6);
		result.add(data2);
		Map<String, Object> data1 = new LinkedHashMap<>(2);
		data1.put("name","3-4分");
		data1.put("value",count3to4);
		result.add(data1);
		Map<String, Object> data = new LinkedHashMap<>(2);
		data.put("name","1-2分");
		data.put("value",count1to2);
		result.add(data);

		return result;
	}

}
