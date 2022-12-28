/**
 *
 * The ConcreteMemberTest is for testing the ConcreteMember methods
 *
 * @author  Daniel Schneiderman && Tuvia Smadar
 * @version 1.0
 * @since   2022-28-12
 */

package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        String test = "I registered and I'm updated";

        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member = new ConcreteMember(admin);
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append(test);
        member.update(usb);
        assertEquals(test, member.toString());
    }

    @Test
    void testToString() {
        String test = "To string test";
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member = new ConcreteMember(admin);
        admin.append(test);
        assertEquals(test, member.toString());

    }
}