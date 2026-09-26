- 09/09/2026

- 15/09/2026

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

- 22/09/2026

La semana que viene son las elecciones de delegado

# Arquitectura P1:

Punto de entrada android y desktop

Engine (api, interfaces)
- AndroidEngine
- DesktopEngine

Game

# Canvas

## Desktop

- mapa de bits --> BufferStrategy (Usaremos doble o triple buffer y cada frame cambiamos y pintamos en el siguiente). Codigo en diapos
- lienzo --> JFrame
- pintura --> Graphics2D, awt.Image, wat.Font
- primitivas de dibujo --> Graphics2D

## Android

- mapa de bits --> surfaceHolder
- lienzo --> SurfaceView
- pintura --> Paint, Bitmap, 
- primitivas de dibujo --> Canvas

# Módulos

- game
- android engine
- desktop engine
- base engine
- android app
- desktop app

```java
public class DesktopEngine implements Engine, Runnable{

    JFrame frame;
    BufferStrategy bf;
    Graphics2D g2d;
    Scene currentScene;
    volatile boolean isRunning;
    Thread renderThread;

    public DesktopEngine(JFrame frame){
        thus.frame = frame;
        this.bf = this.frame.getBufferStrategy();
        this.g2d = (Graphics2D) this.bf.getDrawGraphics();
    }

    @Override
    public void run(){

    }
}
```

__ambos motores necesitan un método resume y pause__
estos inician y terminan el hilo de renderizado