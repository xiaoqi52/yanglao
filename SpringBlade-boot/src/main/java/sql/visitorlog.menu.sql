INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793484621852827649', 1123598815738675201, 'visitorlog', '', 'menu', '/visitor/visitorlog', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793484621852827650', '1793484621852827649', 'visitorlog_add', '新增', 'add', '/visitor/visitorlog/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793484621852827651', '1793484621852827649', 'visitorlog_edit', '修改', 'edit', '/visitor/visitorlog/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793484621852827652', '1793484621852827649', 'visitorlog_delete', '删除', 'delete', '/api/visitor/visitorlog/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793484621852827653', '1793484621852827649', 'visitorlog_view', '查看', 'view', '/visitor/visitorlog/view', 'file-text', 4, 2, 2, 1, NULL, 0);
