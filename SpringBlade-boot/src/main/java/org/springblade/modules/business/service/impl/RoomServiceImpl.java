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
package org.springblade.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springblade.modules.business.entity.Room;
import org.springblade.modules.business.vo.RoomVO;
import org.springblade.modules.business.mapper.RoomMapper;
import org.springblade.modules.business.service.IRoomService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.*;

/**
 * 房间表 服务实现类
 *
 * @author Blade
 * @since 2024-05-23
 */
@Service
public class RoomServiceImpl extends BaseServiceImpl<RoomMapper, Room> implements IRoomService {

	@Override
	public IPage<RoomVO> selectRoomPage(IPage<RoomVO> page, RoomVO room) {
		return page.setRecords(baseMapper.selectRoomPage(page, room));
	}

	@Override
	public List<Map<String, Object>> countByBedCountGroups() {
		Long count1 = count(new QueryWrapper<Room>().eq("bed_count", 1));
		Long count2 = count(new QueryWrapper<Room>().eq("bed_count", 2));
		Long count3 = count(new QueryWrapper<Room>().eq("bed_count", 3));
		Long count4 = count(new QueryWrapper<Room>().eq("bed_count", 4));

		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> data3 = new LinkedHashMap<>(2);
		data3.put("name","4床房");
		data3.put("value",count4);
		result.add(data3);
		Map<String, Object> data2 = new LinkedHashMap<>(2);
		data2.put("name","3床房");
		data2.put("value",count3);
		result.add(data2);
		Map<String, Object> data1 = new LinkedHashMap<>(2);
		data1.put("name","2床房");
		data1.put("value",count2);
		result.add(data1);
		Map<String, Object> data = new LinkedHashMap<>(2);
		data.put("name","1床房");
		data.put("value",count1);
		result.add(data);
		return result;
	}

}
