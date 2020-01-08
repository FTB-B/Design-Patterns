//Service
package loadbalancer.entities;
public class Service {
		// Service URL.
		private String URL;
		// Service name.
		private String name;

		// Rest of the code.

		public Service(String URLIn, String nameIn)
		{
			name = nameIn;
			URL = URLIn;

		}
		public Service()
		{

		}

		public void setServiceURL(String URLIn)
		{
			URL = URLIn;

		}

		public void setServiceName(String nameIn)
		{
			name = nameIn;
		}

		public String getServiceURL()
		{
			return URL;
		}

		public String getServiceName()
		{
			return name;

		}



		@Override
        public String toString() {
        return "[ ServiceName=" + name + ", ServiceURL=" + URL + "]";
    }


	}