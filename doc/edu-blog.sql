/*
 Navicat Premium Data Transfer

 Source Server         : zhibi
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 120.27.24.193:3306
 Source Schema         : edu-blog

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 25/04/2019 11:48:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `browse_num` int(11) NULL DEFAULT 0,
  `comment_num` int(11) NULL DEFAULT 0,
  `start_num` int(11) NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `open` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('123', '切尔奇无群', '大沙发不是', 1, 9, 0, 0, 1, '2019-04-20 22:04:15', '2019-04-20 22:04:18', 'https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d8d48aa8a151f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce863f8b519c45d688d53f20d0.jpg', '', 0);
INSERT INTO `blog` VALUES ('测试法博客', '<p>96544444<img src=\"/upload/2019-04-21/00-1555777859366-050432.jpg\" title=\"00-1555777859366-050432.jpg\" alt=\"wechat.jpg\"/></p>', '回家犒劳， \r\n‘’\r\n‘\r\n?/’', 2, 1, 0, 0, 2, '2019-04-22 22:15:44', NULL, '/data/3af24d52-d514-4c5f-8aae-f4a2bd89df9a.jpg', '', 0);
INSERT INTO `blog` VALUES ('dasd', '<p><img src=\"/upload/2019-04-21/00-1555778076767-085151.png\" title=\"00-1555778076767-085151.png\" alt=\"bg.png\"/></p>', 'dasda', 2, 2, 0, 0, 3, '2019-04-21 00:34:48', NULL, '/data/aa0ff2c1-518a-4b0a-91e9-d88d5ce30220.png', 'sdasdasd', 0);
INSERT INTO `blog` VALUES ('1', '<p>1</p>', '1', 2, 1, 0, 0, 4, '2019-04-21 00:35:26', NULL, '/data/1c60aa0f-fb7a-4e55-8cdc-fa867d29223e.jpg', '1', 0);
INSERT INTO `blog` VALUES ('sdasa', '<p>dsd</p>', 'sasda', 2, 6, 0, 0, 5, '2019-04-21 00:36:22', NULL, '/data/4c2724c0-4d22-4a7c-b6cf-7aed9f68ec3e.jpg', 'dasd', 0);
INSERT INTO `blog` VALUES ('22222', '<p>区234332342342da22321sda</p>', '少时诵诗书1233444', 2, 12, 2, 0, 7, '2019-04-21 22:55:07', NULL, '/upload/8afbc1c2-b31e-4d2e-8346-6c130e93737f.jpg', '123123', 0);
INSERT INTO `blog` VALUES ('天气很好', '<p>今天天气真的很好，心情也好。.................</p>', '不知道描述什么。', 3, 11, 1, 0, 8, '2019-04-22 14:39:01', NULL, '/upload/9c3524e7-be54-4eac-ad44-f2d6fb25f69f.jpg', '晴天', 0);
INSERT INTO `blog` VALUES ('什么是社团', '<p>社团是具有某些共同特征的人相聚而成的互益组织。中国的社团一般具有非盈利和民间化两种基本组织特征。社团与政府组织、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%9E%E6%AD%A3%E5%BC%8F%E7%BB%84%E7%BB%87\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">非正式组织</a>或自然群体有着明显的区别。</p><p><span style=\"font-weight: 700;\">其他定义</span></p><p>社团又称为社会团体，现网络也流行的一种团体名词，是指以文化、学术或公益性为主的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%9E%E6%94%BF%E5%BA%9C%E7%BB%84%E7%BB%87\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">非政府组织</a>。</p><p>在中国大陆，根据1998年10月25日颁布的《<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A4%BE%E4%BC%9A%E5%9B%A2%E4%BD%93%E7%99%BB%E8%AE%B0%E7%AE%A1%E7%90%86%E6%9D%A1%E4%BE%8B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">社会团体登记管理条例</a>》的规定，社会团体指中国公民自愿组成，为实现会员共同意愿，按照其章程开展活动的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%9E%E8%90%A5%E5%88%A9%E6%80%A7\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">非营利性</a>社会组织。成立社会团体必须经其业务主管单位审查同意，必须同时接受登记管理机关（民政）、业务主管单位的监督；事实上，限制或者禁止政治性团体。字面含义上与国民政府之《人民团体法》定义的“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%BA%E6%B0%91%E5%9B%A2%E4%BD%93\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">人民团体</a>”内涵基本相同，下列三类机构组织不属于社会团体：</p><p>·（一）参加<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E4%BA%BA%E6%B0%91%E6%94%BF%E6%B2%BB%E5%8D%8F%E5%95%86%E4%BC%9A%E8%AE%AE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国人民政治协商会议</a>的人民团体；</p><p>·（二）由国务院机构编制管理机关核定，并经国务院批准免于登记的团体；</p><p>·（三）机关、团体、企业事业单位内部经本单位批准成立、在本单位内部活动的团体。</p><p><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"sub73275_2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"社团分类\"></a></p><h2 class=\"title-text\" style=\"margin: 0px; padding: 0px 8px 0px 18px; font-size: 22px; color: rgb(0, 0, 0); float: left; line-height: 24px; font-weight: 400; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">社团分类</h2><p><a class=\"edit-icon j-edit-link\" data-edit-dl=\"2\" style=\"color: rgb(136, 136, 136); display: block; float: right; height: 22px; line-height: 22px; padding-left: 24px; font-size: 12px; font-family: SimSun; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\" style=\"font-family: baikeFont_layout; -webkit-font-smoothing: antialiased; speak: none; font-variant-numeric: normal; font-variant-east-asian: normal; line-height: 1; outline: 0px; margin: 0px 3px 0px 0px; vertical-align: text-bottom; color: rgb(170, 170, 170);\"></span>编辑</a></p><p>社团可依其性质分为政治性、经济性、科技、军事、外交、文化体育、健康卫生及宗教团体等；依其<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%88%90%E5%91%98\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">成员</a>间的联系纽带分为生理、社会、精神物质以及由个体所属组织功能等方面因素结成的四类团体；亦可依其民间性程度分为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%AE%98%E5%8A%9E\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">官办</a>、民办、半官办3类。</p><p>学校社团目前分为综合社团和专业社团。综合性社团是素质教育的第二课堂，它提供了同学们全面发展自己的机会，比如：大学生艺术团、文学社等社团；专业社团是第一课堂的延伸，使同学们全面了解与专业知识及学术研究的前沿动态，如英语协会、足球协会、曲艺协会等，它将为你的专业提供有益的补充。</p><p><br/></p>', '社团', 3, 4, 1, 0, 9, '2019-04-25 10:10:49', NULL, '/upload/7c3337c3-10a9-4c6b-a86d-ea5c4655ea02.jpg', '', 1);
INSERT INTO `blog` VALUES ('社团简介', '<p>好</p>', '社团', 3, 1, 0, 0, 10, '2019-04-25 10:11:42', NULL, '/upload/538aaf3c-98a3-470d-9cbb-73ec9d59257a.jpg', '', 1);
INSERT INTO `blog` VALUES ('跆拳道', '<p>跆拳道起源于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9C%9D%E9%B2%9C%E5%8D%8A%E5%B2%9B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">朝鲜半岛</a>，距今已有两千多年的历史。朝鲜民族古时以农业及打猎为生，在抵御野兽、对抗入</p><p><a class=\"image-link\" nslog-type=\"9317\" href=\"https://baike.baidu.com/pic/%E8%B7%86%E6%8B%B3%E9%81%93/14455/0/a9d3fd1f4134970ac8d79e2c97cad1c8a7865d09?fr=lemma&ct=single\" target=\"_blank\" title=\"跆拳道比赛瞬间\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 220px; height: 138px;\"><img class=\"\" src=\"http://a.hiphotos.baidu.com/baike/s%3D220/sign=41a120634dc2d562f608d7efd71090f3/a9d3fd1f4134970ac8d79e2c97cad1c8a7865d09.jpg\" alt=\"跆拳道比赛瞬间\" style=\"border: 0px; display: block; margin: 0px auto; width: 220px; height: 138px;\"/></a><span class=\"description\" style=\"display: block; color: rgb(85, 85, 85); font-size: 12px; text-indent: 0px; font-family: 宋体; overflow-wrap: break-word; word-break: break-all; line-height: 15px; padding: 8px 7px; min-height: 12px; border-top: 1px solid rgb(224, 224, 224);\">跆拳道比赛瞬间</span></p><p>侵与祭祀活动的舞艺中， 逐渐演变成有意识的攻防技巧及格斗自卫武艺的雏型。在两千年前的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%AB%98%E5%8F%A5%E4%B8%BD\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">高句丽</a>皇室墓葬的壁画中，画有两名男子在用跆拳道的攻防姿势互相争斗。<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_6182893\"></a>&nbsp;<a style=\"color: rgb(19, 110, 194);\" name=\"ref_3\"></a></p><p>所谓跆拳道，跆（TAE），意为以脚踢、摔撞；拳（KWON），以拳头打击；道（DO），是一种艺术方法。跆拳道是一种利用拳和脚的艺术方法。它是以脚法为主的功夫，其脚法占70%。跆拳道的套路共有24套；另外还有兵器、擒拿、摔锁、对拆自卫术及10余种基本功夫等。 跆拳道是经过东亚文化发展的一项朝鲜武术，以东方心灵为土壤，承继长久传统， 以&quot;始于礼，终礼&quot;的武道精神为基础。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_6182893\"></a>&nbsp;</p><p>在<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9C%9D%E9%B2%9C%E4%B8%89%E5%9B%BD%E6%97%B6%E4%BB%A3\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">朝鲜三国时代</a>的高句丽、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%96%B0%E7%BD%97\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">新罗</a>及百济，三国互相抗衡，侵袭对方，更加速使武艺的盛行。无论在武官考核，民间<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%89%8B%E6%90%8F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">手搏</a>击打或祭典舞艺中，都充分表现出武艺的形态。如新罗的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%B7%86%E8%B7%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">跆跟</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%8A%B1%E9%83%8E%E9%81%93\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">花郎道</a>是军中的必修科目， 而在百济国推崇并鼓励人民学习马术、射箭及跆跟等武艺。<span class=\"sup--normal\" data-sup=\"4\" data-ctrmap=\":4,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[4]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[4]_6182893\"></a>&nbsp;</p><p>在跆拳道没有正式命名之前，韩国徒手的搏击流派有很多。名称也有跆跟、手搏、唐手、托肩、花郎道等。从20世纪50年代起，其内涵风格以及名字均得到规范和统一。“跆拳道”一词，是1955年由韩国的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B4%94%E6%B3%93%E7%86%99\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">崔泓熙</a>将军所创，他退伍以后，在跆拳道中融合民间元素，最后成型。<span class=\"sup--normal\" data-sup=\"5-6\" data-ctrmap=\":5,:6,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[5-6]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[5-6]_6182893\"></a>&nbsp;</p><p><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"1_2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"sub6182893_1_2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"发展\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"1-2\"></a></p><h3 class=\"title-text\" style=\"margin: 0px; padding: 0px; font-size: 18px; font-weight: 400;\">发展</h3><p>第二次世界大战后，朝鲜自卫术再度兴起，从异国他乡回归故土的朝鲜人也将各国的武道技艺带回本国，逐</p><p><a class=\"image-link\" nslog-type=\"9317\" href=\"https://baike.baidu.com/pic/%E8%B7%86%E6%8B%B3%E9%81%93/14455/0/0ff41bd5ad6eddc446db3ff83bdbb6fd526633f0?fr=lemma&ct=single\" target=\"_blank\" title=\"跆拳道实战瞬间\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 220px; height: 138px;\"><img class=\"\" src=\"http://h.hiphotos.baidu.com/baike/s%3D220/sign=c6080ded9e82d158bf825eb3b00a19d5/0ff41bd5ad6eddc446db3ff83bdbb6fd526633f0.jpg\" alt=\"跆拳道实战瞬间\" style=\"border: 0px; display: block; margin: 0px auto; width: 220px; height: 138px;\"/></a><span class=\"description\" style=\"display: block; color: rgb(85, 85, 85); font-size: 12px; text-indent: 0px; font-family: 宋体; overflow-wrap: break-word; word-break: break-all; line-height: 15px; padding: 8px 7px; min-height: 12px; border-top: 1px solid rgb(224, 224, 224);\">跆拳道实战瞬间</span></p><p>渐与跆拳道融为一体。<span class=\"sup--normal\" data-sup=\"7\" data-ctrmap=\":7,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[7]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[7]_6182893\"></a>&nbsp;</p><p>1955年4月11日，由韩国各界著名人士组成的名称制定委员会，包括<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B4%94%E6%B3%93%E7%86%99\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">崔泓熙</a>少将（韩国第三军管区司令员），李享根陆军大将（国军联合参谋总长），国会副议长，国会议员，著名企业家，著名武馆馆长等提出了各自的名称。通过无记名的投票，一致通过了崔泓熙将军提出的&quot;<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%B7%86%E6%8B%B3\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">跆拳</a>&quot;二字。由此，产生了“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%B7%86%E6%8B%B3%E9%81%93/14455\" data-lemmaid=\"14455\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">跆拳道</a>”。从此，结束了<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%94%90%E6%89%8B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">唐手</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A9%BA%E6%89%8B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">空手</a>及各种朝鲜古典武道等名称混杂的局面，朝鲜的武道开创了新世界，跆拳道开始了它的历史创造。<span class=\"sup--normal\" data-sup=\"8\" data-ctrmap=\":8,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[8]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[8]_6182893\"></a>&nbsp;</p><p>1961年9月韩国成立了唐手道协会，后更名为跆拳道协会，并成为全国运动会正式竞赛项目。</p><p>1966年第一个国际组织：<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E9%99%85%E8%B7%86%E6%8B%B3%E9%81%93%E8%81%94%E7%9B%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国际跆拳道联盟</a>（简称ITF）成立，崔泓熙被选为主席。</p><p>1972年，国际跆拳道联盟总部迁到加拿大的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%9A%E4%BC%A6%E5%A4%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">多伦多</a>。</p><p>1973年5月，当时的韩国总统<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9C%B4%E6%AD%A3%E7%86%99\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">朴正熙</a>在韩国首都<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%89%E5%9F%8E/449\" data-lemmaid=\"449\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">汉城</a>成立世界跆拳道联盟（简称<a target=\"_blank\" href=\"https://baike.baidu.com/item/WTF/51846\" data-lemmaid=\"51846\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">WTF</a>），并任命<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%87%91%E4%BA%91%E9%BE%99/12291\" data-lemmaid=\"12291\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">金云龙</a>为主席。同时第一届跆拳道世界锦标赛也在汉城举行，这一届比赛有来自19个国家和地区的选手参加。1975年，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%96%E7%95%8C%E8%B7%86%E6%8B%B3%E9%81%93%E8%81%94%E7%9B%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">世界跆拳道联盟</a>（WTF）被接纳为国际体育联盟正式会员。1980年，国际奥委会正式承认了世界跆拳道联盟。</p><p>跆拳道于1988年汉城奥运会时列为为示范比赛项目；于1992年的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B7%B4%E5%A1%9E%E7%BD%97%E9%82%A3%E5%A5%A5%E8%BF%90%E4%BC%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">巴塞罗那奥运会</a>开始被列为试验比赛项目；到2000年的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%82%89%E5%B0%BC%E5%A5%A5%E8%BF%90%E4%BC%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">悉尼奥运会</a>成为奥运正式比赛项目。<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_6182893\"></a>&nbsp;&nbsp;<a style=\"color: rgb(19, 110, 194);\" name=\"ref_3\"></a><span class=\"sup--normal\" data-sup=\"9-10\" data-ctrmap=\":9,:10,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">[9-10]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[9-10]_6182893\"></a>&nbsp;</p><p>1989年，韩国世界跆拳道联盟首次在北京举行跆拳道培训班，WTF跆拳道首次作为竞技体育被介绍到中国。1992年10月7日，中国跆拳道筹备小组成立。</p><p>1995年5月，共有22个单位250多名运动员参加了在<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8C%97%E4%BA%AC%E4%BD%93%E8%82%B2%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">北京体育大学</a>举行的第一届全国跆拳道锦标赛，从此，跆拳道运动在中国迅速发展起来。</p><p>1995年8月正式成立了中国跆拳道协会，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%AD%8F%E7%BA%AA%E4%B8%AD\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">魏纪中</a>当选为第一任协会主席。</p><p>1995年11月，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E8%B7%86%E6%8B%B3%E9%81%93%E5%8D%8F%E4%BC%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国跆拳道协会</a>被<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%96%E7%95%8C%E8%B7%86%E6%8B%B3%E9%81%93%E8%81%94%E7%9B%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">世界跆拳道联盟</a>WTF接纳为正式会员。<span class=\"sup--normal\" data-sup=\"11\" data-ctrmap=\":11,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[11]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[11]_6182893\"></a>&nbsp;</p><p><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"sub6182893_2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"主要特点\"></a></p><h2 class=\"title-text\" style=\"margin: 0px; padding: 0px 8px 0px 18px; font-size: 22px; color: rgb(0, 0, 0); float: left; line-height: 24px; font-weight: 400; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">主要特点</h2><p><a class=\"edit-icon j-edit-link\" data-edit-dl=\"2\" style=\"color: rgb(136, 136, 136); display: block; float: right; height: 22px; line-height: 22px; padding-left: 24px; font-size: 12px; font-family: SimSun; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\" style=\"font-family: baikeFont_layout; -webkit-font-smoothing: antialiased; speak: none; font-variant-numeric: normal; font-variant-east-asian: normal; line-height: 1; outline: 0px; margin: 0px 3px 0px 0px; vertical-align: text-bottom; color: rgb(170, 170, 170);\"></span>编辑</a></p><p><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"2_1\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"sub6182893_2_1\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"技术特点\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"2-1\"></a></p><h3 class=\"title-text\" style=\"margin: 0px; padding: 0px; font-size: 18px; font-weight: 400;\">技术特点</h3><p>1、腿法为主，拳脚并用：由于竞赛的需要、规则上的限制和跆拳道在进攻方法方面的特点，使得跆拳道技法主要是以腿法攻击为主、拳法攻击为辅。据统计在跆拳道技术当中，腿法约占总技法体系的百分之七十。因此腿</p><p><a class=\"image-link\" nslog-type=\"9317\" href=\"https://baike.baidu.com/pic/%E8%B7%86%E6%8B%B3%E9%81%93/14455/0/b812c8fcc3cec3fdf40a5376d488d43f879427f8?fr=lemma&ct=single\" target=\"_blank\" title=\"跆拳道腿法\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: block; width: 220px; height: 205px;\"><img class=\"\" src=\"http://a.hiphotos.baidu.com/baike/s%3D220/sign=912c7d025e6034a82de2bf83fb1349d9/b812c8fcc3cec3fdf40a5376d488d43f879427f8.jpg\" alt=\"跆拳道腿法\" style=\"border: 0px; display: block; margin: 0px auto; width: 220px; height: 205px;\"/></a><span class=\"description\" style=\"display: block; color: rgb(85, 85, 85); font-size: 12px; text-indent: 0px; font-family: 宋体; overflow-wrap: break-word; word-break: break-all; line-height: 15px; padding: 8px 7px; min-height: 12px; border-top: 1px solid rgb(224, 224, 224);\">跆拳道腿法</span></p><p>击无论在攻击范围、攻击力量等方面都远远超过拳法的攻击，而拳法的招式一般偏重于防守和格挡。</p><p>2、强调呼吸，发声扬威：在跆拳道的练习当中要求在气势上给人以威严的感觉，练习者常以洪亮并带有威慑力的声音来显示自己的威力。据日本有关研究资料证明人在无负荷工作时百分之十的肌肉会由于发声使他们的收缩速度提高百分之九，在有负荷工作时更是可以提高百分之十四。这就是为什么在比赛当中，运动员会发出响亮的喊叫声的原因。在发声的同时停止呼吸，可以使人体内部的阻力减小；提高动作速度，集中精力使动作发挥出更大的威力。</p><p>3、动作追求速度，力量和效果，以击破为测试功力的手段：跆拳道不讲究花架子，所有动作都以技击格斗为核心；要求速度快、力量大、击打效果好，在功力的检测方面则以击破力为测试的手段。就是分别以拳脚击碎木板等，以击碎的厚度来判定功力。</p><p>4、以刚制刚，方法简练：受跆拳道的精神影响，运动员在比赛当中多是直击直打；接触防守、躲闪技术运用得比较少，进攻都采用直线连续进攻，以连贯快速的脚法组合击打对手。防守多采用格挡技术或采取以攻对攻，以攻代防的技术。</p><p>5、礼始礼终，内外兼修：在任何场合下，跆拳道练习者始终以礼相待。练习活动都要以礼开始，以礼结束，以养成谦虚、友好、忍让的作风，在道德修养方面不断的提高自己。<span class=\"sup--normal\" data-sup=\"9\" data-ctrmap=\":9,:12,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[9]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[9]_6182893\"></a>&nbsp;&nbsp;<span class=\"sup--normal\" data-sup=\"12\" data-ctrmap=\":9,:12,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">[12]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[12]_6182893\"></a>&nbsp;</p><p><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"2_2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"sub6182893_2_2\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"技术类型\"></a><a style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\" name=\"2-2\"></a></p><h3 class=\"title-text\" style=\"margin: 0px; padding: 0px; font-size: 18px; font-weight: 400;\">技术类型</h3><ul class=\"custom_dot para-list list-paddingleft-1\" style=\"margin-bottom: 15px; margin-left: 2em; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; color: rgb(51, 51, 51); font-family: arial, 宋体, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><li class=\"list-dot list-dot-paddingleft\" style=\"\"><p>技术型：运动员在比赛中动作稳健，腿法多变，技术成熟，心理稳定，攻防一体，常常使对手在不知不觉中败下阵来。</p></li><li class=\"list-dot list-dot-paddingleft\" style=\"\"><p>力量型：运动员身体条件好，腿长肌肉爆发力强，先天素质高人一筹，攻势凌厉，常以力量取胜。</p></li><li class=\"list-dot list-dot-paddingleft\" style=\"\"><p>散手型：运动员作风顽强，比赛中多主动进攻，攻守得宜，自成一体，动作非常实用，有很高的训练水平和比赛技术。</p></li><li class=\"list-dot list-dot-paddingleft\" style=\"\"><p>进攻型：运动员进攻意识强烈，经常是追着对手攻击，用快速连续的技术动作压制对手。</p></li><li class=\"list-dot list-dot-paddingleft\" style=\"\"><p>防守反击型：运动员的技术训练水平很高，也有很多的大赛经验，多是试探性进攻，在对手反击或进攻时找出弱点，然后很直接的回击。<span class=\"sup--normal\" data-sup=\"13\" data-ctrmap=\":13,\" style=\"font-size: 10.5px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[13]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[13]_6182893\"></a>&nbsp;</p></li></ul><p><br/></p>', '跆拳道', 4, 4, 0, 0, 11, '2019-04-25 10:40:04', NULL, '/upload/0d98662a-c63a-4d3a-a85b-40e58c6ef3ca.jpg', '跆拳道', 1);
INSERT INTO `blog` VALUES ('dasad', '<p>dasdasda</p>', 'asdasdasd', 2, 2, 0, 0, 12, '2019-04-25 10:38:19', NULL, '/upload/8e34a92a-8aa4-4a4b-9360-632752159a8d.jpeg', 'dasdasd', 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `user_id` int(11) NULL DEFAULT 0,
  `blog_id` int(11) NULL DEFAULT 0,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 7, 'fdsdsdfs', 1, '2019-04-21 18:37:58', NULL);
INSERT INTO `comment` VALUES (2, 7, 'sdfsdfsdfs', 2, '2019-04-21 18:38:02', NULL);
INSERT INTO `comment` VALUES (3, 8, '你开心就好', 3, '2019-04-22 14:21:37', NULL);
INSERT INTO `comment` VALUES (4, 9, '还不错', 4, '2019-04-25 10:32:08', NULL);

-- ----------------------------
-- Table structure for league
-- ----------------------------
DROP TABLE IF EXISTS `league`;
CREATE TABLE `league`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `user_num` int(11) NULL DEFAULT 0,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `slogan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of league
-- ----------------------------
INSERT INTO `league` VALUES ('芭蕾舞', 1, '2019-04-22 12:34:38', '2019-04-25 10:49:41', -2, '<p>芭蕾舞社团</p>', '/upload/968a6111-b190-495c-8d8c-1379591afbe8.jpg', '13323232323', '为舞而生');
INSERT INTO `league` VALUES ('跆拳道社', 2, '2019-04-22 12:34:41', NULL, 0, NULL, '', '', '');
INSERT INTO `league` VALUES ('街舞社', 3, '2019-04-22 12:34:43', NULL, 0, NULL, '', '', '');
INSERT INTO `league` VALUES ('测试社团', 4, '2019-04-22 12:34:46', NULL, 1, NULL, '', '', '');
INSERT INTO `league` VALUES ('古典乐器社', 5, '2019-04-22 13:05:34', NULL, 0, NULL, '', '', '');

-- ----------------------------
-- Table structure for league_prop
-- ----------------------------
DROP TABLE IF EXISTS `league_prop`;
CREATE TABLE `league_prop`  (
  `league_id` int(11) NULL DEFAULT 0,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for league_user
-- ----------------------------
DROP TABLE IF EXISTS `league_user`;
CREATE TABLE `league_user`  (
  `user_id` int(11) NULL DEFAULT 0,
  `league_id` int(11) NULL DEFAULT 0,
  `operation_id` int(11) NULL DEFAULT 0,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of league_user
-- ----------------------------
INSERT INTO `league_user` VALUES (2, 1, 0, 'OWNER', 'AGREE', 5, '2019-04-22 20:57:59', NULL, '999');
INSERT INTO `league_user` VALUES (3, 1, 0, 'LEADER', 'AGREE', 3, '2019-04-22 14:42:45', '2019-04-22 15:13:27', '哈哈哈');
INSERT INTO `league_user` VALUES (4, 0, 0, 'DEFAULT', 'APPLY', 6, '2019-04-25 10:26:30', NULL, '');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `blog_num` int(11) NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('SDASASD', 0, 1, '2019-04-21 00:45:00', NULL);
INSERT INTO `tag` VALUES ('123', 1, 2, '2019-04-21 17:55:02', NULL);
INSERT INTO `tag` VALUES ('123123', 1, 3, '2019-04-21 22:55:07', NULL);
INSERT INTO `tag` VALUES ('晴天', 2, 4, '2019-04-22 14:20:54', NULL);
INSERT INTO `tag` VALUES ('', 5, 5, '2019-04-22 22:15:45', NULL);
INSERT INTO `tag` VALUES ('dasdasd', 1, 6, '2019-04-25 10:38:19', NULL);
INSERT INTO `tag` VALUES ('跆拳道', 1, 7, '2019-04-25 10:40:04', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('超级管理员', 'admin', '81dc9bdb52d04dc20036dbd8313ed055', '', 'ADMIN', 1, '2019-04-20 21:32:42', '2019-04-20 21:30:48', '/images/avatar.png');
INSERT INTO `user` VALUES ('hhhj', '111', '698d51a19d8a121ce581499d7b701668', 's@ww.11', 'USER', 2, '2019-04-20 23:22:40', '2019-04-21 21:06:18', '/upload/f55ceb47-2a1c-497b-a070-5fc4aaa91ac7.png');
INSERT INTO `user` VALUES ('user', 'user', '81dc9bdb52d04dc20036dbd8313ed055', '', 'USER', 3, '2019-04-22 14:15:12', '2019-04-22 14:16:25', '/upload/b4b4e9b3-4eb3-4293-896c-58335228b4f7.jpg');
INSERT INTO `user` VALUES ('user1', 'user1', '81dc9bdb52d04dc20036dbd8313ed055', NULL, 'USER', 4, '2019-04-25 10:16:03', NULL, '/images/avatar.png');

SET FOREIGN_KEY_CHECKS = 1;
