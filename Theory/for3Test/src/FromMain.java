/**
 * Created by Пользователь on 20.01.2016.
 */
public class FromMain {

    public static void main(String[] args) {
        Locomotive l=new Locomotive(1,15,20,10);

        Train t=new Train(l);

   PassengerCar p1=new PassengerCar(2,25,55,30);
        PassengerCar p2=new PassengerCar(3,25,55,30);
        PassengerCar p3=new PassengerCar(4,25,55,30);
        PassengerCar p4=new PassengerCar(5,25,55,30);
        PassengerCar p5=new PassengerCar(6,25,55,30);


        t.addCar(p1);
        t.addCar(p2);
        t.addCar(p3);
        t.addCar(p4);
        t.addCar(p5);


       System.out.println(p1 + "\n" + p2 + "\n"+ p3+"\n"+ p4);
        System.out.println(t.toString());
    }
}
