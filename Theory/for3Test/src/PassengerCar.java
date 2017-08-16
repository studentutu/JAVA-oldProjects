/**
 * Created by Пользователь on 20.01.2016.
 */
public class PassengerCar extends Car{
    protected int Platz;

    public PassengerCar(double sn, int platz ,double Tonn,double Lange){
        super(sn, Tonn, Lange);

        this.Platz=platz;

    }

    public String toString(){

        String s="[PassengerCar --> "+ "SerNumber:"+ this.getSerialNummer() + "Tonns:"+ this.Tonn + " Lange:"+this.Lange +" Platz:"+this.Platz +"]";

        return s;
    }

}
