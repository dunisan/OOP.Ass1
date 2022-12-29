/**
 *
 * The GroupAdmin class is for manage a list of consumers,
 * of the undoable string builder.
 * the GroupAdmin class is the admin of the undoableStringBuilder
 * the groupAdmin class implements the Sender interface,
 * that is used for implementing the observer design pattern
 *
 * @author  Daniel Schneiderman && Tuvia Smadar
 * @version 1.0
 * @since   2022-28-12
 */
package observer;
import java.util.*;
import java.util.ArrayList;


public class GroupAdmin implements Sender {
    private UndoableStringBuilder status; // The UndoableStringBuilder that the admin has the status of it
    private List<Member> members; // The list that will hold all of the members


    /**
     * A constructor of the admin.
     * Makes a new UndoableStringBuilder
     * Makes a new LinkedList to save all the members
     */

    public GroupAdmin() {
        this.status = new UndoableStringBuilder();
        this.members = new LinkedList<>();
    }


    /**
     * Register a new member that will know the status of the undoableStringBuilder
     * the member is saved in the list.
     *
     * @param obj the member to put into the members list
     */
    @Override
    public void register(Member obj) {
        if(members.contains(obj)) {
            System.out.println("The member is already registered");
            return;
        }
        this.members.add(obj); // add member to the lost

    }


    /**
     * unregister a memner to a list.
     * The object will no longer point to the undoable string builder
     *
     * @param obj the member to unregister him
     * */
    @Override
    public void unregister(Member obj) {
        if(members.contains(obj)) {
            this.members.remove(obj); // removoe member from the list
            obj = null;
        }
        else{
            System.out.println("Member is not registered");
        }
    }

    /**
     * notifyMembers is a private method that is used to notify all members of the list,
     * on the current status of the undoableStringBuilder.
     * used after every change on 'status'
     *
     */
    private void notifyMembers() {
        for(Member o : this.members){ // go over all members that are in the list
            o.update(status); // update the member
        }
    }


    /**
     * inserts a string into the Undoable String Builder.
     * uses the insert method of the undoableString builder class
     *
     * @param offset at which byte to insert the string
     * @param obj the string to insert
     */
    @Override
    public void insert(int offset, String obj) {
        this.status.insert(offset,obj);
        notifyMembers(); // notify all the members on the list
    }


    /**
     *  append a string to the Undoable String Builder.
     *  uses the append method of the undoableString builder class
     * @param obj the string to oppend
     */
    @Override
    public void append(String obj) {
        this.status.append(obj);
        notifyMembers();// notify all the members on the list
    }


    /**
     *  deletes bytes from the Undoable String Builder from byte 'start' to byte 'end'.
     *  uses the delete method of the undoableString builder class
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {
        this.status.delete(start, end);
        notifyMembers();// notify all the members on the list
    }

    /**
     *  undo the last method that was used on the undoableStringBuilder
     *  uses the insert method of the undoableString builder class
     */
    @Override
    public void undo() {
        this.status.undo();
        notifyMembers();// notify all the members on the list
    }

    /**
     * This function is used for testing the registered members in the members list
     * @return the num of members
     */
    public int getNumOfRegisters(){
        return members.size();
    }


}
