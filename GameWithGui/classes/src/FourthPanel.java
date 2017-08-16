import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.util.HashMap;
import java.util.LinkedList;

public class FourthPanel extends JPanel implements MouseListener,MouseMotionListener {

    private LinkedList<Continent> allCont=new LinkedList<>();
    private LinkedList<Teritories> allTer=new LinkedList<>();
    private HashMap<Area,Teritories> MapForTeritories=new HashMap<>();

    private JFrame currentFrame=null;
    private int Punkte=0;

    private EigeneGamer whoIs=null;
    private EigeneGamer player=null;
    private EigeneGamer comp=null;

    private Area Hover=null;
    private Area endPhase=null;//endPhase Shape!!
    private boolean End=false;

    private Area PlayBones= new Area(new Rectangle(390,480,50,50));
    private boolean playBones=true;
    private  String Krieger=null;

    private Area From=null;
    private Area To=null;

    private boolean EndOfTheGame=false;
    private String WinAndEnd=null;


    FourthPanel(LinkedList<Teritories> t){
        this.allTer=t;

    }

    public void setFourthPanel(EigeneGamer who,Area endPh,EigeneGamer player,EigeneGamer comp,HashMap<Area,Teritories> m,JFrame jf,int Punkte,LinkedList<Continent> c){

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
    public void setToPlayBonesWith(Area From, Area To){
        this.From=From;
        this.To=To;
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

        //draw endPhase
        g.setColor(Color.DARK_GRAY);
        ((Graphics2D) g).draw(this.endPhase);

        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        ((Graphics2D) g).drawString("End Phase", 750, 572);

        //endPhase


        //Basic Drawing


        //Hover
        if(this.Hover!=null){
            BasicStroke bb= new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            ((Graphics2D)g).setStroke(bb);
            g.setColor(Color.ORANGE);
            ((Graphics2D)g).draw(this.Hover);

        }
        //Hover


        //Anzahl Verstarkerung!/Armee on Teritories
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:this.allTer){
            ((Graphics2D)g).drawString(""+t.getTeritoryArmee().size(),t.getHaupstadt().getPointx(),t.getHaupstadt().getPointy());

        }
        //Anzahl VerStarkerung/Armee!

        //Armee 1-PlayerArmees
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:this.allTer){

            if(t.getArmee1().size()>0){
                ((Graphics2D)g).drawString(""+t.getArmee1().size(),t.getHaupstadt().getPointx()-5,t.getHaupstadt().getPointy()+10);
                g.setColor(new Color(0, 102, 0));
                ((Graphics2D)g).draw(t.getRealTeritoryShape());
            }
        }
        //Armee 1-PlayerArmees

        //Armee 2-Computer
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        for(Teritories t:this.allTer){

            if(t.getArmees2().size()>0){
                ((Graphics2D)g).drawString(""+t.getArmees2().size(),t.getHaupstadt().getPointx()+5,t.getHaupstadt().getPointy()+10);
                g.setColor(new Color(255, 64, 0));
                ((Graphics2D)g).draw(t.getRealTeritoryShape());
            }
        }

        //Armee 2-Computer

        //PlayBones
        if(this.playBones){
            g.setColor(Color.lightGray);
            ((Graphics2D)g).fill(this.PlayBones);
            g.setColor(Color.BLACK);
            ((Graphics2D)g).drawString("BONES", 390, 489);

        }else{//Play Bones
            g.setColor(Color.RED);
            ((Graphics2D)g).fill(this.PlayBones);
            g.setColor(Color.BLACK);
            ((Graphics2D)g).drawString("Win --> "+ this.Krieger, 350, 489);
        }//Who wins

        if(this.EndOfTheGame){
            g.setColor(Color.MAGENTA);
            ((Graphics2D)g).fill(new Rectangle(100, 90, 600, 300));
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            ((Graphics2D)g).drawString(this.WinAndEnd, 350,200);

        }




    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
    public void mouseClicked(MouseEvent e) {

        if(this.playBones) {
            if (this.PlayBones.contains(e.getPoint())) {

                this.playBones=false;

                // Random with anzahl der Teritories
                Teritories Fr=this.MapForTeritories.get(this.From);
                Teritories To=this.MapForTeritories.get(this.To);

                if(To.getBelongToGamer().equals("Player")){

                    this.repaint();
                    this.computerTurn();

                    return;
                }
                //player on compTeritory
                int random1= (int)(Math.random()*6)+1 + To.getArmee1().size();//Armee1 for player, armee 2 for Comp

                int random2=(int)(Math.random()*6)+1 + To.getTeritoryArmee().size();//Comp

                if(random1>random2){

                    To.removeTeritoryFrom(this.comp);//remove From Computer
                    this.player.addEigeneTeritory(To);//Add to Player


                    int Difference=To.getArmee1().size()-To.getTeritoryArmee().size() ;

                    To.getTeritoryArmee().clear();
                    To.getArmee1().clear();
                    //armee 2 will not touch!!

                    if(Difference<=0){
                        Armee arm=new Armee(To);
                        To.addteritoryArmee(arm);//mindestens 1 Armee!!


                    } else {

                        for (int i = 1; i <= Difference; i++) {
                            Armee arm = new Armee(To);
                            To.addteritoryArmee(arm);

                        }
                    }


                    //this.Krieger=this.player.getNameOGamer();

                    //Player Win
                } else{//Computer Teritory Win

                    int Difference=To.getTeritoryArmee().size() - To.getArmee1().size();

                    To.getTeritoryArmee().clear();
                    To.getArmee1().clear();

                    if(Difference<=0){

                        Armee arm=new Armee(To);
                        To.addteritoryArmee(arm);//mindestens 1 Armee!! it is Computer
                    }else{

                        for(int i=1;i<=Difference;i++){
                            Armee arm=new Armee(To);
                            To.addteritoryArmee(arm);
                        }


                    }
                   // this.Krieger=this.comp.getNameOGamer();

                }// either player win or computerTeritory win

                this.repaint();
                this.Krieger=null;
                this.computerTurn();

            }//clicked on Area


        }//only in Subphase of PlayBones

    }//mouse Clicked


    private void computerTurn(){

        //code for PlayBones for Computer
        //From--> ComputerTo
       // ComputerTo

        Teritories fightFor=null;
        for(Teritories t: this.allTer){

            if(t.getArmees2().size()!=0){
                fightFor=t;
            }
        }

        if(fightFor!=null) {
            int random1 = (int) (Math.random() * 6) + 1 + fightFor.getArmees2().size();//Armee1 for player, Armees 2 for Comp

            int random2 = (int) (Math.random() * 6) + 1 + fightFor.getTeritoryArmee().size();//Player
            if (random1 > random2) {

                fightFor.removeTeritoryFrom(this.player);//remove From Player
                this.comp.addEigeneTeritory(fightFor);//Add to Comp


                int Difference = fightFor.getArmees2().size() - fightFor.getTeritoryArmee().size();

                fightFor.getTeritoryArmee().clear();
                fightFor.getArmees2().clear();
                //armee 1 will not touch!!

                if (Difference <= 0) {
                    Armee arm = new Armee(fightFor);
                    fightFor.addteritoryArmee(arm);//mindestens 1 Armee!!


                } else {

                    for (int i = 1; i <= Difference; i++) {
                        Armee arm = new Armee(fightFor);
                        fightFor.addteritoryArmee(arm);

                    }
                }


                //this.Krieger=this.player.getNameOGamer();

                //Player Win
            } else {//Player Teritory Win

                int Difference = fightFor.getTeritoryArmee().size() - fightFor.getArmees2().size();

                fightFor.getTeritoryArmee().clear();
                fightFor.getArmees2().clear();

                if (Difference <= 0) {

                    Armee arm = new Armee(fightFor);
                    fightFor.addteritoryArmee(arm);//mindestens 1 Armee!! it is Player
                } else {

                    for (int i = 1; i <= Difference; i++) {
                        Armee arm = new Armee(fightFor);
                        fightFor.addteritoryArmee(arm);
                    }


                }
                //this.Krieger=this.comp.getNameOGamer();

            }

        }
        /////////////

        if((this.player.getEigeneTer().size() == this.allTer.size() ) || this.player.getEigeneTer().size()==0 ){

            this.goToWinAndEnd();
            this.repaint();
            return;
        }

        this.ToNextPanelAndNextTurn();


    }

    private void goToWinAndEnd(){

        this.EndOfTheGame=true;
       if( this.player.getEigeneTer().size()!=0){
           this.WinAndEnd=" Congrats! You win!";

       }else{

           this.WinAndEnd="Unfortunately, you have not win :( ";
       }

    }


    private void ToNextPanelAndNextTurn(){

        this.VerstarkPunkteSpread();
        SecondPanel sp=new SecondPanel(this.allTer);


        sp.setthisPanel(this.whoIs, this.endPhase, this.player, this.comp, this.MapForTeritories, this.currentFrame, this.Punkte, this.allCont);


        sp.setVisible(true);
        this.setVisible(false);

        this.removeMouseListener(this);
        this.removeMouseMotionListener(this);

        sp.addMouseListener(sp);
        sp.addMouseMotionListener(sp);
        this.currentFrame.getContentPane().remove(this);
        this.currentFrame.getContentPane().add(sp);

        this.currentFrame.repaint();

        try {
            this.finalize();
        }
        catch (Throwable ignore){
            //System.out.println(ignore.getMessage());
        }



    }

    private void VerstarkPunkteSpread(){

            //for 3 teritory 1 Vp
            // for Continent + 3Vp
        //for player
        LinkedList<Teritories> comparewithContinents=this.player.getEigeneTer();

        int realCountTeritories=0;
        int prufSize=0;
        int howManyContinents=0;

        for(Continent c:this.allCont){

             for(Teritories t:c.getContinentTer()){

                 realCountTeritories++;



                 for(Teritories teritoryPrufSize: comparewithContinents){//players Teritories

                     if(teritoryPrufSize.getTerName().equals(t.getTerName())){

                         prufSize++;

                     }//find precise Teritory

                 }//find exact Teritories

             }//in one Continent for all Continent's Teritories

            if(prufSize==realCountTeritories){
                howManyContinents++;


            }

            realCountTeritories=0;
            prufSize=0;

        }//in all Continents

        int TotalPunkte=(int)(comparewithContinents.size()/3) + (howManyContinents*this.Punkte);
        this.player.addVerstarkPunkte(TotalPunkte);


        //now for computer

        comparewithContinents=this.comp.getEigeneTer();

        realCountTeritories=0;
        prufSize=0;
        howManyContinents=0;
        for(Continent c:this.allCont){

            for(Teritories t:c.getContinentTer()){

                realCountTeritories++;



                for(Teritories teritoryPrufSize: comparewithContinents){//players Teritories

                    if(teritoryPrufSize.getTerName().equals(t.getTerName())){

                        prufSize++;

                    }//find precise Teritory

                }//find exact Teritories

            }//in one Continent for all Continent's Teritories

            if(prufSize==realCountTeritories){
                howManyContinents++;


            }

            realCountTeritories=0;
            prufSize=0;

        }//in all Continents

        TotalPunkte=(int)(comparewithContinents.size()/3) + (howManyContinents*this.Punkte);
        this.comp.addVerstarkPunkte(TotalPunkte);



    }//VP Points



}//end of 4.Panel
