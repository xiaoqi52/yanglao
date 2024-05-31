/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.business.wrapper;

import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.modules.business.entity.PaymentRecord;
import org.springblade.modules.business.vo.PaymentRecordVO;

/**
 * 收费记录表包装类,返回视图层所需的字段
 *
 * @author Blade
 * @since 2024-05-23
 */
public class PaymentRecordWrapper extends BaseEntityWrapper<PaymentRecord, PaymentRecordVO>  {

    public static PaymentRecordWrapper build() {
        return new PaymentRecordWrapper();
    }

	@Override
	public PaymentRecordVO entityVO(PaymentRecord paymentRecord) {
		PaymentRecordVO paymentRecordVO = BeanUtil.copyProperties(paymentRecord, PaymentRecordVO.class);

		return paymentRecordVO;
	}

}
