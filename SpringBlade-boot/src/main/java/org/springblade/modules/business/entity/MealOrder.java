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
 * 点餐表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_meal_order")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "点餐表")
public class MealOrder extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idNumber;
    /**
     * 就餐日期
     */
    @Schema(description = "就餐日期")
    private LocalDate mealDate;
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
    /**
     * 点餐日期
     */
    @Schema(description = "点餐日期")
    private LocalDate orderDate;
    /**
     * 受理状态，A-已申请，C-已取消，P-已批准，F-已完成
     */
    @Schema(description = "受理状态，A-已申请，C-已取消，P-已批准，F-已完成")
    private String orderStatus;


}
