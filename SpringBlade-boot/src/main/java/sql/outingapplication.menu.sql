INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793479393775988738', 1123598815738675201, 'outingapplication', '', 'menu', '/outing/outingapplication', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793479393775988739', '1793479393775988738', 'outingapplication_add', '新增', 'add', '/outing/outingapplication/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793479393775988740', '1793479393775988738', 'outingapplication_edit', '修改', 'edit', '/outing/outingapplication/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793479393775988741', '1793479393775988738', 'outingapplication_delete', '删除', 'delete', '/api/outing/outingapplication/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793479393775988742', '1793479393775988738', 'outingapplication_view', '查看', 'view', '/outing/outingapplication/view', 'file-text', 4, 2, 2, 1, NULL, 0);
