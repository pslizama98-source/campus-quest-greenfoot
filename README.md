# Campus Quest - Prototipo inicial de Greenfoot

Repositorio inicial para el Proyecto Corto No. 4 de Introducción a la Ingeniería.

## Idea del juego
Campus Quest es un juego sencillo, no violento y de temática universitaria. El jugador controla a un estudiante que debe recoger tareas, recuperar energía con café y evitar nubes de estrés para llegar a la entrega final.

## Estado final de la Fase 3
- Mundo principal creado en Greenfoot.
- Actor jugador con movimiento por teclado.
- Objetos coleccionables que suman puntos.
- Obstáculos que reducen energía.
- Meta final para completar el nivel.
- Contadores de puntos, energía y tiempo.
- Sonidos básicos para colección, estrés y victoria.

## Controles
- Flechas del teclado: mover al estudiante.
- Objetivo: juntar tareas y llegar al portal de entrega final.

## Pendiente para Fase 3
- Agregar pantalla de inicio e instrucciones.
- Mejorar sprites y música.
- Agregar segundo nivel con mayor dificultad.
- Ajustar velocidad de obstáculos según validación de usuarios.
- Grabar video final del funcionamiento.

## Estructura
- `CampusQuestWorld.java`: mundo principal, HUD y reglas generales.
- `Student.java`: movimiento y colisiones del jugador.
- `Assignment.java`: objeto que suma puntos.
- `Coffee.java`: power-up de energía.
- `StressCloud.java`: obstáculo móvil.
- `GoalPortal.java`: meta del nivel.
