import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.util.HashMap;
import java.util.LinkedList;

public class ThirdPanel extends JPanel implements  MouseListener,MouseMotionListener{

    private LinkedList<Continent> allCont=new LinkedList<>();
    private LinkedList<Teritories> allTer=new LinkedList<>();
    private HashMap<Area,Teritories> MapForTeritories=new HashMap<>();

    private JFrame currentFrame=null;
    private int Punkte=0;

    private EigeneGamer whoIs=null;
    private EigeneGamer player=null;
    private EigeneGamer comp=null;

    private Area From=null;
    private Area MoveTo=null;
    private Area ArmeeArea=new Area( new Rectangle(470,560,60,20));
    private boolean HowManyArmees=false;

    private Area BackArea=new Area( new Rectangle(895,560,60,20));
    private Area endPhase=null;//endPhase Shape!!
    private boolean End=false;
    private Area Hover=null;

    ThirdPanel(LinkedList<Teritories> t){
        this.allTer=t;
    }

    public void setThirdPanel(EigeneGamer who,Area endPh,EigeneGamer player,EigeneGamer comp,HashMap<Area,Teritories> m,JFrame jf,int Punkte,LinkedList<Continent> c){

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

        ///Basic Drawing
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

        //fill unoccupied teritories
        BasicStroke b= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        ((Graphics2D)g).setStroke(b);

        for(Teritories t: this.allTer){

            t.drawTeritory(g);

        }
        /**
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

        //fill player and computer teritories
         */

        //draw endPhase
        g.setColor(Color.DARK_GRAY);
        ((Graphics2D) g).draw(this.endPhase);

        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        ((Graphics2D) g).drawString("End Phase", 750, 572);

        //endPhase


        //Basic Drawing

        //BackArea
        g.setColor(Color.DARK_GRAY);
        ((Graphics2D) g).draw(this.BackArea);

        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        ((Graphics2D) g).drawString("BackArea",895,572);
        //BackArea


        //ArmeeArea
        if((this.From==null) || (this.MoveTo==null)){
            ((Graphics2D)g).setColor(new Color(204,229,255));
            g.fillRect(470, 530,80,80);

        }else{
            g.setColor(Color.DARK_GRAY);
            ((Graphics2D) g).draw(this.ArmeeArea);

            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
            ((Graphics2D) g).drawString("ArmeeArea", 470, 572);

        }
        //ArmeeArea

        //Hover
        if(this.Hover!=null){
            BasicStroke bb= new BasicStroke(2f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(bb);
            g.setColor(Color.ORANGE);
            ((Graphics2D)g).draw(this.Hover);

        }
        //Hover

        //draw From
        if(this.From!=null){
            ((Graphics2D)g).setColor(new Color(230,67,160));
            ((Graphics2D)g).fill(this.From);

        }
        //DrawMoveTo
        if(this.MoveTo!=null){
            ((Graphics2D)g).setColor(Color.LIGHT_GRAY);
            ((Graphics2D)g).fill(this.MoveTo);
        }



        //Anzahl Verstarkerung!/Armee on Teritories
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:this.allTer){
            ((Graphics2D)g).drawString(""+t.getTeritoryArmee().size(),t.getHaupstadt().getPointx(),t.getHaupstadt().getPointy());

        }
        //Anzahl VerStarkerung!

        //Armee 1-PlayerArmees
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:this.allTer){

            if(t.getArmee1().size()>0){
                ((Graphics2D)g).drawString(""+t.getArmee1().size(),t.getHaupstadt().getPointx()-5,t.getHaupstadt().getPointy()+10);
            }
        }
        //Armee 1-PlayerArmees

        //Armee 2-Computer
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:this.allTer){

            if(t.getArmees2().size()>0){
                ((Graphics2D)g).drawString(""+t.getArmees2().size(),t.getHaupstadt().getPointx()+5,t.getHaupstadt().getPointy()+10);
            }
        }

        //Armee 2-Computer

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {


        if(this.endPhase.contains(e.getPoint())){

            if(this.From!=null && this.MoveTo!=null){
                this.End=true;
                this.HowManyArmees=false;

                this.nextComputerArmeePhase();//only Armees
                this.GoToNaxtPanel();
                this.From=null;
                this.MoveTo=null;

                return;//end of ThirdPanel

            }

        }



        if(this.BackArea.contains(e.getPoint())){

            if(this.From!=null && this.MoveTo!=null) {

                Teritories tFrom = this.MapForTeritories.get(this.From);
                Teritories tMoveTo = this.MapForTeritories.get(this.MoveTo);


                while (tMoveTo.getArmee1().size() > 0) {

                    Armee arm = tMoveTo.getArmee1().pollLast();
                    arm.setTo(tFrom);
                    tFrom.addteritoryArmee(arm);

                }
            }

            this.From=null;
            this.MoveTo=null;
            this.HowManyArmees=false;

            this.repaint();
            return;
        }

        if(this.End==false) {

            if (this.HowManyArmees == false) {

                //this who is in charge==player
                for (Teritories t : this.player.getEigeneTer()) {

                    if(this.From==null) {

                        if (t.getRealTeritoryShape().contains(e.getPoint())) {

                            //From==t
                            this.From = t.getRealTeritoryShape();
                            this.repaint();

                        }
                    }

                    if(this.From!=null) {


                        for (Teritories nachbarn : this.MapForTeritories.get(this.From).getNachbarn()) {

                            if (nachbarn.getRealTeritoryShape().contains(e.getPoint())) {

                                //move to
                                this.MoveTo = nachbarn.getRealTeritoryShape();
                                //this.HowManyArmees=true;
                                this.repaint();


                            }

                        }
                    }


                }

                if(this.From!=null && this.MoveTo!=null){
                    this.HowManyArmees=true;
                }

                return;

            }
        }



        if(this.HowManyArmees==true) {

            if (this.MoveTo.contains(e.getPoint())) {

                Teritories tFrom = this.MapForTeritories.get(this.From);
                Teritories tMoveTo = this.MapForTeritories.get(this.MoveTo);

                if (tFrom.getTeritoryArmee().size() > 1) {//always 1 armee in TeritoryArmee

                    Armee arm = tFrom.getTeritoryArmee().pollLast();
                    arm.setTo(tMoveTo);
                    tMoveTo.addArmee1(arm);

                }

                this.repaint();
                return;
            }


            if (this.From != null) {
                if (this.From.contains(e.getPoint())) {

                    Teritories tFrom = this.MapForTeritories.get(this.From);
                    Teritories tMoveTo = this.MapForTeritories.get(this.MoveTo);

                    if (tMoveTo.getArmee1().size() > 0) {

                        Armee arm = tMoveTo.getArmee1().pollLast();
                        arm.setTo(tFrom);
                        tFrom.addteritoryArmee(arm);

                    }

                    this.repaint();
                    return;
                }
            }
        }


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
    public void GoToNaxtPanel(){

        //remove ThirdPanel,add Fourth panel(Play Bones(this.getArmee1.size() >0 &&this.getArmee2.size() ) or eig.ter, verstarkerung, winner)
       // System.out.println("End of Third Panel");
        this.fixBugs();
        this.nextComputerArmeePhase();
        this.repaint();

        FourthPanel f4p=new FourthPanel(this.allTer);


        f4p.setFourthPanel(this.whoIs, this.endPhase, this.player, this.comp, this.MapForTeritories, this.currentFrame, this.Punkte,this.allCont);
        f4p.setToPlayBonesWith(this.From, this.MoveTo );

        f4p.setVisible(true);
        this.setVisible(false);

        this.removeMouseListener(this);
        this.removeMouseMotionListener(this);

        f4p.addMouseListener(f4p);
        f4p.addMouseMotionListener(f4p);
        this.currentFrame.getContentPane().remove(this);
        this.currentFrame.getContentPane().add(f4p);

        this.currentFrame.repaint();

        try {
            this.finalize();
        }
        catch (Throwable ignore){
            //System.out.println(ignore.getMessage());
        }

    }

    public void fixBugs(){
        for(Teritories t:this.player.getEigeneTer()){

            if(t.getArmee1().size()!=0){

                while(t.getArmee1().size()>0){
                    Armee arm=t.getArmee1().pollLast();
                    t.addteritoryArmee(arm);

                }

            }
        }


    }

    public void nextComputerArmeePhase(){


        //AngriefPhase, all by Computer
        //System.out.println("End of THirdPanel");

        //computer already knows where to go


        Teritories from=this.comp.getAtackFrom();
        Teritories to=this.comp.getAtackThat();
        if(from!=null && to!=null) {

            if ((from.getTeritoryArmee().size() + (6 - 1)) >= to.getTeritoryArmee().size()) {  //
                while (from.getTeritoryArmee().size() > 1) {
                    Armee arm = from.getFromTeriToryArmee();
                    arm.setTo(to);
                    to.addArmee2(arm);
                }
                this.comp.setAtackThat(null);
                this.comp.setAtackFrom(null);
                return;
            }
        }
        //change strategy:  not enough VertarkPunkte to make gut move

        //3.Opportunity  defend boarders

        LinkedList<Teritories> borderList=new LinkedList<>();
        for(Teritories t:this.comp.getEigeneTer()){

            Teritories add=null;
            for(Teritories nachbarn: t.getNachbarn()){
                if(nachbarn.getBelongToGamer().equals("Player")){
                    add=t;
                }
            }

            if(add!=null){
                borderList.add(add);
            }

        }
        //now we know borders with Player
        // using Punkte from Teritory-from. spread them throughout near borders
        Teritories moveTO=null;
        from=null;
        for(Teritories t: borderList){
            //1.Weak borders at one Turn

            for(Teritories ter:this.comp.getEigeneTer()) {

                for (Teritories nachbarnFrom : ter.getNachbarn()) {

                    if (t.getTeritoryArmee().size() == 1) {//weak border

                        if (nachbarnFrom.getTerName().equals(t.getTerName())) {//half of Armees go to weak border
                            int n = ter.getTeritoryArmee().size();
                            n = (n / 2);
                            moveTO = nachbarnFrom;
                            while (n > 1) {

                                Armee arm = ter.getFromTeriToryArmee();
                                if (arm != null) {

                                    arm.setTo(moveTO);
                                    moveTO.addteritoryArmee(arm);
                                }

                                n = n - 1;
                            }

                            return;
                        }

                    }//some borders are weak

                }
            }
            //means there is no weak borders near From

            /**
            //2.check other borders!
            for(Teritories playersTer:t.getNachbarn()){

                if(playersTer.getBelongToGamer().equals("Player")){
                    boolean bool1=t.getTeritoryArmee().size()< playersTer.getTeritoryArmee().size();
                    boolean bool2=t.getTeritoryArmee().size()<= t.getArmee1().size();
                    moveTO = t;

                    //only border, who is under great danger
                    if(bool1 || bool2){
                        Teritories withdrawFrom=null;
                        for( Teritories friendly: t.getNachbarn()){

                            if((!friendly.getBelongToGamer().equals("Player")) &&( !borderList.contains(friendly))  ) {

                                if(withdrawFrom!=null){

                                    if(friendly.getTeritoryArmee().size()>=withdrawFrom.getTeritoryArmee().size()){
                                        withdrawFrom=friendly;
                                    }
                                } else{
                                    withdrawFrom=friendly;
                                }

                            }

                        }//find where to borrow

                        if(withdrawFrom!=null){
                            int n=withdrawFrom.getTeritoryArmee().size();
                            //withdrawFrom is not border so we need all of his armees
                            while(n>1){

                                Armee arm = withdrawFrom.getFromTeriToryArmee();
                                if(arm!=null) {

                                    arm.setTo(moveTO);
                                    moveTO.addteritoryArmee(arm);
                                }

                                n=n-1;
                            }
                                return;
                        }


                    }//it is dangerous
                }//only if threat is from Player

            }//2.check other borders
            */

        }


    }//end of computer Phase



}
