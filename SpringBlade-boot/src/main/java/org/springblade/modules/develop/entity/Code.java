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
package org.springblade.modules.develop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 实体类
 *
 * @author Chill
 */
@Data
@TableName("blade_code")
@Schema(description = "Code对象")
public class Code implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 数据源主键
	 */
	@Schema(description = "数据源主键")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long datasourceId;

	/**
	 * 模块名称
	 */
	@Schema(description = "服务名称")
	private String serviceName;

	/**
	 * 模块名称
	 */
	@Schema(description = "模块名称")
	private String codeName;

	/**
	 * 表名
	 */
	@Schema(description = "表名")
	private String tableName;

	/**
	 * 实体名
	 */
	@Schema(description = "表前缀")
	private String tablePrefix;

	/**
	 * 主键名
	 */
	@Schema(description = "主键名")
	private String pkName;

	/**
	 * 基础业务模式
	 */
	@Schema(description = "基础业务模式")
	private Integer baseMode;

	/**
	 * 包装器模式
	 */
	@Schema(description = "包装器模式")
	private Integer wrapMode;

	/**
	 * 后端包名
	 */
	@Schema(description = "后端包名")
	private String packageName;

	/**
	 * 后端路径
	 */
	@Schema(description = "后端路径")
	private String apiPath;

	/**
	 * 前端路径
	 */
	@Schema(description = "前端路径")
	private String webPath;

	/**
	 * 是否已删除
	 */
	@TableLogic
	@Schema(description = "是否已删除")
	private Integer isDeleted;


}
