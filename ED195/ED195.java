public class ED195 {

    public static boolean balanced(String s) {

        if ((s.length() % 2) != 0)
            return false;

        MyStack<Character> stack = new LinkedListStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (stack.top() == null)
                    return false;
                else if (s.charAt(i) == ']' && stack.top() == '[' || s.charAt(i) == ')' && stack.top() == '(')
                    stack.pop();
                else
                    return false;
            }
        }

        if (stack.size() > 0)
            return false;

        return true;
    }
}
