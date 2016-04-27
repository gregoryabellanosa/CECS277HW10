import java.util.LinkedList;
import java.util.ListIterator;

public class Probs99 {

	public static void main(String[] args) {
		
		Polynomial p = new Polynomial(new Term(-10, 0)); 
		p.add(new Polynomial(new Term(-1, 1))); 
		p.add(new Polynomial(new Term(9, 7)));
		p.add(new Polynomial(new Term(5, 10)));

		System.out.println(p);
		
		Polynomial q = p.mul(p);
		q.print();
		

	}

}
