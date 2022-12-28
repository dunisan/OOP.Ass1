package observer;

/**
 *
 * The ConcreteMember class is for updating the members of the undoableStringBuilder status,
 * the ConcreteMember class implements the Member,
 * that is used for implementing the observer design pattern
 *
 * @author  Daniel Schneiderman && Tuvia Smadar
 * @version 1.0
 * @since   2022-28-12
 */

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