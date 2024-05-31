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
import org.springblade.modules.business.entity.DailyMenu;
import org.springblade.modules.business.vo.DailyMenuVO;
import org.springblade.modules.business.wrapper.DailyMenuWrapper;
import org.springblade.modules.business.service.IDailyMenuService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 每日食谱表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dailymenu/dailymenu")
@Tag(name = "每日食谱表", description = "每日食谱表接口")
public class DailyMenuController extends BladeController {

	private IDailyMenuService dailyMenuService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入dailyMenu")
	public R<DailyMenuVO> detail(DailyMenu dailyMenu) {
		DailyMenu detail = dailyMenuService.getOne(Condition.getQueryWrapper(dailyMenu));
		return R.data(DailyMenuWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 每日食谱表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入dailyMenu")
	public R<IPage<DailyMenuVO>> list(DailyMenu dailyMenu, Query query) {
		IPage<DailyMenu> pages = dailyMenuService.page(Condition.getPage(query), Condition.getQueryWrapper(dailyMenu));
		return R.data(DailyMenuWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 每日食谱表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入dailyMenu")
	public R<IPage<DailyMenuVO>> page(DailyMenuVO dailyMenu, Query query) {
		IPage<DailyMenuVO> pages = dailyMenuService.selectDailyMenuPage(Condition.getPage(query), dailyMenu);
		return R.data(pages);
	}

	/**
	 * 新增 每日食谱表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入dailyMenu")
	public R save(@Valid @RequestBody DailyMenu dailyMenu) {
		return R.status(dailyMenuService.save(dailyMenu));
	}

	/**
	 * 修改 每日食谱表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入dailyMenu")
	public R update(@Valid @RequestBody DailyMenu dailyMenu) {
		return R.status(dailyMenuService.updateById(dailyMenu));
	}

	/**
	 * 新增或修改 每日食谱表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入dailyMenu")
	public R submit(@Valid @RequestBody DailyMenu dailyMenu) {
		return R.status(dailyMenuService.saveOrUpdate(dailyMenu));
	}


	/**
	 * 删除 每日食谱表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(dailyMenuService.deleteLogic(Func.toLongList(ids)));
	}


}
