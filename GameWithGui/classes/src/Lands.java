import java.awt.*;
import java.util.LinkedList;

public class Lands {

    private LinkedList<Point> allPoints=new LinkedList<>();
    private Shape shapeOfLand=null;
    private String nameOfLand;
    private String BelongTo=null;
    //private LinkedList<Armee> besetztWithArmeeFrom=new LinkedList<>();


    Lands(String name, LinkedList<Point> listOfPoint){
        this.nameOfLand=name;
        this.allPoints=listOfPoint;
    }

    public void setShapeOfLand(Shape s){this.shapeOfLand=s;}
    public Shape getShapeOfLand(){return this.shapeOfLand;}

    //public void addbesetztWithArmee(Armee arm){this.besetztWithArmee.add(arm);}
   // public LinkedList<Armee> getBesetztWithArmee(){return this.besetztWithArmee;}

    public LinkedList<Point> getAllPoints(){return this.allPoints;}

    public String getNameOfLand(){return this.nameOfLand;}
    public String getBelongTo(){return this.BelongTo;}
    public void setBelongTo(String s){this.BelongTo=s;}

    public String toString(){
        String s=this.nameOfLand+" Points:";

        for(Point p:this.allPoints){
            s=s+" "+p.toString();
        }
        return  s+"\n";

    }

}
