package dev.me.exercises;

import java.util.Arrays;
import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right,
negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();

        int[][] tests = new int[][] {
                {5,10,-5},
                {8,-8},
                {10,2,-5},
                {-2,-2,1,-2},
                {10,1,2,3,-10}
        };
        for (int[] asteroids : tests){
            System.out.println(Arrays.toString(ac.asteroidCollision(asteroids)));
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else { // asteroid is moving leftwards
                // Handle multiple collisions when the asteroid destroys smaller asteroids in the stack
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                // appends the asteroid since all are going to the left
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) { // both asteroids are destroyed
                    stack.pop();
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
