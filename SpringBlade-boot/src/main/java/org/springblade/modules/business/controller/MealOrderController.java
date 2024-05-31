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

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.business.entity.Dish;
import org.springblade.modules.business.entity.OutingApplication;
import org.springblade.modules.business.service.IDishService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.MealOrder;
import org.springblade.modules.business.vo.MealOrderVO;
import org.springblade.modules.business.wrapper.MealOrderWrapper;
import org.springblade.modules.business.service.IMealOrderService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 点餐表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/mealorder/mealorder")
@Tag(name = "点餐表", description = "点餐表接口")
public class MealOrderController extends BladeController {

	private IMealOrderService mealOrderService;

	private IDishService dishService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入mealOrder")
	public R<MealOrderVO> detail(MealOrder mealOrder) {
		MealOrder detail = mealOrderService.getOne(Condition.getQueryWrapper(mealOrder));
		return R.data(MealOrderWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 点餐表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入mealOrder")
	public R<IPage<MealOrderVO>> list(MealOrder mealOrder, Query query) {
		IPage<MealOrder> pages = mealOrderService.page(Condition.getPage(query), Condition.getQueryWrapper(mealOrder));
		return R.data(MealOrderWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 点餐表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入mealOrder")
	public R<IPage<MealOrderVO>> page(MealOrderVO mealOrder, Query query) {
		IPage<MealOrderVO> pages = mealOrderService.selectMealOrderPage(Condition.getPage(query), mealOrder);
		return R.data(pages);
	}

	/**
	 * 新增 点餐表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入mealOrder")
	public R save(@Valid @RequestBody MealOrder mealOrder) {
		return R.status(mealOrderService.save(mealOrder));
	}

	/**
	 * 修改 点餐表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入mealOrder")
	public R update(@Valid @RequestBody MealOrder mealOrder) {
		return R.status(mealOrderService.updateById(mealOrder));
	}

	/**
	 * 新增或修改 点餐表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入mealOrder")
	public R submit(@Valid @RequestBody MealOrder mealOrder) {
		mealOrder.setOrderStatus("0");
		return R.status(mealOrderService.saveOrUpdate(mealOrder));
	}


	/**
	 * 删除 点餐表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(mealOrderService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 审批 点餐表
	 */
	@PostMapping("/approval")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "审批", description = "传入ids")
	public R approval(@Parameter(name = "主键集合", required = true) @RequestParam String ids,
					  @Parameter(name = "状态", required = true) @RequestParam Integer status) {
		List<Long> idList = Func.toLongList(ids);
		return R.status(mealOrderService.lambdaUpdate().set(MealOrder::getStatus, status)
				.in(MealOrder::getId, idList).update());
	}

}
