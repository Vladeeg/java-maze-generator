package graph;

import java.util.Objects;

public class Vertex {
    private int topD, bottomD, leftD, rightD, id;
    private Vertex top, bottom, left, right;
    Vertex(int id) {
        topD = bottomD = leftD = rightD = Integer.MAX_VALUE;
        top = null;
        bottom = null;
        left = null;
        right = null;
        this.id = id;
    }

    public Vertex getTop() {
        return top;
    }

    public void setTop(Vertex top) {
        this.top = top;
    }

    public Vertex getBottom() {
        return bottom;
    }

    public void setBottom(Vertex bottom) {
        this.bottom = bottom;
    }

    public Vertex getLeft() {
        return left;
    }

    public void setLeft(Vertex left) {
        this.left = left;
    }

    public Vertex getRight() {
        return right;
    }

    public void setRight(Vertex right) {
        this.right = right;
    }

    public int getTopD() {
        return topD;
    }

    public void setTopD(int d) {
        this.topD = d;
    }

    public int getBottomD() {
        return bottomD;
    }

    public void setBottomD(int d) {
        this.bottomD = d;
    }

    public int getLeftD() {
        return leftD;
    }

    public void setLeftD(int d) {
        this.leftD = d;
    }

    public int getRightD() {
        return rightD;
    }

    public void setRightD(int d) {
        this.rightD = d;
    }

    public int getID() {
        return id;
    }

    public boolean isIncidentTo(final Vertex v) {
        return v.equals(top) || v.equals(bottom) || v.equals(left) || v.equals(right);
    }

    public int getDistanceTo(final Vertex v) {
       if (v.equals(top)) {
           return topD;
       }
       if (v.equals(bottom)) {
           return bottomD;
       }
       if (v.equals(left)) {
           return leftD;
       }
       if (v.equals(right)) {
           return rightD;
       }
       return Integer.MAX_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
