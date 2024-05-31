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
import org.springblade.modules.business.entity.Room;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.PaymentRecord;
import org.springblade.modules.business.vo.PaymentRecordVO;
import org.springblade.modules.business.wrapper.PaymentRecordWrapper;
import org.springblade.modules.business.service.IPaymentRecordService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.Objects;

/**
 * 收费记录表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/payment/paymentrecord")
@Tag(name = "收费记录表", description = "收费记录表接口")
public class PaymentRecordController extends BladeController {

	private IPaymentRecordService paymentRecordService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入paymentRecord")
	public R<PaymentRecordVO> detail(PaymentRecord paymentRecord) {
		PaymentRecord detail = paymentRecordService.getOne(Condition.getQueryWrapper(paymentRecord));
		return R.data(PaymentRecordWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 收费记录表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入paymentRecord")
	public R<IPage<PaymentRecordVO>> list(PaymentRecord paymentRecord, Query query) {
		IPage<PaymentRecord> pages = paymentRecordService.page(Condition.getPage(query), Condition.getQueryWrapper(paymentRecord));
		return R.data(PaymentRecordWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 收费记录表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入paymentRecord")
	public R<IPage<PaymentRecordVO>> page(PaymentRecordVO paymentRecord, Query query) {
		IPage<PaymentRecordVO> pages = paymentRecordService.selectPaymentRecordPage(Condition.getPage(query), paymentRecord);
		return R.data(pages);
	}

	/**
	 * 新增 收费记录表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入paymentRecord")
	public R save(@Valid @RequestBody PaymentRecord paymentRecord) {
		return R.status(paymentRecordService.save(paymentRecord));
	}

	/**
	 * 修改 收费记录表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入paymentRecord")
	public R update(@Valid @RequestBody PaymentRecord paymentRecord) {
		return R.status(paymentRecordService.updateById(paymentRecord));
	}

	/**
	 * 新增或修改 收费记录表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入paymentRecord")
	public R submit(@Valid @RequestBody PaymentRecord paymentRecord) {
		if (Objects.isNull(paymentRecord.getId())){
			Long count = paymentRecordService.lambdaQuery().eq(PaymentRecord::getIdNumber, paymentRecord.getIdNumber()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		} else {
			Long count = paymentRecordService.lambdaQuery().eq(PaymentRecord::getIdNumber, paymentRecord.getIdNumber())
				.ne(PaymentRecord::getId, paymentRecord.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前身份证已存在!");
			}
		}
		return R.status(paymentRecordService.saveOrUpdate(paymentRecord));
	}


	/**
	 * 删除 收费记录表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(paymentRecordService.deleteLogic(Func.toLongList(ids)));
	}


}
