import java.util.Scanner;
public class Main {

    private MyBinarySearchTree BST = new MyBinarySearchTree();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }
    public void run() {
        System.out.println("Bienvenido al programa del DANE:");
        int option;
        do {
            System.out.println("\nElija una de las siguientes opciones: ");
            System.out.println("***************************\n" +
                    "Registro DANE\n" +
                    "***************************\n" +
                    "1. Inscribir un ciudadano\n" +
                    "2. Consultar por cédula\n" +
                    "3. Eliminar ciudadano por cédula\n" +
                    "4. Salir");

            option = sc.nextInt();
            sc.nextLine();
            executeOption(option);

        } while(option != 4);
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Ingrese los siguientes datos de la persona: ");
                System.out.println("Nombre:");
                String name = sc.nextLine();
                System.out.println("Cedula:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Ciudad de nacimiento:");
                String city = sc.nextLine();
                System.out.println("Fecha de nacimiento:");
                String birthDate = sc.nextLine();
                BST.insert(name, id, city, birthDate);
                break;
            case 2:
                System.out.println("Ingrese el numero de cedula a buscar: ");
                int idSearch = sc.nextInt();
                sc.nextLine();
                System.out.println("Informacion de la persona:\n");
                BST.showSearch(idSearch);
                break;
            case 3:
                System.out.println("Ingrese el numero de cedula que quiere elminar: ");
                int idDelete = sc.nextInt();
                sc.nextLine();
                if(BST.delete(idDelete) != null) {
                    System.out.println("Eliminado correctamente");
                } else {
                    System.out.println("No se pudo eliminar el elemento");
                }
                break;
            case 4:
                System.out.println("Gracias por utilizar el programa :)");
                break;
        }
    }
}
