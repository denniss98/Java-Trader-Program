import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("traders.txt");
        Scanner in = new Scanner(file);
        String input;
        
        List<Trader> traderList = new ArrayList<Trader>();
        
        int idLength = 3;
        int companyNameLength = 0;
        int locationLength = 0;
        int serviceOfferedLength = 0;
        
        String idHeader = "ID";
        String companyNameHeader = "Company name";
        String locationHeader = "Location";
        String servicesOfferedHeader = "Services offered";
        
        int companyHeaderMin=0;
        int locationHeaderMin=0;
        int servicesOfferedHeaderMin=0;
        while (in.hasNextLine()) {
            String[] traders = in.nextLine().split(":");
            if (traderList.size() == 0) {
                companyNameLength = traders[0].length();
                locationLength = traders[1].length();
                serviceOfferedLength = traders[2].length();
            } else {
                if (companyNameLength < traders[0].length()) {
                    companyNameLength = traders[0].length();
                }
                if (locationLength < traders[1].length()) {
                    locationLength = traders[1].length();
                }
                if (serviceOfferedLength < traders[2].length()) {
                    serviceOfferedLength = traders[2].length();
                }
            }
            Trader trader = new Trader(traders[0], traders[1], traders[2], Integer.parseInt(traders[3]), Double.parseDouble(traders[4]), traders[5]);
            traderList.add(trader);
        }

        do {
            System.out.println("List Traders.......1");
            System.out.println("Select Traders.....2");
            System.out.println("Search Locations...3");
            System.out.println("Search Services....4");
            System.out.println("Exit...............0");
            System.out.println();
            System.out.print("Enter choice:>");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();

            switch (input) {

                case "0":
                    System.out.println("Exiting Program...");
                    break;

                case "1":
                    int count = 1;
                    companyHeaderMin = companyNameLength - companyNameHeader.length() + 3;
                    locationHeaderMin = locationLength - locationHeader.length() + 3;
                    servicesOfferedHeaderMin = serviceOfferedLength - servicesOfferedHeader.length() + 3;
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%s %2s %2s %2s %" + companyHeaderMin + "s %2s %" + locationHeaderMin + "s %2s %" + servicesOfferedHeaderMin + "s", "|", "ID", "|", "Company name", "|", "Location", "|", "Services offered", "|");
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

                    for (Trader trader : traderList) {
                        int companyMin = companyNameLength - trader.getCompanyName().length() + 3;
                        int locationMin = locationLength - trader.getLocation().length() + 3;
                        int servicesOfferedMin = serviceOfferedLength - trader.getServices().length() + 3;
                        System.out.format("%s %2d %2s %2s %" + companyMin + "s %2s %" + locationMin + "s %2s %" + servicesOfferedMin + "s", "|", count, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                        System.out.println();
                        count++;
                    }
                    
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case "2":
                    int count1 = 0;
                    System.out.print("\nEnter trader ID from list [1 - 25] :>");
                    String traderId = sc.nextLine();
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    for (Trader trader : traderList) {
                        if (Integer.parseInt(traderId) - 1 == count1) {
                            System.out.println(trader.toString());
                        }
                        count1++;

                    }
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                    break;

                case "3":
                    int flag =0;
                    int countLocation = 1;
                    companyHeaderMin = companyNameLength - companyNameHeader.length() + 3;
                    locationHeaderMin = locationLength - locationHeader.length() + 3;
                    servicesOfferedHeaderMin = serviceOfferedLength - servicesOfferedHeader.length() + 3;
                    System.out.print("\nEnter search text :>");
                    String location = sc.nextLine();
                    System.out.println();
                     System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%s %2s %2s %2s %" + companyHeaderMin + "s %2s %" + locationHeaderMin + "s %2s %" + servicesOfferedHeaderMin + "s", "|", "ID", "|", "Company name", "|", "Location", "|", "Services offered", "|");
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    for(Trader trader : traderList)
                    {
                        if(trader.getLocation().toLowerCase().contains(location.toLowerCase()))
                        {
                        flag=1;
                        int companyMin = companyNameLength - trader.getCompanyName().length() + 3;
                        int locationMin = locationLength - trader.getLocation().length() + 3;
                        int servicesOfferedMin = serviceOfferedLength - trader.getServices().length() + 3;
                        System.out.format("%s %2d %2s %2s %" + companyMin + "s %2s %" + locationMin + "s %2s %" + servicesOfferedMin + "s", "|", countLocation, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                        System.out.println(); 
                        }
                        countLocation++;
                    }
                    if(flag==0)
                    {
                        System.out.println("\t\t\tNo\tRecords\t\tFound");
                    }
                      System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case "4":
                    int flag1 = 0;
                    int countServicesOffered = 1;
                    companyHeaderMin = companyNameLength - companyNameHeader.length() + 3;
                    locationHeaderMin = locationLength - locationHeader.length() + 3;
                    servicesOfferedHeaderMin = serviceOfferedLength - servicesOfferedHeader.length() + 3;
                    System.out.print("\nEnter search text :>");
                    String service_offered = sc.nextLine();
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%s %2s %2s %2s %" + companyHeaderMin + "s %2s %" + locationHeaderMin + "s %2s %" + servicesOfferedHeaderMin + "s", "|", "ID", "|", "Company name", "|", "Location", "|", "Services offered", "|");
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    for(Trader trader : traderList)
                    {
                        if(trader.getServices().toLowerCase().contains(service_offered.toLowerCase()))
                        {
                        flag1=1;
                        int companyMin = companyNameLength - trader.getCompanyName().length() + 3;
                        int locationMin = locationLength - trader.getLocation().length() + 3;
                        int servicesOfferedMin = serviceOfferedLength - trader.getServices().length() + 3;
                        System.out.format("%s %2d %2s %2s %" + companyMin + "s %2s %" + locationMin + "s %2s %" + servicesOfferedMin + "s", "|", countServicesOffered, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                        System.out.println(); 
                        }
                        countServicesOffered++;
                    }
                    if(flag1==0)
                    {
                        System.out.println("\t\t\tNo\tRecords\t\tFound");
                    }
                      System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    
                    break;
            }
        } while (!input.equals("0"));
    }
}