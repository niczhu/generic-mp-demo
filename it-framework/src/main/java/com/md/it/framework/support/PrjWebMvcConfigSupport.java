package com.md.it.framework.support;

import com.md.it.framework.support.converter.PrjJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PrjWebMvcConfigSupport extends WebMvcConfigurationSupport {

    /**
     * 解决controller中@responseBody返回中文字符串乱码问题
     *
     * @param
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }

    /**
     * 解决返回json对象中文乱码问题
     * 继承 WebMvcConfigurationSupport后不能再使用@Bean 来装配转换器
     *
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        //处理中文乱码问题
        List<MediaType> fastMediaTypeList = new ArrayList<MediaType>();
        fastMediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);

        //在convert中添加配置信息
        PrjJsonHttpMessageConverter defaultJsonHttpMessageConverter = new PrjJsonHttpMessageConverter();
        defaultJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypeList);

        HttpMessageConverter<?> converter = defaultJsonHttpMessageConverter;
        converters.add(converter);

        super.configureMessageConverters(converters);
    }

    /**
     * 解决返回json对象中文乱码问题
     * 继承 WebMvcConfigurationSupport后不能再使用@Bean 来装配转换器
     * @return
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//
//        //处理中文乱码问题
//        List<MediaType> fastMediaTypeList = new ArrayList<MediaType>();
//        fastMediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
//
//        //在convert中添加配置信息
//        JsonHttpMessageConverter defaultJsonHttpMessageConverter = new JsonHttpMessageConverter();
//        defaultJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypeList);
//
//        HttpMessageConverter<?> converter = defaultJsonHttpMessageConverter;
//
//        return new HttpMessageConverters(converter);
//    }

}
