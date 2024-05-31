INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491122797420546', 1123598815738675201, 'paymentrecord', '', 'menu', '/payment/paymentrecord', NULL, 1, 1, 0, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491122797420547', '1793491122797420546', 'paymentrecord_add', '新增', 'add', '/payment/paymentrecord/add', 'plus', 1, 2, 1, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491122797420548', '1793491122797420546', 'paymentrecord_edit', '修改', 'edit', '/payment/paymentrecord/edit', 'form', 2, 2, 2, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491122797420549', '1793491122797420546', 'paymentrecord_delete', '删除', 'delete', '/api/payment/paymentrecord/remove', 'delete', 3, 2, 3, 1, NULL, 0);
INSERT INTO `blade_menu`(`id`, `parent_id`, `code`, `name`, `alias`, `path`, `source`, `sort`, `category`, `action`, `is_open`, `remark`, `is_deleted`)
VALUES ('1793491122797420550', '1793491122797420546', 'paymentrecord_view', '查看', 'view', '/payment/paymentrecord/view', 'file-text', 4, 2, 2, 1, NULL, 0);
