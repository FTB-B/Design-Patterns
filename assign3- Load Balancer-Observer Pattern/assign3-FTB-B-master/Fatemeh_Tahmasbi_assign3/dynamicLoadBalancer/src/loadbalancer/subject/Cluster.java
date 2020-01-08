package loadbalancer.subject;
import java.util.HashMap;
import java.util.Map;
import loadbalancer.entities.Machine;
import  loadbalancer.entities.Service;


public class Cluster implements SubjectI {
		// Hostnames to corresponding machine instances.
		private Map<String, Machine> machines;
		

		// Rest of the code.

		public Cluster()
		{
			machines = new HashMap<String, Machine>();
		}

		public void addMachine(Machine machineIn)
		{
			if(machineIn != null)
			{
				machines.put(machineIn.getMachineHostname(), machineIn);
				System.out.println("In Cluster class, in add machine we could add machine with host name " + machineIn.getMachineHostname());

			}
			else
			{
				System.out.println("In Cluster class, in add machine we could not add new machine ");

			}

			
		}

		public void registerHost(String hostnameIn )
		{
			Machine machineIn = new Machine(hostnameIn);
			if(machines.containsKey(machineIn.getMachineHostname()))
			{
				System.out.println("The hostname is already in the cluster");

			}
			else
			{
				machines.put(machineIn.getMachineHostname(), machineIn);
				System.out.println("The machine added to the cluster");
			}
		}

		public void registerService(String serviceNameIn, String serviceUrlIn, String[] hosts)
		{
			
			for(int i=0 ; i< hosts.length; i++)
			{
				Machine machineEntry = machines.get(hosts[i]);
				machineEntry.addService(serviceNameIn,  serviceUrlIn);
			}
			
		}


		public void removeHost(Machine machineIn)
		{
			if(machines.containsKey(machineIn.getMachineHostname()))
			{
				machines.remove(machineIn.getMachineHostname());
				System.out.println("Cluster: The machine with the hostname  " + machineIn.getMachineHostname() + " is deleted from the cluster");
			}
			else
			{
				System.out.println("Cluster: there is no such machine with the hostname " + machineIn.getMachineHostname() + " to be deleted from the cluster");
			}
		}



		public void removeService(String serviceNameIn)
		{
			for(Machine machineEntry : machines.values())
			{
				machineEntry.deleteService(serviceNameIn);
			}
		}
	}