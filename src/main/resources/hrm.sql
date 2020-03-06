CREATE TABLE `tb_employeestate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `state` varchar(255) NOT NULL COMMENT '员工状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '员工姓名',
  `username` varchar(255) NOT NULL COMMENT '员工工号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `state` varchar(255) DEFAULT NULL COMMENT '在职状态',
  `managername` varchar(255) DEFAULT NULL COMMENT '领导工号',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `hiredate` datetime DEFAULT NULL COMMENT '入职时间',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `marriage` varchar(255) DEFAULT NULL COMMENT '婚姻状态：单身，已婚，离异，丧偶',
  `national` varchar(255) DEFAULT NULL COMMENT '国籍',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `education` varchar(255) DEFAULT NULL COMMENT '学历',
  `degree` varchar(255) DEFAULT NULL COMMENT '学位',
  `graduation_school` varchar(255) DEFAULT NULL COMMENT '毕业院校',
  `graduation_date` datetime DEFAULT NULL COMMENT '毕业时间',
  `job_code` varchar(255) DEFAULT NULL COMMENT '职位编码',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `political_visage` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  KEY `job_code` (`job_code`),
  KEY `managername` (`managername`),
  CONSTRAINT `tb_employee_ibfk_1` FOREIGN KEY (`job_code`) REFERENCES `tb_job` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_employee_ibfk_2` FOREIGN KEY (`managername`) REFERENCES `tb_employee` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '部门名称',
  `code` varchar(255) NOT NULL COMMENT '部门编码',
  `organization_code` varchar(255) NOT NULL COMMENT '组织编码',
  `pcode` varchar(255) DEFAULT NULL COMMENT '父级部门编码',
  `status` int(11) DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE,
  KEY `organization_code` (`organization_code`),
  KEY `pcode` (`pcode`),
  CONSTRAINT `tb_department_ibfk_1` FOREIGN KEY (`organization_code`) REFERENCES `tb_organization` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_department_ibfk_2` FOREIGN KEY (`pcode`) REFERENCES `tb_department` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_employeestate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `state` varchar(255) NOT NULL COMMENT '员工状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_icon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '组织名称',
  `code` varchar(255) NOT NULL COMMENT '组织编码',
  `address` varchar(255) DEFAULT NULL COMMENT '组织地址',
  `business_license_id` varchar(255) DEFAULT NULL COMMENT '营业执照ID',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法人代表',
  `phone` varchar(255) DEFAULT NULL COMMENT '组织电话',
  `mail` varchar(255) DEFAULT NULL COMMENT '组织邮箱',
  `status` int(11) DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_leavetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` varchar(255) NOT NULL COMMENT '请假类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '职位名称',
  `code` varchar(255) NOT NULL COMMENT '职位编码',
  `department_code` varchar(255) NOT NULL COMMENT '部门编码',
  `status` int(11) DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE,
  KEY `department_code` (`department_code`),
  CONSTRAINT `tb_job_ibfk_1` FOREIGN KEY (`department_code`) REFERENCES `tb_department` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `parent_id` int(11) NOT NULL COMMENT '父权限ID',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `css` varchar(255) DEFAULT NULL COMMENT 'CSS样式',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `type` int(11) DEFAULT NULL COMMENT '权限类型 0为目录 1为菜单 2为按钮',
  `permission` varchar(255) DEFAULT NULL COMMENT '具体权限',
  `sort` int(11) NOT NULL DEFAULT '999' COMMENT '排序值',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

CREATE TABLE `tb_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_permission_id` (`role_id`,`permission_id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `tb_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '员工工号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_id` (`user_id`,`role_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';
