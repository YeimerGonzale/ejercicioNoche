/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kilos;
import javax.swing.JOptionPane;

public class Kilos {
    private String nombre;
    private double totalKilos;
    private final double precioPorKilo = 4200; // Precio por kilo de fruta

    // Constructor
    public Kilos(String nombre) {
        this.nombre = nombre;
        this.totalKilos = 0;
    }

    // Método para comprar una cantidad de kilos de fruta
    public void comprarFruta(double kilos) {
        totalKilos += kilos;
    }

    // Método para calcular el descuento basado en la cantidad de kilos comprados
    public double calcularDescuento() {
        if (totalKilos >= 5) {
            return 0.1; // 10% de descuento si se compran 5 kilos o más
        }
        return 0; // Sin descuento
    }

    // Método para calcular el monto total a pagar después del descuento
    public double calcularTotal() {
        double descuento = calcularDescuento();
        double subtotal = totalKilos * precioPorKilo;
        return subtotal - (subtotal * descuento);
    }

    // Método para mostrar el resultado de la compra utilizando JOptionPane
    public void mostrarResultado() {
        double descuento = calcularDescuento();
        double totalPagar = calcularTotal();

        String mensaje = "Nombre: " + nombre + "\n" +
                         "Total kilos comprados: " + totalKilos + "\n" +
                         "Descuento aplicado: " + (descuento * 100) + "%\n" +
                         "Total a pagar: $" + totalPagar;

        JOptionPane.showMessageDialog(null, mensaje, "Resultado de la compra", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        Kilos compra = new Kilos(nombre);

        // Loop para permitir al usuario comprar múltiples veces
        while (true) {
            double kilosComprar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese los kilos de fruta a comprar:"));
            compra.comprarFruta(kilosComprar);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea comprar más fruta?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Mostrar el resultado final de la compra
        compra.mostrarResultado();
    }
}
