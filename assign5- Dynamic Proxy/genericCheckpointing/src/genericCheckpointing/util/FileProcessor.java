package genericCheckpointing.util;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class FileProcessor
{
	BufferedReader userInputReader;
	String filePath ;
	public FileProcessor(String xmlFileNameIn){
		filePath = "./" + xmlFileNameIn;
		try{
			userInputReader = new BufferedReader(new FileReader(filePath));

		}
		catch(Exception e)
		{

		}
		
		
	}
    /*
	public  ArrayList<SerializableObject>  readXMLFileDeserialize( String xmlFileNameIn)
	{
		Class<?> classSample ;
		SerializableObject classObject;
		ArrayList<SerializableObject> AllMyTypes = new ArrayList<SerializableObject>();
	
  		//open the file
  		BufferedReader userInputReader;

  		String filePath = "./" + xmlFileNameIn;
  		//System.out.println("filepath: " + filePath);

		try
		{
			userInputReader = new BufferedReader(new FileReader(filePath));
			//System.out.println("HERERRRRRRRRRRRRRRRRRRrrr");
			String inputLine = userInputReader.readLine();
			while(inputLine != null )
			{
				//System.out.println(inputLine);
				//System.out.println("HERERRRRRRRRRRRRRRRRRRrrr1");
				//return inputLine;
				if(inputLine.contains("<DPSerialization>") || inputLine.contains("</complexType>") || inputLine.contains("</DPSerialization>")) 
				{
					//System.out.println("here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2");
					inputLine  = userInputReader.readLine();
					//System.out.println("HERERRRRRRRRRRRRRRRRRRrrr2");
					continue;
				}
				else
				{
					//System.out.println(inputLine);
					if(inputLine.contains("complexType xsi:type="))
					{
						// get the class name
						//System.out.println("There$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
						//System.out.println(inputLine);
						int classNameIndex1 = inputLine.indexOf(".My");
						int classNameIndex2 = inputLine.indexOf(">");
						String className = inputLine.substring(classNameIndex1+1,classNameIndex2-1);
						//System.out.println("class name is: " + className);
						try
						{
							classSample  = Class.forName("genericCheckpointing.util."+className);
							classObject = (SerializableObject)classSample.newInstance();	
							Field fieldlist[] = classSample.getDeclaredFields(); 
							//System.out.println("55555555555555555555555555555555555");
							//System.out.println("the number of fields for " + className + " is: " + fieldlist.length);	

							Method m[] = classSample.getDeclaredMethods();
							//for(int i=0; i< m.length; i++)
							//	System.out.println("method name: " + m[i].toString());

							// till it read the </complexType> it tries to read the variable names and values
							inputLine  = userInputReader.readLine();
							while(inputLine != null && !inputLine.contains("</complexType>"))
							{
								// reading the fieldtypes
								int fieldNameIndex1 =  inputLine.indexOf("<");
								int fieldNameIndex2 =  inputLine.indexOf("xsi");
								String fieldName = inputLine.substring(fieldNameIndex1+1,fieldNameIndex2-1);
								//System.out.println("field name is: " + fieldName);
								int fieldTypeIndex1 = inputLine.indexOf("xsd:");
								int fieldTypeIndex2 = inputLine.indexOf("\">");
								String fieldType= inputLine.substring(fieldTypeIndex1+4,fieldTypeIndex2);
								//System.out.println("field Type  is: " + fieldType);
								int fieldValueIndex1 = inputLine.indexOf("\">");
								int fieldValueIndex2 = inputLine.indexOf("</my");
								String fieldValue= inputLine.substring(fieldValueIndex1+2,fieldValueIndex2);
								//System.out.println("field value  is: " + fieldValue);

								Class<?>[] signature = new Class<?>[1]; 
								signature[0] = fieldTypes(fieldType); 

								Method meth = classSample.getMethod("set"+fieldName, signature); 
								//System.out.println("method: " + meth.toString());
								Object[] params = new Object[1];
							 
								params[0] = fieldClasses(fieldType,fieldValue);
								Object result = meth.invoke(classObject, params); 
								//System.out.println("after set: " );
           
								inputLine  = userInputReader.readLine();
							}
							if(inputLine.contains("</complexType>"))
							{
								AllMyTypes.add(classObject);
								inputLine  = userInputReader.readLine();
								continue;
							}

						}
						catch (FileNotFoundException fileExc) 
						{	 
							System.err.println(fileExc); 
						}
					}
				}

				inputLine  = userInputReader.readLine();
        	}
        	//System.out.println("end of fileeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		}
		catch(Exception e)
		{
			System.out.println("Exception in reading the file");
		}
      	return AllMyTypes;        
   
	}*/

///////////////////////////////////////////////////////////////////////////////////
	public  String  readXMLFileDeserialize2( )
	{
		
		String inputLine = "" ;
		try{
			inputLine = userInputReader.readLine();

		}
		catch(Exception e)
		{
			System.out.println("nulllllllllllllllllllllllll");

		}
				
				//System.out.println(inputLine);
				return inputLine;
				
   
	}
	////////////////////////////////////////////////////////////////////////////////////////


    


	

	
}
