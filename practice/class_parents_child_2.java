import java.util.*;

public class class_parents_child_2 
{
    public static void main(String[] args)
    {
        Parent ins = new Child(); //선언 타입이 Parent, 실제 타입이 Child인 오브젝트 생성
        ins.method1(); //child의 메소드 사용됨
        ((Parent)ins).method1(); //얘도 child의 메소드 사용됨
        ins.method_only_parent(); //child는 해당 메소드가 없지만, parent가 해당 메소드를 가지고 있기 때문에 사용 가능 (앞에 태그 없이 사용 가능)
        //ins.method_only_child(); //선언 타입이 parent라서 child만 가지고 있는 메소드를 사용할 수 없음
        ((Child)ins).method_only_child(); //앞에 Child태그를 붙여주면 child만 가지고 있는 메소드 사용 가능
        ins.abstract_method(); //패런츠, 차일드 둘 다 해당 메소드를 가지고 있으므로 사용 가능
        ins.static_binding(); //정적 바인딩 - 선언 타입의 메소드 사용 [static 태그가 없이 선언되면 실제 타입의 메소드가 사용됨]
        
        
        Child ins_c = new Child(); //선언, 실제 타입 모두 Child인 오브젝트 생성
        ins_c.method_only_child(); //선언과 실제타입 모두 해당 메소드를 가지고 있기 때문에 태그없이 사용 가능
        ins_c.method_only_parent(); //child클래스가 parent의 확장클래스이기 때문에, parent의 메소드도 태그없이 사용 가능
        ins_c.abstract_method();//추상 메소드를 사용하려면 차일드 클래스에서 한번 더 일반 메소드로 선언을 해줘야함
        
        
        
        
        //Parent ins_p = new Parent(); //추상 클래스는 객체로써 생성 불가 (차일드에서 오버라이딩시켜 사용가능한 클래스) => 추상메소드에 대한 동작이 없음 => 객체로써 생성 불가
        Abst_class_parent ins_abst_p = new Abst_class_child();
        Abst_class_child ins_abst_c = new Abst_class_child();
        ins_abst_p.method1(); //패런츠가 해당 메소드 가지고 있어서 사용 가능
        ins_abst_c.method1(); //패런츠가 해당 메소드 가지고 있어서 사용 가능
        
        
        
        
        Implements imp = new Implements(); //implements 클래스 생성 (인터페이스)
        imp.abst_method(); //메소드 실행
    }
}


abstract class Parent //추상메소드가 1개라도 존재하면 무조건 추상클래스로 선언해줘야함
{
    void method1() //반환값이 없는 경우 void
    {
        System.out.println("1-p");
    }
    
    void method_only_parent() //인스턴스 메소드
    {
        System.out.println("parent only");
    }
    
    abstract void abstract_method(); //추상 메소드
    
    
    
    static void static_binding() //정적 메소드
    {
        System.out.println("static_binding - p");
    }
}

class Child extends Parent //패런츠는 무조건 1개밖에 상속 못받음 (인터페이스는 여러개 상속 가능)
{
    //@Override는 부모 클래스에 있는 메소드를 자식클래스에서 수정해서 사용할 때 사용함.
    //이때 만약 부모 클래스에 해당 클래스가 존재하지 않고 @Override사용시 에러 발생함 
    //(= 기존 클래스를 수정하려는 원래 의도와는 다르게 새로운 메소드가 생성되는 것을 방지)
    @Override
    void method1() //인스턴스 메소드
    {
        System.out.println("1-c");
    }
    
    void method_only_child() //인스턴스 메소드
    {
        System.out.println("child only");
    }
    
    void abstract_method() //인스턴스 메소드
    {
        System.out.println("abstract method");
    }
    
    
    static void static_binding() //정적 메소드
    {
        System.out.println("static_binding - c");
    }
}

abstract class Abst_class_parent //추상 메소드가 없어도 추상 클래스로 선언은 가능함
{
    //abstract void abst_method();
    
    void method1() //인스턴스 메소드
    {
        System.out.println("1-abst_p");
    }
}

class Abst_class_child extends Abst_class_parent //하나의 클래스에서 패런츠는 오직 1개만 상속 가능하지만, 차일드 클래스를 가진 패런츠 클래스가 또 다른 패런츠를 가지는 것은 가능
{
    
}




public interface Interface //인터페이스 (오로지 추상메소드와 상수만 선언 가능)
{
    public static final int const_val = 0; //상수는 무조건 public static키워드를 포함해야함
    
    public abstract void abst_method(); //모든 추상메소드는 무조건 public키워드가 있어야 함
}


class Implements implements Interface //인터페이스에 있는 메소드를 구현해줄 클래스 (인터페이스는 여러개 상속받을 수 있다 ex : class Impliments implements Interface1, Interface2 ...)
{
    public void abst_method() //인터페이스가 public선언 되었으므로 무조건 public키워드가 붙어야함
    {
        System.out.println("abst_method - implements");
    }
}