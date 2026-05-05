public class Historial {
    Pagina cabeza;
    Pagina actual;
    int totalVisitas = 0;

    public Historial(){
        this.cabeza = null;
        this.actual = null;
    }

    public boolean estavacia(){
       return cabeza==null;
    }
    
    public void visitarPagina(Pagina nuevaPagina){
        if (estavacia()) {
            cabeza = nuevaPagina;
            actual = nuevaPagina;
        }else{
            actual = cabeza;
            while (actual.siguiente!= null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaPagina;
        }
    }

    public void buscarUrl(String url){
        if (estavacia()) {
            System.out.println("Lista vacia ");
            return;
        }

        actual = cabeza;
        while (actual != null) {
            if (actual.url.equalsIgnoreCase(url)) {
                actual.visitas += 1;
                System.out.println("[" + actual.url + "| " + actual.titulo + "| " + actual.visitas + "]");
            }

            actual = actual.siguiente;
        }
    }

    public void verHistorial(){
        if (estavacia()) {
            System.out.println("No hay paginas");
        }
        actual = cabeza;
        System.out.println("--- HISTORIAL COMPLETO ---");
        while (actual != null) {
            System.out.println("[" + actual.url + "| " + actual.titulo + "| " + actual.visitas + "]");
            totalVisitas += actual.visitas;
            actual = actual.siguiente;
        }
        String mayor = PaginaTop();
        System.out.println("visitas totales : " + totalVisitas + " | " + "Pagina mas vista: " + mayor);

    
    }
    
    public String PaginaTop(){
        actual = cabeza;
        Pagina paginaTop = cabeza;
        while (actual.siguiente!= null) {
            if (actual.visitas > paginaTop.visitas) {
                paginaTop = actual;
            }
            actual = actual.siguiente;
        }
        return paginaTop.url;
    }


}

