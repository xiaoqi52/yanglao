INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532112482086913', 1123598815738675201, 'repairrequest', '', 'menu', '/repairrequest/repairrequest', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532112482086914', '1793532112482086913', 'repairrequest_add', '新增', 'add', '/repairrequest/repairrequest/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532112482086915', '1793532112482086913', 'repairrequest_edit', '修改', 'edit', '/repairrequest/repairrequest/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532112482086916', '1793532112482086913', 'repairrequest_delete', '删除', 'delete', '/api/repairrequest/repairrequest/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793532112482086917', '1793532112482086913', 'repairrequest_view', '查看', 'view', '/repairrequest/repairrequest/view', 'file-text', 4, 2, 2, 1, NULL, 0);
