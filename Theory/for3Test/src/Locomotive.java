/**
 * Created by Пользователь on 20.01.2016.
 */
public class Locomotive extends Car {
    protected int Leistung;

    public Locomotive(double sn, int leistung,double Tonn,double Lange){
        super(sn, Tonn,Lange);
        this.Leistung=leistung;

    }
    public void connectTo(Car x){
        super.connectTo(x);
    }


    public  String toString(){

        String s="[Locomotive --> "+ super.toString()+" Leistung"+this.Leistung +"]";
        Car c=this;
        while(c.nextSchienefahrzeug!=null){
            if(c.nextSchienefahrzeug instanceof PassengerCar){

                s=s+"\n"+ ((PassengerCar)c.nextSchienefahrzeug).toString();
                c=c.nextSchienefahrzeug;
            }

        }
        return s;
    }



}
