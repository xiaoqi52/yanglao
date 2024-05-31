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
import org.springblade.modules.business.entity.Room;
import org.springblade.modules.system.entity.User;
import org.springblade.modules.system.service.IUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.business.entity.Employee;
import org.springblade.modules.business.vo.EmployeeVO;
import org.springblade.modules.business.wrapper.EmployeeWrapper;
import org.springblade.modules.business.service.IEmployeeService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.Objects;

/**
 * 员工表 控制器
 *
 * @author Blade
 * @since 2024-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/employee/employee")
@Tag(name = "员工表", description = "员工表接口")
public class EmployeeController extends BladeController {

	private IEmployeeService employeeService;

	private IUserService userService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@Operation(summary = "详情", description = "传入employee")
	public R<EmployeeVO> detail(Employee employee) {
		Employee detail = employeeService.getOne(Condition.getQueryWrapper(employee));
		return R.data(EmployeeWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 员工表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@Operation(summary = "分页", description = "传入employee")
	public R<IPage<EmployeeVO>> list(Employee employee, Query query) {
		IPage<Employee> pages = employeeService.page(Condition.getPage(query), Condition.getQueryWrapper(employee));
		return R.data(EmployeeWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 员工表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@Operation(summary = "分页", description = "传入employee")
	public R<IPage<EmployeeVO>> page(EmployeeVO employee, Query query) {
		IPage<EmployeeVO> pages = employeeService.selectEmployeePage(Condition.getPage(query), employee);
		return R.data(pages);
	}

	/**
	 * 新增 员工表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@Operation(summary = "新增", description = "传入employee")
	public R save(@Valid @RequestBody Employee employee) {
		return R.status(employeeService.save(employee));
	}

	/**
	 * 修改 员工表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@Operation(summary = "修改", description = "传入employee")
	public R update(@Valid @RequestBody Employee employee) {
		return R.status(employeeService.updateById(employee));
	}

	/**
	 * 新增或修改 员工表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@Operation(summary = "新增或修改", description = "传入employee")
	public R submit(@Valid @RequestBody Employee employee) {
		if(Objects.isNull(employee.getId())) {
			Long count = employeeService.lambdaQuery().eq(Employee::getEmployeeId, employee.getEmployeeId()).count();
			if (count > 0) {
				throw new ServiceException("当前工号已存在!");
			}
			Long phoneCount = employeeService.lambdaQuery().eq(Employee::getPhone, employee.getPhone()).count();
			if (phoneCount > 0) {
				throw new ServiceException("当前手机号已存在!");
			}
			User user = new User();
			user.setAccount(employee.getUsername());
			user.setPassword(employee.getPassword());
			user.setRoleId(String.valueOf(1123598816738675202L));
			user.setDeptId(String.valueOf(1123598813738675202L));
			user.setRealName("工人");
			user.setRealName(employee.getName());
			user.setName(employee.getName());
			userService.submit(user);
		} else {
			Long count = employeeService.lambdaQuery().eq(Employee::getEmployeeId, employee.getEmployeeId())
				.ne(Employee::getId, employee.getId()).count();
			if (count > 0) {
				throw new ServiceException("当前工号已存在!");
			}
			Long phoneCount = employeeService.lambdaQuery().eq(Employee::getPhone, employee.getPhone())
				.ne(Employee::getId, employee.getId()).count();
			if (phoneCount > 0) {
				throw new ServiceException("当前手机号已存在!");
			}
		}

		return R.status(employeeService.saveOrUpdate(employee));
	}


	/**
	 * 删除 员工表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@Operation(summary = "逻辑删除", description = "传入ids")
	public R remove(@Parameter(name = "主键集合", required = true) @RequestParam String ids) {
		return R.status(employeeService.deleteLogic(Func.toLongList(ids)));
	}


}
