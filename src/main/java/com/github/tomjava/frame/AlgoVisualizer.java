package com.github.tomjava.frame;

import com.github.tomjava.shape.Circle;
import lombok.Setter;

import java.awt.event.*;

public class AlgoVisualizer {
    private Circle[] circles;

    @Setter
    private AlgoFrame frame;

    private int sceneWidth, sceneHeight;

    private boolean isPaused;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int circleNumber){
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;

        circles = new Circle[circleNumber];
        int radius = 50;
        for (int i = 0; i < circleNumber; i++) {
            int x = (int)(Math.random() * (sceneWidth - 2 * radius)) + radius;
            int y = (int)(Math.random() * (sceneHeight - 2 * radius)) + radius;
            int xVelocity = (int)(Math.random()*11) - 5;
            int yVelocity = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x, y, xVelocity, yVelocity, radius);
        }
    }

    public void run() throws InterruptedException{
        frame.addKeyListener(new AlgoKeyListener());
        frame.addMouseListener(new AlgoMouseListener());

        while (true) {
            // todo: render data
            //frame.render();

            Thread.sleep(10);

            if (!isPaused) {
                for (Circle circle : circles) {
                    circle.move(0, 0, sceneWidth, sceneHeight);
                }
            }
        }
    }

    /**
     * todo: keyListener
     */
    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() == ' '){
                isPaused = !isPaused;
            }
        }
    }

    /**
     * todo: mouseEventListener
     */
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event) {
            super.mousePressed(event);

            // get height of menu bar
            int y = frame.getBounds().height - frame.getCanvasHeight();
            event.translatePoint(0, -y);

            System.out.println(event.getPoint());
            for(Circle circle: circles){
                if (circle.contain(event.getPoint().x, event.getPoint().y)){
                    circle.xVelocity += 20;
                    circle.yVelocity += 20;
                }
            }
        }
    }
}
