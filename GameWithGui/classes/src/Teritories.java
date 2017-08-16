import java.awt.*;
import java.awt.geom.Area;
import java.util.LinkedList;
public class Teritories {

    private String terName;
    private LinkedList<Lands> listOfLands;
    private Point haupstadt;
    private LinkedList<Teritories> Nachbarn;
    private String BelongToGamer=null;
    private String BelongToContinent=null;//not needed
    private LinkedList<Armee> teritoryArmee=new LinkedList<>();//Owners teritories
    private LinkedList<Armee> armees2=new LinkedList<>();//for computer
    private LinkedList<Armee> armee1=new LinkedList<>();//For Player

    private LinkedList<Shape> ShapeOfTeritory=new LinkedList<>();
    private Area realTeritoryShape=null;



    Teritories(String terName,Point haupt){
        this.terName=terName;
        this.listOfLands=new LinkedList<>();
        this.haupstadt=haupt;
        this.Nachbarn=new LinkedList<>();
        this.BelongToGamer=null;

    }

    public void drawTeritory(Graphics g){
        if(this.getBelongToGamer()!=null){

            if(this.getBelongToGamer().equals("Player")){
                g.setColor(new Color(51, 153, 51));
                ((Graphics2D)g).fill(this.getRealTeritoryShape());

            }else{
                g.setColor(new Color(204, 0, 0));
                ((Graphics2D)g).fill(this.getRealTeritoryShape());
            }

        }else{
            //Unocupied Teritory
            g.setColor(new Color(102, 153, 255));
            ((Graphics2D)g).fill(this.getRealTeritoryShape());

        }



    }

    public void setBelongToContinent(String cont){
        this.BelongToContinent=cont;

    }
    public String getBelongToContinent(){return this.BelongToContinent;}

    public void setShapeOfTeritory(LinkedList<Shape> s){ this.ShapeOfTeritory=s;}
    public LinkedList<Shape> getShapeOfTeritory(){return this.ShapeOfTeritory;}

    public void setRealTeritoryShape(Area a){this.realTeritoryShape=a;}
    public Area getRealTeritoryShape(){ return this.realTeritoryShape;}

    public void addArmee1(Armee arm){
        this.armee1.add(arm);

    }
    public Armee getFromArmee1(){
        if(this.armee1.size()>0){
        return this.armee1.pollLast();}
        return null;
    }
    public void addArmee2(Armee arm){
        this.armees2.add(arm);
    }
    //no need in method getFromArmee2, becouse computer is smart, make only one move!

    public LinkedList<Armee> getArmee1(){return this.armee1;}
    public LinkedList<Armee> getArmees2(){return this.armees2;}

    public void setClearArmee1(){this.armee1.clear();}
    public void setClearArmee2(){this.armees2.clear();}

    public String getBelongToGamer(){return this.BelongToGamer;}


    public void addToGamer(EigeneGamer eg){
        this.BelongToGamer=eg.getNameOGamer();
        return;
    }
    public  void removeTeritoryFrom(EigeneGamer eg){

        eg.removeEigeneTeritory(this);


    }

    public void addteritoryArmee(Armee arm){
        if(arm==null){return;}
        this.teritoryArmee.add(arm);
    }

    public LinkedList<Armee> getTeritoryArmee(){return this.teritoryArmee;}

    public LinkedList<Teritories> getNachbarn(){return this.Nachbarn;}

    public Point getHaupstadt(){return this.haupstadt;}

    public String getTerName(){ return this.terName;}
    public LinkedList<Lands> getListOfLands(){return this.listOfLands;}




    public void addLand(Lands smallLand){

        this.listOfLands.add(smallLand);

    }

    public Armee getFromTeriToryArmee(){
        if(this.teritoryArmee.size()>1){return this.teritoryArmee.pollLast();}
        return null;
    }



    public void addNachbarn(Teritories t){
        for(Teritories ter:this.Nachbarn){
            if(ter.getTerName().equals(t.getTerName()) ){return;}
        }
        this.Nachbarn.add(t);
    }



    public String toString(){
        String s="";
        s="Teritory -" + this.terName +" Capital :"+this.haupstadt.toString()+"\n";
        for(Lands l:this.listOfLands){

            s=s+" "+l.toString();
        }
        for(Teritories t:this.Nachbarn){
            s=s+"Nachbarn: "+ t.getTerName();
        }
        return s+"\n";
    }
}
