package logic;

import java.util.ArrayList;

/**
 * Clase que hace el manejo de los arboles binarios y la lista circular
 */
public class Management {
	private BinaryTree<Product> inventory= new BinaryTree<Product>(Product.compareHash);
	private CircleLinkedList<Long> queue = new CircleLinkedList<>();

	/**
	 * Metodo que permite añadir a la cola (es la cola de pedidos a consultar)
	 * @param info
	 */
	public String addToQueue(Long info) {
		String data = "";
		if(verifyId(info)) {//retorna verdadero si existe el id
			data ="El id que desea solicitar en esta peticion no existe";
		}else {
			queue.addNode(info);
			data = "La peticion actual cuenta con "+(queue.getSize()-1)+" peticiones por delante";
		}
		return data;
	}

	/**
	 * Este metodo permite poder ver todos los productos en la cola
	 * @return data
	 */
	public String seeAll() {
		String data = "";
		if(queue.isEmpty()) {
			data = "No hay peticiones que mostrar";
		}else {
			while(!queue.isEmpty()) {
				data += inventory.findNode(new Product(queue.getHead().getInfo(), "", 0, "", 0)).getInfo().toString();
				queue.deleteNode(queue.getHead().getInfo());
				data += "\n";
			}
			data += "Se han mostrado todas las solicitudes pendientes de la cola";
		}
		return data;
	}

	/**
	 * Permite ver el primer producto entrado y visto a analizar
	 * @return data
	 */
	public String seeOne() {
		String data = "";
		if(queue.isEmpty()) {
			data = "No hay peticiones que mostrar";
		}else {
			data += inventory.findNode(new Product(queue.getHead().getInfo(), "", 0, "", 0)).getInfo().toString();
			queue.deleteNode(queue.getHead().getInfo());
			data += "\n";
			data += "Se ha mostrado la solicitud en cabeza de la cola, quedan "+queue.getSize()+" peticiones en cola";
		}
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
		String data = "Se ha eliminado correctamente";
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
		if(inventory.isEmpty()) {
			data = "No hay productos que msotrar";
		}else {
			ArrayList<Product> insort = inventory.getList();
			for(int i=0; i<insort.size(); i++) {
				data += (i+1)+". "+insort.get(i).toString()+"\n";
			}
		}
		return data;
	}
}
