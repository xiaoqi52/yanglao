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
import org.springblade.modules.business.entity.VisitorLog;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.Medicine;
import org.springblade.modules.business.vo.MedicineVO;
import org.springblade.modules.business.wrapper.MedicineWrapper;
import org.springblade.modules.business.service.IMedicineService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.*;

/**
 * 药品表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/medicine/medicine")
@Tag(name = "药品表", description = "药品表接口")
public class MedicineController extends BladeController {

	private IMedicineService medicineService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入medicine")
	public R<MedicineVO> detail(Medicine medicine) {
		Medicine detail = medicineService.getOne(Condition.getQueryWrapper(medicine));
		return R.data(MedicineWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 药品表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入medicine")
	public R<IPage<MedicineVO>> list(Medicine medicine, Query query) {
		IPage<Medicine> pages = medicineService.page(Condition.getPage(query), Condition.getQueryWrapper(medicine));
		return R.data(MedicineWrapper.build().pageVO(pages));
	}


	/**
	 * 查询所有药品表
	 */
	@GetMapping("/getAll")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入medicine")
	public R<List<Map<String, Object>>> getAll() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (Medicine medicine : medicineService.list()) {
			Map<String, Object> map = new LinkedHashMap<>(2);
			map.put("label", medicine.getMedicineName());
			map.put("value", medicine.getId());
			list.add(map);
		}
		return R.data(list);
	}


	/**
	 * 自定义分页 药品表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入medicine")
	public R<IPage<MedicineVO>> page(MedicineVO medicine, Query query) {
		IPage<MedicineVO> pages = medicineService.selectMedicinePage(Condition.getPage(query), medicine);
		return R.data(pages);
	}

	/**
	 * 新增 药品表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入medicine")
	public R save(@Valid @RequestBody Medicine medicine) {
		return R.status(medicineService.save(medicine));
	}

	/**
	 * 修改 药品表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入medicine")
	public R update(@Valid @RequestBody Medicine medicine) {
		return R.status(medicineService.updateById(medicine));
	}

	/**
	 * 新增或修改 药品表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入medicine")
	public R submit(@Valid @RequestBody Medicine medicine) {
		if (Objects.isNull(medicine.getId())){
			Long count = medicineService.lambdaQuery().eq(Medicine::getMedicineName, medicine.getMedicineName()).count();
			if (count > 0) {
				throw new ServiceException("当前药品名称已存在!");
			}
		} else {
			Long count = medicineService.lambdaQuery().eq(Medicine::getMedicineName, medicine.getMedicineName())
				.ne(Medicine::getId, medicine.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前药品名称已存在!");
			}
		}
		return R.status(medicineService.saveOrUpdate(medicine));
	}


	/**
	 * 删除 药品表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(medicineService.deleteLogic(Func.toLongList(ids)));
	}


}
