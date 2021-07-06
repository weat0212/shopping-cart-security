
use users_database;

CREATE TABLE IF NOT EXISTS  `product` (
                                          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                          `product` varchar(50) NOT NULL COMMENT '商品名稱',
                                          `price` int(10) NOT NULL COMMENT '商品價格',
                                          `inventory` int(50) NOT NULL DEFAULT '0' COMMENT '商品庫存',
                                          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
                                          `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='偉康科技產品表格';

CREATE TABLE IF NOT EXISTS `purchase_record` (
                                   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                   `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '會員使用者ID',
                                   `product_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '商品ID',
                                   `trading_price` int(50) NOT NULL DEFAULT '0' COMMENT '商品交易價格',
                                   `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '０是失敗１是成功結帳',
                                   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
                                   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='偉康科技面試採購表格';