package genericCheckpointing.util;


import java.lang.reflect.Method;
import java.lang.reflect.Field;
import genericCheckpointing.util.Results;
import java.lang.reflect.InvocationTargetException;


public class XMLSerialization implements SerStrategy 
{


	public XMLSerialization(){}
    
    public void processInput(SerializableObject sObject)
    {

      Results resutls = new Results();
      String seriliazeFile = "./" + "AllUserTypes.txt";     
    	//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
      // all the code to create the output file with XML snippets for
    	//an object
      resutls.writeResult("<DPSerialization>");
      Class<?> cls = sObject.getClass();
      String className = cls.getName();
      resutls.writeResult(" <complexType xsi:type=\"" +className + "\">");
     	Field fieldlist[] = cls.getDeclaredFields(); 
     	for (int i = 0; i < fieldlist.length; i++) 
     	{ 
	      try
        {
          Field fld = fieldlist[i]; 
          //System.out.println("name = " + fld.getName());
          //System.out.println("type = " + fld.getGenericType()); 
          String methodName = "get" + fld.getName();
          Method getterMethod = cls.getMethod(methodName);
          Object invokeRet = getterMethod.invoke(sObject);
          //int value = (int) invokeRet;
          String value = invokeRet.toString();
          //System.out.println("value = " + value);
          String textSerialize = " <" + fld.getName() + " xsi:type=\"xsd:" + fld.getGenericType()+"\">" + value + "</" + fld.getName()+ ">";
          resutls.writeResult(textSerialize);

        }
       catch(NoSuchMethodException  | IllegalAccessException | InvocationTargetException e)
        {
          System.out.println("Exception in processInput file for WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        }
          
      }
      resutls.writeResult(" </complexType>");
      resutls.writeResult("</DPSerialization>");
      resutls.writeResult("end");
   }
}