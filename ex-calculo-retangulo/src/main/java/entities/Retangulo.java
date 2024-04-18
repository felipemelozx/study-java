package entities;

public class Retangulo {
    public double width;
    public double height;

    private double area;
    private double perimeter;
    private double diagonal;

    public  double CalculationArea  () {
        return area = this.width * this.height;
    }

    public double Perimeter(){
        return perimeter = (this.width * 2 ) + (this.height * 2 );
    }

    public double Diagonal (){
        diagonal = (this.height * this.height) + (this.width * this.width);
        return diagonal = Math.sqrt(diagonal);
    }

    public String toString() {
        return  "AREA = " + this.area +
                ",  PERIMETER = " + this.perimeter +
                ",  DIAGONAL = " + this.diagonal;
    }
}
