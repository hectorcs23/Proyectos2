import java.util.*;

public class Gato_Ocampo_Angel_Guzman_Guillermo_Campbell_Hector {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner leerDatos = new Scanner(System.in);

    public static void main(String[] args) {
        int a=0,b=0, op = 0, aa = 0, cont = 1, x=0 ,y=0,z=0,p=0,c=0,d=0;
      
        System.out.println(
                "Grupo 2438 \nNombre 1: 38965, Angel Ocampo \nNombre 2: 39815, Guillermo Guzman \nNombre 3: 39181, Hector Campbell\n\n\t\tGatito\n");
        do {
            char mat[][] ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};;
            System.out.println("\t\tMENU");
            System.out.println("Descripcion del proyecto...........1");
            System.out.println("Instrucciones del juego............2");
            System.out.println("Referencias........................3");
            System.out.println("Jugar..............................4");
            System.out.println("Salir..............................5");
            System.out.println("Elige tu opcion:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println(
                            "El siguiente proyecto es una recreacion del popular juego Gato, elaborado por tres alumnos \nutilizando el lenguaje de programacion Java. El juego del Gato es un juego de estrategia para \ndos jugadores. El objetivo del juego es colocar tres de tus propias fichas en línea recta, ya \nsea horizontal, vertical o diagonalmente, en un tablero de 3x3 casillas. El juego requiere \nestrategia y anticipación, ya que los jugadores deben tomar decisiones para bloquear los \nmovimientos del oponente y buscar oportunidades para crear sus propias líneas de tres \nfichas. Si ningún jugador logra crear una línea de tres fichas y el tablero se llena, el juego se considera un empate.");
                    break;

                case 2:
                    System.out.println(
                            "Para jugar al 'gatito' se requiere de dos personas las cuales las cuales tomaran turnos para \nllenar una cuadricula de 3x3 utilizando las letras 'X' para el jugador 1 y 'O' para el jugador 2. \n\nAl iniciar el juego se mostrara una cuadricula vacia donde el jugador 1 tendra que seleccionar \nla casilla en la cual quiere colocar su letra. Para seleccionar una casilla el juego preguntara \ndos datos al jugador. Primero escribira en que fila (horizontal) quiere ubicarse, para esto \ntendra que escribir '0', '1' o '2' para elegir la posicion Y de su marca. Despues se repite el \nproceso para la posicion X, donde de igual forma tiene que elegir entre '0', '1' o '2' para la \ncolumna (vertical) que quiere llenar. En caso de que se introduzca una posicion no valida o \nque ya este tomada por una marca, el juego pedira introducir de nuevo la coordenada hasta \nque se introduzca una que sea posible. \n\nYa que se imprima la marca del jugador en el tablero, es turno del siguiente jugador, donde se repite\nel proceso ya mencionado hasta que concluya el juego. El objetivo del juego es lograr colocar tres marcas \nde forma consecutiva mientras evitas el triunfo del rival. El juego termina cuando uno de los dos jugadores\ncoloca tres de sus símbolos alineados o ya no hayan espacios vacíos en el tablero, este ultimo caso se considera empate.");
                    break;

                case 3:
                    System.out.println("No se que va aqui");

                    break;

                case 4:
                aa=0;
                    do {
						aa++;
                        escribir(mat);
                            mat = llenarX(mat);
                            
                            for(x=0;x<3;x++)
                            { 
                                a=0;
                                b=0;
                                c=0;
                                for(y=0;y<3;y++)
                                { 
                                if(mat[x][y]!='x')
                                {
                                a=1;
                                }
                                if(mat[y][y]!='x')
                                {
                                c=1;
                                }
                                if(mat[y][x]!='x')
                                {
                                b=1;
                                }
                              
                                }
                                if(a==0 || b==0 || c==0 || mat[0][2]=='x' && mat[1][1]=='x' && mat[2][0]=='x')
                                {
                                aa=5;
                                x=3;
                                escribir(mat);
                                System.out.println("HA GANADO EL JUGADOR X");
                                }
                            }

						if(aa<5)
						{
                        escribir(mat);

                            mat = llenar0(mat);
                            for(x=0;x<3;x++)
                            { 
                                a=0;
                                b=0;
                                c=0;
                                for(y=0;y<3;y++)
                                { 
                                if(mat[x][y]!='o')
                                {
                                a=1;
                                }
                                if(mat[y][y]!='o')
                                {
                                c=1;
                                }
                                if(mat[y][x]!='o')
                                {
                                b=1;
                                }
                                }
                                if(a==0 || b==0 || c==0 || mat[0][2]=='o' && mat[1][1]=='o' && mat[2][0]=='o')
                                {
                                aa=5;
                                x=3;
                                escribir(mat);
                                System.out.println("HA GANADO EL JUGADOR O");
                                }
                            }

						}

                    } while (aa < 5);
                   
                    break;

                case 5:
                    System.out.println("Decidiste salir.");
                    break;

                default:
                    System.out.println("No tengo esa opcion.");
                    break;
            }

        } while (op != 5);

    }

    public static char[][] llenarX(char m1[][]) {
        int r = 0, c = 0, lim = 0;
        do {
            r = sc.nextInt();
            c = sc.nextInt();
            lim++;
            if (r < 0 || r > 2) {
                lim = 0;
            }
            if (c < 0 || c > 2) {
                lim = 0;
            }
            if (lim == 0 || m1[r][c]!=' ') {
                System.out.println("Coordenada no valida, pruebe otra vez");
                lim=0;
            }
        } while (lim == 0);
  		m1[r][c] = 'x';;
        return m1;
    }

    public static char[][] llenar0(char m1[][]) {
        int r = 0, c = 0, lim = 0;
        do {
            r = sc.nextInt();
            c = sc.nextInt();
            lim++;
            if (r < 0 || r > 2) {
                lim = 0;
            }
            if (c < 0 || c > 2) {
                lim = 0;
            }
            if (lim == 0 || m1[r][c]!=' ') {
                System.out.println("Coordenada no valida, pruebe otra vez");
                lim=0;
            }
        } while (lim == 0);
	   		m1[r][c] = 'o';;
        return m1;
    }

    public static void escribir(char m1[][]) {
        int r = 0, c = 0;
        System.out.print("\n");
        for (r = 0; r < 3; r++) {
            for (c = 0; c < 3; c++) {
                if (c == 0) {
                    System.out.print(" " + m1[r][c] + "|");
                }
                if (c == 1) {
                    System.out.print(" " + m1[r][c] + " ");
                }
                if (c == 2) {
                    System.out.print("|" + m1[r][c] + " ");
                }
            }
            System.out.print("\n");
            if (r < 2) {
				System.out.println("---------");
            }
        }
    }


}