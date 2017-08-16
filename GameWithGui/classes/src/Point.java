
public class Point {
    private int Pointx;
    private int Pointy;

    Point(int x,int y){
        this.Pointx=x;
        this.Pointy=y;
    }
    public void setPointx(int newx){
        this.Pointx=newx;

    }
    public void setPointy(int newy){
        this.Pointy=newy;
    }
    public void setXY(int x,int y){
        this.Pointx=x;
        this.Pointy=y;
    }
    public int getPointx(){return this.Pointx;}
    public int getPointy(){return this.Pointy;}

    public String toString(){
        String s="";
        s=this.Pointx + " "+ this.Pointy;
        return s;
    }

}
