package inventory.DAO;

import java.util.List;

import inventory.models.Item;

public interface ItemsDAO {

	Item saveItem(Item item);

	List<Item> findAll();

	Item findItem(int id);
	
	void updateItem(Item item);
	
	void deleteItem(int id);
}
