package com.zhy.wisdom.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class demo {
    public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            // 一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String key = "ce97a456-5e9e-485d-b30b-5b101dd86e28";
        String body = "{\"total\":1,\"type\":11,\"items\":[{\"changeTime\":1422201600000,\"companyId\":69392121,\"天眼查专业版 监控信息推送服务说明15 contentAfter\":\"预包装食品兼散装食品、乳制品零售（依法须经批准的项目经相关部门批准后 方可开展经营活动）、卷烟、雪茄烟（以烟草专卖零售许可证有效期为准）、日用百货、日杂 批发兼零售。\",\"companyName\":\"嘉峪关市佳乐综合商店\",\"contentBefore\":\"糖烟酒、日用杂 品 、 百 货 、 干 鲜 果 零 售 \",\"changeItem\":\" 经 营 范 围 变 更 （ 含 业 务 范 围 变 更 ） \",\"id\":1754459081,\"companyGid\":2356920653}]}";
        System.out.println(getMD5String(body+key));
        System.out.println(body+key);
    }
}
