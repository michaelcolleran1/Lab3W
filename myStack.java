//Coby Andersen
class myStack implements IStack {
    private List<String> stack;

    public myStack() {
        stack = new ArrayList<>();
    }
//pushes a new item into the stack
    @Override
    public void push(String c) {
        stack.add(c);
    }

    //pops (removes) the top item of the stack
    @Override
    public String pop() {
        if (isEmpty()) {
            return null; // Stack is empty
        }
        int lastIndex = stack.size() - 1;
        String item = stack.get(lastIndex);
        stack.remove(lastIndex);
        return item;
    }
//Returns without removing the top item from the stack
    @Override
    public String peek() {
        if (isEmpty()) {
            return null; // Stack is empty
        }
        int lastIndex = stack.size() - 1;
        return stack.get(lastIndex);
    }
//Checks to see if the stack is empty
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
