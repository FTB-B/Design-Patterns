//Machine
package loadbalancer.entities;
import java.util.HashMap;
import loadbalancer.entities.Service;

public class Machine {
		private String hostname;
		// Service name to hosted services.
		private HashMap<String, Service> hostedServices;

		// Rest of the code.


		public Machine(String hostnameIn)
		{
			hostname = hostnameIn;
			hostedServices = new HashMap<String, Service>();

		}

		public Machine()
		{
			hostedServices = new HashMap<String, Service>();

		}

		public void setMachineHostname(String hostnameIn)
		{
			hostname = hostnameIn;
		}

		public String getMachineHostname()
		{
			return hostname;
		}

		//SERVICE_OP__ADD_SERVICE <service name> <URL> <hosti, hostj, ... hostr>

		public void addService(String serviceNameIn, String serviceUrlIn)
		{
		    Service serviceIn = new Service(serviceNameIn, serviceUrlIn);
			if(serviceIn != null)
			{
				if(hostedServices.containsKey(serviceIn))
				{
					System.out.println("The machine " + hostname + " already has the service with servicename " + serviceNameIn);
				}
				hostedServices.put(serviceNameIn,serviceIn);
				System.out.println("In Machine " + hostname + ", AddService, we could add service with " +  serviceNameIn + " servicename and " + serviceUrlIn + " service url");

			}
			else
			{
				System.out.println("In machine class, add service method there is no such service to be added");
			}

		}

		public HashMap<String, Service> getHostedServices()
		{
			return hostedServices;
		}


		public void deleteService(String serviceNameIn)
		{
			if(hostedServices.containsKey(serviceNameIn))
			{
				// there is such service
				hostedServices.remove(serviceNameIn);
				System.out.println("Machine " + hostname + ": the service with the name " + serviceNameIn + " is removed from the machine");
			}
			else
			{
				System.out.println("Machine " + hostname + ": there is no service with the name " + serviceNameIn + " to be removed");
			}

		}





	}