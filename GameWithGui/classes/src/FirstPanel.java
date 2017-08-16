import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.util.LinkedList;
import java.util.HashMap;


public class FirstPanel extends JPanel implements MouseListener,MouseMotionListener {
    private LinkedList<Continent> allCont=new LinkedList<>();
    private LinkedList<Teritories> allTer=new LinkedList<>();
    private HashMap<Area,Teritories> realShapeMap=new HashMap<>();
    private int PUNKTE=0;//constant BonusPunkte for Continent

    private EigeneGamer player=null;
    private EigeneGamer comp=null;
    private EigeneGamer whoIs=null;
    private Area findArea=null;//only for FirstPhase
    private Area endPhase=null;//endPhase Shape!!
    private boolean End=false;//with endPhase!
    private JFrame current=null;//need for transitions in phase!( in Panels!)
    private Area findAreaHover=null;


    FirstPanel(){}//need if this as SuperClass to make construktor() for Subclass



    FirstPanel(LinkedList<Continent> c,LinkedList<Teritories> t,Area end,JFrame curFrame){
        this.allCont.addAll(c);
        this.allTer.addAll(t);
        this.endPhase=end;
        this.current=curFrame;


        for(Teritories ter:this.allTer){

            this.realShapeMap.put(ter.getRealTeritoryShape(),ter);

        }//add to the Mapfor each Area

    }

    public void SetPlayers(EigeneGamer player,EigeneGamer computer,int punkte){
        this.player=player;
        this.comp=computer;

        this.PUNKTE=punkte;
        this.whoIs=this.player;


    }


    @Override
    public void paintComponent(Graphics g){

        if(!this.End) {

            //Basic Drawing
            ((Graphics2D)g).setColor(new Color(204,229,255));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            //NachbarnLines to  current Teritory
            for(Teritories t:this.allTer) {
                int curentX=t.getHaupstadt().getPointx();
                int curentY=t.getHaupstadt().getPointy();

                //Add NachbarnLines
                for(Teritories Nachb:t.getNachbarn()){

                    int ToX=Nachb.getHaupstadt().getPointx();
                    int ToY=Nachb.getHaupstadt().getPointy();

                    Graphics2D dd=(Graphics2D)g;

                    BasicStroke b= new BasicStroke(5f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);

                    dd.setStroke(b);
                    g.setColor(Color.BLACK);

                    int Large=Math.abs(curentX - ToX);

                    if(Large >=650){//if line is too Large

                        if(curentX>625){//is it on right side?
                            g.drawLine(curentX, curentY, 1249, ToY);
                            g.drawLine(0, ToY, ToX, ToY);
                        }else {//it is on left side!
                            g.drawLine(curentX, curentY, 0, ToY);
                            g.drawLine(1249, ToY, ToX, ToY);
                        }

                    }else{
                        g.drawLine(curentX, curentY, ToX, ToY);

                    }

                }//Block of NachbarnLines
            }
            //End Nachbarn Lines for Every Teritories

            /**
            //fill unoccupied and occupied teritories
            BasicStroke b= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(b);

            g.setColor(Color.BLUE);

            for(Teritories t: this.allTer){

                ((Graphics2D)g).fill(t.getRealTeritoryShape());


            }//fill all unoccupied and occupied  teritories


            */
            for(Teritories t: this.allTer){

                t.drawTeritory(g);

            }
            //BasicDrawing

            BasicStroke b= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(b);

            //fill Teritories in green and red:
            b= new BasicStroke(5f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(b);
            g.setColor(Color.BLACK);
            ((Graphics2D) g).draw(this.endPhase);
            b= new BasicStroke(2f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(b);
            g.setColor(Color.RED);
            ((Graphics2D) g).drawString("Click here to confirm", 750, 572);

            b= new BasicStroke(2f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(b);

            if(this.findAreaHover!=null){
                g.setColor(Color.ORANGE);
                ((Graphics2D) g).draw(this.findAreaHover);

            }

            if (this.findArea != null) {
                g.setColor(Color.BLACK);
                ((Graphics2D) g).fill(this.findArea);

                g.setColor(Color.RED);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
                ((Graphics2D) g).drawString("This is " + this.realShapeMap.get(this.findArea).getTerName(), this.realShapeMap.get(this.findArea).getHaupstadt().getPointx() - 10, realShapeMap.get(this.findArea).getHaupstadt().getPointy());


            }//only for first Phase!

            /**
            if (this.player.getEigeneTer().size() != 0) {

                for (Teritories t : this.player.getEigeneTer()) {

                    g.setColor(Color.GREEN);
                    ((Graphics2D) g).fill(t.getRealTeritoryShape());
                }

            }//paint all teritories for player

            if (this.comp.getEigeneTer().size() != 0) {

                for (Teritories t : this.comp.getEigeneTer()) {

                    g.setColor(Color.RED);
                    ((Graphics2D) g).fill(t.getRealTeritoryShape());
                }

            }//paint all teritories for comp
             */

        }
        g.setColor(Color.BLACK);
        ((Graphics2D) g).drawString("That is Landerwerb: for Player 21 Teritories", 25, 560);
        ((Graphics2D) g).drawString("You have " + this.player.getPunktLand() + " Teritories to choose", 25, 575);
        ((Graphics2D) g).drawString("Choose Teritory than Click Black Box", 25, 590);

    }//paintComponent for FisrtPanel!

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.endPhase.contains(e.getPoint())){

            if(this.whoIs.getPunktLand()!=0) {

                if(this.findArea!=null) {

                    if(this.whoIs.getEigeneTer().size()==0){
                        this.whoIs.addPunktLand(-1);
                        this.whoIs.addEigeneTeritory(this.realShapeMap.get(this.findArea));
                        this.findArea = null;
                        this.findAreaHover=null;
                        this.repaint();

                    } else{
                        Teritories t=this.whoIs.getEigeneTer().peek();

                        if(!t.getTerName().equals(this.realShapeMap.get(this.findArea).getTerName())){

                            if(this.whoIs.getEigeneTer().contains(this.realShapeMap.get(this.findArea))){
                                this.findArea = null;
                                this.findAreaHover=null;
                                this.repaint();
                            }else {
                                this.whoIs.addPunktLand(-1);
                                this.whoIs.addEigeneTeritory(this.realShapeMap.get(this.findArea));
                                this.findArea = null;
                                this.findAreaHover = null;
                                this.repaint();
                            }

                        }


                    }

                }
            }
            if(this.whoIs.getPunktLand() ==0){

                this.findArea=null;

                this.ComputerLandesBewerbPhase();
                this.repaint();
            }

        }//endPhase

        //choosen Teritory!
        for(Teritories t:this.allTer) {

            if (t.getRealTeritoryShape().contains(e.getPoint())) {

                this.findArea = t.getRealTeritoryShape();
                this.repaint();
                return;

            }
        }


    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //choosen Teritory!
        for(Teritories t:this.allTer) {

            if (t.getRealTeritoryShape().contains(e.getPoint())) {

                this.findAreaHover = t.getRealTeritoryShape();
                this.repaint();

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {



    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    public void ComputerLandesBewerbPhase(){

        MouseListener[] mouseListeners = this.getMouseListeners();
        for (MouseListener mouseListener : mouseListeners) {
            this.removeMouseListener(mouseListener);
        }

        //System.out.println("End of Game From FirstPanel!!!");

        this.whoIs=this.comp;//goes to the secondPanel
        this.End=true;


        //now computer get teritories!
        this.ComputerTeritories();

        //End of Phase
        //remove FirstPanel, set to Frame new 2.Panel

        SecondPanel sp=new SecondPanel(this.allTer);
        sp.setthisPanel(this.whoIs, this.endPhase, this.player, this.comp, this.realShapeMap, this.current, this.PUNKTE, this.allCont);
        //sp.setOpaque(true); not really need

        sp.setVisible(true);
        this.setVisible(false);

        sp.addMouseListener(sp);
        sp.addMouseMotionListener(sp);
        this.current.getContentPane().remove(this);
        this.current.getContentPane().add(sp);

        try {
            this.finalize();
        }
        catch (Throwable ignore){}

        //this.current.repaint();


    }

    public void ComputerTeritories(){

        for(Teritories t:this.allTer){

            if(t.getBelongToGamer()==null){
                this.comp.addEigeneTeritory(t);
                t.addToGamer(this.comp);


            }
        }// 21 Teritory left!


        //Teritories[] terAr = this.allTer.toArray(new Teritories[this.allTer.size()]);
        // int random=(int)( Math.random()*(terAr.length));//letzte nicht inkludiert
       // for(int it=0;it<terAr.length;it++){
            /**
            if(terAr[it].getBelongToGamer()==null){


                //all Teritories


                if(random==it) {
                    this.whoIs.addEigeneTeritory(terAr[it]);
                    terAr[it].addToGamer(this.whoIs);
                    this.whoIs.addPunktLand(-1);

                    random=(int)( Math.random()*(terAr.length));
                    it=0;
                }
                 *

            }
            **/
            /**
            if(it==terAr.length-1){
                random=(int)( Math.random()*(terAr.length));
                it=0;}

            if(this.whoIs.getPunktLand() ==0){

                this.whoIs=player;

                return;
            }
             */


        //}//untill PunktLand==0,search in loop


    }//computerTeritories

}
