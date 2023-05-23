Aunque por motivos de simplicidad he decido que la manera de usar esta aplicacion
sea mediante un CLI, sería muy simple hacer que un cliente REST se comunicara 
ya que solo tendría que usar las interfaces de los casos de usos, incluso he dejado la 
carpeta donde irian las definiciones para un API Rest.

En cuanto a los TEST por motivos de tiempo solo he testeado la logica de negocio

Aunque es un proyecto Spring Boot, todo lo relativo al dominio no tiene nada para 
cumplir con la arquitetura hexagonal, es por ello que en Infrastructure se hace
la configuración de los Beans para no tener que usar ningún autowired dentro del
domain

Si se quisiera ejecutar la aplicacion con los parametros provistos en el PDF sería 
de la siguiente manera  5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM 
Donde los primeros 2 valores son el ancho y el alto, y luego se toman los parametros
de 4 en 4, si falta uno de los 4 la aplicación falla y lanza un mensaje en pantalla

He asumido dos posibles errores y he tratado de controlarlo a traves de excepciones
Uno es cuando el robot intenta moverse a una posición invalida(menor que 0 o mayor
que el weidth o height)
Y otra cuando un robot intenta limpiar en la posicion que ya hay un robot.

Posible Mejoras:
- Añadir mas test para probar otras casuisticas
- Hacer un mejor control de los errores

Muchas gracias de antemano por mirar esta prueba y agradecería un feedback el cual
será siempre tomado positivamente.
