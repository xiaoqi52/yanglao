INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345601826818', 1123598815738675201, 'mealorder', '', 'menu', '/mealorder/mealorder', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345601826819', '1793525345601826818', 'mealorder_add', '新增', 'add', '/mealorder/mealorder/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345601826820', '1793525345601826818', 'mealorder_edit', '修改', 'edit', '/mealorder/mealorder/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345601826821', '1793525345601826818', 'mealorder_delete', '删除', 'delete', '/api/mealorder/mealorder/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345601826822', '1793525345601826818', 'mealorder_view', '查看', 'view', '/mealorder/mealorder/view', 'file-text', 4, 2, 2, 1, NULL, 0);
