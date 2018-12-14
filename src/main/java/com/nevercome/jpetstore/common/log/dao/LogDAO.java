package com.nevercome.jpetstore.common.log.dao;

import com.nevercome.jpetstore.common.log.JPetStoreSession;

public interface LogDAO {

    void saveSession(JPetStoreSession jPetStoreSession);

    void saveSessionAttr(JPetStoreSession jPetStoreSession);

    void saveRequestList(JPetStoreSession jPetStoreSession);
}
