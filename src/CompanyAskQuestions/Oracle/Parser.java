package CompanyAskQuestions.Oracle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Parser {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Educative\\project\\springboot apps\\springBoot_Apps\\java_algorithm\\src\\CompanyAskQuestions\\Oracle\\f.txt";
        parse(path);
        getReport();
    }
    static public void parse(String path) throws IOException {

        File file=new File(path);    //creates a new file instance
        FileReader fr = null;
        try{
            //Creating stream to read the object
            fr =new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;

            String[] headers = null;
            boolean isHeader = true;
            while((line=br.readLine())!=null)
            {
                //Check if first line is headers
                if(isHeader == true) {
                    headers = line.split(",");
                    if(headers[0] != null && headers[0].equals("customerId"))
                        continue;

                    headers = "customerId,contractId,geozone,teamcode,projectcode,buildduration".split(",");
                    isHeader = false;
                }
                PasreUtils(line.split(","), headers);
            }

        }
        finally {
            fr.close();
        }
    }
    static private ArrayList<CustomerData> dataSets = new ArrayList<>();
    static public void PasreUtils(String[] input, String[] headers)  {
        CustomerData newInstance = new CustomerData();
        newInstance.setCustomerId(Long.parseLong(input[0]));
        newInstance.setContractId(Long.parseLong(input[1]));
        newInstance.setGeozone(input[2]);
        newInstance.setTeamcode(input[3]);
        newInstance.setProjectcode(input[4]);
        newInstance.setBuildduration(input[5]);

        dataSets.add(newInstance);
    }
    static public void PasreUtils(String[] input, boolean isTrue)  {
        final String[] headers = "customerId,contractId,geozone,teamcode,projectcode,buildduration".split(",");
        CustomerData newInstance = new CustomerData();
        for(int i = 0; i < input.length; i++) {
            switch (headers[i]) {
                case "customerId" :
                    newInstance.setCustomerId(Long.parseLong(input[i]));
                    break;
                case "contractId" :
                    newInstance.setContractId(Long.parseLong(input[i]));
                    break;
                case "geozone" :
                    newInstance.setGeozone(input[i]);
                    break;
                case "teamcode" :
                    newInstance.setTeamcode(input[i]);
                    break;
                case "projectcode" :
                    newInstance.setProjectcode(input[i]);
                    break;
                case "buildduration" :
                    newInstance.setBuildduration(input[i]);
                    break;
            }
        }

        dataSets.add(newInstance);
    }

    static void getReport() {
        //The number of unique customerId for each contractId
        HashMap<Long, Set<Long>> uniqueCustomerId_perContractId = new HashMap<>();
        for(CustomerData it : dataSets) {
            Set<Long> v = new HashSet<>() {{
                add(it.getCustomerId());
            }};
            Set<Long> retVal = uniqueCustomerId_perContractId.putIfAbsent(it.getContractId(), v);

            if(retVal != null)
                uniqueCustomerId_perContractId.get(it.getContractId()).add(it.getCustomerId());
        }
        System.out.printf("==========================================================\n\n");
        System.out.println( " The number of unique customerId for each contractId : ");
        uniqueCustomerId_perContractId.forEach((k , v) -> System.out.println(" for Contract id : " + k + " -> total Customer Id : " + v.size()));

        // The number of unique customerId for each geozone
        HashMap<String, Set<Long>> custId_perGeoZone = new HashMap<>();
        for(CustomerData it : dataSets) {
            Set<Long> values = new HashSet<>() {{
                add(it.getCustomerId());
            }};
            Set<Long> retVal = custId_perGeoZone.putIfAbsent(it.getGeozone(), values);

            if(retVal != null)
                custId_perGeoZone.get(it.getGeozone()).add(it.getCustomerId());
        }
        System.out.printf("==========================================================\n\n");
        System.out.println( " The number of unique customerId for each geozone : ");
        custId_perGeoZone.forEach((k , v) -> System.out.println(" for geozone : " + k + " -> total Custmer Id : " + v.size()));

        //The average buildduration for each geozone
        HashMap<String, ArrayList<String>> buildDuration_perGeoZone = new HashMap<>();
        for(CustomerData it : dataSets) {
            ArrayList<String> value = new ArrayList<>() {
                {
                    add(it.getBuildduration());
                }
            };
            ArrayList<String> retVal = buildDuration_perGeoZone.putIfAbsent(it.getGeozone(), value);

            if(retVal != null)
                buildDuration_perGeoZone.get(it.getGeozone()).add(it.getBuildduration());
        }
        System.out.printf("==========================================================\n\n");
        System.out.println( " The average build duration for each geozone : ");
        for(Map.Entry<String, ArrayList<String>> v : buildDuration_perGeoZone.entrySet()) {
            System.out.print(" for geozone : " + v.getKey() + " -> average is " );
            OptionalDouble average = v.getValue().stream().mapToLong(item -> Long.parseLong(item)).average();
            System.out.println(average.getAsDouble());
        }

        //The list of unique customerId for each geozone
        System.out.printf("==========================================================\n\n");
        System.out.println( " The list of unique customerId for each geo zone : ");
        custId_perGeoZone.forEach((k , v) -> System.out.println(" for geozone : " + k + " -> Unique Custmer Ids : " + v));
    }
}
