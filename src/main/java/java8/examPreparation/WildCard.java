package java8.examPreparation;

public class WildCard {
    interface BI{}
    interface DI extends BI{}
    interface DDI extends DI{}

    static class C<T>{}
    static void foo(C<? super DI> arg){}

    public static void main(String[] args) {
        foo(new C<BI>());
        foo(new C<DI>());
//        foo(new C<DDI>());
        foo(new C());
    }
}
