package com.nevercome.jpetstore.common.log;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JPetStoreListener implements ServletContextListener, HttpSessionListener {

////    private static final Log log = LogFactory.getLog(JPetStoreListener.class);
//    private static final Log log = LogFactory.getLog(JPetStoreListener.class);
//
//    /** The servlet context attribute key. */
//    public static final String JPETSTORE_ATTRIBUTE_KEY = "jpetstores";
//
//    /**
//     * The click stream (individual) attribute key: this is
//     * the one inserted into the HttpSession.
//     */
//    public static final String SESSION_ATTRIBUTE_KEY = "jpetstore";
//
//    private Map<String, JPetStore> jPetStoreMap = new ConcurrentHashMap<>();
//
//    public JPetStoreListener() {
//        log.logDebug("JPetStoreLogger Constructed");
//    }
//
//    /***
//     * Notification that the ServletContext has been initialized.
//     * @param servletContextEvent
//     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        log.logDebug("ServletContext initialised");
//        servletContextEvent.getServletContext().setAttribute(JPETSTORE_ATTRIBUTE_KEY, jPetStoreMap);
    }

    /***
     * Notification that the ServletContext has been destroyed.
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        log.logDebug("ServletContext destroyed");
//        jPetStoreMap.clear();
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        final HttpSession session = httpSessionEvent.getSession();
//        if(log.isDebugEnabled()) {
//            log.logDebug("Session " + session.getId() + " was created, adding a new jpetstore.");
//        }

//        Object attrValue = session.getAttribute(SESSION_ATTRIBUTE_KEY);
//        if (attrValue != null) {
//            log.logWarn("Session " + session.getId() + " already has an attribute named " +
//                    SESSION_ATTRIBUTE_KEY + ": " + attrValue);
//        }
//        final JPetStore jPetStore = new JPetStore();
//        为新建的session绑定一个jpetstore
//        session.setAttribute(SESSION_ATTRIBUTE_KEY, jPetStore);
//        jPetStoreMap.put(session.getId(), jPetStore);
    }

    /***
     * Notification that a session has been destroyed.销毁session，应该在此方法内完成对应jpetstore的持久化
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        final HttpSession session = httpSessionEvent.getSession();
        // check if the session is not null (expired)
//        if (session == null) {
//            return;
//        }if (log.isDebugEnabled()) {
//            log.logDebug("Session " + session.getId() + " was destroyed, logging the jpetstore and removing it.");
//        }
//        final JPetStore jPetStore = jPetStoreMap.get(session.getId());
//        if(jPetStore == null) {
//            log.logWarn("Session " + session.getId() + " doesn't have a jpetstore.");
//            return;
//        }
//        try {
//            if (jPetStore.getSession() != null) {
////                ClickstreamLoggerFactory.getLogger().log(jPetStore);
//            }
//        }
//        catch (Exception e) {
//            log.logError(e.getMessage(), e);
//        }
//        finally {
//            jPetStoreMap.remove(session.getId());
//        }
    }
}
