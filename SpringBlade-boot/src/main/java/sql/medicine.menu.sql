INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519535117635586', 1123598815738675201, 'medicine', '', 'menu', '/medicine/medicine', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519535117635587', '1793519535117635586', 'medicine_add', '新增', 'add', '/medicine/medicine/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519535117635588', '1793519535117635586', 'medicine_edit', '修改', 'edit', '/medicine/medicine/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519535117635589', '1793519535117635586', 'medicine_delete', '删除', 'delete', '/api/medicine/medicine/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519535117635590', '1793519535117635586', 'medicine_view', '查看', 'view', '/medicine/medicine/view', 'file-text', 4, 2, 2, 1, NULL, 0);
