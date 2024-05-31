INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532111773249538', 1123598815738675201, 'employeereview', '', 'menu', '/employeereview/employeereview', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532111773249539', '1793532111773249538', 'employeereview_add', '新增', 'add', '/employeereview/employeereview/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532111773249540', '1793532111773249538', 'employeereview_edit', '修改', 'edit', '/employeereview/employeereview/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532111773249541', '1793532111773249538', 'employeereview_delete', '删除', 'delete', '/api/employeereview/employeereview/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532111773249542', '1793532111773249538', 'employeereview_view', '查看', 'view', '/employeereview/employeereview/view', 'file-text', 4, 2, 2, 1, NULL, 0);
