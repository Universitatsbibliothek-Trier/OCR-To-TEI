public class App 
{
 
    public static void main(String[] args) throws Exception 
    {
        // String xsdPath="OCR-To-TEI/src/resources/testfile.xsd";
        // String xmlPath="OCR-To-TEI/src/resources/testfile1_example.xml";
        String xsdPath="OCR-To-TEI/src/resources/testfile.xsd";
        String xmlPath="OCR-To-TEI/src/resources/testfile1_example.xml";
        System.out.println("testfile xml validates against testfile.xsd" + XMLValidator.validateXMLSchema(xsdPath, xmlPath) );

    }

   
}
