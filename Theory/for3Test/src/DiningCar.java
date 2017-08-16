/**
 * Created by Пользователь on 20.01.2016.
 */
public class DiningCar extends PassengerCar {
    protected boolean offen;

        public DiningCar(double sn, int platz,boolean off, int Tonn,int Lange){

            super(sn,platz, Tonn,Lange);

            this.offen=off;
        }
    public boolean getOffen(){return  this.offen;}


    public String toString(){

        String s="[DiningCar --> " + super.toString() + (this.offen?"Offen":"Nicht Offen") +"]";
            return  s;
    }
}
