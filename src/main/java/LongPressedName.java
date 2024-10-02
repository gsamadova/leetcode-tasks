public class LongPressedName {
    public Stack<CI> makeStack(String string) {
        Stack<CI> stack = new Stack<>();
        for (char c : string.toCharArray()) {
            if (stack.empty()) {
                stack.push(new CI(c, 1));
            } else {
                CI ci = stack.peek();
                if (ci.c() == c) {
                    stack.pop();
                    stack.push(new CI(c, ci.count() + 1));
                } else {
                    stack.push(new CI(c, 1));
                }
            }
        }
        return stack;
    }

    public boolean isLongPressedName(String name, String typed) {
        Stack<CI> nameStack = makeStack(name);
        Stack<CI> typedStack = makeStack(typed);

        if (nameStack.size() != typedStack.size()) {
            return false;
        }

        while (!nameStack.empty() && !typedStack.empty()) {
            CI nameCI = nameStack.pop();
            CI typedCI = typedStack.pop();
            if (nameCI.c() != typedCI.c() || nameCI.count() > typedCI.count()) {
                return false;
            }
        }
        return true;
    }
}

record CI(char c, int count) {};