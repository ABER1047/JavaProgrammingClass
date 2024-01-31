import java.util.*;

public class class_parents_child_1
{
    public static void main(String[] args)
    {
        //Animal이 슈퍼클래스인 human클래스 생성 (이때 Animal은 선언 타입, human은 실제 타입)
        Animal tmp_ins = new Human(); //업케스팅 (animal클래스가 패런츠)
        //Human tmp_ins = new Animal(); 다운케스팅 (다운케스팅은 항상 컴파일 오류 발생 = 항상 사용 불가)
        tmp_ins.eat();
        
        //Animal 클래스에 eat메소드가 존재하니, human클래스의 eat메소드 사용하기(사용 가능) [앞에 human태그가 없어도, 패런츠와 차일드 클래스 모두 eat메소드를 가지고 있으므로 에러는 발생하지 않음]
        ((Animal)tmp_ins).eat();
        
        //Animal클래스의 bark메소드가 존재하니, human메소드에 bark클래스가 없어도 사용가능 [앞에 animal태그가 없으면 에러 발생]
        ((Animal)tmp_ins).bark();
        
        //human클래스에 talk메소드가 존재하니, animal메소드에 talk클래스가 없어도 사용가능 [앞에 human태그가 없으면 에러 발생]
        ((Human)tmp_ins).talk();
    }
}

class Human extends Animal
{   
    void eat()
    {
        System.out.println("eat-human");
    }
    
    void talk()
    {
        System.out.println("talk-human");
    }
}

class Animal extends Entity //하나의 클래스에서 패런츠는 1개만 상속 가능하지만, 차일드 클래스를 가진 패런츠 클래스가 또 다른 패런츠를 가지는 것은 가능
{
    void eat()
    {
        System.out.println("eat-animal");
    }
    
    void bark()
    {
        System.out.println("bark-animal");
    }
}

class Entity
{
    void sleep()
    {
        System.out.println("sleep");
    }
}