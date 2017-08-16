public class Tree
{

    /*
    Aufgabe:
        Objekte der Klasse Tree stellen binäre Suchbäume über ganzen Zahlen mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.


    Punkte (maximal 30):
        10 Punkte für countLeaves,
        10 Punkte für add(Tree),
        10 Punkte für toString.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

	class Node
	{
		private int countLeaves() 
		{
			if (left == null && right == null) 
			{
				return 1;
			}
			int count = 0;
			if (left != null) 
			{
				count = left.countLeaves();
			}
			if (right != null) 
			{
				count += right.countLeaves();
			}
			return count;
		}

		private void add(Node other) 
		{
			if(other == null) 
			{
				return;
			}
			if(other.left != null) 
			{
				add(other.left);
			}
			add(other.elem);
			if(other.right != null) 
			{
				add(other.right);
			}
		}

		@Override
		public String toString() 
		{
			String result = Integer.toString(elem);
			if (right != null) 
			{
				result = right + " " + result;
			}
			if (left != null) 
			{
				result += " " + left;
			}
			return result;
		}

	} // End of the definition of Node

	// The root of the tree.  Do not change or add object variables.
	private Node root;

	public int countLeaves()
	{
		if (root == null)
		{
			return 0;
		}
		return root.countLeaves();
	}

	public void add(Tree other)
	{
		if(other == null || other.root == null)
		{
			return;
		}
		if(this.root == null)
		{
			this.add(other.root.elem);
			this.root.add(other.root.left);
			this.root.add(other.root.right);
			return;
		}
		root.add(other.root);
	}

	@Override
	public String toString() 
	{
		if (root == null) 
		{
			return "";
		}
		return root.toString();
	}

	// Just for testing, not used for assessment (geht nicht in die Beurteilung ein).
	public static void main(String[] args)
	{
		Tree tr = new Tree();
		tr.add(1);
		tr.add(2);
		tr.add(3);
		tr.add(4);
		System.out.println(tr);
		System.out.println(tr.countLeaves());
		Tree tr2 = new Tree();
		tr.add(tr2);
		System.out.println(tr2.countLeaves());
		System.out.println(tr2);
	}
}