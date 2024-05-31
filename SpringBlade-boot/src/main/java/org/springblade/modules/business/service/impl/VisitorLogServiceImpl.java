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

import org.springblade.modules.business.entity.VisitorLog;
import org.springblade.modules.business.vo.VisitorLogVO;
import org.springblade.modules.business.mapper.VisitorLogMapper;
import org.springblade.modules.business.service.IVisitorLogService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 来访表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class VisitorLogServiceImpl extends BaseServiceImpl<VisitorLogMapper, VisitorLog> implements IVisitorLogService {

	@Override
	public IPage<VisitorLogVO> selectVisitorLogPage(IPage<VisitorLogVO> page, VisitorLogVO visitorLog) {
		return page.setRecords(baseMapper.selectVisitorLogPage(page, visitorLog));
	}

}
