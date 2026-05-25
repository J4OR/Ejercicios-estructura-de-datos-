public class ColaPacientes {
    private Paciente salida;
    private Paciente entrada;
    private int tamanio;

    public ColaPacientes() {
        this.salida  = null;
        this.entrada = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public Paciente peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay paciente en espera.");
            return null;
        }
        return salida;
    }

    public void enqueue(Paciente paciente) {
        if (isEmpty()) {
            salida  = paciente;
            entrada = paciente;
        } else {
            entrada.siguiente = paciente;
            entrada = paciente;
        }
        tamanio++;
    }

    public Paciente dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay pacientes en espera.");
            return null;
        }
        Paciente dato = salida;
        salida = salida.siguiente;
        if (salida == null) {
            entrada = null;
        }
        tamanio--;
        return dato;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("SALIDA -> ");
        Paciente actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.nombreCompleto + " | " + actual.sintomaPrincipal + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }

    public void atenderTodos() {
        if (isEmpty()) {
            System.out.println("No hay pacientes para atender.");
            return;
        }
        int totalAtendidos = 0;
        System.out.println("\n========== INICIO DE ATENCIÓN ==========");
        while (!isEmpty()) {
            Paciente p = dequeue();
            totalAtendidos++;
            System.out.println("\n  Turno #" + totalAtendidos);
            System.out.println("  Cedula:   " + p.cedula);
            System.out.println("  Paciente: " + p.nombreCompleto);
            System.out.println("  Edad:     " + p.edad + " anios");
            System.out.println("  Sintoma:  " + p.sintomaPrincipal);
        }
        System.out.println("\n========== FIN DEL TURNO ==========");
        System.out.println("Total de pacientes atendidos: " + totalAtendidos);
    }
}
