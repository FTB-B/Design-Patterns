package genericCheckpointing.util;


public class MyAllTypesSecond extends MyAllTypesFirst
{
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private double myOtherDoubleT;



	public MyAllTypesSecond()
	{
		myDoubleT = 0.0;
		myFloatT = 0.0f;
		myShortT = 0;
		myCharT = ' ';
		myOtherDoubleT = 0.0;

	}
	//get methods
	public double getmyDoubleT()
	{
		return myDoubleT;
	}
	public float getmyFloatT()
	{
		return myFloatT;
	}
	public short getmyShortT()
	{
		return myShortT;
	}
	public char getmyCharT()
	{
		return myCharT;
	}
	public double getmyOtherDoubleT()
	{
		return myOtherDoubleT;

	}
  

    //set methods  
	public void setmyDoubleT(double doublTIn)
	{
		myDoubleT = doublTIn;
	}
	public void setmyFloatT(float floatTIn)
	{
		myFloatT = floatTIn;
	}

	public void setmyShortT(short shortTIn)
	{
		myShortT = shortTIn;
	}
	public void setmyCharT(char charTIn)
	{
		myCharT = charTIn;
	}
	public void setmyOtherDoubleT(double myOtherDoubleTIn)
	{
		myOtherDoubleT = myOtherDoubleTIn;
	}
	@Override
    public String toString() {
        return "[ myDoubleT=" + myDoubleT + ", myFloatT=" + myFloatT + ", myShortT= " + myShortT +", myCharT = " + myCharT + ", myOtherDoubleT = " + myOtherDoubleT+ "]";
    }

    @Override
    public boolean equals(SerializableObject objectIn) {
       if (this == objectIn) 
       	{
            return true;
        }
        if (null == objectIn || objectIn.getClass() != this.getClass())
        {
            return false;
        }
        MyAllTypesSecond serObject = (MyAllTypesSecond) objectIn;

        if(myDoubleT == serObject.myDoubleT && myFloatT ==  serObject.myFloatT && myShortT == serObject.myShortT && myCharT == serObject.myCharT && myOtherDoubleT == serObject.myOtherDoubleT )
        	return true;
        else
        	return false;

    }

    @Override
    public int hashCode()
    {
        final int prime = 11;
        int result = 1;
        result = prime * result + (int)myDoubleT;
        result = prime * result;
        result = prime * result + (int) myFloatT;
        result = prime * result;
        result = prime * result + myShortT;
        result = prime * result;
        result = prime * result + (int)myCharT;
        result = prime * result + (int)myOtherDoubleT;
        result = prime * result;

        return result;
    }

	
}