import java.util.ArrayList;
public class myXMLValidator implements IXMLValidator{
    
    public boolean validateXML(IStack stack, String inputXML) {
        //split string by space
        String[] XMLString = inputXML.split("\n");
        ArrayList<String> values = new ArrayList<>();
        
        for(int i = 0; i < XMLString.length - 1; i++) {
            //Test opening
            if(XMLString[i].charAt(0) == '<' && XMLString[i].charAt(XMLString[i].length() - 1) == '>') {
                stack.push(XMLString[i]);
            }
            
            //Test closing
            else if(XMLString[i].charAt(0) == '<' && XMLString[i].charAt(1) == '/' && 
                    XMLString[i].charAt(XMLString[i].length() - 1) == '>') {
                String newChar = XMLString[i].replace("/", "");
                //If value on top matches pop, if not then add to array
                if(stack.peek().equals(newChar)) {
                    stack.pop();
                }
                else {
                    values.add(newChar);
                }
            }
        }
        
        //pop remaining values
        int j = 0;
        do {
            if(stack.peek().equals(values.get(j))) {
                stack.pop();
            }
        }while(!values.isEmpty());
        
        //return true/false value
        if(stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
