package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Item;

import java.util.List;
import java.util.Map;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface ItemMapper {
    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);
}
