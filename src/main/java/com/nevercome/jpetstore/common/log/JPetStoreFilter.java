package com.nevercome.jpetstore.common.log;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

//@WebFilter("/**")
public class JPetStoreFilter implements javax.servlet.Filter {

    private static final Logger logger = Logger.getLogger("com.nevercome.jpetstore.common.log.JPetStoreFilter");

    public static final String FILTER_APPLIED = "jpetstoreFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("JPetStoreFilter init");
//        System.out.println("JPetStoreFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
// Ensure that filter is only applied once per request.
        if (servletRequest.getAttribute(FILTER_APPLIED) == null) {
            logger.info("Applying jpetstore filter to request.");

            servletRequest.setAttribute(FILTER_APPLIED, true);

            HttpServletRequest request = (HttpServletRequest) servletRequest;

            HttpSession session = request.getSession();
            JPetStoreSession jPetStoreSession = (JPetStoreSession) session.getAttribute(JPetStoreListener.SESSION_ATTRIBUTE_KEY);
            jPetStoreSession.addRequest(request);
        } else {
            logger.info("Jpetstore filter already applied, ignoring it.");
        }

//         pass the request on
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
