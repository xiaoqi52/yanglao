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
import org.springblade.modules.business.entity.PaymentRecord;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.OutingApplication;
import org.springblade.modules.business.vo.OutingApplicationVO;
import org.springblade.modules.business.wrapper.OutingApplicationWrapper;
import org.springblade.modules.business.service.IOutingApplicationService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;
import java.util.Objects;

/**
 * 外出申请表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/outing/outingapplication")
@Tag(name = "外出申请表", description = "外出申请表接口")
public class OutingApplicationController extends BladeController {

	private IOutingApplicationService outingApplicationService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入outingApplication")
	public R<OutingApplicationVO> detail(OutingApplication outingApplication) {
		OutingApplication detail = outingApplicationService.getOne(Condition.getQueryWrapper(outingApplication));
		return R.data(OutingApplicationWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 外出申请表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入outingApplication")
	public R<IPage<OutingApplicationVO>> list(OutingApplication outingApplication, Query query) {
		IPage<OutingApplication> pages = outingApplicationService.page(Condition.getPage(query), Condition.getQueryWrapper(outingApplication));
		return R.data(OutingApplicationWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 外出申请表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入outingApplication")
	public R<IPage<OutingApplicationVO>> page(OutingApplicationVO outingApplication, Query query) {
		IPage<OutingApplicationVO> pages = outingApplicationService.selectOutingApplicationPage(Condition.getPage(query), outingApplication);
		return R.data(pages);
	}

	/**
	 * 新增 外出申请表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入outingApplication")
	public R save(@Valid @RequestBody OutingApplication outingApplication) {
		return R.status(outingApplicationService.save(outingApplication));
	}

	/**
	 * 修改 外出申请表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入outingApplication")
	public R update(@Valid @RequestBody OutingApplication outingApplication) {
		return R.status(outingApplicationService.updateById(outingApplication));
	}

	/**
	 * 新增或修改 外出申请表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入outingApplication")
	public R submit(@Valid @RequestBody OutingApplication outingApplication) {
		if (Objects.isNull(outingApplication.getId())){
			Long count = outingApplicationService.lambdaQuery().eq(OutingApplication::getIdNumber, outingApplication.getIdNumber()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		} else {
			Long count = outingApplicationService.lambdaQuery().eq(OutingApplication::getIdNumber, outingApplication.getIdNumber())
				.ne(OutingApplication::getId, outingApplication.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		}
		outingApplication.setStatus(0);
		return R.status(outingApplicationService.saveOrUpdate(outingApplication));
	}


	/**
	 * 删除 外出申请表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(outingApplicationService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 审批 外出申请表
	 */
	@PostMapping("/approval")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "审批", description = "传入ids")
	public R approval(@Parameter(name = "主键集合", required = true) @RequestParam String ids,
					@Parameter(name = "状态", required = true) @RequestParam Integer status) {
		List<Long> idList = Func.toLongList(ids);
		return R.status(outingApplicationService.lambdaUpdate().set(OutingApplication::getStatus, status)
				.in(OutingApplication::getId, idList).update());
	}


}
