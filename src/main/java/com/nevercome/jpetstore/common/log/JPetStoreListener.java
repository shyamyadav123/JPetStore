package com.nevercome.jpetstore.common.log;

import com.nevercome.jpetstore.common.log.service.LogService;
import com.nevercome.jpetstore.common.log.service.impl.LogServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@WebListener
public class JPetStoreListener implements ServletContextListener, HttpSessionListener {

//    private static final Log log = LogFactory.getLog(JPetStoreListener.class);
//    private static final Log log = LogFactory.getLog(JPetStoreListener.class);

    private LogService logService = LogServiceImpl.getInstance();

    private static final Logger logger = Logger.getLogger("com.nevercome.jpetstore.common.log.JPetStoreListener");

    /**
     * The servlet context attribute key.
     */
    public static final String JPETSTORE_ATTRIBUTE_KEY = "jpetstores";

    /**
     * The click stream (individual) attribute key: this is
     * the one inserted into the HttpSession.
     */
    public static final String SESSION_ATTRIBUTE_KEY = "jpetstore";

    private Map<String, JPetStoreSession> jPetStoreMap = new ConcurrentHashMap<>();

    public JPetStoreListener() {
        logger.info("JPetStoreLogger Constructed");
    }
//

    /***
     * Notification that the ServletContext has been initialized.
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("ServletContext initialised");
        servletContextEvent.getServletContext().setAttribute(JPETSTORE_ATTRIBUTE_KEY, jPetStoreMap);
    }

    /***
     * Notification that the ServletContext has been destroyed.
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("ServletContext destroyed");
        jPetStoreMap.clear(); //应该在此处完成持久化 为什么不是在session被销毁的时候
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        final HttpSession session = httpSessionEvent.getSession();
//        session.setMaxInactiveInterval(15);
        logger.info("Session " + session.getId() + " was created, adding a new jpetstore.");
        Object attrValue = session.getAttribute(SESSION_ATTRIBUTE_KEY);
        if (attrValue != null) {
            logger.info("Session " + session.getId() + " already has an attribute named " +
                    SESSION_ATTRIBUTE_KEY + ": " + attrValue);
        }
        final JPetStoreSession jPetStoreSession = new JPetStoreSession();
//        为新建的session绑定一个jpetstore
        session.setAttribute(SESSION_ATTRIBUTE_KEY, jPetStoreSession);
        jPetStoreMap.put(session.getId(), jPetStoreSession);
    }

    /***
     * Notification that a session has been destroyed.销毁session，应该在此方法内完成对应jpetstore的持久化
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        final HttpSession session = httpSessionEvent.getSession();
        logger.info("Session " + session.getId() + " is ready to destroy");
//         check if the session is not null (expired)
        if (session == null) {
            logger.info("Session " + session.getId() + " was destroyed, logging the jpetstore and removing it.");
            return;
        }
        final JPetStoreSession jPetStoreSession = jPetStoreMap.get(session.getId());
        if (jPetStoreSession == null) {
            logger.warning("Session " + session.getId() + " doesn't have a jpetstore.");
            return;
        }
        try {
            if (jPetStoreSession.getSession() != null) {
//                ClickstreamLoggerFactory.getLogger().log(jPetStoreSession);
                logger.info(jPetStoreSession.toString());
//                持久化这个session的信息
//                持久化session的属性
//                持久化session对应的requestList
                logService.save(jPetStoreSession);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            jPetStoreMap.remove(session.getId());
        }
    }
}
