package org.csu.my_pet_store_spring.persistence;


import org.csu.my_pet_store_spring.domain.LineItem;

import java.util.List;

public interface LineItemMapper {

  List<LineItem> getLineItemsByOrderId(int orderId);

  void insertLineItem(LineItem lineItem);

}
