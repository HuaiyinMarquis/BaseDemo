package com.springTest.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 定义我们自己的LocaleResolver用来替代spring Boot默认定义的
 *  org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter#localeResolver()
 *  用于方便个性化识别区域信息（国际化）
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String local = request.getParameter("lan");
        if (!StringUtils.isEmpty(local) && "en".equals(local))
            return Locale.US;
        return Locale.CHINESE;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
