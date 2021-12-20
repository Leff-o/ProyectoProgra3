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
		while(!queue.isEmpty()) {
			data += inventory.findNode(new Product(queue.getHead().getInfo(), "", 0, "", 0)).getInfo().toString();
			queue.deleteNode(queue.getHead().getInfo());
			data += "\n";
		}
		data += "Se han msotrado todas las solicitudes pendientes de la cola";
		return data;
	}
	
	public String seeOne() {
		String data = "";
		data += inventory.findNode(new Product(queue.getHead().getInfo(), "", 0, "", 0)).getInfo().toString();
		queue.deleteNode(queue.getHead().getInfo());
		data += "\n";
		data += "Se ha msotrado la solicitud en cabeza de al cola, quedan "+queue.getSize()+" peticiones en cola";
		return data;
		
	}
	
	public String addProduct(Long id, String description, double value, String supplier, int stock) {
		String data = "";
		inventory.addNode(new Product(id, description, value, supplier, stock));
		data = "El nuevo producto ha sido agregado exitosamente al inventario";
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
