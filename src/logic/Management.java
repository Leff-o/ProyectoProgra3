package logic;

import java.util.ArrayList;

/**
 * Clase que hace el manejo de los arboles binarios y la lista circular
 */
public class Management {
	private BinaryTree<Product> inventory;
	private CircleLinkedList<Long> queue;

	/**
	 * Metodo que permite añadir a la cola (es la cola de pedidos a consultar)
	 * @param info
	 */
	public void addToQueue(Long info) {
		queue.addNode(info);
	}

	/**
	 * Este metodo permite poder ver todos los productos en la cola
	 * @return data
	 */
	public String seeAll() {
		String data = "";
		while(!queue.isEmpty()) {
			data += inventory.findNode(new Product(queue.getHead().getInfo(), "", 0, "", 0)).getInfo().toString();
			queue.deleteNode(queue.getHead().getInfo());
			data += "\n";
		}
		data += "Se han mostrado todas las solicitudes pendientes de la cola";
		return data;
	}

	/**
	 * Permite ver el primer producto entrado y visto a analizar
	 * @return data
	 */
	public String seeOne() {
		String data = "";
		data += inventory.findNode(new Product(queue.getHead().getInfo(), "", 0, "", 0)).getInfo().toString();
		queue.deleteNode(queue.getHead().getInfo());
		data += "\n";
		data += "Se ha msotrado la solicitud en cabeza de al cola, quedan "+queue.getSize()+" peticiones en cola";
		return data;
		
	}


	/**
	 * Metodo que permite añadir un nuevo producto a la cola de inventarios
	 * @param id
	 * @param description
	 * @param value
	 * @param supplier
	 * @param stock
	 * @return data
	 */
	public String addProduct(Long id, String description, double value, String supplier, int stock) {
		String data = "";
		inventory.addNode(new Product(id, description, value, supplier, stock));
		data = "El nuevo producto ha sido agregado exitosamente al inventario";
		return data;
	}

	/**
	 * Este metodo permite eliminar un producto de la cola, con un id
	 * @param id
	 * @return data
	 */
	public String removeProduct(Long id) {
		String data = "";
		inventory.deleteNode(new Product(id, "", 0.0, "", 0));
		return data;
	}

	/**
	 *
	 * @param id
	 * metodo que permite verificar el id de un producto en el inventario
	 * @return boolean
	 */
	public boolean verifyId(Long id) {
		try {
			Product aux = inventory.findNode(new Product(id, "", 0.0, "", 0)).getInfo();
			if(aux==null) {
				return true;
			}else {
				return false;
			}
		} catch (NullPointerException e) {
			return true;
		}

	}



	/**
	 * Este metodo permite ver todos los productos que estan dentro del inventario o cola
	 * @return
	 */
	public String seeProducts() {
		String data = "";
		ArrayList<Product> insort = inventory.getList();
		for(int i=0; i<insort.size(); i++) {
			data += insort.get(i).toString();
		}
		return data;
	}
}
