import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.util.HashMap;
import java.util.LinkedList;
public class SecondPanel extends JPanel implements MouseListener,MouseMotionListener {

    private LinkedList<Continent> allCont=new LinkedList<>();
    private LinkedList<Teritories> allTer=new LinkedList<>();
    private HashMap<Area,Teritories> MapForTeritories=new HashMap<>();

    private JFrame currentFrame=null;
    private int Punkte=0;

    private EigeneGamer whoIs=null;
    private EigeneGamer player=null;
    private EigeneGamer comp=null;


    private Area endPhase=null;//endPhase Shape!!
    private boolean End=false;
    private Area Hover=null;

    private boolean TeritoryWith0Verst=false;




    SecondPanel(LinkedList<Teritories> t){
        this.allTer.addAll(t);


    }

    public void setthisPanel(EigeneGamer who,Area endPh,EigeneGamer player,EigeneGamer comp,HashMap<Area,Teritories> m,JFrame jf,int Punkte,LinkedList<Continent> c){

        this.allCont.addAll(c);
        this.whoIs=who;
        this.endPhase=endPh;
        this.player=player;
        this.comp=comp;
        this.MapForTeritories=m;
        this.Punkte=Punkte;

        this.currentFrame=jf;
        this.repaint();

    }


    @Override
    public void paintComponent(Graphics g){

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
        BasicStroke b= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        ((Graphics2D)g).setStroke(b);
        for(Teritories t: this.allTer){

            t.drawTeritory(g);

        }
        /**
        //fill unoccupied teritories
        BasicStroke b= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        ((Graphics2D)g).setStroke(b);

        g.setColor(Color.BLUE);

        for(Teritories t: this.allTer){

            ((Graphics2D)g).fill(t.getRealTeritoryShape());


        }//fill all unoccupied teritories, fill all AnzahlTeritoryArmee(Verstarkerung)!


        //fill Teritories in green and red:

        //for player
        g.setColor(Color.GREEN);
            for(Teritories t:this.player.getEigeneTer()){
                ((Graphics2D)g).fill(t.getRealTeritoryShape());
            }

        //for comp
        g.setColor(Color.RED);
        for(Teritories t:this.comp.getEigeneTer()){
            ((Graphics2D)g).fill(t.getRealTeritoryShape());
        }
         */

        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        ((Graphics2D) g).drawString("This is SecondPanel:First Click on Teritory", 50, 580);
        ((Graphics2D) g).drawString("Secondly Click on Black Box",50,590);
        ((Graphics2D) g).drawString("When you are ran out of point click on Black Box",50,600);
        //fill player and computer teritories

        //draw endPhase

            g.setColor(Color.DARK_GRAY);
            ((Graphics2D) g).draw(this.endPhase);

        //endPhase

        //Anzahl Verstarkerung!/Armee on Teritories
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:allTer){
            ((Graphics2D)g).drawString(""+t.getTeritoryArmee().size(),t.getHaupstadt().getPointx(),t.getHaupstadt().getPointy());

        }
        //Anzahl VerStarkerung!

        //Basic Drawing




        //Hover
        if(this.Hover!=null){
            BasicStroke bb= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(bb);
            g.setColor(Color.ORANGE);
            ((Graphics2D)g).draw(this.Hover);

        }
        //Hover

        //all Teritories with 1 Armee for player

        if(this.TeritoryWith0Verst){
            BasicStroke bb= new BasicStroke(3f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(bb);
            g.setColor(Color.RED);
            ((Graphics2D)g).drawString("All Teritories must be with at least 1 Armee!",50,610);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(this.endPhase.contains(e.getPoint())){

            if(this.player.getVerstarkPunkte()==0) {

                if(this.TeritoryWith0Verst==false) {
                    this.End = true;
                    this.Hover = null;
                    this.GoToNextPhase();
                }
            }
            this.repaint();
            return;
        }

        if(this.End==false) {//if we are still in this Phase

            this.TeritoryWith0Verst=false;
            /**
            for(Teritories t: this.player.getEigeneTer()){
                if(t.getTeritoryArmee().size()==0){
                    this.TeritoryWith0Verst=true;
                }

            }
             */


            if (SwingUtilities.isLeftMouseButton(e)) {//left Mouse Buttom
                for (Teritories t : this.player.getEigeneTer()) {


                    if (t.getRealTeritoryShape().contains(e.getPoint())) {

                        if (this.player.getVerstarkPunkte() != 0) {
                            this.player.getVerstarkerung();
                            this.player.addhaveArmeeOnTer(t);

                            /**
                             Armee arm = this.player.getHaveVerst().pollLast();//Verstarkerung is One Arme without teritory!

                             arm.setTo(t);//tie armee to teritory
                             t.addteritoryArmee(arm);//add armee to teritory
                             */
                        }


                        this.repaint();
                        this.Hover = null;
                        for(Teritories tet: this.player.getEigeneTer()){
                            if(tet.getTeritoryArmee().size()==0){
                                this.TeritoryWith0Verst=true;
                            }

                        }
                        return;
                    }


                }
            } else{//right MouseButtom

                for (Teritories t : this.player.getEigeneTer()) {


                    if (t.getRealTeritoryShape().contains(e.getPoint())) {
                        if(t.getTeritoryArmee().peekLast()!=null) {
                            this.player.addVerstarkPunkte(1);
                            t.getTeritoryArmee().pollLast().setTo(null);

                        }
                        this.repaint();
                        this.Hover = null;

                        for(Teritories tet: this.player.getEigeneTer()){
                            if(tet.getTeritoryArmee().size()==0){
                                this.TeritoryWith0Verst=true;
                            }

                        }
                        return;
                    }


                }


            }//right Mouse Buttom


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

        for(Teritories t:this.allTer){

            if(t.getRealTeritoryShape().contains(e.getPoint())){
                this.Hover=t.getRealTeritoryShape();
                this.repaint();
                return;
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {}


    public void GoToNextPhase(){

       // System.out.println("Computer will get Verstarkerung!");
        this.computerVertarkPhase();

        //end of phase--------------------------------

        //Third Panel: move Armee, play Bones, then to the Fourth Panel- Who Have Win, distribute VerstarkPunkte
        ThirdPanel tp=new ThirdPanel(this.allTer);
        tp.setThirdPanel(this.whoIs, this.endPhase, this.player, this.comp, this.MapForTeritories, this.currentFrame, this.Punkte, this.allCont);

        tp.setVisible(true);
        this.setVisible(false);

        this.removeMouseListener(this);
        this.removeMouseMotionListener(this);

        tp.addMouseListener(tp);
        tp.addMouseMotionListener(tp);
        this.currentFrame.getContentPane().remove(this);
        this.currentFrame.getContentPane().add(tp);


        try {
            this.finalize();
        }
        catch (Throwable ignore){}
        //this.currentFrame.repaint();


    }

    public void computerVertarkPhase(){

        for(Teritories t: this.comp.getEigeneTer()){
            if(t.getTeritoryArmee().size()==0){
                this.comp.getVerstarkerung();
                this.comp.addhaveArmeeOnTer(t);
            }

        }//to each teritory 1 punkt

        //Where am I? best continent to start
        // Opportunities? to get new (small)continent
        // Priorities? 1.defend continents, 2.offensive towards player's Teritories
        Continent mostTeritoriesAreIn=null;
        int minDifferenceOnContinent=30;//something big enough
        for(Continent c: this.allCont){

            int continentSize=c.getContinentTer().size();
            int howManyTeritAreInConinent=0;

            for(Teritories contTer:c.getContinentTer()){

                for(Teritories compTer: this.comp.getEigeneTer()){

                    if(compTer.getTerName().equals(contTer.getTerName())) {

                        howManyTeritAreInConinent++;
                    }
                }//compare with computer teritories

            }//teritories of  continent c

            if ((continentSize - howManyTeritAreInConinent) != 0) {//difference must not be 0(Computer has this Continent already)

                if (minDifferenceOnContinent >= (continentSize - howManyTeritAreInConinent)) {
                    minDifferenceOnContinent = continentSize - howManyTeritAreInConinent;
                    mostTeritoriesAreIn = c;

                }
            }

        }//for all Continents

        //now we know where we must start
        //mostTeritoriesAreIn  continet
        //Opportunities && Priorities! only one Take Continent!
        // 1. take  mostTeritoriesAreIn's Continent, defend if necessary
        // 2. take teritory from Player, which is located on  small Continent

        //1.Opportunity
        if(mostTeritoriesAreIn!=null){

            Teritories PlayerTeritory=null;

                for(Teritories findPlayerTer:mostTeritoriesAreIn.getContinentTer() ){

                    if(findPlayerTer.getBelongToGamer().equals("Player")){

                        if(PlayerTeritory!=null){

                           if( PlayerTeritory.getTeritoryArmee().size() >=findPlayerTer.getTeritoryArmee().size()){
                                PlayerTeritory=findPlayerTer;
                           }//find one with the smallest ammount on Player's Armee

                        }else {
                            PlayerTeritory = findPlayerTer;
                        }

                    }

                }//find most attractive PlayerTeritory

            //now we know what teritory we will atack
            this.comp.setAtackThat(PlayerTeritory);
            //VertarkPunkte to near Nachbarn
            //PlayerTeritory !=null
            Teritories SendVerstarkerungTo=null;
            for(Teritories t:PlayerTeritory.getNachbarn()){

                    if( !t.getBelongToGamer().equals("Player")){
                        if(SendVerstarkerungTo!=null){

                            if(t.getTeritoryArmee().size() >=SendVerstarkerungTo.getTeritoryArmee().size()){
                                SendVerstarkerungTo=t;
                            }//conputerTeritory with the highest ammount of Armees

                        }else {
                            SendVerstarkerungTo = t;
                        }
                    }
            }

if(SendVerstarkerungTo!=null) {
    while (this.comp.getVerstarkPunkte() > 0) {

        this.comp.getVerstarkerung();
        this.comp.addhaveArmeeOnTer(SendVerstarkerungTo);

    }
    //Computer will go From
    this.comp.setAtackFrom(SendVerstarkerungTo);

}
        }//verstartPunkte To Nachbarn  of PlayerTeritory
        if(this.comp.getVerstarkPunkte()==0){return;}


        //2.Opportunity  prepare To take new Teritory
        //means  in Computer's Continents there only  Computer's Teritories
        Teritories toPlayersTeritory=null;
        Teritories from=null;
        for(Teritories t:this.comp.getEigeneTer()){

            for(Teritories Nachbarn:t.getNachbarn()){

                if(Nachbarn.getBelongToGamer().equals("Player")){

                    if(toPlayersTeritory!=null){
                        if(Nachbarn.getTeritoryArmee().size()<=toPlayersTeritory.getTeritoryArmee().size()){
                            toPlayersTeritory=Nachbarn;
                            from=t;
                        }

                    }else {
                        toPlayersTeritory = Nachbarn;
                        from=t;
                    }
                }

            }
        }
        this.comp.setAtackThat(toPlayersTeritory);

        while(this.comp.getVerstarkPunkte()>0){
            this.comp.getVerstarkerung();
            this.comp.addhaveArmeeOnTer(from);
        }

        this.comp.setAtackFrom(from);



    }//computerVertarkPhase

}
