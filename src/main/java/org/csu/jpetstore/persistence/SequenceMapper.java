package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Sequence;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface SequenceMapper {

    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
