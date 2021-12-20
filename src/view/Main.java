package view;

import javax.swing.JOptionPane;

import logic.Management;

public class Main {

    private static Management mng;

    public static void main(String[] args) {
        mng=new Management();
        menu();
    }

    public static void menu(){
        boolean menu=true;
        String[] options= {
        		//METODOS PRODUCTOS AL ARBOL
                "Agregar productos",
                "Eliminar productos",
                "Ver produtos",
                //METODOS PETICIONES A LA COLA
                "Agregar peticion",
                "Mostar peticion en cola",
                "Mostar todas las peticiones en cola",
                //
                "Salir"
        };
        while (menu==true) {
            String option=(String) JOptionPane.showInputDialog(null,"Seleccione una opcion", "Opciones",JOptionPane.DEFAULT_OPTION,null,options,options[0]);
            if (option!=null) {
                switch (option){
                    case "Agregar productos":
                        boolean addId=true;
                        while(addId==true) {
                            String idJO=JOptionPane.showInputDialog("Ingrese el id");
                            if(idJO!=null) {
                                try {
                                    Long id=Long.parseLong(idJO);
                                    boolean exist=mng.verifyId(id);
                                    if (exist==true) {
                                        addId=false;
                                        boolean addDescription=true;
                                        while(addDescription==true) {
                                            String description=JOptionPane.showInputDialog("Ingrese la descripcion");
                                            if (description!=null) {
                                                addDescription=false;
                                                boolean addValue=true;
                                                while(addValue==true) {
                                                    String valueJO=JOptionPane.showInputDialog("Ingrese el valor");
                                                    if (valueJO!=null) {
                                                        try {
                                                            double value=Double.parseDouble(valueJO);
                                                            addValue=false;
                                                            boolean addSupplier=true;
                                                            while(addSupplier==true) {
                                                                String supplier=JOptionPane.showInputDialog("Ingrese el nombre del proveedor");
                                                                if (supplier!=null) {
                                                                    addSupplier=false;
                                                                    boolean addStock=true;
                                                                    while(addStock==true) {
                                                                        String stockJO=JOptionPane.showInputDialog("Ingrese el numero de stock");
                                                                        if(stockJO!=null) {
                                                                            try {
                                                                                int stock=Integer.parseInt(stockJO);
                                                                                addStock=false;
                                                                                JOptionPane.showMessageDialog(null, mng.addProduct(id, description, value, supplier, stock));
                                                                            }catch (NumberFormatException e) {
                                                                                JOptionPane.showMessageDialog(null, "Error, verifique que ingreso numeros","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                                                            }
                                                                        }else {
                                                                            int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                                                            if (ans==0) {
                                                                                addStock=false;
                                                                            }
                                                                        }
                                                                    }
                                                                }else {
                                                                    int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                                                    if (ans==0) {
                                                                        addSupplier=false;
                                                                    }
                                                                }
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            JOptionPane.showMessageDialog(null, "Error, verifique que ingreso numeros","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }else {
                                                        int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                                        if (ans==0) {
                                                            addValue=false;
                                                        }
                                                    }
                                                }
                                            }else {
                                                int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                                if (ans==0) {
                                                    addDescription=false;
                                                }
                                            }
                                        }
                                    }else {
                                        JOptionPane.showMessageDialog(null, "Error, el id ya existe","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error, verifique que ingreso numeros","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                }
                            }else {
                                int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                if (ans==0) {
                                    addId=false;
                                }
                            }
                        }
                        break;
                    case "Eliminar productos":
                        boolean idExist=true;
                        while(idExist==true) {
                            String idJO=JOptionPane.showInputDialog("Ingrese el id a eliminar");
                            if (idJO!=null) {
                                try {
                                    Long id=Long.parseLong(idJO);
                                    boolean exist=mng.verifyId(id);
                                    if (exist!=true) {
                                        JOptionPane.showMessageDialog(null, mng.removeProduct(id));
                                        idExist=false;
                                    }else {
                                        JOptionPane.showMessageDialog(null, "Error, El id no se encontro","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                        idExist=false;
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error, verifique que ingreso numeros","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                }
                            }else {
                                int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                if (ans==0) {
                                    idExist=false;
                                }
                            }
                        }
                        break;
                    case "Ver produtos":
                        if(mng.seeProducts()!="") {
                            JOptionPane.showMessageDialog(null, mng.seeProducts());
                        }else {
                            JOptionPane.showMessageDialog(null, "Error, verifique que ya haya añadido productos","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Agregar peticion":
                    	boolean addRequest=true;
                        while(addRequest==true) {
                            String requestkJO=JOptionPane.showInputDialog("Ingrese el id del producto a pedir");
                            if(requestkJO!=null) {
                                try {
                                    Long request=Long.parseLong(requestkJO);
                                    addRequest=false;
                                    JOptionPane.showMessageDialog(null, mng.addToQueue(request));
                                }catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error, verifique que ingreso numeros","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                                }
                            }else {
                                int ans= JOptionPane.showConfirmDialog(null, "¿Estas seguro?","Alerta",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
                                if (ans==0) {
                                	addRequest=false;
                                }
                            }
                        }
                    	break;
                    case "Mostar peticion en cola":
                    	String txt = mng.seeOne();
                        if(txt!="") {
                            JOptionPane.showMessageDialog(null, txt);
                        }else {
                            JOptionPane.showMessageDialog(null, "Error, verifique que ya haya añadido productos","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Mostar todas las peticiones en cola":
                    	String txt1 = mng.seeAll();
                        if(txt1!="") {
                            JOptionPane.showMessageDialog(null, txt1);
                        }else {
                            JOptionPane.showMessageDialog(null, "Error, verifique que ya haya añadido productos","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Salir":
                        JOptionPane.showMessageDialog(null, "Hasta pronto", "Adios", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                }
            }else {
                JOptionPane.showMessageDialog(null, "Hasta pronto", "Adios", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }
}