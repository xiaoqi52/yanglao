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

import lombok.extern.slf4j.Slf4j;
import org.springblade.core.log.exception.ServiceException;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.business.entity.PaymentRecord;
import org.springblade.modules.system.entity.User;
import org.springblade.modules.system.service.IUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.Elderly;
import org.springblade.modules.business.vo.ElderlyVO;
import org.springblade.modules.business.wrapper.ElderlyWrapper;
import org.springblade.modules.business.service.IElderlyService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.Objects;

/**
 * 老人表 控制器
 *
 * @author Blade
 * @since 2024-05-22
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/elderly/elderly")
@Tag(name = "老人表", description = "老人表接口")
public class ElderlyController extends BladeController {

	private IElderlyService elderlyService;

	private IUserService userService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入elderly")
	public R<ElderlyVO> detail(Elderly elderly) {
		Elderly detail = elderlyService.getOne(Condition.getQueryWrapper(elderly));
		return R.data(ElderlyWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 老人表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入elderly")
	public R<IPage<ElderlyVO>> list(Elderly elderly, Query query) {
		IPage<Elderly> pages = elderlyService.page(Condition.getPage(query), Condition.getQueryWrapper(elderly));

		return R.data(ElderlyWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 老人表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入elderly")
	public R<IPage<ElderlyVO>> page(ElderlyVO elderly, Query query) {
		IPage<ElderlyVO> pages = elderlyService.selectElderlyPage(Condition.getPage(query), elderly);
		return R.data(pages);
	}

	/**
	 * 新增 老人表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入elderly")
	public R save(@Valid @RequestBody Elderly elderly) {
		return R.status(elderlyService.save(elderly));
	}

	/**
	 * 修改 老人表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入elderly")
	public R update(@Valid @RequestBody Elderly elderly) {
		return R.status(elderlyService.updateById(elderly));
	}

	/**
	 * 新增或修改 老人表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入elderly")
	public R submit(@Valid @RequestBody Elderly elderly) {
		if(Objects.isNull(elderly.getId())) {
			Long count = elderlyService.lambdaQuery().eq(Elderly::getIdNumber, elderly.getIdNumber()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
			User user = new User();
			user.setAccount(elderly.getUsername());
			user.setPassword(elderly.getPassword());
			user.setRoleId(String.valueOf(1793838450638680066L));
			user.setDeptId(String.valueOf(1123598813738675203L));
			user.setRealName("老人");
			user.setName(elderly.getName());
			user.setRealName(elderly.getName());
			userService.submit(user);
		} else {
			Long count = elderlyService.lambdaQuery().eq(Elderly::getIdNumber, elderly.getIdNumber())
				.ne(Elderly::getId, elderly.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		}
		return R.status(elderlyService.saveOrUpdate(elderly));
	}


	/**
	 * 删除 老人表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(elderlyService.deleteLogic(Func.toLongList(ids)));
	}


}
