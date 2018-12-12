package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Sequence;
import com.nevercome.jpetstore.persistence.dao.SequenceDAO;

public class SequenceDAOImpl implements SequenceDAO {

    private static class SingletonHolder {
        private static final SequenceDAO INSTANCE = new SequenceDAOImpl();
    }
    private SequenceDAOImpl() {}
    public static final SequenceDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Sequence getSequence(Sequence sequence) {
        return null;
    }

    @Override
    public void updateSequence(Sequence sequence) {

    }
}
