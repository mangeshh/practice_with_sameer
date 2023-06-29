package stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++){
            char c = chars[i];
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                char sElem = stack.peek();
                if(c == ')'){
                    if(sElem == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                } else if(c == ']'){
                    if(sElem == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                } else if(c == '}'){
                    if(sElem == '{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }  else{
                    stack.push(c);
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(()){}";

        if(isValid(s)){
            System.out.println(s + " is a valid parenthesis ");
        }
        else{
            System.out.println(s + " is not a valid parenthesis");
        }
    }
}
