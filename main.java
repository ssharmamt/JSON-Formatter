public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        
        
        ArrayList<String> result = new ArrayList<>();
        
        
        if (A.length()==0)
            return result;
            
            
            String indent ="";
            String curr ="";
            
            int i=0, length = A.length();
            
            
            while (i<length){
                curr += A.charAt(i);
                switch (A.charAt(i)){
                    case ',':
                        result.add(curr);
                        curr = indent;
                        i++;
                        break;
                        
                    case ':':
                        i++;
                        if(A.charAt(i) == '{' || A.charAt(i) =='['){
                            result.add(curr);
                            curr= indent;
                        }
                        break;
                        
                    case '{':
                        
                    case  '[':
                        i++;
                        result.add(curr);
                        if(i<length && (A.charAt(i) != '}' || A.charAt(i) !=']'))
                        {
                            indent += '\t';
                        }
                        curr = indent;
                        break;
                        
                        
                    case '}':
                    case  ']':
                        i++;
                        if(i<length && A.charAt(i) == ',') break;
                        
                        result.add (curr);
                        
                        
                        if (i< length && (A.charAt(i) == ']' || A.charAt(i) == '}'))
                        {
                            if(!indent.isEmpty()){
                                indent = indent.substring(0, indent.length()-1);
                                 
                            }
                        }
                        curr = indent;
                        break;
                        
                        default :
                        i++;
                        if (i< length && (A.charAt(i) == '}' || A.charAt(i) == ']'))
                        {
                            result.add(curr);
                            if (!indent.isEmpty())
                                indent = indent.substring(0, indent.length()-1);
                                curr = indent;
                        }
                }
            }
       
        return result;
    }
}
