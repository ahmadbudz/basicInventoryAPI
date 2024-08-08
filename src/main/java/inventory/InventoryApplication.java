package inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import inventory.DAO.ItemsDAOImp;
import inventory.models.Item;

@SpringBootApplication
public class InventoryApplication {
	
	@Autowired
	private ItemsDAOImp itemsDAOImp;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return runner -> {
			initTableData();
		};
	}
	
	private void initTableData() {
		Item item1 = new Item("milk",20,120);
		Item item2 = new Item("eggs",11,300);
		Item item3 = new Item("honey",27,300);
		Item item4 = new Item("zaatar",7,500);
		Item item5 = new Item("oil",16,50);
		
		itemsDAOImp.saveItem(item1);
		itemsDAOImp.saveItem(item2);
		itemsDAOImp.saveItem(item3);
		itemsDAOImp.saveItem(item4);
		itemsDAOImp.saveItem(item5);
		
	}
	
}
