package com.kakoypackage.chess.model.chessboard;

import com.trolltech.qt.core.QPoint;
import com.trolltech.qt.core.QRectF;
import com.trolltech.qt.gui.*;

/**
 * Created by ananas on 18.07.16.
 */
public class Board extends QGraphicsScene {

    Cell[][] cells = new Cell[8][8];
    int cellSize = 58;

    public Board(QRectF rect)
    {
        super(rect)
        ;
        Cell.setSize(cellSize);
        for (int i =0;i < 8; i++)
            for (int j = 0; j < 8; j++)
            {
                Cell newCell = new Cell(new QPoint(i, j), (i + j) % 2 == 0);
                newCell.setPos(cellSize / 2 + i*cellSize, cellSize / 2 + (7 - j)*cellSize);
                cells[i][j] = newCell;
                this.addItem(newCell);
            }
    }

}

class Cell extends QGraphicsItem
{
    static int size;
    boolean select  = false;
    boolean white = true;
    QPoint coordBoard;

    public Cell(QPoint coord, boolean white)
    {
        coordBoard = coord;
        this.white = white;
    }

    static void setSize(int s)
    {
        size = s;
    }

    @Override
    public QRectF boundingRect() {
        return new QRectF(-size/2, -size/2, size, size);
    }

    @Override
    public void paint(QPainter qPainter, QStyleOptionGraphicsItem qStyleOptionGraphicsItem, QWidget qWidget) {
        qPainter.setBrush(white ? new QColor(245,245,220) : new QColor (150, 75, 0));
        qPainter.setPen(select ? new QPen(new QColor(0, 230, 230), 3.5) : new QPen(new QColor(0,0,0), 1));

        qPainter.drawRect(boundingRect());
    }


    @Override
    public void mousePressEvent(QGraphicsSceneMouseEvent event) {
        System.out.println("Click on " + coordBoard);
        select = !select;
        update();
    }
}
