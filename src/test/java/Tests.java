
import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import observer.UndoableStringBuilder;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(() -> JvmUtilities.objectFootprint(s1));

        logger.info(() -> JvmUtilities.objectFootprint(s1, s2));

        logger.info(() -> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    //Create new group
    GroupAdmin admin = new GroupAdmin();

    //Create new members
    ConcreteMember member1 = new ConcreteMember();
    ConcreteMember member2 = new ConcreteMember();
    ConcreteMember member3 = new ConcreteMember();
    ConcreteMember member4 = new ConcreteMember();


    @Test
    void register(){


        // print the memoryStats of the admin
        System.out.println("print the memory state of the admin:");
        logger.info(() -> JvmUtilities.memoryStats(admin));

        System.out.println("");

        // Add to members to admin
        admin.register(member1);
        admin.register(member2);


        //Checks if the members has register currently
        assertEquals(admin.getNumOfRegisters(),2);

        // Add to more members to admin
        admin.register(member3);
        admin.register(member4);


        //Checks if the members has register currently
        assertEquals(admin.getNumOfRegisters(),4);


        // Add the same member - it should not add him.

        admin.register(member1);

        assertEquals(admin.getNumOfRegisters(), 4);


        // print the memoryStats of the memoryStat after adding 2 members
        System.out.println("print the memory state of the admin after adding 2 members:");
        logger.info(() -> JvmUtilities.memoryStats(admin));


    }


    @Test
    void unregister(){
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);
        admin.register(member4);


        // print the memoryStats of the admin
        System.out.println("print the memory state of the admin:");
        logger.info(() -> JvmUtilities.memoryStats(admin));

        // unregister 2 members.
        admin.unregister(member4);
        admin.unregister(member3);
        assertEquals(admin.getNumOfRegisters(), 2);

        // unregister the same member. it should take him out once.
        admin.unregister(member2);
        admin.unregister(member2);
        assertEquals(admin.getNumOfRegisters(), 1);

        // unregister the last member. list needs to contains 0 members.
        admin.unregister(member1);
        assertEquals(admin.getNumOfRegisters(), 0);

        // print the memoryStats of the admin after unregistered the members
        System.out.println("print the memory state of the admin:");
        logger.info(() -> JvmUtilities.memoryStats(admin));


    }



    @Test
    void append() {
        // print the memoryStats of the admin
        System.out.println("print the memory state of the admin:");
        logger.info(() -> JvmUtilities.memoryStats(admin));

        String test = "APPEND";
        admin.register(member1);
        admin.append(test);
        assertEquals(test, member1.toString());

        admin.register(member2);
        admin.append(test);
        assertEquals(test+test, member2.toString());


        // print the memoryStats of the admin and of one member
        System.out.println("print the memory state of the admin:");
        logger.info(() -> JvmUtilities.memoryStats(admin));
        logger.info(() -> JvmUtilities.memoryStats(member1));


    }



    @Test
    void insert(){
        // register 1 member. Then insert a string into the admin
        String test = "insert test";
        admin.register(member1);
        admin.append(test); // append a string to the admin

        admin.insert(0, "INSERT"); // insert "INSERT" into the text
        assertEquals("INSERTinsert test", member1.toString());

        // print the memoryStats of the admin
        System.out.println("print the memory state of the member1:");
        logger.info(() -> JvmUtilities.memoryStats(member1));

        System.out.println("");
        admin.register(member2);
        admin.insert(0, "INSERT");
        assertEquals("INSERTINSERTinsert test", member1.toString());
        assertEquals("INSERTINSERTinsert test", member2.toString());


        // print the memoryStats of the admin
        System.out.println("print the memory state of the members:");
        logger.info(() -> JvmUtilities.memoryStats(member1));
        logger.info(() -> JvmUtilities.memoryStats(member2));

    }


    @Test
    void delete() {
        // print the memoryStats of the admin
        System.out.println("print the memory state of the admin:");
        logger.info(() -> JvmUtilities.memoryStats(admin));


        String test = "delete the first word";
        admin.register(member1);
        admin.append(test);

        admin.delete(0,7);
        assertEquals("the first word", member1.toString());


        // print the memoryStats of the admin
        System.out.println("print the memory state of the admin and a member:");
        logger.info(() -> JvmUtilities.memoryStats(admin));
        logger.info(() -> JvmUtilities.memoryStats(member2));

    }

    @Test
    void undo() {

        //printing the memoryStats of admin before adding members.
        System.out.println("The admin memory 'use' before adding members");
        logger.info(() -> JvmUtilities.memoryStats(admin));

        String test = "UNDO";
        admin.register(member1);
        admin.register(member2);

        admin.append(test);
        admin.insert(0, "123");

        admin.undo();
        assertEquals(test, member1.toString());
        assertEquals(test, member2.toString());


        //printing the memoryStats of admin after adding members.
        System.out.println("The admin memory 'use' before adding members");
        logger.info(() -> JvmUtilities.memoryStats(admin));
    }


    @Test
    void update(){
        //printing the memoryStats of member1 before adding members.
        System.out.println("The admin memory 'use' before adding members");
        logger.info(() -> JvmUtilities.memoryStats(member1));


        String test = "UPDATE";

        // make a new UndoableStringBuilder and try to update the member.
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append(test);
        member1.update(usb);
        assertEquals(test, member1.toString());



        //printing the memoryStats of member1 after adding members.
        System.out.println("The admin memory 'use' before adding members");
        logger.info(() -> JvmUtilities.memoryStats(member1));
    }




}
