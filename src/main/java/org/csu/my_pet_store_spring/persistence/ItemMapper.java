package org.csu.my_pet_store_spring.persistence;

import java.util.List;
import java.util.Map;
import org.csu.my_pet_store_spring.domain.Item;

public interface ItemMapper {
    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);
}
