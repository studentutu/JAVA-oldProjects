import java.awt.EventQueue;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

public class StartFrom {

    public static LinkedList<Lands> allLands=new LinkedList<>();
    public static LinkedList<Teritories> allTer=new LinkedList<>();
    public static LinkedList<Continent> allCont=new LinkedList<>();
    private static int punkte=0;


    public static void main(String[] args) {

        String workingDirectory=System.getProperty("user.dir");

        File fli= new File(workingDirectory + "\\world.map" );

       // System.out.println(workingDirectory);
       // System.out.println(fli.exists());


        BufferedReader fromWorldMap=null;
        try {
            fromWorldMap = new BufferedReader(new FileReader(fli));

            Scanner sc=new Scanner( fromWorldMap.readLine());//firstLine

            String word="";
            while(sc.hasNext()){//nextLine kann  man auch verwenden

                if(sc.hasNextInt()){punkte=sc.nextInt();} else {
                    word=sc.next();//one String- First word

                    if (word.equals("patch-of")) {

                        allLands.add(readLand(sc.nextLine()));//land need to be added to Teritory(by name)
                    } else if (word.equals("capital-of")) {

                        allTer.add(readCapital(sc.nextLine()));//teritory with capital but withou land, add lands(by name)
                    } else if (word.equals("neighbors-of")) {

                        addNachbarn(sc.nextLine());
                    } else if (word.equals("continent")) {

                        allCont.add(readContinent(sc.nextLine()));
                    }

                }


                sc=null;
                sc=new Scanner( fromWorldMap.readLine());
            }

        }catch (Exception ignore){}
        finally {
            try {
                if (fromWorldMap != null) {
                    fromWorldMap.close();
                }
            } catch (IOException ignore){}
        }


        //Scanner scc=new Scanner(System.in);
        //Scanner sc=new Scanner(scc.nextLine());//firstLine
        //String word="";

        /**
        while(sc.hasNext()){//firstWord, and so on

            if(sc.hasNextInt()){punkte=sc.nextInt();} else {

                word = sc.next();
                //System.out.println("======"+word+"=======");

                if (word.equals("patch-of")) {

                    allLands.add(readLand(sc.nextLine()));//land need to be added to Teritory(by name)
                } else if (word.equals("capital-of")) {

                    allTer.add(readCapital(sc.nextLine()));//teritory with capital but withou land, add lands(by name)
                } else if (word.equals("neighbors-of")) {

                    addNachbarn(sc.nextLine());
                } else if (word.equals("continent")) {

                    allCont.add(readContinent(sc.nextLine()));
                }
            }

            if(scc.hasNextLine()){sc=new Scanner(scc.nextLine()); }//if input HasNextLine,get nextLine

        }//end of all Inputs
         */

/**
        for(Continent t:allCont){
            System.out.println("------Continent-------");
            System.out.print(t.toString());
            System.out.println();
            System.out.println("---------Continent------!!!!!!!");
        }

        for(Teritories t:allTer){
            System.out.println("----------Teritory-----------");
            System.out.print(t.toString());
            System.out.println();
            System.out.println("----------Teritory-----!!!!!!!");
        }
 */



        EventQueue.invokeLater(new Runnable() {
            public void run() {


        BodyOfGame bd=new BodyOfGame(allLands,allTer,allCont,punkte);
        bd.startToPlay();


            }
       });




    }//end of public static void main




    //new Land
    public static Lands  readLand(String s){
        //create lands: create many points

        String name="";
        Scanner my= new Scanner(s);
        LinkedList<Point> mylist=new LinkedList<>();

        //get LandName from Input
        while(!my.hasNextInt()){
            name=name+" "+my.next();
        }
        name=name.substring(1);
        //System.out.println("+" + name + "-fromLand");

        //get Points for Land
        while(my.hasNext()){

                int x = my.nextInt();
                int y = my.nextInt();
                mylist.add(new Point(x, y));

        }

        //create Land
        Lands newland=new Lands(name,mylist);
        return newland;

    }//end of new Land

    //new Teritory
    public static Teritories readCapital(String sc){
        //create new Point capital, add to Teritory
        Scanner my=new Scanner(sc);
        String name="";
        Point p=null;

        //get TeritoryName from input
        while(!my.hasNextInt()){
            name=name+" "+my.next();
        }
        name=name.substring(1);
        //System.out.println("+"+name+"+");

        //get CapitalPoint
        while(my.hasNextInt()){

            int x=my.nextInt();
            int y=my.nextInt();
            p=new Point(x,y);
        }


        // teritory with name,capitalPoint but without land!
        Teritories ter=new Teritories(name,p);
        for(Lands l:allLands){
            if(l.getNameOfLand().equals(ter.getTerName())){//if landName==terName then add(for Teritory  Land)
                ter.addLand(l);
            }
        }

        return ter;
    }//end of new Teritory

    //New Continent
    public static Continent readContinent(String sc){
        //create continent, add terotery to them

        Scanner my=new Scanner(sc);
        String nameOfContinent="";
        LinkedList<String> nameOfTeritories=new LinkedList<>();
        String nameOfTer="";

        //get from input nameOfContinent
        String some1=my.next();
        while(!some1.equals(":")){
            nameOfContinent=nameOfContinent+" "+some1;
            some1=my.next();
        }
        //some1==":"
        while(my.hasNext()){

            some1=my.next();

            if(some1.equals("-")){
                    nameOfTeritories.add(nameOfTer.substring(1));
                    nameOfTer="";
            }else{
                    nameOfTer=nameOfTer+" "+some1;//need substring(1)
            }

        }//end of bigWhile
        nameOfTer=nameOfTer.substring(1);
        nameOfTeritories.add(nameOfTer);//last Teritory!
        //System.out.println(nameOfTer);

        //create continent,add teritories
        Continent mycontinent=new Continent(nameOfContinent);
        for(String s: nameOfTeritories) {
            for (Teritories t : allTer) {
                if(t.getTerName().equals(s)){
                    mycontinent.addTer(t);
                }
            }
        }

        return mycontinent;
    }//end of new Continent


    //Just add Nachbarn
    public static void addNachbarn(String sc){
        //add Nachbarn to teritory

        Scanner my=new Scanner(sc);
        String nameOfMainTeritory="";
        LinkedList<String> nachbarn=new LinkedList<>();
        String nameNachbarn="";

        //get from input NameofMainTeritory
        String some1=my.next();
        while(!some1.equals(":")){
            nameOfMainTeritory=nameOfMainTeritory+" "+some1;
            some1=my.next();
        }
        nameOfMainTeritory=nameOfMainTeritory.substring(1);
        //System.out.println("!!"+nameOfMainTeritory+"!!");

        //some1==":"
        while(my.hasNext()){

            some1=my.next();

            if(some1.equals("-")){
                    nachbarn.add(nameNachbarn.substring(1));
                    nameNachbarn="";
            }else{
                    nameNachbarn=nameNachbarn+" "+some1;//need substring(1)
            }

        }//end of bigWhile
        nameNachbarn=nameNachbarn.substring(1);
        nachbarn.add(nameNachbarn);//last Nachbarn!
        //System.out.println("--"+nameNachbarn+"---");


        //find Teritory with the nameOfMainTeritory from allTer
        Teritories current=null;
        for(Teritories t:allTer){
            if(t.getTerName().equals(nameOfMainTeritory ) ){
                 current=t;
            }
        }

        //now add All Nachbarn from ListNachbarn
        for( String s:nachbarn) {
                for (Teritories t : allTer) {
                     if (t.getTerName().equals(s)){//For each NachbarnName find Teritory with the same name
                         current.addNachbarn(t); //add to MainTeritory <--NachbarnTeritory
                         t.addNachbarn(current); //ad to NachbarnTeritory <-- MainTeritory
                     }
                 }
        }//end of list of nachbarn
        return;
    }//end of addNachbarn

}//end of StartFrom
