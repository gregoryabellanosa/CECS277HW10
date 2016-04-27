import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	
	private Term term;
	private LinkedList<Term> terms = new LinkedList<Term>();
	
	public Polynomial(Term t)
	{
		term = t;
		terms.addLast(t);
	}
	
	public void add(Polynomial p)
	{
		ListIterator<Term> i = p.getTerms().listIterator();
		while (i.hasNext())
		{
			Term current = i.next();
			terms.addLast(current);
		}
	}
	
	public Polynomial mul(Polynomial p)
	{
		Polynomial poly = new Polynomial(new Term(0, 0));
		ListIterator<Term> i1 = terms.listIterator();
		ListIterator<Term> i2 = p.getTerms().listIterator();
		
		while (i1.hasNext())
		{
			Term cur1 = i1.next();
			while (i2.hasNext())
			{
				Term cur2 = i2.next();
				int coeff = cur1.getCoefficient() * cur2.getCoefficient();
				int pow = cur1.getPower() + cur2.getPower();
				Term t = new Term(coeff, pow);
				poly.getTerms().addLast(t);
			}
			if (!i2.hasNext())
			{
				i2.previous();
				i2.previous();
			}
		}
		poly.getTerms().removeFirst();
		return poly;
	}
	
	public void print()
	{
		ListIterator<Term> i = terms.listIterator();
		String poly = "";
		while (i.hasNext())
		{
			Term cur = i.next();
			String operand = "";
			int newC = cur.getCoefficient();
			if (cur.getCoefficient() > 0)
			{
				operand = "+";
			}
			else
			{
				operand = "-";
				newC *= (-1);
			}
			poly += operand + " " + newC + "x^" + cur.getPower() + " ";
		}
		System.out.println(poly);
	}
	
	public void sub(Polynomial p)
	{
		p.getTerm().setCoefficient(p.getTerm().getCoefficient() * (-1));
		terms.addLast(p.getTerm());
	}
	
	public Term getTerm()
	{
		return term;
	}
	
	public void setTerm(Term t)
	{
		term = t;
	}
	
	public LinkedList<Term> getTerms()
	{
		return terms;
	}

	public void setTerms(LinkedList<Term> t)
	{
		terms = t;
	}
	
	public String toString()
	{
		ListIterator<Term> i = terms.listIterator();
		String polynomial = "";
		while (i.hasNext())
		{
			polynomial += i.next().toString() + " ";
		}
		return polynomial;
	}
}