CREATE DATABASE `ycdb`;

USE `ycdb`;
CREATE TABLE `yc_user` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `nickName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '别名',
  `passWord` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `userURL` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户链接地址',
  `userRole` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户角色',
  `userAvatar` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像链接地址',
  `userGitHubId` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户github',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `yc_tag_article` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_oId` bigint(20) DEFAULT NULL COMMENT '文章Id',
  `tag_oId` bigint(20) DEFAULT NULL COMMENT '标签Id',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_tag` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tagTitle` varchar(255) DEFAULT NULL COMMENT '标签标题',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

CREATE TABLE `yc_plugin` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `author` varchar(255) DEFAULT NULL COMMENT '插件作者',
  `name` varchar(255) DEFAULT NULL COMMENT '插件名称',
  `status` varchar(255) DEFAULT NULL COMMENT '插件状态',
  `version` varchar(255) DEFAULT NULL COMMENT '插件版本',
  `setting` mediumtext COMMENT '插件配置',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_option` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `optionValue` varchar(255) DEFAULT NULL COMMENT '配置项值',
  `optionCategory` varchar(255) DEFAULT NULL COMMENT '配置项分类',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_link` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `linkAddress` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `linkDescription` varchar(255) DEFAULT NULL COMMENT '链接描述',
  `linkOrder` varchar(255) DEFAULT NULL COMMENT '链接排序',
  `linkTitle` varchar(255) DEFAULT NULL COMMENT '链接标题',
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_comment` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commentContent` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `commentCreated` datetime DEFAULT NULL COMMENT '评论时间',
  `commentName` varchar(255) DEFAULT NULL COMMENT '评论人名称',
  `commentOnId` bigint(20) DEFAULT NULL COMMENT '评论文章Id',
  `commentSharpURL` varchar(255) DEFAULT NULL COMMENT '评论的访问路径',
  `commentThumbnailURL` varchar(255) DEFAULT NULL COMMENT '评论人头像图片链接地址',
  `commentURL` varchar(255) DEFAULT NULL COMMENT '评论人链接地址',
  `commentOriginalCommentId` varchar(255) DEFAULT NULL COMMENT '父评论Id',
  `commentOriginalCommentName` varchar(255) DEFAULT NULL COMMENT '父评论人名称',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_category` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryTitle` varchar(255) DEFAULT NULL COMMENT '分类标题',
  `categoryURI` varchar(255) DEFAULT NULL COMMENT '分类访问路径',
  `categoryDescription` varchar(255) DEFAULT NULL COMMENT '分类描述',
  `categoryOrder` varchar(255) DEFAULT NULL COMMENT '分类展现的排序',
  `categoryTagCnt` varchar(255) DEFAULT NULL COMMENT '分类聚合下标签计数',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_article` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `articleTitle` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `articleAbstract` varchar(255) DEFAULT NULL COMMENT '文章摘要Markdown',
  `articleAbstractText` varchar(255) DEFAULT NULL COMMENT '文章摘要纯文本',
  `articleTags` varchar(255) DEFAULT NULL COMMENT '文章标签英文，分割',
  `articleAuthorId` bigint(20) DEFAULT NULL COMMENT '文章作者Id',
  `articleCommentCount` varchar(255) DEFAULT NULL COMMENT '文章评论计数',
  `articleViewCount` varchar(255) DEFAULT NULL COMMENT '文章浏览计数',
  `articleContent` mediumtext COMMENT '文章正文内容',
  `articlePermalink` varchar(255) DEFAULT NULL COMMENT '文章访问路径',
  `articlePutTop` varchar(255) DEFAULT NULL COMMENT '文章是否置顶',
  `articleCreated` datetime DEFAULT NULL COMMENT '文章创建时间',
  `articleUpdated` datetime DEFAULT NULL COMMENT '文章更新时间',
  `articleRandomDouble` double DEFAULT NULL COMMENT '文章随机数',
  `articleSignId` varchar(255) DEFAULT NULL COMMENT '文章关联的签名id',
  `articleCommentable` varchar(255) DEFAULT NULL COMMENT '文章是否可以评论',
  `articleViewPwd` varchar(255) DEFAULT NULL COMMENT '文章浏览密码，空不设置密码',
  `articleImg1URL` varchar(255) DEFAULT NULL COMMENT '文章首图地址',
  `articleStatus` varchar(255) DEFAULT NULL COMMENT '文章状态',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_archivedate_article` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `archiveDate_oId` bigint(20) DEFAULT NULL COMMENT '存档日期id',
  `article_oId` bigint(20) DEFAULT NULL COMMENT '文章id',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yc_archivedate` (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `archiveTime` datetime DEFAULT NULL COMMENT '存档日期，该月份的第一天',
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

