# 09/09/2026

# 15/09/2026

las máquinas virtuales de java y las de android no son iguales, aunq la de android proviene de la de java.

ART (máquina virtual) realiza optimizaciones sobre el bitcode en tiempo de instalación ahora (en tiempo de ejecución antes).

Usar versión de android 11 (R) Api level(30)

synchronized: mod no se pueden usar dos métodos de la misma instancia de clase a la vez nunca si ambos tienen synchronized (le pone un mutex al método)

volatile: le pone un mutex a la variable

## gradle

build system. Compila y trata dependencias. Y crea las builds de las apps.

## ap android

conjunto de componentes llamados actividades.

jerarquía con views y layouts

apps de android tiene manifest.json => archivo descriptivo de lo que tiene nuestra app. Número y nombre de actividades y si pueden ser llamadas desde otras apps, target y min SDK. Si usa cámara y otros requisitos u otras cosas con permisos.

Intentos: 
- implicitos (acción: ver un tipo de fichero, mandar correo, etc)
- explicitos (nombre de la actividad que quieres abrir)

## android studio

2 módulos principales especificos de android
- app
- desktop

Hay 2 ejemplos en el campus virtual con circulos que se mueven. Pinta lo mismo en 2 dispositivos.

Hay que hacer 2 motores que abstraiga de que fufe en ambas lo mismo.
Ambos motores implementan intefaz comun de motor.