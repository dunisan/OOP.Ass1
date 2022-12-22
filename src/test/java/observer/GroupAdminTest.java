package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class GroupAdminTest {

    @Test
    void name() {
    }

    @Test
    void register() {

        String test = "I registered and I'm updated";
        GroupAdmin admin1 = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin1); // create member1
        ConcreteMember member2 = new ConcreteMember(admin1); // create member2

        admin1.register(member1);
        admin1.append(test);
        assertEquals(test, member1.toString());

        admin1.register(member2);
        assertEquals(test, member2.toString());

    }

    @Test
    void unregister() {
    }

    @Test
    void notifyMembers() {
    }

    @Test
    void insert() {
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }

    @Test
    void replace() {
    }

    @Test
    void reverse() {
    }
}