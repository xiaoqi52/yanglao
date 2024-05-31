/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.business.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

import org.springblade.core.log.exception.ServiceException;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.business.entity.Medicine;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.Dish;
import org.springblade.modules.business.vo.DishVO;
import org.springblade.modules.business.wrapper.DishWrapper;
import org.springblade.modules.business.service.IDishService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.*;

/**
 * 菜品表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dish/dish")
@Tag(name = "菜品表", description = "菜品表接口")
public class DishController extends BladeController {

	private IDishService dishService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入dish")
	public R<DishVO> detail(Dish dish) {
		Dish detail = dishService.getOne(Condition.getQueryWrapper(dish));
		return R.data(DishWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 菜品表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入dish")
	public R<IPage<DishVO>> list(Dish dish, Query query) {
		IPage<Dish> pages = dishService.page(Condition.getPage(query), Condition.getQueryWrapper(dish));
		return R.data(DishWrapper.build().pageVO(pages));
	}

	/**
	 * 查询所有菜品
	 */
	@GetMapping("/getAll")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入dish")
	public R<List<Map<String, Object>> > getAll() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (Dish dish : dishService.list()) {
			Map<String, Object> map = new LinkedHashMap<>(2);
			map.put("label", dish.getName());
			map.put("value", dish.getId());
			list.add(map);
		}
		return R.data(list);
	}


	/**
	 * 自定义分页 菜品表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入dish")
	public R<IPage<DishVO>> page(DishVO dish, Query query) {
		IPage<DishVO> pages = dishService.selectDishPage(Condition.getPage(query), dish);
		return R.data(pages);
	}

	/**
	 * 新增 菜品表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入dish")
	public R save(@Valid @RequestBody Dish dish) {
		return R.status(dishService.save(dish));
	}

	/**
	 * 修改 菜品表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入dish")
	public R update(@Valid @RequestBody Dish dish) {
		return R.status(dishService.updateById(dish));
	}

	/**
	 * 新增或修改 菜品表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入dish")
	public R submit(@Valid @RequestBody Dish dish) {
		if (Objects.isNull(dish.getId())){
			Long count = dishService.lambdaQuery().eq(Dish::getName, dish.getName()).count();
			if (count > 0) {
				throw new ServiceException("当前菜品名称已存在!");
			}
		} else {
			Long count = dishService.lambdaQuery().eq(Dish::getName, dish.getName())
				.ne(Dish::getId, dish.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前菜品名称已存在!");
			}
		}
		return R.status(dishService.saveOrUpdate(dish));
	}


	/**
	 * 删除 菜品表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(dishService.deleteLogic(Func.toLongList(ids)));
	}


}
