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
import org.springblade.modules.business.entity.Dish;
import org.springblade.modules.business.vo.DishVO;
import org.springblade.modules.business.mapper.DishMapper;
import org.springblade.modules.business.service.IDishService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 菜品表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class DishServiceImpl extends BaseServiceImpl<DishMapper, Dish> implements IDishService {

	@Override
	public IPage<DishVO> selectDishPage(IPage<DishVO> page, DishVO dish) {
		return page.setRecords(baseMapper.selectDishPage(page, dish));
	}

	@Override
	public Map<Long, String> getDishNamesByIds(List<Long> dishIds) {
		if (dishIds == null || dishIds.isEmpty()){
			return null;
		}
		QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
		queryWrapper.in("id", dishIds);

		List<Dish> dishes = list(queryWrapper);
		return dishes.stream()
			.collect(Collectors.toMap(Dish::getId, Dish::getName));
	}

}
