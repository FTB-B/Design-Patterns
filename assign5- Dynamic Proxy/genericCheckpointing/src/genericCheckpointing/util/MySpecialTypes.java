package genericCheckpointing.util;


public class MySpecialTypes  extends SerializableObject 
{
	private int myInt1;
	private int myInt2;
	private String myString1;
	private String myString2;
	private double myDoubleT1;
	private double myDoubleT2;


	public MySpecialTypes()
	{
		myInt1 = 0;
		myInt2 = 0;
		myString1 = "";
		myString2 = "";
		myDoubleT1 = 0.0;
		myDoubleT2 = 0.0;

	}
	
	//get methods
	public int getmyInt1()
	{
		return myInt1;
	}
	public int getmyInt2()
	{
		return myInt2;
	}
	public String getmyString1()
	{
		return myString1;
	}
	public String getmyString2()
	{
		return myString2;
	}
	public double getmyDoubleT1()
	{
		return myDoubleT1;
	}
	public double getmyDoubleT2()
	{
		return myDoubleT2;
	}


	//get methods
	public  void setmyInt1(int myInt1In)
	{
		myInt1 = myInt1In;
	}
	public void setmyInt2(int myInt2In)
	{
		myInt2 = myInt2In;
	}
	public void setmyString1(String myString1In)
	{
		myString1 = myString1In;
	}
	public void setmyString2(String myString2In)
	{
		myString2 = myString2In;
	}
	public void setmyDoubleT1(double myDouble1In)
	{
		myDoubleT1 = myDouble1In;
	}
	public void setmyDoubleT2(double myDouble2In)
	{
		myDoubleT2 = myDouble2In;
	}
	@Override
    public String toString() {
        return "[ myInt1=" + myInt1 + ", myInt2=" + myInt2 + ", myString1= " + myString1 +", myString2 = " + myString2 + ", myDoubleT1 = " + myDoubleT1 + ", myDoubleT2 = " + myDoubleT2+"]";
    }

    
    public boolean equals(SerializableObject objectIn) {
       if (this == objectIn) 
       	{
            return true;
        }
        if (null == objectIn || objectIn.getClass() != this.getClass())
        {
            return false;
        }
        MySpecialTypes serObject = (MySpecialTypes) objectIn;

        if(myInt1 == serObject.myInt1 && myInt2 ==  serObject.myInt2 &&  (myString1 !=null  && myString1.equals(serObject.myString1)) && (myString2 !=null  && myString2.equals(serObject.myString2))
         && myDoubleT1 == serObject.myDoubleT1 && myDoubleT2 == serObject.myDoubleT2)
        	return true;
        else
        	return false;

    }

    @Override
    public int hashCode()
    {
        final int prime = 11;
        int result = 1;
        result = prime * result + myInt1;
        result = prime * result;
        result = prime * result + myInt2;
        result = prime * result;
        result = prime * result + myString1.hashCode();
        result = prime * result;
        result = prime * result + myString2.hashCode();
        result = prime * result;
        result = prime * result + (int)myDoubleT1;
        result = prime * result;
        result = prime * result + (int)myDoubleT2;
        result = prime * result;

        return result;
    }

	
	
	
	
}