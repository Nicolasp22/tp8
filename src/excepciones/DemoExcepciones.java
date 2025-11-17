package excepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoExcepciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. División segura
        System.out.println("\n--- 1. División Segura ---");
        try {
            System.out.print("Ingrese el numerador: ");
            int num1 = scanner.nextInt();
            System.out.print("Ingrese el divisor: ");
            int num2 = scanner.nextInt();
            System.out.println("Resultado: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: La entrada debe ser un número entero.");
            scanner.nextLine(); // Limpiar el buffer
        }

        // 2. Conversión de cadena a número
        System.out.println("\n--- 2. Conversión de Cadena ---");
        try {
            System.out.print("Ingrese un texto para convertir a número: ");
            String texto = scanner.next();
            int numero = Integer.parseInt(texto);
            System.out.println("Número convertido con éxito: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: La cadena ingresada no es un formato de número válido.");
        }

        // 4. Excepción personalizada
        System.out.println("\n--- 4. Excepción Personalizada ---");
        try {
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();
            verificarEdad(edad);
            System.out.println("Edad válida.");
        } catch (EdadInvalidaException e) {
            System.out.println("Error al validar la edad: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: La edad debe ser un número entero.");
            scanner.nextLine(); // Limpiar el buffer
        }

        // 3 y 5. Lectura de archivo y try-with-resources
        System.out.println("\n--- 3 y 5. Lectura de Archivo (try-with-resources) ---");
        leerArchivo("src/excepciones/ejemplo.html");
        scanner.close();
    }
    

    public static void verificarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {  
            throw new EdadInvalidaException("La edad (" + edad + ") debe estar entre 0 y 120.");
        }
    }

  
    public static void leerArchivo(String nombreArchivo) {
        // Usa try-with-resources para garantizar que BufferedReader se cierre
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) { 
            System.out.println("Error: Archivo no encontrado. Verifique la ruta.");
        } catch (IOException e) { 
            System.out.println("Error de I/O al leer el archivo: " + e.getMessage());
        }
    }
}