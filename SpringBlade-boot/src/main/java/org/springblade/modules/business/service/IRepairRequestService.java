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
package org.springblade.modules.business.service;

import org.springblade.modules.business.entity.RepairRequest;
import org.springblade.modules.business.vo.RepairRequestVO;
import org.springblade.core.mp.base.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 报修表 服务类
 *
 * @author Blade
 * @since 2024-05-23
 */
public interface IRepairRequestService extends BaseService<RepairRequest> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param repairRequest
	 * @return
	 */
	IPage<RepairRequestVO> selectRepairRequestPage(IPage<RepairRequestVO> page, RepairRequestVO repairRequest);

}
