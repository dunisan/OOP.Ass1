package observer;

public class Main {
    public static void main(String[] args) {

        String error = null;
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin usb = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember(usb);
        ConcreteMember member2 = new ConcreteMember(usb);
        ConcreteMember member3 = new ConcreteMember(usb);

        usb.append("to be or not to be") ;
        System.out.println(member1) ;
        usb.replace(3, 5, "eat") ;
      //  System.out.println(usb) ;
        usb.delete(3,6) ;
        usb.replace(17, 19, "eat") ;
      //  System.out.println(usb) ;
        usb.reverse();
      //  System.out.println(usb) ;
      //  System.out.println();
        usb.undo();
      ///  System.out.println(usb);
        usb.undo();
     //   System.out.println(usb) ;
        usb.undo();
       // System.out.println(usb);

    }
}