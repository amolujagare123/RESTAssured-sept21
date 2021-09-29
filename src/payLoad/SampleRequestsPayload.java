package payLoad;

public class SampleRequestsPayload {

    public static String getSampleCreatePayLoad()
    {
       return "{\n" +
               "    \"name\": \"morpheus\",\n" +
               "    \"job\": \"leader\"\n" +
               "}" ;
    }

    // insteat of the value use "+variable+"

    public static String getSampleCreate(String name,String job)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}" ;
    }





}
