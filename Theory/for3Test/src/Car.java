/**
 * Created by Пользователь on 20.01.2016.
 */
public  class Car extends Schienenfahrzeug {

    protected  double Tonn;
    protected  double Lange;
    public Car  nextSchienefahrzeug=null;

    public Car(double sn, double Tonn, double Lange){
       super(sn);

        this.Tonn=Tonn;
        this.Lange=Lange;

    }
    @Override
    public   String toString(){
        String s="";
        s=s+"[Car--> "+" SerNumber:"+ this.getSerialNummer() + "Tonns:"+ this.Tonn + " Lange:"+this.Lange + "]";

        return s;
    }

    public void connectTo(Car x){

        if(this.nextSchienefahrzeug==null){
            this.nextSchienefahrzeug=x;
            return;
        }
        if(this.nextSchienefahrzeug!=null){
            this.nextSchienefahrzeug.connectTo(x);
            return;
        }

    }



}