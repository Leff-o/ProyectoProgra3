package logic;

import java.util.ArrayList;

public class Management {
	
	private BinaryTree<Product> inventory;
	private CircleLinkedList<Long> queue;
	
	public void addToQueue(Long info) {
		queue.addNode(info);
	}
	
	public String seeAll() {
		String data = "";
		
		return data;
	}
	
	public String seeOne() {
		String data = "";
		
		return data;
		
	}
	
	public String addProduct(Long id, String description, double value, String supplier, int stock) {
		String data = "";
		Product aux = inventory.findNode(new Product(id, "", 0.0, "", 0)).getInfo();
		if(aux==null) {
			inventory.addNode(new Product(id, description, value, supplier, stock));
			data = "El nuevo producto ha sido agregado exitosamente al inventario";
		}else {
			data = "ERROR. El ID a regristrar pertenece al producto\n";
			data += aux.toString();
		}
		return data;
	}
	
	public String removeProduct(Long id) {
		String data = "";
		inventory.deleteNode(new Product(id, "", 0.0, "", 0));
		return data;
	}
	
	public String seeProducts() {
		String data = "";
		ArrayList<Product> insort = inventory.getList();
		for(int i=0; i<insort.size(); i++) {
			data += insort.get(i).toString();
		}
		return data;
	}
	
	

}
