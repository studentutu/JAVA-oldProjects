/*
Lesen Sie die Aufgaben genau durch.
Verändern Sie die in den Aufgaben beschriebenen Programmstellen.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!

Achtung: Vorgegebene Testfälle überprüfen nur die Syntax. Sie überprüfen nicht die Korrektheit der Lösungen.
*/
public class List 
{

    /*
    Aufgabe:
        Objekte der Klasse List stellen verkettete Listen von Strings mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile entsprechend den Kommentaren an den mit TODO: gekennzeichneten Stellen.

    Punkte (maximal 40):
        10 Punkte für replaceLast,
        10 Punkte für equals,
        10 Punkte für toString,
        10 Punkte für main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

	class Node 
	{
		private String replaceLast(String elem) 
		{
			if (this.next == null) {
				String replaced = this.elem;
				this.elem = elem;
				return replaced;
			}
			return next.replaceLast(elem);
		}

		@Override
		public boolean equals(Object other) 
		{
			if(other == null || other.getClass() != Node.class) {
				return false;
			}
			Node that = (Node)other;
			if(!this.elem.equals(that.elem)){
				return false;
			}
			if(that.next == null) {
				return this.next == null;
			} else {
				return this.next.equals(that.next);
			}
		}

		@Override
		public String toString() {
			if (next != null) {
				return elem + "," + next;
			}
			return elem;
		}

	} // End of the definition of Node

	public String replaceLast(String elem)
	{
		if (head == null) 
		{
			return null;
		} 
		else 
		{
			return head.replaceLast(elem);
		}
	}

	@Override
	public boolean equals(Object other) 
	{
		if (other == null) 
		{
			return false;
		}
		if (other.getClass() != List.class) 
		{
			return false;
		}
		List that = ((List)other);
		if (this.head == null) 
		{
			return that.head == null;
		}
		return this.head.equals(that.head);
	}

	@Override
	public String toString() 
	{
		if (head == null) 
		{
			return "";
		}
		return head.toString();
	}

	public static void main(String[] args) 
	{
		List list1 = new List();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		System.out.println(list1);
		System.out.println(list1.replaceLast("cc"));
		System.out.println(list1);

		List list2 = new List();
		list2.addFirst("cc");
		list2.addFirst("b");
		list2.addFirst("a");
		System.out.println(list1.equals(list2));
		list1.addFirst("cc");
		System.out.println(list1.equals(list2));
	}
}