package genericCheckpointing.util;

import java.util.ArrayList;
public interface DeSerStrategy extends Strategy {
   ArrayList<SerializableObject> processInput(String fileNameIn);

}