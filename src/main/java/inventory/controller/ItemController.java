package inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inventory.DAO.ItemsDAOImp;
import inventory.models.Item;

@RestController
@RequestMapping("/api/inventory")
public class ItemController {
	
	private ItemsDAOImp itemsDAOImp;
	
	@Autowired
	public ItemController(ItemsDAOImp itemsDAOImp) {
		this.itemsDAOImp = itemsDAOImp;
	}
	
	@GetMapping("")
	public List<Item> findAll(){
		return itemsDAOImp.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Item findItem(@PathVariable int id) {
		return itemsDAOImp.findItem(id);
	}
	
	@PostMapping()
	public Item insertItem(@RequestBody Item item) {
		return itemsDAOImp.saveItem(item);
	}
	
	@PutMapping()
	public void updateItem(@RequestBody Item item) {
		itemsDAOImp.updateItem(item);
	}
	
	@DeleteMapping("/id/{id}")
	public void deleteItem(@PathVariable int id) {
		itemsDAOImp.deleteItem(id);
	}
	
	
}
