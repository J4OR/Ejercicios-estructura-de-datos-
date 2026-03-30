// 3. Sensor de Temperatura (Control de Calidad)
// Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.

// El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada para asegurarse de 
// que la máquina no se recalentó.
// Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos.

public class Ejercicio_3_Arrays {
        public static void main(String[] args) {
            double[] temperaturas = {22.5, 23.0, 21.8, 24.1, 25.3, 20.9, 26.7, 24.5};
            double temperaturaMaxima = temperaturas[0];
            busquedaLineal(temperaturas, temperaturaMaxima);
            System.out.println("La temperatura más alta registrada es: " + temperaturaMaxima + "°C");
        }

        public static void busquedaLineal (double[] temperaturas, double temperaturaMaxima){
            for (int i = 0; i < temperaturas.length; i++) {
                if (temperaturas [i] > temperaturaMaxima){
                    temperaturaMaxima = temperaturas[i];
                }
            }
        }

        
}
