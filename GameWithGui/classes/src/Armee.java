import java.util.LinkedList;

public class Armee {
    private Teritories ownTeritory;
    private String nameOfArmee;

    Armee(){
        this.ownTeritory=null;
        this.nameOfArmee="Reinforce";
    }
    Armee(Teritories l){

        this.nameOfArmee="Reinforce";
        this.ownTeritory=l;
    }



    public Teritories getOwnTeritory(){return this.ownTeritory;}

    public void setTo(Teritories t){this.ownTeritory=t;}

}
