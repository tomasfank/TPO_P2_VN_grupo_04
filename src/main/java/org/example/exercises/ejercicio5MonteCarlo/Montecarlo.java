package org.example.exercises.ejercicio5MonteCarlo;

import org.example.classes.R2Point;
import org.example.classes.SetOfR2Points;

public class Montecarlo {

    private SetOfR2Points points;

    public Montecarlo(){
        this.points = new SetOfR2Points();
    }

    public void testPoint(R2Point p){
        double modulo = 0;
        modulo += Math.pow(p.getX(),2.0);
        modulo += Math.pow(p.getY(),2.0);
        modulo = Math.pow(modulo, 0.5);
        if (modulo < 1){
            points.add(p);
        }
    }

    public int cantidadPuntos(){
        return points.size();
    }
}
