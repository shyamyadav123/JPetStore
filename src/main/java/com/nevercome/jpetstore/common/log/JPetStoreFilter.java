package com.nevercome.jpetstore.common.log;

import com.mysql.jdbc.log.LogFactory;
import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JPetStoreFilter implements javax.servlet.Filter {

//    private static final Log log = LogFactory.getLog();

    public static final String FILTER_APPLIED = "jpetstoreFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
// Ensure that filter is only applied once per request.
        if (servletRequest.getAttribute(FILTER_APPLIED) == null) {
//            log.debug("Applying clickstream filter to request.");

            servletRequest.setAttribute(FILTER_APPLIED, true);

            HttpServletRequest request = (HttpServletRequest) servletRequest;

            HttpSession session = request.getSession();
            JPetStore jPetStore = (JPetStore) session.getAttribute(JPetStoreListener.SESSION_ATTRIBUTE_KEY);
            jPetStore.addRequest(request);
        } else {
//            log.debug("Clickstream filter already applied, ignoring it.");
        }

        // pass the request on
//        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
