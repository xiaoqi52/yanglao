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
 * 老人表实体类
 *
 * @author Blade
 * @since 2024-05-22
 */
@Data
@TableName("yl_elderly")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "老人表")
public class Elderly extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idNumber;
    /**
     * 姓名
     */
    @Schema(description = "姓名")
    private String name;
    /**
     * 性别
     */
    @Schema(description = "性别")
    private String gender;
    /**
     * 出生日期
     */
    @Schema(description = "出生日期")
    private LocalDate birthDate;
    /**
     * 电话
     */
    @Schema(description = "电话")
    private String phone;
    /**
     * 来源市
     */
    @Schema(description = "来源市")
    private String originCity;
    /**
     * 家庭地址
     */
    @Schema(description = "家庭地址")
    private String homeAddress;
    /**
     * 监护人姓名
     */
    @Schema(description = "监护人姓名")
    private String guardianName;
    /**
     * 监护人性别
     */
    @Schema(description = "监护人性别")
    private String guardianGender;
    /**
     * 监护人电话
     */
    @Schema(description = "监护人电话")
    private String guardianPhone;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;
    /**
     * 登录密码
     */
    @Schema(description = "登录密码")
    private String password;
    /**
     * 房间号
     */
    @Schema(description = "房间号")
    private String roomNumber;
    /**
     * 床位号
     */
    @Schema(description = "床位号")
    private Short bedNumber;
    /**
     * 入住日期
     */
    @Schema(description = "入住日期")
    private LocalDate checkInDate;
    /**
     * 特护类型
     */
    @Schema(description = "特护类型")
    private String specialCareType;
    /**
     * 健康状况
     */
    @Schema(description = "健康状况")
    private String healthStatus;


}
