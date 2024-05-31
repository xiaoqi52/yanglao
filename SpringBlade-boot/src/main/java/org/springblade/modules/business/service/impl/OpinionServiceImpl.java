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

import org.springblade.modules.business.entity.Opinion;
import org.springblade.modules.business.vo.OpinionVO;
import org.springblade.modules.business.mapper.OpinionMapper;
import org.springblade.modules.business.service.IOpinionService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 意见表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class OpinionServiceImpl extends BaseServiceImpl<OpinionMapper, Opinion> implements IOpinionService {

	@Override
	public IPage<OpinionVO> selectOpinionPage(IPage<OpinionVO> page, OpinionVO opinion) {
		return page.setRecords(baseMapper.selectOpinionPage(page, opinion));
	}

}
