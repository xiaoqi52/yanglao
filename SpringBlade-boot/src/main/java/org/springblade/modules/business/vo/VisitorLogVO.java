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
import org.springblade.modules.business.entity.VisitorLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 来访表视图实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@Schema(description = "来访表")
public class VisitorLogVO {
	@Serial
	private static final long serialVersionUID = 1L;

	@JsonSerialize(
			using = ToStringSerializer.class
	)
	private Long id;

	/**
	 * 身份证号
	 */
	@Schema(description = "身份证号")
	private String idNumber;
	/**
	 * 主访客姓名
	 */
	@Schema(description = "主访客姓名")
	private String mainVisitorName;
	/**
	 * 访客人数
	 */
	@Schema(description = "访客人数")
	private Byte visitorCount;
	/**
	 * 与老人关系
	 */
	@Schema(description = "与老人关系")
	private String relationship;
	/**
	 * 来访时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@Schema(description = "来访时间")
	private LocalDateTime visitTime;
	/**
	 * 离开时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@Schema(description = "离开时间")
	private LocalDateTime leaveTime;

}
