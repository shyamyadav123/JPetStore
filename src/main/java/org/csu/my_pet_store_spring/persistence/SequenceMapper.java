package org.csu.my_pet_store_spring.persistence;


import org.csu.my_pet_store_spring.domain.Sequence;

public interface SequenceMapper {

  Sequence getSequence(Sequence sequence);
  void updateSequence(Sequence sequence);
}
