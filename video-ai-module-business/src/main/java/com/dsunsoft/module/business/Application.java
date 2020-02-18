package com.dsunsoft.module.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dsunsoft.core.config.VideoAiConfig;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

//@SpringBootApplication(scanBasePackages = "com.dsunsoft")
//@MapperScan("com.dsunsoft.module.business.dao")
@SpringBootApplication(scanBasePackages = "com.dsunsoft",exclude = PageHelperAutoConfiguration.class)
@EnableConfigurationProperties({VideoAiConfig.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		ShuiZhiInterface sz = new ShuiZhiInterface();
//		String responseData = sz.sendRequest();
//		System.out.println(responseData);
		//String md5 = DigestUtils.string2MD5("1562557999147deviceNoAMT19032315470001vrSrC1Zn671GUq8Mgq4Ioqvsl1PoWkm8");
		 // 注：执行main函数前请先将CONST.java文件中的APPID、SECRET以及PHONE填全，不然程序执行将会报错。

        // 获取管理员token
//        LechengManagServiceImpl userManager = new LechengManagServiceImpl();
//        HashMap<String, Object> paramsMap = new HashMap<String, Object>();
//        JSONObject json = userManager.accessToken(paramsMap);
//        JSONObject jsonResult = json.getJSONObject("result");
//        JSONObject jsonData = jsonResult.getJSONObject("data");
//        String token = jsonData.getString("accessToken");//At_f67da1182032463fb20a65687c88cc7d
//        System.out.println(token);
//        paramsMap = new HashMap<String, Object>();
//        paramsMap.put("token", token);
//        paramsMap.put("queryRange", "1-100");
//        
//        JSONObject json2 = userManager.liveList(paramsMap);
//        JSONObject jsonResult2 = json2.getJSONObject("result");
//        JSONObject jsonData2 = jsonResult2.getJSONObject("data");
//        
//        System.out.println(jsonData2.toJSONString());
        
        
	}
}
