import java.util.LinkedList;


public class EigeneGamer {
    private String nameOGamer;

    //private boolean WinInBones=false;
    private Teritories AtackThat=null;
    private Teritories AtackFrom=null;

    private LinkedList<Armee> haveVerst=new LinkedList<>();
    private LinkedList<Teritories> EigeneTer=new LinkedList<>();
    //private LinkedList<Armee> haveArmeeOnTer=new LinkedList<>();// needed to find Armee  // but not needed

    private int VerstarkPunkte=0;
    private int PunktLand=0;

    EigeneGamer(String nameOGamer){
        this.nameOGamer=nameOGamer;
        this.haveVerst=new LinkedList<Armee>();
        this.EigeneTer=new LinkedList<Teritories>();
        this.VerstarkPunkte=0;

    }
    //public boolean getWinInBones(){return this.WinInBones;}
    //public void setWinInBones(boolean b){this.WinInBones=b;}
    public void setAtackThat(Teritories t){ this.AtackThat=t;}
    public void setAtackFrom(Teritories t){ this.AtackFrom=t;}
    public Teritories getAtackThat(){return this.AtackThat;}
    public Teritories getAtackFrom(){return this.AtackFrom;}

    /* not needed
    public Armee findArmee(Teritories t){
        Armee[] armee=this.haveArmeeOnTer.toArray(new Armee[this.haveArmeeOnTer.size()]);

        for(int i=0;i<armee.length;i++) {

            if (t.getTerName().equals(armee[i].getOwnTeritory().getTerName())){
                Armee sendTo=armee[i];
                //this.haveArmeeOnTer.remove(i);
                for(Armee a:this.haveArmeeOnTer){
                    if(a.getOwnTeritory().getTerName().equals(sendTo.getOwnTeritory().getTerName())){
                        this.haveArmeeOnTer.remove(a);
                    }
                }
                return sendTo;

            }
        }
        return null;
    }
    */


    public void addhaveArmeeOnTer(Teritories t){

        if(this.haveVerst.peekLast()!=null){

            Armee arm=this.haveVerst.pollLast();
            arm.setTo(t);
            t.addteritoryArmee(arm);

            //needed
            // but not needed
            //this.haveArmeeOnTer.add(arm);
        }

    }

    public String getNameOGamer(){return this.nameOGamer;}//Player oder Computer


    public void addVerstarkPunkte(int n){
        this.VerstarkPunkte=this.VerstarkPunkte+n;
    }
    public int getVerstarkPunkte(){return this.VerstarkPunkte;}

    public void addPunktLand(int n){
        this.PunktLand=this.PunktLand+n;
    }
    public int getPunktLand(){return this.PunktLand;}


    public LinkedList<Teritories> getEigeneTer(){return this.EigeneTer;}

    public void addEigeneTeritory(Teritories t){


        if(this.EigeneTer.contains(t)){return;}
        t.addToGamer(this);
        this.EigeneTer.add(t);
        return;
    }

    public void removeEigeneTeritory(Teritories t){
        if(this.EigeneTer.contains(t)){this.EigeneTer.remove(t);}
        return;
    }



    public void getVerstarkerung(){//
        if(this.VerstarkPunkte>0) {

           // Verstarkerung ver = new Verstarkerung();
            Armee arm=new Armee();
            this.haveVerst.add(arm);//+1 to haveVertark

            this.VerstarkPunkte=this.VerstarkPunkte-1;
            return;

        }else{ return;}
    }
    public LinkedList<Armee> getHaveVerst(){return this.haveVerst;}

}
