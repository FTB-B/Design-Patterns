package genericCheckpointing.util;
import java.util.ArrayList;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class XMLDeSerialization implements DeSerStrategy 
{
	FileProcessor fileProcess;// = new FileProcessor();
	public XMLDeSerialization(){}

	public ArrayList<SerializableObject> processInput(String fileNameIn)
	{
		fileProcess = new FileProcessor(fileNameIn);
		Class<?> classSample ;
		SerializableObject classObject;
		ArrayList<SerializableObject> AllMyTypes = new ArrayList<SerializableObject>();
		ArrayList<SerializableObject> seriliazedObjects = new ArrayList<>();
		

		String inputLine = fileProcess.readXMLFileDeserialize2();

		while(inputLine != null )
		{
			//System.out.println("1-" + inputLine);
			if((inputLine.contains("<DPSerialization>") || inputLine.contains("</complexType>") || inputLine.contains("</DPSerialization>")) && inputLine !=null)
				{
					//System.out.println("here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2");
					inputLine  = fileProcess.readXMLFileDeserialize2();
					//System.out.println("2-" + inputLine);
					continue;
				}
				else if(inputLine != null)
				{
					//System.out.println("else-" +inputLine);
					if(inputLine.contains("complexType xsi:type="))
					{
						// get the class name
						//System.out.println("There$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
						//System.out.println("else1-"+inputLine);
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
							inputLine = fileProcess.readXMLFileDeserialize2();
							while(inputLine != null && !inputLine.contains("</complexType>"))
							{
								// reading the fieldtypes
								//System.out.println("inputline: " + inputLine);
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
           
								 inputLine = fileProcess.readXMLFileDeserialize2();
							}
							if(inputLine.contains("</complexType>"))
							{
								AllMyTypes.add(classObject);
								//System.out.println("</complexType" + classObject);
								inputLine  = fileProcess.readXMLFileDeserialize2();
								continue;
							}

						}
						catch (Exception e) 
						{	 
							System.err.println(e); 
							//System.out.println("EXCETIONNNNNNNNNNNNNNNNNNN");
						}
					}
				}

				 inputLine = fileProcess.readXMLFileDeserialize2();
				// System.out.println("3-" + inputLine);


		}
	
		return AllMyTypes;

	}



	Class fieldTypes(String fieldTypeIn)
  {
  	if(fieldTypeIn.equals("int"))
  		return int.class;
  	else if(fieldTypeIn.equals("long"))
  		return long.class;
  	else if(fieldTypeIn.equals("boolean"))
  		return boolean.class;
  	else if(fieldTypeIn.equals("double"))
  		return double.class;
  	else if(fieldTypeIn.equals("float"))
  		return float.class;
  	else if(fieldTypeIn.equals("short"))
  		return short.class;
  	else if(fieldTypeIn.equals("char"))
  		return char.class;
  	else
  		return String.class;

  }

  Object fieldClasses(String fieldTypeIn,  String fieldValueIn)
  {
  	if(fieldTypeIn.equals("int"))
  		return (new Integer(Integer.parseInt(fieldValueIn)));
  	else if(fieldTypeIn.equals("long"))
  		return (new Long(Long.parseLong(fieldValueIn)));
  	else if(fieldTypeIn.equals("boolean"))
  		return (new Boolean(Boolean.valueOf(fieldValueIn)));
  	else if(fieldTypeIn.equals("double"))
  		return (new Double(Double.parseDouble(fieldValueIn)));
  	else if(fieldTypeIn.equals("float"))
  		return(new Float(Float.parseFloat(fieldValueIn)));
  	else if(fieldTypeIn.equals("short"))
  		return(new Short(Short.valueOf(fieldValueIn)));
  	else if(fieldTypeIn.equals("char"))
  		return(new Character(fieldValueIn.charAt(0)));
  	else
  		return(new String(fieldValueIn));

  }
}