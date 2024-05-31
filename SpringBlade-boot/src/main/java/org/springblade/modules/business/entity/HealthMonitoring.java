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
 * 健康监测表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_health_monitoring")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "健康监测表")
public class HealthMonitoring extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idNumber;
    /**
     * 监测日期
     */
    @Schema(description = "监测日期")
    private LocalDate monitoringDate;
    /**
     * 身高（cm）
     */
    @Schema(description = "身高（cm）")
    private Short height;
    /**
     * 体重（kg）
     */
    @Schema(description = "体重（kg）")
    private Short weight;
    /**
     * 心率（次/分钟）
     */
    @Schema(description = "心率（次/分钟）")
    private Short heartRate;
    /**
     * 舒张压（mmHg）
     */
    @Schema(description = "舒张压（mmHg）")
    private Short diastolicPressure;
    /**
     * 收缩压（mmHg）
     */
    @Schema(description = "收缩压（mmHg）")
    private Short systolicPressure;
    /**
     * 血糖（mmol/L）
     */
    @Schema(description = "血糖（mmol/L）")
    private Double bloodSugar;
    /**
     * 其他
     */
    @Schema(description = "其他")
    private String other;


}
