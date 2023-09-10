
package com.mycompany.cal.naci.edad;
import java.util.Scanner;
public class CalNaciEdad {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la fecha actual (formato dd/mm/aaaa):");
        String fechaActual = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (formato dd/mm/aaaa):");
        String fechaNacimiento = scanner.nextLine();

        if (fecha_valida(fechaActual) && fecha_valida(fechaNacimiento)) {
            int edad = calcular_edad(fechaActual, fechaNacimiento);
            System.out.println("La edad es: " + edad + " años.");
        } else {
            System.out.println("Fechas ingresadas no válidas.");
        }
    }

    public static boolean fecha_valida(String fecha) {
        String[] partes = fecha.split("/");
        if (partes.length != 3) {
            return false;
        }

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 0) {
            return false;
        }

        if (mes == 2) {
            if (bisiesto(anio)) {
                return dia <= 29;
            } else {
                return dia <= 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return dia <= 30;
        } else {
            return true;
        }
    }

    public static boolean bisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static int calcular_edad(String fechaActual, String fechaNacimiento) {
        String[] partesActual = fechaActual.split("/");
        String[] partesNacimiento = fechaNacimiento.split("/");

        int diaActual = Integer.parseInt(partesActual[0]);
        int mesActual = Integer.parseInt(partesActual[1]);
        int anioActual = Integer.parseInt(partesActual[2]);

        int diaNacimiento = Integer.parseInt(partesNacimiento[0]);
        int mesNacimiento = Integer.parseInt(partesNacimiento[1]);
        int anioNacimiento = Integer.parseInt(partesNacimiento[2]);

        int edad = anioActual - anioNacimiento;

        if (mesActual < mesNacimiento || (mesActual == mesNacimiento && diaActual < diaNacimiento)) {
            edad--;
        }

        return edad;
    }
}
