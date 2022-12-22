package observer;


import java.util.*;
import java.util.ArrayList;
///ddd


public class ConcreteMember implements  Member {

    private GroupAdmin admin;
    private UndoableStringBuilder concreteMember;

    public ConcreteMember(GroupAdmin admin) {

        this.admin = admin;
        admin.register(this);
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.concreteMember = usb;
    }

    @Override
    public String toString() {
        return this.concreteMember.toString();
    }
}