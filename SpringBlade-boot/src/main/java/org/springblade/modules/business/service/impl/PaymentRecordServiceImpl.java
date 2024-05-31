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
 package org.springblade.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.modules.business.entity.PaymentRecord;
import org.springblade.modules.business.mapper.PaymentRecordMapper;
import org.springblade.modules.business.service.IPaymentRecordService;
import org.springblade.modules.business.vo.PaymentRecordVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 收费记录表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */

@Service
public class PaymentRecordServiceImpl extends BaseServiceImpl<PaymentRecordMapper, PaymentRecord> implements IPaymentRecordService {

	@Override
	public IPage<PaymentRecordVO> selectPaymentRecordPage(IPage<PaymentRecordVO> page, PaymentRecordVO paymentRecord) {
		return page.setRecords(baseMapper.selectPaymentRecordPage(page, paymentRecord));
	}

	@Override
	public Map<String, List<Object>> getChargeLastSevenDays() {
		// Get the date 7 days ago
		LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);

		List<PaymentRecord> records = list(new QueryWrapper<PaymentRecord>()
			.ge("date", sevenDaysAgo));

		Map<String, Integer> result = records.stream()
			.collect(Collectors.groupingBy(
				record -> record.getDate().toLocalDate().toString(),
				Collectors.summingInt(PaymentRecord::getAmount)
			));

		Map<String, List<Object>> map = new HashMap<>(2);
		List<Object> days = new ArrayList<>();
		List<Object> amounts = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			days.add(entry.getKey());
			amounts.add(entry.getValue());
		}
       map.put("days",days);
	   map.put("amounts",amounts);
		return map;
	}

	@Override
	public Map<String, List<Object>> getChargeLastSixMonths() {
		LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
		List<PaymentRecord> records = list(new QueryWrapper<PaymentRecord>()
			.ge("date", sixMonthsAgo.atStartOfDay()));

		Map<String, Integer> result = records.stream()
			.collect(Collectors.groupingBy(
				record -> record.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")),
				Collectors.summingInt(PaymentRecord::getAmount)
			));


		Map<String, List<Object>> map = new HashMap<>(2);

		List<Object> months = new ArrayList<>();
		List<Object> amounts = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			months.add(entry.getKey());
			amounts.add(entry.getValue());
		}
		map.put("months",months);
		map.put("amounts",amounts);

		return map;
	}

}
