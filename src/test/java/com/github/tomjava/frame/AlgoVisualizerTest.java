package com.github.tomjava.frame;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgoVisualizerTest {

    @Test
    public void run() throws Exception{
        int sceneWidth = 800;
        int sceneHeight = 800;
        final int N = 10;

        AlgoVisualizer algoVisualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
        AlgoFrame frame = new AlgoFrame("Hello", sceneWidth, sceneHeight);
        algoVisualizer.setFrame(frame);

        algoVisualizer.run();
    }
}