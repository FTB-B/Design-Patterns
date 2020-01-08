//SubjectI
package loadbalancer.subject;
import loadbalancer.entities.Machine;
import  loadbalancer.entities.Service;

public interface SubjectI
{
	public void registerHost(String hostNameIn);
	public void removeHost(Machine machineIn);
	//public void notifyMachines();

	public void registerService(String serviceNameIn, String serviceUrlIn, String[] hosts);
	public void removeService(String serviceNameIn);

}