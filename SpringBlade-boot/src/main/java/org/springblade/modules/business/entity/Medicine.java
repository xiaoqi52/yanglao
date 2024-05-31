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
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;

/**
 * 药品表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_medicine")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "药品表")
public class Medicine extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 药品类型
     */
    @Schema(description = "药品类型")
    private String medicineType;
    /**
     * 药品名称
     */
    @Schema(description = "药品名称")
    private String medicineName;
    /**
     * 生产厂商
     */
    @Schema(description = "生产厂商")
    private String manufacturer;
    /**
     * 生产日期
     */
    @Schema(description = "生产日期")
    private LocalDate productionDate;
    /**
     * 有效天数
     */
    @Schema(description = "有效天数")
    private Short validDays;
    /**
     * 单价
     */
    @Schema(description = "单价")
    private BigDecimal price;
    /**
     * 药品数量
     */
    @Schema(description = "药品数量")
    private Short quantity;


}
