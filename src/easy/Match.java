package easy;

/**
 * Created by boomhe on 2018/1/25.
 */
public class Match {

    /**
     * 判断括号  匹配是否正确
     *
     * @param args
     */
    public static void main(String[] args) {
        Match main = new Match();
        String temp = "(()){{()}}[]";
        Boolean isMatch = main.isMatch(temp);
        System.out.println("字符串成对匹配 = " + isMatch);

    }

    /**
     * 思路：判断栈顶左边的字符与其是否匹配，不匹配直接返回 false
     *
     * @param string
     * @return
     */
    public Boolean isMatch(String string) {
        char[] chars = new char[string.length() + 1];
        // --top   防止数组越界的错误
        int top = 1;
        for (char c : string.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                chars[top++] = c;
            } else if (c == ')' && chars[--top] != '(') {
                return false;
            } else if (c == '}' && chars[--top] != '{') {
                return false;
            } else if (c == ']' && chars[--top] != '[') {
                return false;
            }
        }
        return top == 1;
    }
}
