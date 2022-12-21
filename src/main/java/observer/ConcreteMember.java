package observer;


import java.util.*;
import java.util.ArrayList;


public class ConcreteMember implements  Member {

    private GroupAdmin admin;

    public ConcreteMember(GroupAdmin admin) {
        this.admin = admin;
        admin.register(this);
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        System.out.println(usb);
    }
}