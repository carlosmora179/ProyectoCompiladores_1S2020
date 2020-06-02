# JavaTropicalizado :coffee: :palm_tree:
  El actual proyecto consiste en la creacion de un compilador funcional, tomando como base el mismo 
lenguaje java donde se impletará desde el analizador lexico hasta la finalización del mismo, llegando 
al analizador de semantica y así lograr un compilador capaz de leer y ejecutar código, con la peculiaridad 
de que este va a estar traudcido al lenguaje español.

## Logros :white_check_mark:
  Se crea un programa que logra tomar un archivo de formato “.txt” con un ejemplo de código con la 
gramática establecida. El programa toma esta prueba la analiza léxicamente con los tokens especificados 
en el enunciado del proyecto y crea un archivo “salida.txt” donde cada línea del archivo es una 
tupla (token, palabra). Se logra identificar errores en la línea que ocurren, el analizador reacciona 
terminando el proceso con una excepción indicando las características de la misma.

## Pendiente :construction:
  Se encuentra pendiente el analizador sintactico y el analizador semantico incluyendo todas sus funcionalidades.

## Errores conocidos :warning:
  Actualmente al 01/06/2020 no se registrar ningun error.

# Instalación y ejecución :hammer: :memo:

  En la carpeta del código se encuentra un carpeta llamada dist en la cual se encutra el archivo ejecutable de la 
aplicación donde basta con darle doble click al mismo y localizar el archivo de prueba y posteriormente el programara 
generará otro .txt llamado salida.txt en el que se encuentran todos los tokens identificados y clasificados.
  
 Además para la edición del código es necesario un editor de codigo java ademas de los ambientes de trabajo 
para la maquina virtual el codigo actual de cre utilizando el JDK1.8 y java en su version 8.

## Importante :heavy_exclamation_mark:
El codigo a ejecutar debe estar separado por espacios en blanco entre cada una de sus palabras ejemplo: publico vacio programa ( ent numero ) { } ; 
como se puede observar se encuentra con una separacion de 1 espacio en cada una de sus palabras validas. 
