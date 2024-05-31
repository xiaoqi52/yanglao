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
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 意见表视图实体类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Data
@Schema(description = "意见表")
public class OpinionVO  {
	@Serial
	private static final long serialVersionUID = 1L;
	@JsonSerialize(
			using = ToStringSerializer.class
	)
	private Long id;
	/**
	 * 意见标题
	 */
	@Schema(description = "意见标题")
	private String title;
	/**
	 * 意见内容
	 */
	@Schema(description = "意见内容")
	private String content;
	/**
	 * 发布者身份证号
	 */
	@Schema(description = "发布者身份证号")
	private String publisherId;
	/**
	 * 发布时间
	 */

	@Schema(description = "发布时间")
	private LocalDateTime publishTime;

}
