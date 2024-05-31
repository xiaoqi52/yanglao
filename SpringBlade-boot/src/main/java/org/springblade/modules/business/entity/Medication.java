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
 * 用药表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_medication")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用药表")
public class Medication extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idNumber;
    /**
     * 用药日期
     */
    @Schema(description = "用药日期")
    private LocalDate medicationDate;
    /**
     * 药品编号
     */
    @Schema(description = "药品编号")
    private Long medicineId;
    /**
     * 用药量
     */
    @Schema(description = "用药量")
    private Short dosage;


}
