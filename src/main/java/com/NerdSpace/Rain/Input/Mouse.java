package com.NerdSpace.Rain.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
    private int x=-1,y=-1,b=-1;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getButton() {
        return b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        b = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        b = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
