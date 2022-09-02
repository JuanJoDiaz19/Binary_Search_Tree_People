public class MyBinarySearchTree {
    private Node root;

    public void insert(String name, int id, String city, String birthDate ) {

        Person tempPerson = new Person(name, id, city, birthDate);
        Node node = new Node(id, tempPerson);
        if(root == null) {
            root = node;
        } else {
            insert(node, root);
        }
    }

    private void insert(Node insert, Node current) {
        if(insert.getKey() > current.getKey() ) {
            // Cuando va por la derecha
            if(current.getRight() == null){
                current.setRight(insert);
                return;
            } else {
                insert(insert, current.getRight());
            }
        } else if (insert.getKey() < current.getKey()) {
            //Cuando va por la izquierda
            if(current.getLeft() == null){
                current.setLeft(insert);
                return;
            } else {
                insert(insert, current.getLeft());
            }
        } else {
            //Cuando son iguales
        }
    }

    //Metodo de busqueda:
    public void showSearch(int goal){
        showSearch(goal, root, 1);
    }

    private void showSearch(int goal, Node current, int counter) {
        if (current == null) {
            System.out.println("Esta persona no esta en el sistema :(");
            return;
        }
        if( goal < current.getKey()) {
            //Cuando es menor que el numero
            showSearch(goal , current.getLeft(), counter + 1);
        }else if( goal > current.getKey()){
            //Cuando es mayor que el numero que estamos buscando
            showSearch(goal, current.getRight(), counter + 1);
        } else {
            //Cuando son iguales
            System.out.print(current.getValue());
            System.out.println("Encontrado en " + counter + " iteraciones\n***************************\n");
            return;

        }
    }

    /*public Node search(int goal){
        return search(goal, root, 1);
    }
    private Node search(int goal, Node current, int counter) {
        if (current == null) {
            return null;
        }
        if( goal < current.getKey()) {
            //Cuando es menor que el numero
            return search(goal , current.getLeft(), counter + 1);
        }else if( goal > current.getKey()){
            //Cuando es mayor que el numero que estamos buscando
            return search(goal, current.getRight(), counter + 1);
        } else {
            //Cuando son iguales
            return current;
        }
    }*/
    public Node delete(int goal){
        return delete(goal, root);
    }
    private Node delete(int goal, Node current){
        if(current == null){
            return null;
        }
        if(current.getKey() == goal){
            //1. Nodo Hoja
            if(current.getLeft() == null && current.getRight() == null){
                if(current == root){
                    root = null;
                }else{

                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getRight() == null){
                if(current == root){
                    root = current.getLeft();
                }
                return current.getLeft();
            }
            //3. Nodo solo hijo derecho
            else if(current.getLeft() == null){
                if(current == root){
                    root = current.getRight();
                }
                return current.getRight();
            }
            //4. Nodo con dos hijos
            else{
                Node min = getMin(current.getRight());
                //Transferencia de valores, NUNCA de conexiones
                current.setKey(min.getKey());
                current.setValue(min.getValue());
                //Hacer eliminación a partir de la derecha
                Node subarbolDER = delete(min.getKey(), current.getRight());
                current.setRight( subarbolDER );
                return current;
            }


        }else if(goal < current.getKey()){
            Node subArbolIzquierdo = delete(goal, current.getLeft());
            current.setLeft(subArbolIzquierdo);
            return current;
        }else{
            Node subArbolDerecho = delete(goal, current.getRight());
            current.setRight(subArbolDerecho);
            return current;
        }
    }

    public Node getMin(Node current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Metodo de Eliminacion





}
