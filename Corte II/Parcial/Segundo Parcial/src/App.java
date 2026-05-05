import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();
        int op = 0;
        while (op!=4) {
            System.out.println("====================================");
            System.out.println("                Menu");
            System.out.println("====================================");
            System.out.println("1. Visitar");
            System.out.println("2. Buscar");
            System.out.println("3. Ver todo");
            System.out.println("4. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                   
                    System.out.print("Url: ");
                    String url = sc.nextLine();
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    Pagina pagina = new Pagina(url, titulo);
                    historial.visitarPagina(pagina);
                    break;
                case 2:
                    System.out.println("Ingrese la url a buscar");
                    String urlB = sc.nextLine();
                    historial.buscarUrl(urlB);
                    break;
                case 3:
                    historial.verHistorial();
                    break;
                case 4:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
        
    }    
}

