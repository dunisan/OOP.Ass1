/**
 *
 *
 * The MyStringBuilder class is for manipulating strings,
 * so that we can execute on it the undo() method
 * so that the last action we made on the string will go back.
 *
 * @author  Daniel Schneiderman && Tuvia Hagever
 * @version 1.0
 * @since   2022-03-11
 */

package observer;
import java.util.*;

public class UndoableStringBuilder {

    private static Stack<String> stack; // A stack that holds strings.
    // that is how we will perform the undo method.

    /**
     * A constructor for the object of the class
     * that will let us to build string and perform the undo method.
     */
    public UndoableStringBuilder(){
        stack = new Stack<>();
    }

    /**
     * A constructor for the object of the class
     * that will let us to build string and perform the undo method.
     * It makes the first string.
     *
     * @param string The given string to push into the stack.
     * @throws NullPointerException if str is null
     */
    public UndoableStringBuilder(String string){
        if(string == null)
            throw new NullPointerException("str is null");

        stack = new Stack<>();
        stack.push(string);

    }

    /**
     * Appends the specified string to this character sequence.
     *
     * The characters of the String argument are appended, in order,
     * increasing the length of this sequence by the length of the argument.
     * If str is null, then the four characters "null" are appended.
     *
     * @param str The string
     * @return  a reference to this object
     */

    public UndoableStringBuilder append(String str){
        if(stack.empty()) //If the stack is empty so we first of all push the string into it
            stack.push(str);
        else    // else we push a new string that appends str to the current string
            stack.push(stack.peek() + str);

        return this;
    }


    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start The beginning index
     * @param end The ending index
     * @return  a reference to this object
     */
    public UndoableStringBuilder delete(int start, int end){
        StringBuilder newString = new StringBuilder(stack.peek());
        try {
            newString.delete(start,end);
            stack.push(newString.toString()); // push the updated string
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println(e);
        }


        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * The characters of the String argument are inserted, in order,
     * into this sequence at the indicated offset, moving up any characters originally above that position,
     * and increasing the length of this sequence by the length of the argument.
     * If str is null, then the four characters "null" are inserted into this sequence.
     *
     * @param offset The offset
     * @param str A string
     * @return  a reference to this object
     */
    public UndoableStringBuilder insert(int offset, String str){

        StringBuilder newString = new StringBuilder(stack.peek());
        try {
            newString.insert(offset, str);
            stack.push(newString.toString());
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println(e);
        }

        return this;

    }

    /**
     *Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end - 1
     * or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     *
     * @param start The beginning index
     * @param end The ending index
     * @param str String that will replace contents
     * @return  a reference to this object
     */

    public UndoableStringBuilder replace(int start, int end, String str){
        StringBuilder newString = new StringBuilder(stack.peek());
        try {
            newString.replace(start, end, str);
            stack.push(newString.toString());
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println(e);
        }

        return this;
    }


    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     * If there are any surrogate pairs included in the sequence,
     * these are treated as single characters for the reverse operation.
     * Thus, the order of the high-low surrogates is never reversed.
     * Let n be the character length of this character sequence (not the length in char values)
     * just prior to execution of the reverse method.
     * Then the character at index k in the new character sequence is equal to the character at index n-k-1
     * in the old character sequence.
     *
     * @return  a reference to this object
     */
    public UndoableStringBuilder reverse(){
        StringBuilder newString = new StringBuilder(stack.peek());
        newString.reverse();
        stack.push(newString.toString());

        return this;
    }


    /**
     * Undo the last action that was done on the string.
     *
     * @return  a reference to this object
     */
    public UndoableStringBuilder undo(){
        stack.pop();

        return this;
    }

    /**
     * A string representation of the object.
     *
     * @return A string representation of the object.
     */
    public String toString(){
        if(stack.empty()){
            return null;
        }
        else{
            return stack.peek();
        }
    }

}


