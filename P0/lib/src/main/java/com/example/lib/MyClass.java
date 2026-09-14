package com.example.lib;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class MyClass {
    // https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
    private static class my_canvas extends Canvas{
        boolean circle_exist = false;
        @Override
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            if(circle_exist)
                g2.fillOval(100,100,200,200);
        }
        public void add_circle(){
            circle_exist=true;
            //Forces paint again
            repaint();
        }
        public void clear(){
            circle_exist=false;
            repaint();
        }
    }
    private static class my_mouse_listener implements MouseListener {
        JFrame my_window;
        String my_message;
        my_mouse_listener(JFrame window, String msg){
            my_window = window;
            my_message = msg;
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){
            //Pop up window
            JOptionPane.showMessageDialog(my_window, my_message);
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
    }
    private static class canvas_cleaner implements MouseListener {
        my_canvas my_canvas;
        canvas_cleaner(my_canvas can){
            my_canvas = can;
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){
            my_canvas.clear();
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
    }
    private static class canvas_painter implements MouseListener {
        my_canvas my_canvas;
        canvas_painter(my_canvas can){
            my_canvas = can;
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){
            my_canvas.add_circle();
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
    }
    public static void main(String[] args){
        JFrame myScreen = new JFrame();
        myScreen.setSize(400,600);

        myScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myScreen.setLayout(new FlowLayout());

        TextField tf1;
        tf1 = new TextField(20);
        myScreen.add(tf1);

        Button b1;
        b1 = new Button("Click Me");
        b1.addMouseListener(new my_mouse_listener(myScreen,"You clicked me?"));
        myScreen.add(b1);


        my_canvas mcan = new my_canvas();
        mcan.setSize(300,300);
        Button bclear = new Button("Clear");
        Button bpaint = new Button("Paint");
        bclear.addMouseListener(new canvas_cleaner(mcan));
        bpaint.addMouseListener(new canvas_painter(mcan));

        myScreen.add(bclear);
        myScreen.add(bpaint);
        myScreen.add(mcan);

        myScreen.setVisible(true);
    }
}