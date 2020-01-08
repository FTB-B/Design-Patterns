// implements InvocationHandler

package genericCheckpointing.util;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StoreRestoreHandler implements InvocationHandler
{
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable 
   {
   		try
   		{
   			//do something "dynamic"
    			// if the method is write
       				// if the wireFormat is XML
           				//  call serializeData(args[0], new XMLSerializationStrategy());
   			if(method.getName().startsWith("write"))
   			{
   				if(args[1].equals("XML"))
   				{
   					serializeData((SerializableObject)args[0], new XMLSerialization());
   				}
   				return new Object();
   			}
    		else//(method.getName().startsWith("read"))
   			{
   				ArrayList<SerializableObject> allMyTypes  = deserializeData(args[0].toString(),  new XMLDeSerialization());
   				//System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHello world! " + allMyTypes.size());
   				return allMyTypes;
   			}

   		}catch(Exception e)
   		{
   			System.out.println("Exception in the InvocationHandler");
   		}
   		return new Object();

   }


//##########################################################################################################################
  public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
              sStrategy.processInput(sObject);
    }
//###########################################################################################################################
  public ArrayList<SerializableObject> deserializeData(String fileNameIn, DeSerStrategy deSerStrategy) 
  {
  	ArrayList<SerializableObject> AllMyTypes = new ArrayList<SerializableObject>();
  	AllMyTypes = deSerStrategy.processInput(fileNameIn);
    //System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" + AllMyTypes.size());
  	return AllMyTypes;
   
  }
 
	
}