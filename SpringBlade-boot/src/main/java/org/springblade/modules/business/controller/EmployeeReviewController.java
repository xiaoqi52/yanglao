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
import org.springblade.modules.business.entity.EmployeeReview;
import org.springblade.modules.business.vo.EmployeeReviewVO;
import org.springblade.modules.business.wrapper.EmployeeReviewWrapper;
import org.springblade.modules.business.service.IEmployeeReviewService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 员工评价表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/employeereview/employeereview")
@Tag(name = "员工评价表", description = "员工评价表接口")
public class EmployeeReviewController extends BladeController {

	private IEmployeeReviewService employeeReviewService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入employeeReview")
	public R<EmployeeReviewVO> detail(EmployeeReview employeeReview) {
		EmployeeReview detail = employeeReviewService.getOne(Condition.getQueryWrapper(employeeReview));
		return R.data(EmployeeReviewWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 员工评价表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入employeeReview")
	public R<IPage<EmployeeReviewVO>> list(EmployeeReview employeeReview, Query query) {
		IPage<EmployeeReview> pages = employeeReviewService.page(Condition.getPage(query), Condition.getQueryWrapper(employeeReview));
		return R.data(EmployeeReviewWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 员工评价表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入employeeReview")
	public R<IPage<EmployeeReviewVO>> page(EmployeeReviewVO employeeReview, Query query) {
		IPage<EmployeeReviewVO> pages = employeeReviewService.selectEmployeeReviewPage(Condition.getPage(query), employeeReview);
		return R.data(pages);
	}

	/**
	 * 新增 员工评价表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入employeeReview")
	public R save(@Valid @RequestBody EmployeeReview employeeReview) {
		return R.status(employeeReviewService.save(employeeReview));
	}

	/**
	 * 修改 员工评价表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入employeeReview")
	public R update(@Valid @RequestBody EmployeeReview employeeReview) {
		return R.status(employeeReviewService.updateById(employeeReview));
	}

	/**
	 * 新增或修改 员工评价表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入employeeReview")
	public R submit(@Valid @RequestBody EmployeeReview employeeReview) {
		return R.status(employeeReviewService.saveOrUpdate(employeeReview));
	}


	/**
	 * 删除 员工评价表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(employeeReviewService.deleteLogic(Func.toLongList(ids)));
	}


}
