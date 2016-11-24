package com.wiyar.tao.util;

/**
 * Created by fzl on 2016/11/23.
 */
import org.apache.commons.httpclient.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoTest1 {

    //public static final String GET_URL = "http://112.4.27.9/mall-back/if_user/store_list?storeId=32";
    public static final String GET_URL = "https://wmcrm.baidu.com/crm?qt=orderlist&order_status=0&start_time=2016-11-22&end_time=2016-11-22&pay_type=2&is_asap=0";

    //    public static final String POST_URL = "http://112.4.27.9/mall-back/if_user/store_list";
    // 妙兜测试接口
    //public static final String POST_URL = "http://121.40.204.191:8180/mdserver/service/installLock";
    public static final String POST_URL = "https://waimaie.meituan.com/v2/logon/pass/step1/logon";

    /**
     * 接口调用 GET
     */
    public static void httpURLConectionGET() {
        try {
            URL url = new URL(GET_URL);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接

            connection.setRequestProperty("Cookie","BAIDUID=C2766220791D563E3934B370C9F343E4:FG=1; PSTM=1477558053; BIDUPSID=E786902CAC664D11670F1A0D354B95FD; PSINO=2; H_PS_PSSID=1438_21120_18134_21454_21409_21553_21377_21525_21192_21614_21399; WMUSS=wBAAAmGhoPO1NUaDU6Tw1WDT0Pfn04QxUQTQhGZXYVOyEVYTovb3UCQ103fS1DEAIe-ixUdjgAAUzoBYTh9GnoSKkgaby4QBGkwGUpqRzlfSHw9fnppQk4jQjBaP0lVUXIeamFLeWU1Kn1-FUU4cw01MAwvGU18PA8tF0516AIaAfldXw5P15YMslkxCYAAI; WMSTOKEN=AA8QAABBcUA1fnRkCiR9ViE6ZU1QM0I8UipGWnMbXSMkC0B2F0AAA8sS0Frfz9gZEgEYR8kHOgCGgGHgzMN3W4AAGTf6xEFDAAA4tzaGv6oABy7DtkXWagAAKcD5CAYA; new_order_time=1479815382; new_remind_time=1479815353; ULOG_UID=ivtfvex45i9; newyear=open; _wmcrmpush=2626E5D29F55898B7D1C8AA6E0A0E01B_1479815470_10_1556745922_qdpysj0");


            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
    }

    /**
     * 接口调用  POST
     */
    public static void httpURLConnectionPOST () {
        try {
            URL url = new URL(POST_URL);

            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中

            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");


            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);

            // 设置连接输入流为true
            connection.setDoInput(true);

            // 设置请求方式为post
            connection.setRequestMethod("POST");

            // post请求缓存设为false
            connection.setUseCaches(false);

            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);

            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            connection.connect();

            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());

            String app_key = "app_key="+ URLEncoder.encode("4f7bf8c8260124e6e9c6bf094951a111", "utf-8");		// 已修改【改为错误数据，以免信息泄露】
            String agt_num = "&agt_num="+ URLEncoder.encode("10111", "utf-8");				// 已修改【改为错误数据，以免信息泄露】
            String pid = "&pid="+ URLEncoder.encode("BLZXA150401111", "utf-8");				// 已修改【改为错误数据，以免信息泄露】
            String departid = "&departid="+ URLEncoder.encode("10007111", "utf-8");			// 已修改【改为错误数据，以免信息泄露】
            String install_lock_name = "&install_lock_name="+ URLEncoder.encode("南天大门", "utf-8");
            String install_address = "&install_address="+ URLEncoder.encode("北京育新", "utf-8");
            String install_gps = "&install_gps="+ URLEncoder.encode("116.350888,40.011001", "utf-8");
            String install_work = "&install_work="+ URLEncoder.encode("小李", "utf-8");
            String install_telete = "&install_telete="+ URLEncoder.encode("13000000000", "utf-8");
            String intall_comm = "&intall_comm="+ URLEncoder.encode("一切正常", "utf-8");

            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444
            String parm = app_key+ agt_num+ pid+ departid+ install_lock_name+ install_address+ install_gps+ install_work+ install_telete+ intall_comm;

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new NameValuePair("userName", "pysj2"));
            params.add(new NameValuePair("password", "13306392284"));
            params.add(new NameValuePair("imgVerifyValue", "4e3f"));

            System.out.println(getQuery(params));
            // 将参数输出到连接
            dataout.writeBytes(getQuery(params));

            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)

            System.out.println(connection.getResponseCode());

            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据

            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
//                sb.append(bf.readLine());
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    public static void httpPost() throws IOException {
        URL postUrl = new URL("https://waimaie.meituan.com/v2/logon/pass/step1/logon");
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();

        connection.setRequestProperty("Cookie","device_uuid=!abb487f5-be53-44c0-9531-cdb127e6cd70; uuid_update=true; _lxsdk=1588b95d9cdc8-0d98a8a19c615a-1d306c51-1fa400-1588b95d9cdc8; pushToken=0STLQEhZ3277G8R3qHakigWEoENrkQ_Tm02tuTR0rHMQ*; acctId=3941143; token=0PMgbZXVCBsPEj69ojpaPKM1noIdONwQ3fxz9NjFrYOg*; brandId=-1; wmPoiId=600017; isOfflineSelfOpen=0; city_id=370200; isChain=0; existBrandPoi=false; userName=pysj2; logistics_support=1; cityId=310100; provinceId=310000; shopCategory=food; JSESSIONID=pvy81rleti6hzpgwrpy1dw93; _lxsdk_s=682bd1af673d0cbfbf32604d2e2b%7C%7C55; __mta=141857421.1479810603587.1479894752330.1479894757822.20; wpush_server_url=wss://wpush.meituan.com");

        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        //设置本次连接是否自动重定向
        connection.setInstanceFollowRedirects(true);
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection
                .getOutputStream());
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        //String content = "字段名=" + URLEncoder.encode("字符串值", "编码");
        String content = "userName=pysj2&password=13306392284&imgVerifyValue=4e3f";
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        //流用完记得关
        out.flush();
        out.close();
        //获取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
        //该干的都干完了,记得把连接断了
        connection.disconnect();
    }

    public static void main(String[] args) throws IOException {
//        httpURLConectionGET();
        //httpURLConnectionPOST();
        httpPost();
        System.out.println(new Date().getTime());
    }
}