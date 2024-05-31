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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.HealthMonitoring;
import org.springblade.modules.business.vo.HealthMonitoringVO;
import org.springblade.modules.business.wrapper.HealthMonitoringWrapper;
import org.springblade.modules.business.service.IHealthMonitoringService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 健康监测表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/healthmonitoring/healthmonitoring")
@Tag(name = "健康监测表", description = "健康监测表接口")
public class HealthMonitoringController extends BladeController {

	private IHealthMonitoringService healthMonitoringService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入healthMonitoring")
	public R<HealthMonitoringVO> detail(HealthMonitoring healthMonitoring) {
		HealthMonitoring detail = healthMonitoringService.getOne(Condition.getQueryWrapper(healthMonitoring));
		return R.data(HealthMonitoringWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 健康监测表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入healthMonitoring")
	public R<IPage<HealthMonitoringVO>> list(HealthMonitoring healthMonitoring, Query query) {
		IPage<HealthMonitoring> pages = healthMonitoringService.page(Condition.getPage(query), Condition.getQueryWrapper(healthMonitoring));
		return R.data(HealthMonitoringWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 健康监测表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入healthMonitoring")
	public R<IPage<HealthMonitoringVO>> page(HealthMonitoringVO healthMonitoring, Query query) {
		IPage<HealthMonitoringVO> pages = healthMonitoringService.selectHealthMonitoringPage(Condition.getPage(query), healthMonitoring);
		return R.data(pages);
	}

	/**
	 * 新增 健康监测表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入healthMonitoring")
	public R save(@Valid @RequestBody HealthMonitoring healthMonitoring) {
		return R.status(healthMonitoringService.save(healthMonitoring));
	}

	/**
	 * 修改 健康监测表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入healthMonitoring")
	public R update(@Valid @RequestBody HealthMonitoring healthMonitoring) {
		return R.status(healthMonitoringService.updateById(healthMonitoring));
	}

	/**
	 * 新增或修改 健康监测表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入healthMonitoring")
	public R submit(@Valid @RequestBody HealthMonitoring healthMonitoring) {
		return R.status(healthMonitoringService.saveOrUpdate(healthMonitoring));
	}


	/**
	 * 删除 健康监测表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(healthMonitoringService.deleteLogic(Func.toLongList(ids)));
	}


}
