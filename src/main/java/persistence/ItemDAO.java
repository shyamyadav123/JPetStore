package persistence;

import domain.Item;

import java.util.List;
import java.util.Map;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public interface ItemDAO {

    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);

}
