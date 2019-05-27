/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congruencialmultiplicativo;

import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-user
 */
public class CongruencialMultiplicativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 0;
        int x = 0;
        int m;
        int numero, d, modulo, semilla, t, cmultiplicativa;

        int opcion = 0;
        boolean dato = true;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Eliga una Opcion\n"
                    + "1    Congruencial Multiplicativo con el sistema Decimal\n"
                    + "2    Congruencial Multiplicativo con el sistema Binario\n"
                    + "3    Salir", null, JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    //Se ingresa los valores para "d"
                    d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de d", JOptionPane.QUESTION_MESSAGE));
                    //Creamos el módulo respectivo
                    modulo = (int) Math.pow(10, d);
                    //Se ingresa valores que para la semilla que no sean divisibles para 2 o 5 y sea relativamente primo a "módulo"
                    semilla = (int) primo_Cercano(modulo);

                    int p[] = {3, 11, 13, 19, 21, 27, 29, 37, 53, 59, 61, 67, 69, 77, 83, 91};
                    int numeroaleat = (int) (Math.random() * p.length) + 1;
                    int p_seleccionado = p[numeroaleat];

                    t = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese t", JOptionPane.QUESTION_MESSAGE));
                    cmultiplicativa = (200 * t) + p_seleccionado;
                    System.out.printf("n" + "\t\t" + "Xn" + " \n");
                    int ax = semilla;

                    for (int i = 0; i < 20; i++) {
                        //Se verifica cada uno de los valores
                        numero = (cmultiplicativa * semilla) % modulo;
                        System.out.printf(i + 1 + "\t\t" + numero + "\n");
                        semilla = numero;
                        if (ax == semilla) {
                            break;
                        }
                    }
                    break;
                case 2: // LA OPCION 2: SE DEBE DE INGRESAR LOS VALORES FINALES DE m Y a.
                    x = semilla();
                    a = multiplicador();
                    m = modulo();
                    calcular(x, a, m);
                    break;
                case 3: // LA OPCION 3: SIRVE PARA SALIR DEL PROGRAMA
                    dato = false;
                    break;
                default:
            }
        } while (dato);
    }
    
    //Método único creado para la opción del Sistema Decimal

    public static double primo_Cercano(double n) {
        int aux = 2;
        boolean b = true;

        while ((b) && (aux != n)) {
            if (n % aux == 0) {
                b = false;
            }
            aux++;
        }

        if (b) {
            return n;
        } else {
            return primo_Cercano(n - 1);
        }
    }

    //Métodos creados para la opcion del Sistema Binario.
    public static int semilla() {
        int x = 0;
        boolean numeroentero = false;
        do {
            try {
                //Aqui se ingresa el valor para la semill en donde se verificará si es relativamente primo a "m" y asi mismo sea impar
                x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de X:", null, JOptionPane.INFORMATION_MESSAGE));
                //Aqui se verifica si el número es un número primo
                if (x % 2 == 1) {
                    int a = 0;
                    for (int i = 1; i < (x + 1); i++) {
                        if (x % i == 0) {
                            a++;
                        }
                    }
                    //Se condiciona que el valor sea in número entero impar
                    if (a != 2) {
                        JOptionPane.showMessageDialog(null, "Debe ser un número primo");
                    } else {
                        numeroentero = true;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe se entero impar");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero impar");
            }
        } while (!numeroentero);
        return x;
    }

    public static int multiplicador() {
        int a = 0;
        int t = 0;
        boolean entero = false;
        do {
            try {
                //Se ingresa el valor de "t" donde se verificará que sea cualquier valor entero.
                t = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de t", null, JOptionPane.INFORMATION_MESSAGE));
                //Aqui se condiciona con respecto al documento que debe ser mayor o igual a cero
                if (t >= 0) {
                    //Se ingresa la fórmula correspondiente
                    a = (8 * t) + 3;
                    return a;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe se un número entero impar");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero un número entero impar");
            }
        } while (!entero);
        return a;
    }

    public static int modulo() {
        int m = 2;
        int d = 0;
        boolean numeroentero = false;
        do {
            try {
                //Aqui se solicita el valor para la variable d en donde este será el indicador del periodo que será para el valor de m=2
                d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de d", null, JOptionPane.INFORMATION_MESSAGE));
                //Se condiciona que m debe ser mayor o igual a  cero y asi mismo debe ser entero
                if (m >= 0) {
                    return (int) Math.pow(m, d);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe se entero");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!numeroentero);
        return m;
    }

    public static void calcular(int x, int a, int m) {
        int r = 0; // Resultado
        int i = 0; // Contador
        int x2 = x;
        double aux1, aux2;
        System.out.println("n\tX\t(ax + X)%m\tXn\tNumeros Uniformes");
        while (r != x2) {
            //Encuentra el resultado
            r = (a * x) % m;
            // Toma los valores para separar los datos
            aux1 = (a * x) % m;
            //Toma los valores para separar los datos
            aux2 = r % m;
            System.out.println(i + 1 + "\t" + x + "\t" + "(" + (int) a + "+" + (int) x + ")" + "%" + (int) m + "\t" + (int) r + "\t" + (double) r / m);
            x = (int) r;
            i++;
        }
    }

}
