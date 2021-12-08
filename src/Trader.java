public class Trader {
    
    private String companyName;
    private String location;
    private String services;
    private int numEmployees;
    private double dailyRate;
    private String description;
    
    
    Trader(String companyName, String location, String services, int numEmployees, double dailyRate, String description)
    {
        this.companyName = companyName;
        this.location = location;
        this.services = services;
        this.numEmployees = numEmployees;
        this.dailyRate = dailyRate;
        this.description = description;
    }
    
    public String getCompanyName()
    {
        return this.companyName;
    }
    
    public String getLocation()
    {
        return this.location;
    }
    
        public String getServices()
    {
        return this.services;
    }
    
    public int getNumEmployees()
    {
        return this.numEmployees;
    }
    
    public double getDailyRate()
    {
        return this.dailyRate;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    @Override
    public String toString()
    {
        StringBuilder str1 = new StringBuilder();
        str1.append("Company name:\t\t\t"+this.companyName+"\nLocation:\t\t\t"+this.location+"\nServices offered:\t\t"+ this.services+"\nNumber of employees:\t\t"+this.numEmployees+"\nDaily call out rate (\u00a3):\t"+this.dailyRate+"\nOther information:\t\t"+ this.description);
        return str1.toString();
    }
}