--学生表
CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `age` int DEFAULT NULL COMMENT '学生年龄',
  `class_id` int DEFAULT NULL COMMENT '班级id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` int(1) unsigned zerofill NOT NULL COMMENT '是否删除，0表示为删除；1表示已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

--班级表
CREATE TABLE `clbum` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `name` varchar(32) DEFAULT NULL COMMENT '班级名',
  `number` int DEFAULT NULL COMMENT '班级人数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` int DEFAULT NULL COMMENT '是否删除，0表示未删除，1表示已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;