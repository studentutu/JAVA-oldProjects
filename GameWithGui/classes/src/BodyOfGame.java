import javafx.scene.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.Area;
import java.util.LinkedList;
import java.util.HashMap;

public class BodyOfGame {//extends JFrame
    private  LinkedList<Lands> allLands=new LinkedList<>();
    private  LinkedList<Teritories> allTer=new LinkedList<>();
    private  LinkedList<Continent> allCont=new LinkedList<>();
    private  int punkte=0;

    private Area endPhase=new Area(new Rectangle(750,560,60,20));


    private EigeneGamer player=null;
    private EigeneGamer computer=null;
    //private EigeneGamer whoIsOnCharge=null;

    private JFrame willWorl=null;




    BodyOfGame(LinkedList<Lands> l,LinkedList<Teritories> t, LinkedList<Continent> c,int p ){
        this.willWorl=new JFrame("GameWith GUI or ALL Those Teritories");
        this.willWorl.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.willWorl.setSize(1250, 650);


        this.allLands.addAll(l);
        this.allTer.addAll(t);
        this.allCont.addAll(c);
        this.punkte=p;


    }


    public void startToPlay(){

        this.StartToDraw();
        this.setContinentsToTeritories();

        this.willWorl.getContentPane().setLayout(new OverlayLayout(this.willWorl.getContentPane()));


            for (Teritories t : this.allTer) {

                Area a = new Area(t.getShapeOfTeritory().peekFirst());
                for (Shape s : t.getShapeOfTeritory()) {
                    Area ar = new Area(s);
                    if (s != t.getShapeOfTeritory().peekFirst()) {
                        a.add(ar);
                    }


                }
                t.setRealTeritoryShape(a);



            }//set to each teritory her RealyShape!


        FirstPanel fp=new FirstPanel(this.allCont,this.allTer,this.endPhase,this.willWorl);//in first panel!
        fp.addMouseMotionListener(fp);
        fp.addMouseListener(fp);
        fp.setOpaque(false);
        this.willWorl.getContentPane().add(fp);
        //-----------------------------------------



        int startTeritoryPukte=  (this.allTer.size()%2==1)? (this.allTer.size()/2)+1:this.allTer.size()/2;
        //System.out.println(this.allTer.size()+  " For player "+startTeritoryPukte + " For comp "+startTeritoryPukte); 21

        int StartVerstarkPunkte=21 +3;
        //24 punkte, in jede Teritory mind 1, 3 Punkte Frei

        EigeneGamer player=new EigeneGamer("Player");
        player.addPunktLand(startTeritoryPukte);
        player.addVerstarkPunkte(StartVerstarkPunkte);
        this.player=player;

        EigeneGamer comput=new EigeneGamer("Computer");
        comput.addPunktLand(startTeritoryPukte);
        comput.addVerstarkPunkte(StartVerstarkPunkte);
        this.computer=comput;

        fp.SetPlayers(this.player, this.computer, this.punkte);
        //goes to the FirstPanel!


        this.willWorl.setVisible(true);
        //hier wil be end!
        //main worker end, thread fp!

        //1.Panel: Teritory Phase - nur Welche Terotories
        //2.Panel - 4.Panel : Eroberung Phase :
             //2.Panel: VerstakrPunkte aufteilen
             //3.Panel: Phase Armee Player, Computer
            //4.Panel: Play Bones, VerstakrPunkte generieren , wer hat gewinn und end.

    }



    public void StartToDraw(){


        for(Teritories t:this.allTer){
            LinkedList<Shape> linkOfShapes=new LinkedList<>();

            for(Lands l:t.getListOfLands()) {

                LinkedList<Integer> allx=new LinkedList<>();
                LinkedList<Integer> ally=new LinkedList<>();


                for(Point p:l.getAllPoints()){

                    allx.add(p.getPointx());
                    ally.add(p.getPointy());
                }


                Integer[] x = allx.toArray(new Integer[allx.size()]);
                Integer[] y = ally.toArray(new Integer[ally.size()]);

                int[] xarray = new int[x.length];
                int[] yarray = new int[y.length];

                for (int i = 0; i < x.length; i++) {
                    xarray[i] = x[i];
                    yarray[i] = y[i];
                }
                Shape s = new Polygon(xarray, yarray, xarray.length);
                linkOfShapes.add(s);
                //l.setShapeOfLand(s);

            }

            t.setShapeOfTeritory(linkOfShapes);

        }


    }//end of Helper StartToDraw

    public void setContinentsToTeritories(){

        for(Continent c:this.allCont){

            for(Teritories t:c.getContinentTer()){
                t.setBelongToContinent(c.getContinentName());

            }

        }//end

    }//end of helper


}
