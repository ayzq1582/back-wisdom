package com.zhy.wisdom.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

    public static void main(String[] args) {
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName("smtp.163.com");
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo("1355053917@qq.com");
            // 发送人的邮箱2
            email.setFrom("15010071819@163.com", "15010071819");
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication("15010071819@163.com", "LTPWGDDZMSPXPSPO");
            // 要发送的邮件主题
            email.setSubject("测试邮件");
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg(getEmailMsg());
            // 发送
            email.send();
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
    }

    static String getEmailMsg(){
        String html ="<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<body>\n" +
                "      各位领导、同事：</br>\n" +
                "          大家好！</br>\n" +
                "          根据SAP系统数据显示，目前存在供应商货款到期未支付的情况。最长欠款天数100天。</br>\n" +
                "          请业务部门及时了解并反馈逾期支付原因，已达到支付状态的，请及时推动清款进程，保障BOE信用。\n" +
                "\t\n" +
                "        <table border='1' cellpadding='1' cellspacing='0' style='margin-left:70px'>\n" +
                "          <tr style = 'font-size:'16px'; height='20px''>\n" +
                "            <td align = 'center'>供应商代码</td>\n" +
                "            <td align = 'center'>供应商名称</td>\n" +
                "            <td align = 'center'>现地</td>\n" +
                "            <td align = 'center'>币种</td>\n" +
                "            <td align = 'center'>应付金额</td>\n" +
                "            <td align = 'center'>系统到期日</td>\n" +
                "            <td align = 'center'>欠款天数</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "            <td>123</td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "       </div>\n" +
                "\t</body>\n" +
                "\n" +
                "</html>";
        System.out.println(html);
        return html;
    }
}
