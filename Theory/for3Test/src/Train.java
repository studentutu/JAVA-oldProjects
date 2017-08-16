/**
 * Created by Пользователь on 20.01.2016.
 */
public class Train {

    private Locomotive l;
    public Train (Locomotive l){
        this.l=l;

    }

    public void addCar(Car x){

        l.connectTo(x);

    }
    public final boolean hasOpenDiningCar(){
        Car c=this.l;
        if(c instanceof DiningCar){
            return ((DiningCar) c).getOffen();
        }
        while( c.nextSchienefahrzeug!=null){

            if(c instanceof DiningCar){
                return ((DiningCar) c).getOffen();
            }
                c=(Car)c.nextSchienefahrzeug;
        }
        return false;
    }
    @Override
    public String toString(){

        return this.l.toString();
    }
}
