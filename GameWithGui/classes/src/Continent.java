import java.util.LinkedList;
public class Continent {

    private String continentName;
    private LinkedList<Teritories> continentTer;

    Continent(String continentName){
        this.continentName=continentName;
        this.continentTer=new LinkedList<>();

    }
    public void addTer(Teritories teritory){
        for(Teritories t:this.continentTer){
            if(t.getTerName().equals(teritory.getTerName())){return;}

        }
        this.continentTer.add(teritory);

    }
    public void removeTer(Teritories t){

       if( this.continentTer.contains(t)){ this.continentTer.remove(t); return;}
        return;
    }

    public String getContinentName(){return this.continentName;}
    public LinkedList<Teritories> getContinentTer(){return this.continentTer;}

    public  String toString(){
        String s=this.continentName;
        for(Teritories t:this.continentTer){
        s=s+" "+t.getTerName();
        }
        return s;
    }
}
