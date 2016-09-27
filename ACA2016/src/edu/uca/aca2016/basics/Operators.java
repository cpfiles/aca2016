package edu.uca.aca2016.basics;

/**
 * The code in this class was taken from the Oracle Documentation on Java:
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 */
class Operators{
    public void doAssignment() {
        int x = 0;
        int y = 0;
        int z = 1;
        
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
    }
    
    /*
        Operator	Description
        +           Additive operator (also used for String concatenation)
        -           Subtraction operator
        *           Multiplication operator
        /           Division operator
        %           Remainder operator
     */
    public void doMath(){
        int result = 1 + 2;
        // result is now 3
        System.out.println("1 + 2 = " + result);
        int original_result = result;

        result = result - 1;
        // result is now 2
        System.out.println(original_result + " - 1 = " + result);
        original_result = result;

        result = result * 2;
        // result is now 4
        System.out.println(original_result + " * 2 = " + result);
        original_result = result;

        result = result / 2;
        // result is now 2
        System.out.println(original_result + " / 2 = " + result);
        original_result = result;

        result = result + 8;
        // result is now 10
        System.out.println(original_result + " + 8 = " + result);
        original_result = result;

        result = result % 7;
        // result is now 3
        System.out.println(original_result + " % 7 = " + result);
    }

    public void doConcatenation(){
        String firstString = "This is";
        String secondString = " a concatenated string.";
        String thirdString = firstString + secondString;
        System.out.println(thirdString);
    }

    /*
        Operator	Description
        +           Unary plus operator; indicates positive value (numbers are positive without this, however)
        -           Unary minus operator; negates an expression
        ++          Increment operator; increments a value by 1
        --          Decrement operator; decrements a value by 1
        !           Logical complement operator; inverts the value of a boolean
     */
    public void doUnary(){
        int result = +1;
        // result is now 1
        System.out.println(result);

        result--;
        // result is now 0
        System.out.println(result);

        result++;
        // result is now 1
        System.out.println(result);

        result = -result;
        // result is now -1
        System.out.println(result);

        boolean success = false;
        // false
        System.out.println(success);
        // true
        System.out.println(!success);
    }

    public void doPrePost(){
        int i = 3;
        i++;
        // prints 4
        System.out.println(i);
        ++i;
        // prints 5
        System.out.println(i);
        // prints 6
        System.out.println(++i);
        // prints 6
        System.out.println(i++);
        // prints 7
        System.out.println(i);
    }
    
    /*
        ==      equal to
        !=      not equal to
        >       greater than
        >=      greater than or equal to
        <       less than
        <=      less than or equal to
    */
    public void doComparison() {
        int value1 = 1;
        int value2 = 2;
        if(value1 == value2)
            System.out.println("value1 == value2");
        if(value1 != value2)
            System.out.println("value1 != value2");
        if(value1 > value2)
            System.out.println("value1 > value2");
        if(value1 < value2)
            System.out.println("value1 < value2");
        if(value1 <= value2)
            System.out.println("value1 <= value2");
    }
    
    /*
        && Conditional-AND
        || Conditional-OR
    */
    public void doConditional() {
        int value1 = 1;
        int value2 = 2;
        
        if((value1 == 1) && (value2 == 2)) {
            System.out.println("value1 is 1 AND value2 is 2");
        }
        
        if((value1 == 1) || (value2 == 1)) {
            System.out.println("value1 is 1 OR value2 is 1");
        }
    }
    
    public void doTernary() {
        int value1 = 1;
        int value2 = 2;
        int result;
        boolean someCondition = true;
        result = someCondition ? value1 : value2;

        System.out.println(result);
    }
    
    class Parent {}
    class Child extends Parent implements MyInterface {}
    interface MyInterface {}
    
    public void doInstance() {
        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        System.out.println("obj1 instanceof Parent: " + (obj1 instanceof Parent));
        System.out.println("obj1 instanceof Child: " + (obj1 instanceof Child));
        System.out.println("obj1 instanceof MyInterface: " + (obj1 instanceof MyInterface));
        System.out.println("obj2 instanceof Parent: " + (obj2 instanceof Parent));
        System.out.println("obj2 instanceof Child: " + (obj2 instanceof Child));
        System.out.println("obj2 instanceof MyInterface: " + (obj2 instanceof MyInterface));
    }
    
    public void doBits() {
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
    }

    public static void main(String[] args){
        Operators ops = new Operators();

        // Assignment, Arithmetic, and Unary Operators
        System.out.println("==== Assignment Example ====");
        ops.doAssignment();
        System.out.println("==== Arithemtic Example ====");
        ops.doMath();
        System.out.println("==== Concatenation Example ====");
        ops.doConcatenation();
        System.out.println("==== Unary Example ====");
        ops.doUnary();
        System.out.println("==== Pre/Post Unary Example ====");
        ops.doPrePost();
        
        // Equality, Relational, and Conditional Operators
        System.out.println("==== Comparison Example ====");
        ops.doComparison();
        System.out.println("==== Conditional Example ====");
        ops.doConditional();
        System.out.println("==== Ternary Example ====");
        ops.doTernary();
        System.out.println("==== Instance Example ====");
        ops.doInstance();
        
        // Bitwise and Bit Shift Operators
        System.out.println("==== Bitwise Example ====");
        ops.doBits();
    }
}
