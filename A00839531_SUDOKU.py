import random
import os

def instrucciones():
    print("""
Este sudoku se juega igual que el juego clásico con algunas excepciones:
Para empezar recordemos que en un sudoku tienes que colocar números del 1-9 en una matriz de 9x9 de tal forma que no se repita el mismo número en la misma fila, columna, o cuadro, (los cuadrados están marcados dentro del juego).
Para jugar este sudoku, debes de colocar un número del 1-9 son sus coordenadas que van de (0-8,0-8)El tablero la primera columna y fila son (0 0) y las últimas (8 8). las coordenadas se deben colocar en el formato ("x y") por ejemplo (0 8).
El juego sigue hasta que cometas 5 errores o coloques un 0, los números que coloques y estén correctos al momento de ponerlos no se pueden quitar. Es decir, solo te marcará error cuando hayas repetido número en la misma fila, columna, o cuadro. De otra forma podrás seguir jugando.
Los puntos se consiguen con cada número correcto puesto en el tablero menos el numero de errores cometidos, siendo el número máximo de puntos un 41. Cada matriz es diferente y tiene un resultado. ¡Mucha suerte!
""")
while True:
    print("Bienvenido! Elige la opcion que des")
    print("\nMenú:")
    print("1. Instrucciones")
    print("2. Jugar")
    print("3. salir")

    opcion = input("Selecciona una opción: ")

    if opcion == "1":
        instrucciones()
    elif opcion == "2":
        def imprimir(Matriz_Sudoku):
            for i, fila in enumerate(Matriz_Sudoku):
                fila_formateada = ' '.join(fila)
                if i % 3 == 0 and i != 0:
                    print('-' * len(fila_formateada))  
                print(fila_formateada)
        def escribir(Matriz_Sudoku, a, b, c):
            d=b+1
            if(d%3==0):
                Matriz_Sudoku[a][b] = c +'|'
            else:
                Matriz_Sudoku[a][b] = c
            return Matriz_Sudoku
        def pedirnum():
            while True:
            
                try:
                    valor = int(input("Ingrese un número del 1 al 9: "))
                    if 0 <= valor <= 9:
                        break
                    else:
                        print("El número debe estar en el rango de 1 a 9.")
                except ValueError:
                    print("Por favor, ingrese un número válido.")
            return valor
        def pedircoordenadas(Matriz_Sudoku):
            x = 0
            y = 0
            while True:
                try:
                    coordenadas = input("Ingresa las coordenadas (x y): ")
                    x, y = map(int, coordenadas.split())
                    if 0 <= x < 9 and 0 <= y < 9:
                        if Matriz_Sudoku[x][y] == '-' or Matriz_Sudoku[x][y] == '-|':
                            break
                        else:
                            print("Por favor, ingrese coordenadas vacías.")
                    else:
                        print("Ingrese números válidos")
                except ValueError:
                    print("Por favor, ingrese números válidos.")
            return x, y
        def generar_tablero_sudoku():
            tablero = [[0] * 9 for _ in range(9)]

            def es_valido(fila, columna, numero):
                for i in range(9):
                    if tablero[fila][i] == numero or tablero[i][columna] == numero:
                        return False

                cuadrante_fila = (fila // 3) * 3
                cuadrante_columna = (columna // 3) * 3
                for i in range(3):
                    for j in range(3):
                        if tablero[cuadrante_fila + i][cuadrante_columna + j] == numero:
                            return False

                return True

            def resolver():
                for fila in range(9):
                    for columna in range(9):
                        if tablero[fila][columna] == 0:
                            numeros_disponibles = list(range(1, 10))
                            random.shuffle(numeros_disponibles)
                            for numero in numeros_disponibles:
                                if es_valido(fila, columna, numero):
                                    tablero[fila][columna] = numero
                                    if resolver():
                                        return True
                                    tablero[fila][columna] = 0
                            return False
                return True

            resolver()
            return tablero
        nombre=input("cual es tu nombre?")
        Matriz_Resuelta = generar_tablero_sudoku()

        M1 = []
        M2 = []
        M3 = []
        M4 = []
        M5 = []
        M6 = []
        M7 = []
        M8 = []
        M9 = []
        Matriz_Sudoku=[ 
                    M1,
                    M2,
                    M3,
                    M4,
                    M5,
                    M6,
                    M7,
                    M8,
                    M9]
        j = 9
        p = 0

        for cont in range(0,9):
            for cont1 in range(1,10):
                if(cont1%3==0):
                    a = '-|'
                else:
                    a = '-'
                Matriz_Sudoku[cont].append(a)
        i=0
        while i<40:
            xr=i%9
            yr=random.randint(0, 8)
            if Matriz_Sudoku[xr][yr] == '-' or Matriz_Sudoku[xr][yr] == '-|':
                valor=Matriz_Resuelta[xr][yr]
                escribir(Matriz_Sudoku,xr,yr,str(valor))
                i=i+1
        e=0
        while (e<5):
            f=str(e)
            error=0
            imprimir(Matriz_Sudoku)
            print('tienes '+f+' errores')
            valor = pedirnum()
            if valor==0:
                break
            x, y = pedircoordenadas(Matriz_Sudoku)
            for z in range (0,8):
                if z != y:
                    q = Matriz_Sudoku[x][z]
                    q=q.replace('|', "")
                else:
                    q='.'
                if z != x:
                    t = Matriz_Sudoku[z][y]
                    t=t.replace('|', "")
                else:
                    t='.'
                if(str(valor) == q or str(valor)==t):
                    error = 1
            a1=int(x/3)*3
            b1=int(y/3)*3
            for z in range(0,3):
                for v in range (0,3):
                    a=(a1+z)
                    b=(b1+v)
                    if a != x or b!=y:
                        u = Matriz_Sudoku[a][b]
                        u = u.replace('|',"")
                    else:
                        u='.'
                    if(str(valor)) == u:
                        error=1
            if (error==1):
                e=error+e
            else:
                escribir(Matriz_Sudoku, x, y, str(valor))
                p=p+1
            if(p==41):
                print("felicidades has ganado")
                e=5
        puntaje=p-e
        if(puntaje<0):
            puntaje=0
        print(nombre+' tu puntaje fue de '+str(puntaje))
    elif opcion == "3":
        print("Saliendo del programa.")
        break
    else:
        print("Opción no válida. Por favor, selecciona una opción válida.")

