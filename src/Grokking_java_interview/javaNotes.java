package Grokking_java_interview;

public class javaNotes {

    /*
    1. Java is pass by value only. Even reference data types are passed by value.
    2. Methods of a class can be overloaded in Java by:
       -> Changing the number of parameters
       -> Changing the type of the parameters passed into the methods

    3. There are two levels of access control, the top level and the member level.
    4. There are four accessibility levels in Java.
       -> public
       -> package private
       -> protected
       -> private
     5.The top-level access modifiers apply to top level classes.
        Classes can be marked either public or package private.
        ->A public class is accessible across different packages.
        ->A package private class is only visible to other classes within the same package.
     6.There's no explicit modifier for package private.
        -> In the absence of any modifier the class or member variables are package private.
        -> A member marked package private is only visible within its own package.
     7.The protected modifier specifies that a member can only be accessed within
        its own package (as with package-private) and, in addition,
        by a subclass of its class in another or the same package.
      8.The private modifier specifies that the member can only be accessed in its own class.
         Note that top level classes can't be marked private or protected but nested ones can be.
      9.The Object class is the superclass directly or indirectly of every other class in Java.
        The Object class itself doesn't have any superclass.
      10. Methods define in object class:
        clone()
        equals()
        hashCode()
        finalize()
        getClass()
        toString()
      11. Always use the equals() method when comparing strings!
        String myStr = "abc";
        System.out.println(myStr == "abc");
        output: compiler depend. may be both string literals pointing to same memory locations.
      12.one needs to override the hashCode() method whenever we override the equals() method for a class.
         The vice-versa is not necessary that is if you override the hashCode method it is not a must to
          override the equals method.
           HashSet<Celebrity> set = new HashSet();
            Celebrity realKardashian = new Celebrity("Kim", 17);
            Celebrity kardashianClone = new Celebrity("Kim", 17);
            set.add(realKardashian);

            if (set.contains(kardashianClone)) {
                System.out.println("Kim is a celebrity");
            } else {
                System.out.println("Can't find Kim");
            }
          The value returned by hashCode() is the object's hash code, which is the object's memory address in hexadecimal.
       13.Object's implementation of finalize() does nothing — you can override finalize() to do cleanup,
           such as freeing up resources.
           The finalize() method may be called automatically by the system, but when it is called,
            or even if it is called, is uncertain. Therefore, you should not rely on this method to do your cleanup for you.
            For example, if you don't close file descriptors in your code after performing I/O and
            you expect finalize() to close them for you, you may run out of file descriptors.
        14.a default no-argument constructor is provided by the compiler.
        15. Can we change the contents of a final array as in the code snippet below?
            final int[] array = new int[5];
            array[0] = 1;   // compile

            final int[] array = new int[5];
            array = new int[10]; // not compile
         16.A static initialization block is a normal block of code enclosed in braces, { }, and preceded by the static keyword.
            It can be used to initialize static fields of a class.
         17.The Java compiler copies initializer blocks into every constructor.
            Therefore, this approach can be used to share a block of code between multiple constructors.
         18.The java.lang.Object class is the super class of all classes in Java.
         19.primary purpose of nested classes is logically grouping related classes in one place and improving encapsulation.
            Static Nested Class
            Non-Static Nested Class or Inner Class. The following classes are also considered inner classes.
            Local Class
            Anonymous Class
         20. A class that is defined in a block is called a local class.
             A block is a group of zero or more statements between balanced braces.
         21.An anonymous class is like a local class except they don't have a name and
             should be used in place of a local class when the intended use is only one time.
         22.If a class includes abstract methods, then the class itself must be declared abstract.
         23.A class marked final can't be extended or inherited from.
            final class DontExtendMe {
            }
            // Compile time error
            class WontCompile extends DontExtendMe {
            }
         24.You may want to make a class final if it is not designed for inheritance or
            you want to forbid any changes by subclassing.
         25.The finalize() method is a protected and non-static method of the java.lang.Object class
            The finalize() method is invoked by the JVM when an object is garbage collected.

         26. interface can only have variables that are final and static by default.
             interface can have static, abstract, or default methods.
             interface all methods and constants are public.
             A class can only extend another class, but it can implement multiple interfaces. Similarly,
             an interface can extend multiple interfaces. An interface never implements a class or an interface.
         27. Use an interface if you expect unrelated classes would implement your interface.
             For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
             Interfaces are also used in instances where multiple inheritance of type is desired.
             Lastly, use an interface if you want to specify the behavior of a certain type but aren't concerned
             who implements the behavior.
         28.An interface may have no methods at all. Such an interface can be useful to refer to objects of
            a bunch of classes that are related and implement the empty interface.
            Such interfaces are also called marker interfaces.
         29.A functional interface is an interface that contains only one abstract method.
         30.What is the difference between Comparable interface and Comparator interface?
         31.Lambda expressions allow us to pass code as data or functionality as a method argument.
           Lambda expressions can be used to replace writing anonymous classes, when the class implements a functional interface.
           A functional interface has only a single abstract method and may have default or static methods.
         32.We can capture the local variables in the enclosing scope of the lambda expression as we have done in the example with the variable i.
            The restriction is however that i should be either final or effectively final.
             If you try to change the value of i after defining the lambda, you'll get a compile error
         33.Generics in Java were released with J2SE 1.5 in 2004. Later on, J2SE 1.5 was renamed to Java SE 5.0.
         34.Type safety is the extent to which a programming language discourages or prevents type errors.
         35.A generic type is a generic class or interface that is parameterized over types.
            For instance, the LinkedList<E> class in java is a generic class.
         36.The E in the generic class LinkedList<E> is called a type parameter.
         37.The scope of the type variable is local to the method itself.
            it may appear in the method signature and the method body, but not outside the method.
            A generic method can appear in a class which itself is not generic.
            we don't specify the type which is automatically inferred by the compiler. A feature known as type inference.
         38.Note, generics classes or interfaces can't be parameterized over primitive types.
         39.Also note that for a parametrized outer class we don't need to specify the parameter type when
            accessing the static members from outside the outer class e.g. OuterClass<Integer>.InnerClass or
            OuterClass<String>.InnerClass are all invalid and compile time errors.
            Simply, OuterClass.InnerClass is good enough when accessing from outside the outer class and OuterClass.<T>InnerClass
            when accessing within the outer class.
          40.Arrays are covariant, meaning we can cast an array of a subtype to its super type but not vice versa.
          41.Arrays being covariant imply two things:
            An array of type T[] may contain elements of type T and its subtypes.
            An array of type S[] is a subtype of T[] if S is a subtype of T.

          50.All stateless objects and their corresponding classes are thread-safe.
             Since the actions of a thread accessing a stateless object can't affect
             the correctness of operations in other threads, stateless objects are thread-safe.
          51.A mutex is owned by the thread acquiring it, till the point, it releases it,
             whereas for a semaphore there's no notion of ownership.
          52.In the Java programming language there's no mutex but something called a monitor
             which can be thought of as a mutex with bells and whistles.
          53.When we use synchronized in an instance method signature we are in reality acquiring the monitor associated with the object.
          When we use synchronized in a static method signature we are acquire the monitor associated with the class object.
          54.For static methods, the monitor will be the class object,which is distinct from the monitor of each instance of the same class.
             If an uncaught exception occurs in a synchronized method, the monitor is still released.
             Furthermore, synchronized blocks can be re-entered that is they are reentrant.
           54.If there's a single thread that writes to the volatile variable and other threads only read the volatile variable then
            just using volatile is enough, however, if there's a possibility of multiple threads writing to the volatile variable
             then synchronized would be required to ensure atomic writes to the variable.

     */
}
