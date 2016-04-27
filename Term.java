
public class Term {
	
	private int coefficient;
	private int power;
	
	public Term()
	{
		coefficient = 1;
		power = 1;
	}
	
	public Term(int c, int p)
	{
		coefficient = c;
		power = p;
	}

	public int getCoefficient() 
	{
		return coefficient;
	}

	public void setCoefficient(int c) 
	{
		coefficient = c;
	}

	public int getPower() 
	{
		return power;
	}

	public void setPower(int p) 
	{
		power = p;
	}

	public String toString()
	{
		return "(" + getCoefficient() + "," +  getPower() + ")";
	}

}
