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
import org.springblade.modules.business.entity.OutingApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.VisitorLog;
import org.springblade.modules.business.vo.VisitorLogVO;
import org.springblade.modules.business.wrapper.VisitorLogWrapper;
import org.springblade.modules.business.service.IVisitorLogService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.Objects;

/**
 * 来访表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/visitor/visitorlog")
@Tag(name = "来访表", description = "来访表接口")
public class VisitorLogController extends BladeController {

	private IVisitorLogService visitorLogService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入visitorLog")
	public R<VisitorLogVO> detail(VisitorLog visitorLog) {
		VisitorLog detail = visitorLogService.getOne(Condition.getQueryWrapper(visitorLog));
		return R.data(VisitorLogWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 来访表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入visitorLog")
	public R<IPage<VisitorLogVO>> list(VisitorLog visitorLog, Query query) {
		IPage<VisitorLog> pages = visitorLogService.page(Condition.getPage(query), Condition.getQueryWrapper(visitorLog));
		return R.data(VisitorLogWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 来访表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入visitorLog")
	public R<IPage<VisitorLogVO>> page(VisitorLogVO visitorLog, Query query) {
		IPage<VisitorLogVO> pages = visitorLogService.selectVisitorLogPage(Condition.getPage(query), visitorLog);
		return R.data(pages);
	}

	/**
	 * 新增 来访表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入visitorLog")
	public R save(@Valid @RequestBody VisitorLog visitorLog) {
		return R.status(visitorLogService.save(visitorLog));
	}

	/**
	 * 修改 来访表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入visitorLog")
	public R update(@Valid @RequestBody VisitorLog visitorLog) {
		return R.status(visitorLogService.updateById(visitorLog));
	}

	/**
	 * 新增或修改 来访表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入visitorLog")
	public R submit(@Valid @RequestBody VisitorLog visitorLog) {
		if (Objects.isNull(visitorLog.getId())){
			Long count = visitorLogService.lambdaQuery().eq(VisitorLog::getIdNumber, visitorLog.getIdNumber()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		} else {
			Long count = visitorLogService.lambdaQuery().eq(VisitorLog::getIdNumber, visitorLog.getIdNumber())
				.ne(VisitorLog::getId, visitorLog.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		}
		return R.status(visitorLogService.saveOrUpdate(visitorLog));
	}


	/**
	 * 删除 来访表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(visitorLogService.deleteLogic(Func.toLongList(ids)));
	}


}
