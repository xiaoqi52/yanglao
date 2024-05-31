/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.business.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

import org.springblade.core.log.exception.ServiceException;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.business.entity.Dish;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.Room;
import org.springblade.modules.business.vo.RoomVO;
import org.springblade.modules.business.wrapper.RoomWrapper;
import org.springblade.modules.business.service.IRoomService;
import org.springblade.core.boot.ctrl.BladeController;

import java.rmi.ServerException;
import java.util.*;

/**
 * 房间表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/room/room")
@Tag(name = "房间表", description = "房间表接口")
public class RoomController extends BladeController {

	private IRoomService roomService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入room")
	public R<RoomVO> detail(Room room) {
		Room detail = roomService.getOne(Condition.getQueryWrapper(room));
		return R.data(RoomWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 房间表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入room")
	public R<IPage<RoomVO>> list(Room room, Query query) {
		IPage<Room> pages = roomService.page(Condition.getPage(query), Condition.getQueryWrapper(room));
		return R.data(RoomWrapper.build().pageVO(pages));
	}


	/**
	 * 获取所有房间 房间表
	 */
	@GetMapping("/getAll")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入room")
	public R<List<Map<String,Object>>> getAll() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (Room room : roomService.list()) {
			Map<String, Object> map = new LinkedHashMap<>(2);
			map.put("label", room.getRoomNumber());
			map.put("value", room.getRoomNumber());
			list.add(map);
		}
		return R.data(list);
	}


	/**
	 * 自定义分页 房间表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入room")
	public R<IPage<RoomVO>> page(RoomVO room, Query query) {
		IPage<RoomVO> pages = roomService.selectRoomPage(Condition.getPage(query), room);
		return R.data(pages);
	}

	/**
	 * 新增 房间表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入room")
	public R save(@Valid @RequestBody Room room) {
		return R.status(roomService.save(room));
	}

	/**
	 * 修改 房间表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入room")
	public R update(@Valid @RequestBody Room room) {
		return R.status(roomService.updateById(room));
	}

	/**
	 * 新增或修改 房间表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入room")
	public R submit(@Valid @RequestBody Room room) {
		if (Objects.isNull(room.getId())){
			Long count = roomService.lambdaQuery().eq(Room::getRoomNumber, room.getRoomNumber()).count();
			if (count > 0) {
				throw new ServiceException("当前房间号已存在!");
			}

		} else {
			Long count = roomService.lambdaQuery().eq(Room::getRoomNumber, room.getRoomNumber())
				.ne(Room::getId, room.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前房间号已存在!");
			}

		}
		return R.status(roomService.saveOrUpdate(room));
	}


	/**
	 * 删除 房间表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(roomService.deleteLogic(Func.toLongList(ids)));
	}


}
