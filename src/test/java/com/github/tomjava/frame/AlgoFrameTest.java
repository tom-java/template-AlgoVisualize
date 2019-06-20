package com.github.tomjava.frame;

import com.github.tomjava.shape.Circle;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * use custom frame
 */
public class AlgoFrameTest {
    @Test
    public void frame() throws Exception{
        AlgoFrame algoFrame =
                new AlgoFrame("hello", 500, 500);

        Thread.sleep(20 * 1000);
    }

    @Test
    public void render() throws Exception{
        int sceneWidth = 800;
        int sceneHeight = 800;
        final int N = 10;

        Circle[] circles = new Circle[N];
        int radius = 50;
        for (int i = 0; i < N; i++) {
            int x = (int)(Math.random() * (sceneWidth - 2 * radius)) + radius;
            int y = (int)(Math.random() * (sceneWidth - 2 * radius)) + radius;
            int xVelocity = (int)(Math.random()*11) - 5;
            int yVelocity = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x, y, xVelocity, yVelocity, radius);
        }
        AlgoFrame frame = new AlgoFrame("an", sceneWidth, sceneHeight);
        while (true) {
            frame.render(circles);

            Thread.sleep(10);

            for (Circle circle : circles) {
                circle.move(0, 0, sceneWidth, sceneHeight);
            }
        }
    }
}