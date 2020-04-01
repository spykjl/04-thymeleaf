package com.karl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


//官方建议扩展spring mvc方法
@Configuration
public class MyLocalResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();

        if (!StringUtils.isEmpty(language)) {
//            System.out.println("debug:"+language);
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
