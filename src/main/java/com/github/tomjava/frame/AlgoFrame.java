package com.github.tomjava.frame;

import com.github.tomjava.shape.Circle;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * JFrame = MenuBar + Panel
 */
public class AlgoFrame extends JFrame {
    private static int defaultWidth = 800;
    private static int defaultHeight = 800;

    /**
     * width and height of this frame's writable area
     */
    @Getter
    private int canvasWidth;
    @Getter
    private int canvasHeight;

    /**
     * JFrame dependent on panel
     */
    @Getter @Setter
    private JPanel panel;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas algoCanvas = new AlgoCanvas();
        algoCanvas.setPreferredSize(
                new Dimension(canvasWidth, canvasHeight));
        setContentPane(algoCanvas);

        // make algoFrame follow size of panel
        pack();
        // setSize(canvasWidth, canvasHeight);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, defaultWidth, defaultHeight);
    }

    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles = circles;

        // refresh this canvas
        repaint();
    }

    /**
     * hold out content and display on JFrame
     */
    private class AlgoCanvas extends JPanel{
        public AlgoCanvas() {
            super(true);
        }

        /**
         * do all paint jobs
         * @param g: inject by context
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // draw an oval
//            g.drawOval(100, 200, 50, 50);

            // use new draw api
            Graphics2D g2D = (Graphics2D) g;

            // reduce the aliased of edge
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.addRenderingHints(hints);

            g2D.setColor(Color.RED);

            AlgoVisHelper.setStrokeWidth(g2D, 1);

//            Ellipse2D circle = new Ellipse2D.Double(100, 100, 300, 300);
//            g2D.draw(circle);
//            AlgoVisHelper.strokeCircle(g2D, 400, 400, 20);

            // status will continue
//            g2D.setColor(Color.RED);

//            Ellipse2D circle2 = new Ellipse2D.Double(10, 10, 30, 30);
//            g2D.fill(circle2);
//            AlgoVisHelper.fillCircle(g2D, 100, 100, 80);


            for (Circle circle : circles){
                AlgoVisHelper.strokeCircle(g2D, circle.x, circle.y, circle.getRadius());
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
