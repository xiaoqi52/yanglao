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
package org.springblade.modules.business.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;

/**
 * 每日食谱表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_daily_menu")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "每日食谱表")
public class DailyMenu extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    @Schema(description = "日期")
    private LocalDate date;
    /**
     * 早午晚，E-早餐，L-午餐，D-晚餐
     */
    @Schema(description = "早午晚，E-早餐，L-午餐，D-晚餐")
    private String mealType;
    /**
     * 菜品编号
     */
    @Schema(description = "菜品编号")
    private Long dishId;


}
