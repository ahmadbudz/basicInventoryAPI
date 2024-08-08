"# basicInventoryAPI" 

GET Methods(needs EMPLOYEE role):

GET /api/inventory
	will show all items in the db
	
GET /api/inventory/id/{id}
	will show the item with that id
	
PUT Methods(needs MANAGER role):

PUT /api/inventory
	will update the item with the info specified in the request body
	
POST Methods(needs MANAGER role):
	
POST /api/inventory
	will add a item to the mysql db
	
Delete Methods(needs ADMIN role):

delete /api/inventory/id/{id}
	will delete the item with that id

