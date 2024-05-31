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
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;

/**
 * 员工表实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@TableName("yl_employee")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "员工表")
public class Employee extends BaseEntity {

    @Serial
	private static final long serialVersionUID = 1L;

    /**
     * 工号：前两位是部门/岗位号，后三位是流水号
     */
    @Schema(description = "工号：前两位是部门/岗位号，后三位是流水号")
    private String employeeId;
    /**
     * 部门名
     */
    @Schema(description = "部门名")
    private String department;
    /**
     * 姓名
     */
    @Schema(description = "姓名")
    private String name;
    /**
     * 电话
     */
    @Schema(description = "电话")
    private String phone;
    /**
     * 性别：M（男）或F（女）
     */
    @Schema(description = "性别：M（男）或F（女）")
    private String gender;
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


}
