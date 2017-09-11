package com.keessi.springMVC_tutorial.resolver;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UrlLocaleResolver implements LocaleResolver {
    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String uri = request.getRequestURI();
        System.out.println("URI = " + uri);
        String prefixEn = request.getServletContext().getContextPath() + "/en/";
        String prefixZh = request.getServletContext().getContextPath() + "/zh/";
        Locale locale = null;
        if (uri.startsWith(prefixEn)) {
            locale = Locale.ENGLISH;
        } else if (uri.startsWith(prefixZh)) {
            locale = Locale.CHINA;
        }
        if (locale != null) {
            request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        } else {
            locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                locale = Locale.ENGLISH;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
