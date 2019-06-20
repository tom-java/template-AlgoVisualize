package com.github.tomjava.shape;

import lombok.Getter;

public class Circle {
    /**
     * the center dimension of circle
     * x: x dimension
     * y: y dimension
     */
    public int x,y;

    /**
     * velocity of x and y
     */
    public int xVelocity, yVelocity;

    @Getter
    private int radius;

    public Circle(int x, int y, int xVelocity, int yVelocity, int radius) {
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
    }

    public void move(int minX, int minY, int maxX, int maxY){
        x += xVelocity;
        y += yVelocity;

        checkCollision(minX, minY, maxX, maxY);
    }

    /**
     * if this circle contain point(x,y)
     * @param x
     * @param y
     * @return
     */
    public boolean contain(int x, int y){
        return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) <= radius * radius;
    }

    /**
     *
     * @param minX: min value of x dimension
     * @param minY
     * @param maxX
     * @param maxY
     */
    private void checkCollision(int minX, int minY, int maxX, int maxY) {
        if (x - radius < minX){
            x = radius;
            xVelocity = -xVelocity;
        }
        if (x + radius >= maxX){
            x = maxX - radius;
            xVelocity = -xVelocity;
        }
        if (y - radius < minY){
            y = radius;
            yVelocity = -yVelocity;
        }
        if (y + radius >= maxY){
            y = maxY - radius;
            yVelocity = -yVelocity;
        }
    }
}
