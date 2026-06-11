//https://leetcode.com/problems/asteroid-collision
//my solution - 7ms beat 11%
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        int n = asteroids.length;
        for (int item : asteroids){
            if (stk.isEmpty()) {
                stk.push(item);
                continue;
            }
            
            while (!stk.isEmpty() && stk.peek() > 0 &&
            item < 0 && (Math.abs(item) > Math.abs(stk.peek()))){
                stk.pop();
            }

            if (!stk.isEmpty() && stk.peek() > 0 &&
            item < 0 && (Math.abs(item) < Math.abs(stk.peek()))){
                continue;
            }

            if (!stk.isEmpty() && stk.peek() > 0 && 
            item < 0 && (Math.abs(item) == Math.abs(stk.peek()))){
                stk.pop();
                continue;
            }

            stk.push(item);
        }

        Object[] objArr = stk.toArray(); 
    
        int len = objArr.length;
        int[] arr = new int[len];
        
        for (int i = 0; i < len; i++) {
            arr[i] = (Integer) objArr[i];
        }
        
        return arr;
    }
}

//1ms solution - beat 100%
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;

        for (int ast : asteroids) {
            boolean alive = true;
            while (alive && ast < 0 && top >= 0 && stack[top] > 0) {
                if (stack[top] < -ast) {
                    top--;
                } else if (stack[top] == -ast) {
                    top--;
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) stack[++top] = ast;
        }

        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}
