# Reto_Tecnico_Sofka
En este repositorio se encuentra el proyecto Challenge de Preguntas y Respuestas de Sofka

CONFIGURACION DEL JUEGO: 
El juego inicia pidiendo el nombre del jugador, despues, le pregunta al jugador si desea empezar con el juego, a lo que debe responder con si, si lo desea. 
Existe una base de datos que guarda cinco preguntas de cada categoria, y el jugador tendra en pantalla una de estas preguntas que fue seleccionada al azar de las preguntas.
Existen 5 categorias y cada una de ellas tienen 5 preguntas del nivel de su categoria, si el jugador responde bien, optiene una serie de puntos que cambian de acuerdo a la categoria que se encuentre.
Si el jugador responde bien, tiene la oportunidad de avanzar a la siguiente ronda, donde se encontrara con una pregunta de la categoria correspondiente y si contesta mal, finaliza el juego sin puntos.
Cada vez que el jugador avanza de rondas, se le suman los puntos q obtiene de cada pregunta bien contestada. si el jugador no desea seguir de manera voluntaria el juego, podra retirarse con los puntos totales que obtuvo hasta el momento.

Codigo:
La clase respuesta, esta encargada de todas las respuestas que ofrece cada pregunta.al finaliz la clase pregunta, esta encargada de todas las preguntas que ofrece cada categoria. 
La clase Test, es la encargada de configurar el juego, en esta se encuentra todas las categorias con sus preguntas y respuestas. 
Tambien, en la clase Test, se encuentra la logica de persistencia de datos, donde exiten metodos que reciben los datos por un archivo txt los lee y luego los procesa.
La clase Juego_preguntas_Respuestas, con tiene el metodo Main. existen otras clases como lo son la clase leer() y la clase ListaDinamica(), las cuales han sido usadas durante toda mi trayectoria de programador. 
La clase leer(), se usa para recibir informacion que escribe el usuario, y la clase ListaDinamica(), es una especie de vector un poco mejorado, estas clases son usadas como librerias. 
Finalmente, cuando el juego concluye ya sea porque el jugador gano o perdio o decidio retirarse, sus datos como el nombre del jugador y sus puntos totales, son guardados en un archivo txt como persistencia de datos.
