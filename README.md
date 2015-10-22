# Simulador Máquina de Turing

Práctica 2 de la asignatura Complejidad computacional del cuarto curso de ingeniería informática, itinerario de computación.

## Objetivo

La práctica consiste en programar un simulador de una máquina de Turing.

## Requisitos

- Los elementos de la Máquina de Turing se introducirán en tiempo de ejecución.
- Para una ejecución con una Máquina de Turing determinada, el simulador debe poder ejecutarse con diferentes parámetros de entrada, que serán introducidas por teclado o por fichero.
- La cabeza de L/E debe encontrarse en el primer símbolo de los parámetros de entrada.
- Como salida, el programa debe indicar si la Máquina de Turing se ha parado en un estado de aceptación y mostrar la cinta a la derecha de la cabeza de L/E hasta encontrar un símbolo en blanco.

## Ficheros de entrada

Ejemplo de fichero aceptado por la máquina (maq1.mt):

```txt
# Máquina que reconoce el lenguaje: w = (a|b|c)* ^ |a| es par.
q0 q1
a b c
a b c .
q0
.
q0
q0 a q1 a R
q0 b q0 b R
q0 c q0 c R
q1 a q0 a R
q1 b q1 b R
q1 c q1 c R
```

## Implementación

Para la creación de la máquina se ha utilizado el paradigma de la progrmación orientada a objetos con el lenguaje de programación java y el entorno de desarrollo eclipse.

## Ejercicios a realizar
 1. MT que reconozca el lenguaje L= { w Є Σ* | w=(a|b|c)* |a| es par }.

2. MT que reciba como parámetro una cadena binaria y copie los unos en la cinta a continuación de la cadena de entrada, dejando un símbolo blanco en medio. Ejemplo:

Cadena de entrada: **•10010110•**

Resultado final: **•10010110•1111•**
