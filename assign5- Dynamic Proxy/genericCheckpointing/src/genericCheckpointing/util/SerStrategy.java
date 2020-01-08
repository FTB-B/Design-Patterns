// create a new interface
package genericCheckpointing.util;

public interface SerStrategy extends Strategy {
   void processInput(SerializableObject sObject);

}