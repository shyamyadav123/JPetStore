package com.nevercome.jpetstore.common.log.dao.impl;

import com.nevercome.jpetstore.common.log.JPetStoreRequest;
import com.nevercome.jpetstore.common.log.JPetStoreSession;
import com.nevercome.jpetstore.common.log.dao.LogDAO;
import com.nevercome.jpetstore.persistence.db.DBUtil;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogDAOImpl implements LogDAO {

    private static class SingletonHolder {
        private static final LogDAO INSTANCE = new LogDAOImpl();
    }

    private LogDAOImpl() {
    }

    public static final LogDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void saveSession(JPetStoreSession jPetStoreSession) {
        HttpSession session = jPetStoreSession.getSession();
        Map<String, Object> valMap = new HashMap<>();
        valMap.put("id", session.getId());
        valMap.put("ip", jPetStoreSession.getHostname());
        valMap.put("referer", jPetStoreSession.getInitialReferrer());
        valMap.put("is_bot", jPetStoreSession.isBot());
        valMap.put("request_count", jPetStoreSession.getStream().size());
        valMap.put("start_time", jPetStoreSession.getStart());
        valMap.put("end_time", jPetStoreSession.getLastRequest());
        try {
            int count = DBUtil.insert("session_record", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveSessionAttr(JPetStoreSession jPetStoreSession) {
        try {
            Enumeration<String> paraNames = jPetStoreSession.getSession().getAttributeNames();
            for (Enumeration e = paraNames; e.hasMoreElements(); ) {
                String thisAttr = e.nextElement().toString();
                Map<String, Object> valMap = new HashMap<>();
                Object object = jPetStoreSession.getSession().getAttribute(thisAttr);
                valMap.put("attribute", thisAttr);
                valMap.put("value", object.toString());
                valMap.put("sid", jPetStoreSession.getSession().getId());
                int count = DBUtil.insert("request_list", valMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRequestList(JPetStoreSession jPetStoreSession) {
        List<JPetStoreRequest> requestStream = jPetStoreSession.getStream();
        try {
            for (JPetStoreRequest request : requestStream) {
                Map<String, Object> valMap = new HashMap<>();
                valMap.put("ip", jPetStoreSession.getHostname());
                valMap.put("uri", request.toString());
                valMap.put("query", request.getQueryString());
                valMap.put("timestamp", request.getTimestamp());
                valMap.put("sid", jPetStoreSession.getSession().getId());
                int count = DBUtil.insert("request_list", valMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
