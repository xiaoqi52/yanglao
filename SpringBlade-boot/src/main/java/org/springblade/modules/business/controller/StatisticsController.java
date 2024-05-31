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
package org.springblade.modules.business.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.tool.api.R;
import org.springblade.modules.business.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统计
 *
 * @author Blade
 * @since 2024-05-27 09:52
 */
@RestController
@AllArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController extends BladeController {

	private IElderlyService elderlyService;

	private IHealthMonitoringService healthMonitoringService;

	private IPaymentRecordService paymentRecordService;

	private IRoomService roomService;

	private IEmployeeReviewService employeeReviewService;

	private IMealOrderService mealOrderService;

	private IDishService dishService;

	/**
	 * 人员统计类
	 */
	@GetMapping("/personnel")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "人员统计类")
	public R<List<Map<String, Object>>> personnel() {
		List<Map<String, Object>> data = elderlyService.countByAgeGroups();
		return R.data(data);
	}

	/**
	 * 健康类：身高
	 */
	@GetMapping("/health/height")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "健康类：身高")
	public R<List<Map<String, Object>>> healthHeight() {
		List<Map<String, Object>> data = healthMonitoringService.countByHeightGroups();
		return R.data(data);
	}

	/**
	 * 健康类：体重
	 */
	@GetMapping("/health/weight")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "健康类：体重")
	public R<List<Map<String, Object>>> healthWeight() {
		List<Map<String, Object>>data = healthMonitoringService.countByWeightGroups();
		return R.data(data);
	}

	/**
	 * 点餐类
	 */
	@GetMapping("/catering")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "点餐类")
	public R<List<Map<String, Object>>> catering() {
		List<Map<String, Object>> top10DishOrders = mealOrderService.getTop10DishOrders();
		List<Long> top10DishIds = top10DishOrders.stream()
			.map(order -> (Long) order.get("dish_id"))
			.collect(Collectors.toList());
		Map<Long, String> dishNames = dishService.getDishNamesByIds(top10DishIds);

		// Prepare the result list
		List<Map<String, Object>> result = new ArrayList<>();
		for (Map<String, Object> order : top10DishOrders) {
			Map<String, Object> item = new HashMap<>();
			item.put("name", dishNames.get((Long) order.get("dish_id")));
			item.put("value", order.get("count"));
			result.add(item);
		}

		return R.data(result);
	}

	/**
	 * 评价类
	 */
	@GetMapping("/evaluate")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "评价类")
	public R<List<Map<String, Object>>> evaluate() {
		List<Map<String, Object>> data = employeeReviewService.countByScoreGroups();
		return R.data(data);
	}

	/**
	 * 房间类
	 */
	@GetMapping("/room")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "房间类")
	public R<List<Map<String, Object>>> room() {
		List<Map<String, Object>> data = roomService.countByBedCountGroups();
		return R.data(data);
	}

	/**
	 * 收费类：最近7天
	 */
	@GetMapping("/charge/lastSevenDay")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "收费类：最近7天")
	public R<Map<String, List<Object>>> chargeLastSevenDay() {
		Map<String, List<Object>> data = paymentRecordService.getChargeLastSevenDays();
		return R.data(data);
	}

	/**
	 * 收费类：最近6个月
	 */
	@GetMapping("/charge/lastSixMonths")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "收费类：最近6个月")
	public R<Map<String, List<Object>>> lastSixMonths() {
		Map<String, List<Object>> data = paymentRecordService.getChargeLastSixMonths();
		return R.data(data);
	}

}
