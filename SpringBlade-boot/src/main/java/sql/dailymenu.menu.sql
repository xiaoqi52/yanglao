INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345366945793', 1123598815738675201, 'dailymenu', '', 'menu', '/dailymenu/dailymenu', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345366945794', '1793525345366945793', 'dailymenu_add', '新增', 'add', '/dailymenu/dailymenu/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345366945795', '1793525345366945793', 'dailymenu_edit', '修改', 'edit', '/dailymenu/dailymenu/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345366945796', '1793525345366945793', 'dailymenu_delete', '删除', 'delete', '/api/dailymenu/dailymenu/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793525345366945797', '1793525345366945793', 'dailymenu_view', '查看', 'view', '/dailymenu/dailymenu/view', 'file-text', 4, 2, 2, 1, NULL, 0);
