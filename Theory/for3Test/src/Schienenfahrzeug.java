/**
 * Created by Пользователь on 20.01.2016.
 */
public  class Schienenfahrzeug {

    protected double serielNummer;
    private static int countInstances = 1;

    public Schienenfahrzeug(double sn) {
        //neu Instance
        this.serielNummer = sn;
        countInstances++;

    }




    public String getSerialNummer(){
        return ""+this.serielNummer;
    }


}
