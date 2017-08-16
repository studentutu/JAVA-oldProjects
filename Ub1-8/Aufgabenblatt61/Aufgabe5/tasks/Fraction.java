/*
    Aufgabenstellung zu Fraction:

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO gekennzeichnet sind; genauer: die innersten runden Klammern mit dem
    TODO-Kommentar.
    Lassen Sie andere Teile der Klasse unverändert.
    Von dieser Einschränkung ausgenommen ist nur die Methode main, die Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Welche Vor- und Nachteile ergeben sich bei Verwendung der statischen Klassenmethode addFractions und der
       Objektmethode addFrac?
    2. Warum sind manche Methoden static, andere nicht? Welche sind wie?
    3. Warum sind manche Methoden public und andere private? Welche sind wie?
    4. Wozu dient reduce()?
    5. Warum gibt es in addFrac einen Vergleich mit null?

*/
public class Fraction {

    private int numerator;   // (Zähler)
    private int denominator; // (Nenner); denominator > 0 is required

    // New fraction with numerator num and denominator denom; denom != 0 is required.
    public Fraction(int num, int denom) {
        if (denom < 0) { // denominator > 0 is required, but value of fraction shall be as specified by num and denom
            num = (num /* TODO: modify expression */);
            denom = (num==0?1:denom<0?-(denom):denom==0?1:denom /* TODO: modify expression */);
        }
        numerator = (num /* TODO: modify expression */);
        denominator = (denom /* TODO: modify expression */);
        reduce();
    }

    // Returns a new fraction with the result of adding frac to this fraction.
    // If frac is null, the result shall contain a copy of this fraction (new object of same state).
    public Fraction addFrac(Fraction frac){
        if(frac == null){
            return (this/* TODO: modify expression */);
        }
        return (new Fraction(addFractions(this.numerator,this.denominator,frac.numerator,frac.denominator)[0], addFractions(this.numerator,this.denominator,frac.numerator,frac.denominator)[1]) /* TODO: modify expression */);
    }

    // Reduce the fraction. Use 0/1 for 0.
    private void reduce() {
        if (numerator == 0) {
            denominator = (1 /* TODO: modify expression */);
        } else {

            int gcd = gcd((numerator < 0) ? (-numerator) : numerator, denominator);

            numerator = ((int)numerator/gcd /* TODO: modify expression */);
            denominator = ((int)denominator/gcd /* TODO: modify expression */);
        }
    }

    // Returns the greatest common divisor of a und b.
    private int gcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return (b /* TODO: modify expression */);
    }

    // Adds two fractions, one specified by numerator num1 and denominator denom1, the other by numerator num2 and
    // denominator denom2. The resulting array contains the numerator at index 0 and the denominator at index 1.
    // denom1 != 0 and denom2 != 0 is required.
    public static int[] addFractions(int num1, int denom1, int num2, int denom2) {
        return ( ((denom1==0)&&(denom2==0))?new int[]{0,1} :new int[]{(denom2*num1)+(denom1*num2), (denom1*denom2)}  /* TODO: modify expression */);
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    Fraction fr=new Fraction(5,10);
        System.out.println(fr.numerator + "/" + fr.denominator);
	Fraction fr2=new Fraction(3,5);
	 System.out.println(fr2.numerator + "/" + fr2.denominator);
	Fraction neueAddFrac=fr.addFrac(fr2);
	 System.out.println(neueAddFrac.numerator + "/" + neueAddFrac.denominator);
    }

}
