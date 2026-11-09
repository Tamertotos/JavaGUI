package processing;

public class ObjectProcessor {
    public String process(Object obj){
        System.out.println("START OF THE PROCESS");
        String json = "";
        try {
            Validator.validate(obj);
            json = JsonSerializer.serialize(obj);
            System.out.println("JSON SERIALIZATION SUCCESSFULLY DONE");
        } catch (ValidationException e){
            //System.err.print() causes ordering issues
            System.out.println("VALIDATION ERROR OCCURRED!!!!!");

            return "{\n" +
                    "VALIDATION EXCEPTION: ERROR" +
                    "\n}";
        } catch (IllegalAccessException e){
            return "{\n" +
                    "INTERNAL ACCESS EXCEPTION: ERROR WITH REFLECTION" +
                    "\n}";
        }

        return json;
    }
}
