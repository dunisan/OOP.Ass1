package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



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
        admin1.register(member2);
        assertEquals(test, member1.toString());
        assertEquals(test, member2.toString());

    }

    @Test
    void unregister() {
        String test = "I registered and I'm updated";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1

        admin.unregister(member1);

        assertEquals(null, member1.toString());

    }

    @Test
    void insert() {
        String test = "I registered and I'm updated";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1
        admin.register(member1);
        admin.append(test);

        admin.insert(3, "INSERT");
        assertEquals("I rINSERTegistered and I'm updated", member1.toString());

    }

    @Test
    void append() {
        String test = "I registered and I'm updated";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1
        ConcreteMember member2 = new ConcreteMember(admin);
        admin.register(member1);
        admin.append(test);
        assertEquals(test, member2.toString());
    }

    @Test
    void delete() {
        String test = "I registered and I'm updated";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1
        ConcreteMember member2 = new ConcreteMember(admin);
        admin.register(member1);
        admin.append(test);

        admin.delete(3,10);
        assertEquals("I red and I'm updated", member2.toString());
    }

    @Test
    void undo() {
        String test = "I registered and I'm updated";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1
        ConcreteMember member2 = new ConcreteMember(admin);
        admin.register(member1);
        admin.append(test);
        admin.delete(3,10);

        admin.undo();
        assertEquals(test, member2.toString());
    }

    @Test
    void replace() {
        String test = "I registered and I'm updated";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1
        ConcreteMember member2 = new ConcreteMember(admin);
        admin.register(member1);
        admin.append(test);

        admin.replace(3,5, "DAD" );
        assertEquals("I rDADistered and I'm updated", member2.toString());
    }

    @Test
    void reverse() {
        String test = "TESTING REVERSE";
        GroupAdmin admin = new GroupAdmin(); // create an admin
        ConcreteMember member1 = new ConcreteMember(admin); // create member1
        ConcreteMember member2 = new ConcreteMember(admin);
        admin.register(member1);
        admin.append(test);

        admin.reverse();
        assertEquals("ESREVER GNITSET", member2.toString());

    }
}