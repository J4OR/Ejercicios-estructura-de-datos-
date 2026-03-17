import java.util.Scanner;

public class Parcial_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos producto desea agregar: ");
        int n= sc.nextInt();
        Dispositivo[] dispositivos = new Dispositivo[n];
        for (int i = 0; i < n; i++){
            System.out.println("PRODUCTO" + (i+1) );
            System.out.println("Ingrese el id del producto:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese la marca del producto: ");
            String marca = sc.nextLine();
            System.out.println("Ingrese el precio del producto: ");
            double precio = sc.nextDouble();
            dispositivos[i] = new Dispositivo(id, marca, precio, id);
        };
        
        shellSort(dispositivos);

         System.out.println( "INVENTARIO ORDENADO ");

        for (int i = 0; i < dispositivos.length; i++) {
            System.out.println("ID: " + dispositivos[i].getId() + "|Nombre: " + dispositivos[i].getMarca() + 
                " |Precio: $" + dispositivos[i].getPrecio());
        }
        System.out.println("\nBUSQUEDA DE PRODUCTO POR ID");
        System.out.println("Ingrese el id del producto a buscar: ");
        int idBuscado= sc.nextInt();

        busquedaBinaria(dispositivos, idBuscado);
        sc.close();

        Dispositivo mayor = dispositivos[0];
        Dispositivo menor = dispositivos[0];

        for (int i = 0; i < dispositivos.length; i++) {
            if(dispositivos[i].getPrecio()>mayor.getPrecio()){
                mayor = dispositivos[i];
            }
            if (dispositivos[i].getPrecio()<menor.getPrecio()) {
                menor = dispositivos[i];                
            }
        }
        System.out.println("El Dispositivo con precio mas alto es:");
        System.out.println(mayor.getMarca());
        System.out.println("El dispositivo mas barato es : ");
        System.out.println(menor.getMarca());

        
    }
    //shell sort
    public static void shellSort(Dispositivo[] d) {

        int n = d.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Dispositivo temp = d[i];
                int j;
                for (j = i; j >= gap && d[j - gap].getId() > temp.getId(); j -= gap) {
                    d[j] = d[j - gap];
                }
                d[j] = temp;
            }
        }
    }

    //busqueda Binaria

    public static void busquedaBinaria (Dispositivo[] d, int idBuscado){
        int low= 0;
        int high = d.length - 1;
        boolean encontrar = false;

        while (low<=high) {
            int mid = (low + high) / 2;
            if(d[mid].getId()==idBuscado){
                System.out.println("Producto Encontrado");
                System.out.println("ID: "+ d[mid].getId() + " | " + d[mid].getMarca() + " | $" + d[mid].getPrecio());
                encontrar = true;
                break;
            } 
            if (idBuscado < d[mid].getId()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (!encontrar) {
            System.out.println("Producto no encontrado.");
        }
    }

    
}   

