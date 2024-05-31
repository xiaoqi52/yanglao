INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576037265409', 1123598815738675201, 'healthmonitoring', '', 'menu', '/healthmonitoring/healthmonitoring', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576037265410', '1793519576037265409', 'healthmonitoring_add', '新增', 'add', '/healthmonitoring/healthmonitoring/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576037265411', '1793519576037265409', 'healthmonitoring_edit', '修改', 'edit', '/healthmonitoring/healthmonitoring/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576037265412', '1793519576037265409', 'healthmonitoring_delete', '删除', 'delete', '/api/healthmonitoring/healthmonitoring/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793519576037265413', '1793519576037265409', 'healthmonitoring_view', '查看', 'view', '/healthmonitoring/healthmonitoring/view', 'file-text', 4, 2, 2, 1, NULL, 0);
