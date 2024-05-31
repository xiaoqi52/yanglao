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
import org.springblade.modules.business.entity.Opinion;
import org.springblade.modules.business.vo.OpinionVO;
import org.springblade.modules.business.wrapper.OpinionWrapper;
import org.springblade.modules.business.service.IOpinionService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 意见表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/opinion/opinion")
@Tag(name = "意见表", description = "意见表接口")
public class OpinionController extends BladeController {

	private IOpinionService opinionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入opinion")
	public R<OpinionVO> detail(Opinion opinion) {
		Opinion detail = opinionService.getOne(Condition.getQueryWrapper(opinion));
		return R.data(OpinionWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 意见表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入opinion")
	public R<IPage<OpinionVO>> list(Opinion opinion, Query query) {
		IPage<Opinion> pages = opinionService.page(Condition.getPage(query), Condition.getQueryWrapper(opinion));
		return R.data(OpinionWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 意见表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入opinion")
	public R<IPage<OpinionVO>> page(OpinionVO opinion, Query query) {
		IPage<OpinionVO> pages = opinionService.selectOpinionPage(Condition.getPage(query), opinion);
		return R.data(pages);
	}

	/**
	 * 新增 意见表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入opinion")
	public R save(@Valid @RequestBody Opinion opinion) {
		return R.status(opinionService.save(opinion));
	}

	/**
	 * 修改 意见表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入opinion")
	public R update(@Valid @RequestBody Opinion opinion) {
		return R.status(opinionService.updateById(opinion));
	}

	/**
	 * 新增或修改 意见表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入opinion")
	public R submit(@Valid @RequestBody Opinion opinion) {
		return R.status(opinionService.saveOrUpdate(opinion));
	}


	/**
	 * 删除 意见表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(opinionService.deleteLogic(Func.toLongList(ids)));
	}


}
