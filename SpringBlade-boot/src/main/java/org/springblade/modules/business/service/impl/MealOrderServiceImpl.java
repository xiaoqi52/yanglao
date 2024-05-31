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
import org.springblade.modules.business.entity.MealOrder;
import org.springblade.modules.business.vo.MealOrderVO;
import org.springblade.modules.business.mapper.MealOrderMapper;
import org.springblade.modules.business.service.IMealOrderService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 点餐表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class MealOrderServiceImpl extends BaseServiceImpl<MealOrderMapper, MealOrder> implements IMealOrderService {

	@Override
	public IPage<MealOrderVO> selectMealOrderPage(IPage<MealOrderVO> page, MealOrderVO mealOrder) {
		return page.setRecords(baseMapper.selectMealOrderPage(page, mealOrder));
	}

	@Override
	public List<Map<String, Object>> getTop10DishOrders() {
		QueryWrapper<MealOrder> queryWrapper = new QueryWrapper<>();
		queryWrapper.select("dish_id", "count(dish_id) as count")
			.groupBy("dish_id")
			.orderByDesc("count")
			.last("limit 10");

		return listMaps(queryWrapper);
	}

}
