package entities;

public class Student {
    public String name ;
    public double notaFirst ;
    public double notaSecond ;
    public double notaThird ;
    public double media;
    public boolean approve;
    public double missing ;
    public double grade ;

    public void averageNote (){
        grade = notaFirst + notaSecond + notaThird ;
        media = grade / 3 ;
        approveDisapprove ();
    }
    public void approveDisapprove (){
        if ( media >= 60 ){
            approve = true;
        } else {
            approve = false;
            missing = 60 - media;
        }
    }
}
