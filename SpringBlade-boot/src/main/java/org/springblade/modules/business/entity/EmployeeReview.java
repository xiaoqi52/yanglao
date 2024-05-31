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
 * 员工评价表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_employee_review")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "员工评价表")
public class EmployeeReview extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 评价者身份证号
     */
    @Schema(description = "评价者身份证号")
    private String reviewerId;
    /**
     * 被评价员工工号
     */
    @Schema(description = "被评价员工工号")
    private String employeeId;
    /**
     * 评价日期
     */
    @Schema(description = "评价日期")
    private LocalDate reviewDate;
    /**
     * 评价分数
     */
    @Schema(description = "评价分数")
    private Byte score;
    /**
     * 评价语
     */
    @Schema(description = "评价语")
    private String comment;


}
