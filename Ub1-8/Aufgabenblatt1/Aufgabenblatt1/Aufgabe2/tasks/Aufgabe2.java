/*
    Aufgabe2) Verzweigungen und Schleifen
    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Schreiben Sie eine while-Schleife, die alle ungeraden und durch 3 teilbaren Zahlen im Intervall von 0 bis einschließlich 100 aufsummiert.
    - Geben Sie die Summe mit "System.out.println()" aus.

    Zusatzfragen:
    1) Könnte man diese Aufgabe auch mit einer for-Schleife lösen? Wenn ja, wie würde der Ansatz aussehen?
    2) Die Schleife summiert Werte in einem bestimmten Intervall. Wie könnten Sie das Programm umbauen damit die Schleife beliebige Intervalle aufsummiert?
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        /* TODO: add code here */
        int sum =0;
        int i=0;
        while (i<=100) {
            if(i%2!= 0 && i%3==0 ) {
                sum = sum + i;
            }
            i++;
        }
        System.out.println("Summ ist " + sum);
        sum =0;
        for(i=0;i<=100;i++){
            if (i%2!= 0 && i%3==0) {
                sum = sum +i;
            }

        }
        System.out.println("Summ mit for ist " + sum);

        System.out.println("Summ ist " + summiert(0,100));
    }
    // eine Methode


      public static int summiert(int min,int max){
         int summ = 0;
         for (int j = min; j<= max;j++){
             if (j%3==0 && j%2!= 0){
               summ=summ+j;
            }
         }
          return summ;
      }

}
