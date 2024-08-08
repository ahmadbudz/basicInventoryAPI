package inventory.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inventory.models.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ItemsDAOImp implements ItemsDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ItemsDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*
	 * inserts the item into the mysql database
	 * @param Item new item 
	 * @return the inserted item
	 */
	@Override
	@Transactional
	public Item saveItem(Item item) {
		entityManager.persist(item);
		return entityManager.find(Item.class, item.getId());
	}
	
	/*
	 * returns all the items in the mysql database
	 * @return List<Item>
	 */
	@Override
	public List<Item> findAll() {
		TypedQuery<Item> theQuery = entityManager.createQuery("from Item", Item.class);
		return theQuery.getResultList();
	}
	
	/*
	 * return an item based on its id
	 * @param int id(primary key)
	 * @return Item
	 */
	@Override
	public Item findItem(int id) {
		return entityManager.find(Item.class, id);
	}
	
	/*
	 * updates the information of an item
	 * @param Item updated item
	 */
	@Override
	@Transactional
	public void updateItem(Item item) {
		entityManager.merge(item);
	}
	
	/*
	 * deletes an item from the database
	 * @param int id(primarykey)
	 */
	@Override
	@Transactional
	public void deleteItem(int id) {
		Item item = entityManager.find(Item.class, id);
		entityManager.remove(item);
	}

}
