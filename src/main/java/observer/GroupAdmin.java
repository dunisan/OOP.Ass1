package observer;
import java.util.*;
import java.util.ArrayList;


public class GroupAdmin implements Sender {
    private UndoableStringBuilder status;
    private List<Member> members;

    public GroupAdmin(UndoableStringBuilder status) {
        this.status = status;
        this.members = new LinkedList<>();
    }


    @Override
    public void register(Member obj) {
        this.members.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);
    }

    @Override
    public void notifyMembers() {
        for(Member o : this.members){
            o.update(status);
        }
    }

    @Override
    public void insert(int offset, String obj) {
        this.status.insert(offset,obj);
        notifyMembers();
    }

    @Override
    public void append(String obj) {
        this.status.append(obj);
        notifyMembers();
    }

    @Override
    public void delete(int start, int end) {
        this.status.delete(start, end);
        notifyMembers();
    }

    @Override
    public void undo() {
        this.status.undo();
        notifyMembers();
    }

    @Override
    public void replace(int start, int end, String str) {
        this.status.replace(start,end, str);
        notifyMembers();
    }

    @Override
    public void reverse() {
        this.status.reverse();
        notifyMembers();
    }
}