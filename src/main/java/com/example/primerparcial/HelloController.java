package com.example.primerparcial;

import com.example.primerparcial.algotitmo.Paralelo;
import com.example.primerparcial.algotitmo.Secuencial;
import com.example.primerparcial.algotitmo.Sorter;
import com.example.primerparcial.ar.ArrayGen;
import com.example.primerparcial.service.Tiempo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import java.util.Arrays;

public class HelloController {
    private static final int ARRAY_SIZE = 100000;

    @FXML private Button startButton;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private Label seqTimeLabel;
    @FXML private Label parTimeLabel;

    @FXML
    protected void onStartButtonClick() {
        startButton.setDisable(true);
        progressIndicator.setVisible(true);
        seqTimeLabel.setText("Tiempo Secuencial: Calculando...");
        parTimeLabel.setText("Tiempo Paralelo: Calculando...");

        new Thread(this::runTest).start();
    }

    private void runTest() {
        int[] originalArray = ArrayGen.generateRandomArray(ARRAY_SIZE);
        int[] arrayForSec = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrayForPar = Arrays.copyOf(originalArray, originalArray.length);

        Sorter seqSorter = new Secuencial();
        Sorter parSorter = new Paralelo();

        long timeSec = Tiempo.measureTime(seqSorter, arrayForSec);
        long timePar = Tiempo.measureTime(parSorter, arrayForPar);

        Platform.runLater(() -> {
            seqTimeLabel.setText("Tiempo Secuencial: " + timeSec + " ms");
            parTimeLabel.setText("Tiempo Paralelo: " + timePar + " ms");
            progressIndicator.setVisible(false);
            startButton.setDisable(false);
        });
    }
}
