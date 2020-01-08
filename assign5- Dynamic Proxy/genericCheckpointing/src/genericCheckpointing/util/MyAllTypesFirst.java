package genericCheckpointing.util;
import java.util.Objects;


public class MyAllTypesFirst extends  SerializableObject 
{
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	private int myOtherInt;
	private long myOtherLong;

	//empty constructor
	public MyAllTypesFirst()
	{
		myInt = 0;
		myLong = 0;
		myString = "";
		myBool = true;
		myOtherInt = 0;

	}

    //get methods
	public int getmyInt()
	{
		return myInt;
	}
	public long getmyLong()
	{
		return myLong;
	}
	public String getmyString()
	{
		return myString;
	}
	public boolean getmyBool()
	{
		return myBool;
	}
	public int getmyOtherInt()
	{
		return myOtherInt;
	}
	public long getmyOtherLong()
	{
		return myOtherInt;
	}
  

    //set methods  
	public void setmyInt(int intIn)
	{
		myInt = intIn;
	}
	public void setmyLong(long longIn)
	{
		myLong = longIn;
	}

	public void setmyString(String stringIn)
	{
		myString = stringIn;
	}
	public void setmyBool(boolean boolIn)
	{
		myBool = boolIn;
	}
	public void setmyOtherInt(int myOtherIntIn)
	{
		myOtherInt = myOtherIntIn;
	}
	public void setmyOtherLong(long myOtherLongIn)
	{
		myOtherLong = myOtherLongIn;
	}

	@Override
    public String toString() {
        return "[ myInt=" + myInt + ", myLong=" + myLong + ", myString= " + myString +", myBool = " + myBool + ", myOtherInt = " + myOtherInt+ ", myOtherLong = " + myOtherLong+"]";
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
        MyAllTypesFirst serObject = (MyAllTypesFirst) objectIn;

        if(myInt == serObject.myInt && myLong ==  serObject.myLong && (myString !=null  && myString.equals(serObject.myString))
         && myBool == serObject.myBool && myOtherInt == serObject.myOtherInt && myOtherLong == serObject.myOtherLong )
        	return true;
        else
        	return false;

    }

    @Override
    public int hashCode()
    {
        final int prime = 11;
        int result = 1;
        result = prime * result + myInt;
        result = prime * result;
        result = prime * result + myOtherInt;
        result = prime * result;
        result = prime * result + (int)myLong;
        result = prime * result;
        result = prime * result + myString.hashCode();
        result = prime * result + (int)myOtherLong;
        result = prime * result;

        return result;
    }

	
}