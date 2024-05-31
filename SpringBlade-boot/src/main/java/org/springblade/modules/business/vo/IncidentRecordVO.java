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
package org.springblade.modules.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springblade.modules.business.entity.IncidentRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 事故记录表视图实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@Schema(description = "事故记录表")
public class IncidentRecordVO  {
	@Serial
	private static final long serialVersionUID = 1L;


	@JsonSerialize(
			using = ToStringSerializer.class
	)
	private Long id;

	/**
	 * 事故类型
	 */
	@Schema(description = "事故类型")
	private String incidentType;
	/**
	 * 事故描述
	 */
	@Schema(description = "事故描述")
	private String description;
	/**
	 * 发生时间
	 */
	@Schema(description = "发生时间")
	@DateTimeFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	private LocalDateTime occurredAt;
	/**
	 * 损失金额（元）
	 */
	@Schema(description = "损失金额（元）")
	private BigDecimal loss;

}