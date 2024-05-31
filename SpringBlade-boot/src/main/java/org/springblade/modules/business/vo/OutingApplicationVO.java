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

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springblade.modules.business.entity.OutingApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 外出申请表视图实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@Schema(description = "外出申请表")
public class OutingApplicationVO {
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
	 * 申请时间
	 */
	@Schema(description = "申请时间")
	private LocalDate applicationDate;
	/**
	 * 预计外出时间
	 */
	@Schema(description = "预计外出时间")
	private LocalDateTime expectedOutDate;
	/**
	 * 预计返回时间
	 */
	@Schema(description = "预计返回时间")
	private LocalDateTime expectedReturnDate;
	/**
	 * 实际外出时间
	 */
	@Schema(description = "实际外出时间")
	private LocalDateTime actualOutDate;
	/**
	 * 实际返回时间
	 */
	@Schema(description = "实际返回时间")
	private LocalDateTime actualReturnDate;
	/**
	 * 原由
	 */
	@Schema(description = "原由")
	private String reason;

	private Integer status;
}
