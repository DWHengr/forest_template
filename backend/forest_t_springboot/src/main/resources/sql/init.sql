SET
FOREIGN_KEY_CHECKS=0;

drop table if exists `t_test`;
create table t_test
(
    int_field    bigint(32) NOT NULL COMMENT 'int类型',
    string_field varchar(256) DEFAULT NULL COMMENT '字符串类型',
    date_field   datetime     DEFAULT NULL COMMENT '时间类型'
) engine=innodb default charset=utf8 comment='测试表' row_format=dynamic;
