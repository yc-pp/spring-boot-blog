/**
 * 正则匹配2-18位的中英文字符串
 *
 * @param str
 * @returns {boolean}
 */
function validCN_ENString2_18(str) {
    var pattern = /^[a-zA-Z0-9-\u4E00-\u9FA5_,， ]{2,18}$/;
    if (pattern.test(str.trim())) {
        return (true);
    } else {
        return (false);
    }
}
/**
 * url验证
 *
 * @param str
 * @returns {boolean}
 */
function isURL(str_url) {
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}"
        + "|"
        + "([0-9a-zA-Z_!~*'()-]+\.)*"
        + "([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\."
        + "[a-zA-Z]{2,6})"
        + "(:[0-9]{1,4})?"
        + "((/?)|"
        + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$";
    var re = new RegExp(strRegex);
    if (re.test(str_url)) {
        return (true);
    } else {
        return (false);
    }
}
/**
 * 正则匹配2-100位的中英文字符串
 *
 * @param str
 * @returns {boolean}
 */
function validCN_ENString2_100(str) {
    var pattern = /^[a-zA-Z0-9-\u4E00-\u9FA5_,， ]{2,100}$/;
    if (pattern.test(str.trim())) {
        return (true);
    } else {
        return (false);
    }
}
<!-- 正则验证 start-->
/**
 * 判空
 *
 * @param obj
 * @returns {boolean}
 */
function isNull(obj) {
    if (obj == null || obj == undefined || obj.trim() == "") {
        return true;
    }
    return false;
}
/**
 * 参数长度验证
 *
 * @param obj
 * @param length
 * @returns {boolean}
 */
function validLength(obj, length) {
    if (obj.trim().length < length) {
        return true;
    }
    return false;
}