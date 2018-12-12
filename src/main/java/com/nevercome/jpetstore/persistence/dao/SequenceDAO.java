package com.nevercome.jpetstore.persistence.dao;

import com.nevercome.jpetstore.domain.model.Sequence;

public interface SequenceDAO {
    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
