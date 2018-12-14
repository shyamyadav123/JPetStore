package com.nevercome.jpetstore.common.log.service.impl;

import com.nevercome.jpetstore.common.log.JPetStoreSession;
import com.nevercome.jpetstore.common.log.dao.LogDAO;
import com.nevercome.jpetstore.common.log.dao.impl.LogDAOImpl;
import com.nevercome.jpetstore.common.log.service.LogService;

public class LogServiceImpl implements LogService {

    private LogDAO logDAO = LogDAOImpl.getInstance();

    @Override
    public void save(JPetStoreSession jPetStoreSession) {
        logDAO.saveSession(jPetStoreSession);
        logDAO.saveSessionAttr(jPetStoreSession);
        logDAO.saveRequestList(jPetStoreSession);
    }

    private static class SingletonHolder {
        private static final LogService INSTANCE = new LogServiceImpl();
    }

    private LogServiceImpl() {
    }

    public static final LogService getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
