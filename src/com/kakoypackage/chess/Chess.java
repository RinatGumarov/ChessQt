package com.kakoypackage.chess;

import com.trolltech.qt.core.QRectF;
import com.trolltech.qt.gui.*;

/**
 * Created by ananas on 18.07.16.
 */
public class Chess extends QMainWindow {

    Ui_MainWindow ui = new Ui_MainWindow();

    public static void main(String[] args)
    {
        QApplication.initialize(args);

        Chess chess = new Chess();

        QApplication.execStatic();
    }

    public Chess ()
    {
        ui.setupUi(this);
        QGraphicsScene scene = new Board(new QRectF(0,0, ui.graphicsView.height() - 10, ui.graphicsView.width() - 10));
        ui.graphicsView.setScene(scene);
        show();
    }
}


