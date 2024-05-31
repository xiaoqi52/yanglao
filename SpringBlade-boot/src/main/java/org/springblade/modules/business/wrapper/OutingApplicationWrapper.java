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
import org.springblade.modules.business.entity.OutingApplication;
import org.springblade.modules.business.vo.OutingApplicationVO;

/**
 * 外出申请表包装类,返回视图层所需的字段
 *
 * @author Blade
 * @since 2024-05-23
 */
public class OutingApplicationWrapper extends BaseEntityWrapper<OutingApplication, OutingApplicationVO>  {

    public static OutingApplicationWrapper build() {
        return new OutingApplicationWrapper();
    }

	@Override
	public OutingApplicationVO entityVO(OutingApplication outingApplication) {
		OutingApplicationVO outingApplicationVO = BeanUtil.copyProperties(outingApplication, OutingApplicationVO.class);

		return outingApplicationVO;
	}

}