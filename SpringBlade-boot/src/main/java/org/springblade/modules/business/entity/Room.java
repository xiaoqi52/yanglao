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
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;

/**
 * 房间表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_room")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "房间表")
public class Room extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 房间号：1位楼号-三位房间号
     */
    @Schema(description = "房间号：1位楼号-三位房间号")
    private String roomNumber;
    /**
     * 朝向：东、南、西、北、东北等
     */
    @Schema(description = "朝向：东、南、西、北、东北等")
    private String orientation;
    /**
     * 面积（平方米）
     */
    @Schema(description = "面积（平方米）")
    private BigDecimal area;
    /**
     * 床位数
     */
    @Schema(description = "床位数")
    private Short bedCount;
    /**
     * 配置描述
     */
    @Schema(description = "配置描述")
    private String description;
    /**
     * 床位月单价（元）
     */
    @Schema(description = "床位月单价（元）")
    private Short bedMonthlyPrice;


}
