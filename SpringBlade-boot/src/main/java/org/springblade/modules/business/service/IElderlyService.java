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

import org.springblade.modules.business.entity.Elderly;
import org.springblade.modules.business.vo.ElderlyVO;
import org.springblade.core.mp.base.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * 老人表 服务类
 *
 * @author Blade
 * @since 2024-05-22
 */
public interface IElderlyService extends BaseService<Elderly> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param elderly
	 * @return
	 */
	IPage<ElderlyVO> selectElderlyPage(IPage<ElderlyVO> page, ElderlyVO elderly);

	/**
	 * 查询不同年龄段的老人数
	 *
	 * @return
	 */
	List<Map<String, Object>> countByAgeGroups();
}
