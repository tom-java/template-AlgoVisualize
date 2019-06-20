package com.github.tomjava;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class ApplicationTest {
    @Test
    public void frame() throws Exception{
        // create a window immediately
        JFrame frame = new JFrame("Hello, friend");

        // make this window visible
        frame.setVisible(true);

        // we are in junit, after junit exit, the frame process will be killed
        // so I set a delay for junit process.
        Thread.sleep(20 * 1000);
    }

    @Test
    public void frame2() throws Exception{
        // create a window immediately
        JFrame frame = new JFrame();

        // set size of this window
        frame.setSize(1000, 1000);

        // disallow user change it's size
        frame.setResizable(false);

        // make this window visible
        frame.setVisible(true);

        Thread.sleep(20 * 1000);
    }

    @Test
    public void frame3() throws Exception{
        // create a window immediately
        JFrame frame = new JFrame();

        // when we click exit button, it should exit process
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set size of this window
        frame.setSize(1000, 1000);

        // make this window visible
        frame.setVisible(true);

        Thread.sleep(20 * 1000);
    }

    @Test
    public void event() throws Exception{
        // use a event queue to dispatch this GUI thread
        EventQueue.invokeLater(() -> {
            // create a window immediately
            JFrame frame = new JFrame();

            // when we click exit button, it should exit process
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // set size of this window
            frame.setSize(1000, 1000);

            // make this window visible
            frame.setVisible(true);
        });
        Thread.sleep(20 * 1000);
    }
}
