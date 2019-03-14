package com.cyh.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyh.entity.weChat.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WeChat_GetAccessToken implements Runnable{

    public static String AppID;

    public static String AppSecret;

    public static String GetAccessTokenUrl;

    @Value("${WeChat.AppID}")
    public void setAppID(String thisAppID) {
        AppID = thisAppID;
    }

    @Value("${WeChat.AppSecret}")
    public void setAppSecret(String thisAppSecret) {
        AppSecret = thisAppSecret;
    }

    @Value("${WeChat.GetAccessTokenUrl}")
    public void setGetAccessTokenUrl(String thisGetAccessTokenUrl) {
        GetAccessTokenUrl = thisGetAccessTokenUrl;
    }

    private static boolean onlyOneRun = true;

    public static AccessToken accessToken = null;

    @Override
    public void run() {
        GetAccessTokenUrl = GetAccessTokenUrl.replace("AppID",AppID);
        GetAccessTokenUrl = GetAccessTokenUrl.replace("AppSecret",AppSecret);
        while (true){
            try{
                accessToken = this.getAccessToken();
                if(null!=accessToken){

                    if(onlyOneRun){
                        onlyOneRun = false;
                        //项目启动：创建一次微信菜单
                        WeChat_CreateMenuUtil.CreateMenus();
                    }

                    Thread.sleep(7000 * 1000); //获取到access_token 休眠7000秒
                }else{
                    Thread.sleep(1000*3); //获取的access_token为空 休眠3秒
                }
            }catch(Exception e){
                System.out.println("发生异常："+e.getMessage());
                e.printStackTrace();
                try{
                    Thread.sleep(1000*10); //发生异常休眠1秒
                }catch (Exception e1){

                }
            }
        }
    }

    /**
     * 获取access_token
     * @return
     */
    private AccessToken getAccessToken(){
        String Url = String.format(GetAccessTokenUrl);
        String result = getHttpsResponse(Url,"","");
        Date date = new Date();
        System.out.println("["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) +"]-->"+result);
        JSONObject json = JSON.parseObject(result);
        AccessToken token = new AccessToken();
        token.setAccessToken(json.getString("access_token"));
        token.setExpiresin(json.getInteger("expires_in"));
        return token;
    }

    /**
     * 请求一个https地址
     * @param hsUrl 请求的url
     * @param requestMethod  get/post
     * @param menu  请求的菜单
     * @return
     */
    public static String getHttpsResponse(String hsUrl, String requestMethod,String menu) {
        URL url;
        InputStream is = null;
        String resultData = "";
        try {
            url = new URL(hsUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            TrustManager[] tm = {xtm};
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tm, null);
            con.setSSLSocketFactory(ctx.getSocketFactory());
            con.setHostnameVerifier((arg0, arg1) -> true);
            con.setDoInput(true); //允许输入流，即允许下载
            //在android中必须将此项设置为false
            con.setDoOutput(false); //允许输出流，即允许上传
            con.setUseCaches(false); //不使用缓冲
            if(null!=requestMethod && !requestMethod.equals("")) {
                con.setRequestMethod(requestMethod); //使用指定的方式
            }
            else{
                con.setRequestMethod("GET"); //使用get请求
            }
            // 当有数据需要提交时
            if (null!=menu && !menu.equals("")) {
                OutputStream outputStream = con.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(menu.getBytes("UTF-8"));
                outputStream.close();
            }
            is = con.getInputStream();   //获取输入流，此时才真正建立链接
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isr);
            String inputLine = "";
            while ((inputLine = bufferReader.readLine()) != null) {
                resultData += inputLine + "\n";
            }
            Certificate[] certs = con.getServerCertificates();
            for (Certificate cert : certs) {
                X509Certificate xcert = (X509Certificate) cert;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }

    static X509TrustManager xtm = new X509TrustManager() {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
            // TODO Auto-generated method stub
        }
        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
            // TODO Auto-generated method stub
        }
    };
}
