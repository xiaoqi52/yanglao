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
import org.springblade.modules.business.entity.MealOrder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.RepairRequest;
import org.springblade.modules.business.vo.RepairRequestVO;
import org.springblade.modules.business.wrapper.RepairRequestWrapper;
import org.springblade.modules.business.service.IRepairRequestService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 报修表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/repairrequest/repairrequest")
@Tag(name = "报修表", description = "报修表接口")
public class RepairRequestController extends BladeController {

	private IRepairRequestService repairRequestService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入repairRequest")
	public R<RepairRequestVO> detail(RepairRequest repairRequest) {
		RepairRequest detail = repairRequestService.getOne(Condition.getQueryWrapper(repairRequest));
		return R.data(RepairRequestWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 报修表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入repairRequest")
	public R<IPage<RepairRequestVO>> list(RepairRequest repairRequest, Query query) {
		IPage<RepairRequest> pages = repairRequestService.page(Condition.getPage(query), Condition.getQueryWrapper(repairRequest));
		return R.data(RepairRequestWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 报修表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入repairRequest")
	public R<IPage<RepairRequestVO>> page(RepairRequestVO repairRequest, Query query) {
		IPage<RepairRequestVO> pages = repairRequestService.selectRepairRequestPage(Condition.getPage(query), repairRequest);
		return R.data(pages);
	}

	/**
	 * 新增 报修表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入repairRequest")
	public R save(@Valid @RequestBody RepairRequest repairRequest) {
		return R.status(repairRequestService.save(repairRequest));
	}

	/**
	 * 修改 报修表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入repairRequest")
	public R update(@Valid @RequestBody RepairRequest repairRequest) {
		return R.status(repairRequestService.updateById(repairRequest));
	}

	/**
	 * 新增或修改 报修表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入repairRequest")
	public R submit(@Valid @RequestBody RepairRequest repairRequest) {
		repairRequest.setRepairStatus("0");
		return R.status(repairRequestService.saveOrUpdate(repairRequest));
	}


	/**
	 * 删除 报修表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(repairRequestService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 审批 报修表
	 */
	@PostMapping("/approval")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "审批", description = "传入ids")
	public R approval(@Parameter(name = "主键集合", required = true) @RequestParam String ids,
					  @Parameter(name = "状态", required = true) @RequestParam Integer status) {
		List<Long> idList = Func.toLongList(ids);
		return R.status(repairRequestService.lambdaUpdate().set(RepairRequest::getStatus, status)
				.in(RepairRequest::getId, idList).update());
	}


}
