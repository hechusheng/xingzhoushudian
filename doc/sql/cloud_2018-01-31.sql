# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: www.irichers.com (MySQL 5.7.13)
# Database: cloud
# Generation Time: 2018-01-31 01:57:14 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table oauth_client_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '客户端id',
  `resource_ids` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源id',
  `client_secret` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户端秘钥',
  `scope` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '范围',
  `authorized_grant_types` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '授权类型',
  `web_server_redirect_uri` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '回调地址',
  `authorities` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限',
  `access_token_validity` int(11) DEFAULT NULL COMMENT 'token存活时长,单位秒',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '刷新秘钥存活时长,单位秒',
  `additional_information` varchar(4096) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '附加信息',
  `autoapprove` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;

INSERT INTO `oauth_client_details` (`id`, `client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES
	(1,'webapp','','webapp','read,write','password,refresh_token',NULL,'admin',3600,7200,'{}','true'),
	(2,'gateway',NULL,'gateway','xx','implicit',NULL,NULL,NULL,NULL,NULL,'true');

/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_job_class_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_job_class_info`;

CREATE TABLE `t_job_class_info` (
  `EXEC_CLASS_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `EXEC_CLASS_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `EXEC_CLASS` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SORT_NO` int(11) NOT NULL,
  `DEL_FLAG` int(11) NOT NULL,
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`EXEC_CLASS_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table t_job_exec_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_job_exec_detail`;

CREATE TABLE `t_job_exec_detail` (
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_CODE` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `START_TIME` date NOT NULL,
  `END_TIME` date NOT NULL,
  `SUCCESS_FLAG` int(11) NOT NULL,
  `LOG_INFO` blob,
  `DEL_FLAG` int(11) NOT NULL,
  `SORT_NO` int(11) NOT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table t_job_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_job_info`;

CREATE TABLE `t_job_info` (
  `JOB_CODE` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `EXEC_CLASS_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CRON_EXPRESS` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NEXT_EXEC_DATE` date NOT NULL,
  `DEL_FLAG` int(11) NOT NULL,
  `EXEC_FLAG` int(11) NOT NULL,
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SORT_NO` int(11) NOT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`JOB_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table t_sys_dept
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_dept`;

CREATE TABLE `t_sys_dept` (
  `DEPT_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门代码',
  `DEPT_NAME` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  `DEPT_NAME_J` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称简（页面默认=名称，但可以自己录）',
  `PARENT_DEPT_CODE` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上级部门代码',
  `AUTH_CODE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门范围代码',
  `REMARK` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`DEPT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门代码和名称等是需要从前台页面录入部门职能范围代码:根部门就是取部门代码，其他新建子部门时，获取父部门的范围代码+3位随机数。';



# Dump of table t_sys_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `MENU_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单代码',
  `MENU_NAME` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单URL',
  `PARENT_MENU_CODE` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '父菜单代码',
  `TYPE` int(11) NOT NULL COMMENT '类型(1代表菜单2代表目录)',
  `LEVEL` int(11) DEFAULT NULL COMMENT '菜单层次（项目根节点是0，下面一次+1）',
  `AUTH_CODE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单范围代码（用于like''1%''上下级查询，方便mysql）',
  `REMARK` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`MENU_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单前台取消录入。\r\n菜单代码生成规则如下：JVM的年月日时分秒毫秒18位（201711111111111000）+2位随机数。\r\n所以总的菜单层数不能超过（40-18-2）/2=10层，放开字段长度即无限制。\r\n菜单范围代码:根菜单就是菜单代码，其他新建子菜单时，获取父菜单的范围代码+‘3位随机数’。\r\n\r\nJVM的年月日时分秒毫秒18位（201711111111111000）以及2位随机数，需要写成工具类。';



# Dump of table t_sys_menu_button
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_menu_button`;

CREATE TABLE `t_sys_menu_button` (
  `BUTTON_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '按钮代码',
  `BUTTON_NAME` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '按钮名称',
  `BUTTON_URL` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '放置按钮所要执行的action',
  `BUTTON_STYLE` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '放置按钮所要执行的样式',
  `MENU_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单代码',
  `REMARK` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`BUTTON_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='按钮代码生成规则：JVM的年月日时分秒毫秒+2位随机数。';



# Dump of table t_sys_post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_post`;

CREATE TABLE `t_sys_post` (
  `POST_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `POST_NAME` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL,
  `POST_NAME_J` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DEPT_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DEL_FLAG` int(11) NOT NULL,
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SORT_NO` int(11) NOT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`POST_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table t_sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `ROLE_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色代码',
  `ROLE_NAME` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `REMARK` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`ROLE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色代码：JVM的年月日时分秒毫秒+2位随机数。\n角色名称代码层面也要做校验，不允许角色名称重名';



# Dump of table t_sys_role_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role_menu`;

CREATE TABLE `t_sys_role_menu` (
  `ROLE_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色代码',
  `MENU_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单代码',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单';



# Dump of table t_sys_role_menu_button
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role_menu_button`;

CREATE TABLE `t_sys_role_menu_button` (
  `ROLE_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色代码',
  `MENU_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单代码',
  `BUTTON_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '按钮代码',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单按钮';



# Dump of table t_sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户代码（页面录入，全系统唯一）',
  `USER_NAME` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名称',
  `USER_ACCT` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户登录账号（登录用）',
  `USER_PWD` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户密码(SHA256加密后)',
  `ADMIN_FLAG` int(11) NOT NULL COMMENT '管理员标记 1代表是 0 代表否',
  `ID_CARD` varchar(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `SEX` int(11) DEFAULT NULL COMMENT '性别 0女1男',
  `TEL` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '固定电话',
  `PHONE` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮件',
  `IP` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  `DEPT_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门代码',
  `REMARK` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  `CLIENT_ID` int(11) DEFAULT NULL COMMENT '客户端id',
  PRIMARY KEY (`USER_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户代码全系统唯一，新增用户时，\n   同一用户如果存在已作废，需要提示已经存在，是否覆盖，选是覆盖信息并启用，否则退回。\n   同一用户如果存在且未作废，需要提示已经存在，点击取消。';

LOCK TABLES `t_sys_user` WRITE;
/*!40000 ALTER TABLE `t_sys_user` DISABLE KEYS */;

INSERT INTO `t_sys_user` (`USER_CODE`, `USER_NAME`, `USER_ACCT`, `USER_PWD`, `ADMIN_FLAG`, `ID_CARD`, `SEX`, `TEL`, `PHONE`, `EMAIL`, `IP`, `DEPT_CODE`, `REMARK`, `DEL_FLAG`, `UUID`, `SORT_NO`, `CREATED_TIME`, `CREATED_BY`, `UPDATED_TIME`, `UPDATED_BY`, `CLIENT_ID`)
VALUES
	('1','管理员','admin','$2a$10$3ShCiUXzEE2QD8BxPNXwhuQNfvR0y/ZaJdMScFvRUWUUya5kVSCgO',1,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,0,'',0,'2018-01-30 15:00:14','','2018-01-30 15:00:14',NULL,NULL);

/*!40000 ALTER TABLE `t_sys_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_user_dept
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_dept`;

CREATE TABLE `t_sys_user_dept` (
  `USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户代码',
  `DEPT_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门代码',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户部门';



# Dump of table t_sys_user_freeze
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_freeze`;

CREATE TABLE `t_sys_user_freeze` (
  `USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FREEZE_DATE` date NOT NULL,
  `FREEZE_FLAG` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `UNFREEZE_DATE` date DEFAULT NULL,
  `UNFREEZE_USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UNFREEZE_REASON` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DEL_FLAG` int(11) NOT NULL,
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SORT_NO` int(11) NOT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table t_sys_user_menu_extra
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_menu_extra`;

CREATE TABLE `t_sys_user_menu_extra` (
  `USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户代码',
  `MENU_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单代码',
  `START_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '有效期起',
  `END_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '有效期止',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户额外菜单';



# Dump of table t_sys_user_post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_post`;

CREATE TABLE `t_sys_user_post` (
  `USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户代码',
  `POST_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '岗位代码',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户岗位';



# Dump of table t_sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `USER_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户代码',
  `ROLE_CODE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色代码',
  `DEFAULT_FLAG` int(11) NOT NULL COMMENT '默认角色标记 1默认0不默认',
  `DEL_FLAG` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `UUID` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `SORT_NO` int(11) NOT NULL COMMENT '序号（从0开始）',
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(用户代码)',
  `UPDATED_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UPDATED_BY` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(用户代码)',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
