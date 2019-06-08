package persistence;

import domain.Sequence;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public interface SequenceDAO {

    Sequence getSequence(Sequence sequence);

    void updateSequence(Sequence sequence);

}
