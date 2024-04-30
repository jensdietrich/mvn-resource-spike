public class Foo {

    static {
        System.out.println("Foo from resource folder loaded");
    }

    public static class Inner {
        static {
            System.out.println("Foo$Inner from resource folder loaded");
        }
    }

    public static void foo() {
        System.out.println("Foo from resource folder");
    }


}