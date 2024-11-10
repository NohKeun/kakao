package com.kakao.online.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneqoncore.core.component.OneQProcess;
import com.oneqoncore.core.interceptor.ControllerInterceptor;
import com.oneqoncore.core.mapper.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import jakarta.servlet.MultipartConfigElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer, WebMvcRegistrations {

    @Bean
    public OneQProcess oneQProcess(){
        return new OneQProcess();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return MapperUtil.getObjectMapper();
    }


    @Bean
    public ControllerInterceptor controllerInterceptor()
    {
        log.debug("controllerInterceptor");
        return new ControllerInterceptor(oneQProcess());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(controllerInterceptor())
//                .addPathPatterns("/**/*.SVC")
        ;
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean // 세션에 지역 설정. default는 KOREAN = 'ko'
    public LocaleResolver messageLocaleResolver() { // 지역 설정
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREAN);
        return slr;
    }

    @Bean // 지역설정을 변경하는 인터셉터. 요청시 파라미터에 lang 정보를 지정하면 변경됨
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

//    @Bean
//    public SessionLocaleResolver localeResolver() {
//        return new SessionLocaleResolver();
//    }

    @Bean
    public UrlFilenameViewController urlFilenameViewController() {
        return new UrlFilenameViewController();
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView ov = new MappingJackson2JsonView();
        ov.setContentType("application/json;charset=UTF-8");
        //ov.setObjectMapper(MapperUtil.getObjectMapper());

        ov.setObjectMapper(MapperUtil.mapper);
        return ov;
    }

    @Bean
    public ViewResolver beanNameResolver() {
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        resolver.setOrder(0);
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("");
    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        log.info("configureContentNegotiation start.....");

        configurer.defaultContentType(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON);
//		.useJaf(true)
        //configurer.favorPathExtension(true);
        configurer.mediaType("xml", MediaType.APPLICATION_XML);
        configurer.mediaType("pdf", MediaType.APPLICATION_PDF);
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
        configurer.mediaType("xls", MediaType.valueOf("application/vnd.ms-excel"));
        configurer.mediaType("text/plain", MediaType.TEXT_PLAIN);
//        configurer.mediaType("text/html",  MediaType.TEXT_HTML);
        configurer.ignoreAcceptHeader(true);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        log.info("contentNegotiatingViewResolver start.....");

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(beanNameResolver());
        // resolvers.add(new PdfViewResolver());
        // resolvers.add(new XlsViewResolver());
        resolver.setViewResolvers(resolvers);

        return resolver;
    }
}