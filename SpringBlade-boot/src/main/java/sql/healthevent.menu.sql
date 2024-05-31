INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576293117954', 1123598815738675201, 'healthevent', '', 'menu', '/healthevent/healthevent', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576293117955', '1793519576293117954', 'healthevent_add', '新增', 'add', '/healthevent/healthevent/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576293117956', '1793519576293117954', 'healthevent_edit', '修改', 'edit', '/healthevent/healthevent/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576293117957', '1793519576293117954', 'healthevent_delete', '删除', 'delete', '/api/healthevent/healthevent/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576293117958', '1793519576293117954', 'healthevent_view', '查看', 'view', '/healthevent/healthevent/view', 'file-text', 4, 2, 2, 1, NULL, 0);
