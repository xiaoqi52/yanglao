INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491123120381954', 1123598815738675201, 'incidentrecord', '', 'menu', '/incident/incidentrecord', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491123120381955', '1793491123120381954', 'incidentrecord_add', '新增', 'add', '/incident/incidentrecord/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491123120381956', '1793491123120381954', 'incidentrecord_edit', '修改', 'edit', '/incident/incidentrecord/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491123120381957', '1793491123120381954', 'incidentrecord_delete', '删除', 'delete', '/api/incident/incidentrecord/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491123120381958', '1793491123120381954', 'incidentrecord_view', '查看', 'view', '/incident/incidentrecord/view', 'file-text', 4, 2, 2, 1, NULL, 0);
