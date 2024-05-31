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
import org.springblade.modules.business.entity.Medication;
import org.springblade.modules.business.vo.MedicationVO;
import org.springblade.modules.business.wrapper.MedicationWrapper;
import org.springblade.modules.business.service.IMedicationService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 用药表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/medication/medication")
@Tag(name = "用药表", description = "用药表接口")
public class MedicationController extends BladeController {

	private IMedicationService medicationService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入medication")
	public R<MedicationVO> detail(Medication medication) {
		Medication detail = medicationService.getOne(Condition.getQueryWrapper(medication));
		return R.data(MedicationWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 用药表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入medication")
	public R<IPage<MedicationVO>> list(Medication medication, Query query) {
		IPage<Medication> pages = medicationService.page(Condition.getPage(query), Condition.getQueryWrapper(medication));
		return R.data(MedicationWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 用药表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入medication")
	public R<IPage<MedicationVO>> page(MedicationVO medication, Query query) {
		IPage<MedicationVO> pages = medicationService.selectMedicationPage(Condition.getPage(query), medication);
		return R.data(pages);
	}

	/**
	 * 新增 用药表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入medication")
	public R save(@Valid @RequestBody Medication medication) {
		return R.status(medicationService.save(medication));
	}

	/**
	 * 修改 用药表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入medication")
	public R update(@Valid @RequestBody Medication medication) {
		return R.status(medicationService.updateById(medication));
	}

	/**
	 * 新增或修改 用药表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入medication")
	public R submit(@Valid @RequestBody Medication medication) {
		return R.status(medicationService.saveOrUpdate(medication));
	}


	/**
	 * 删除 用药表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(medicationService.deleteLogic(Func.toLongList(ids)));
	}


}
