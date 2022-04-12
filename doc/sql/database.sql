/*
* MySQL8.x版本
*/

-- ----------------------------
-- 系统管理数据库
-- ----------------------------
CREATE DATABASE IF NOT EXISTS snow_system DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
-- ----------------------------
-- 数据源管理数据库
-- ----------------------------
CREATE DATABASE IF NOT EXISTS snow_meta DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
-- ----------------------------
-- demo管理数据库
-- ----------------------------
CREATE DATABASE IF NOT EXISTS snow_demo DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
-- ----------------------------
-- NACOS
-- ----------------------------
CREATE DATABASE IF NOT EXISTS snow_nacos DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;


-- seata 分布式事务
CREATE DATABASE IF NOT EXISTS seata DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;

