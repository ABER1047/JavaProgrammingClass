public class exception_prac 
{
    public static void main(String args[])
    {
    }
    
    class Throw_class
    {
        //declare방법으로 예외 처리 = throw절 (catch블록을 만날 때 까지 계속 전파)
        public void test_method() throws MyException
        {
            //예외 발생 코드
        }
    }

    class Try_catch
    {
        public void test_method()
        {
            try
            {
                //예외가 발생할 수 있는 코드
            }
            catch(MyException e)
            {
                //위의 예외에 해당되는 예외 발생시 실행될 코드
                System.out.println("Exception by MyException - catch");
            }
            finally
            {
                //try문 실행 도중 예외 발생시 catch문 실행 후 finally문 실행됨
            }
        }
    }

    class Try_with_resource
    {
        public void test_method()
        {
            //파일 같은거 읽어들일 때, 혹은 Scanner같은거 사용할 때, 마지막에 항상 .close를 통해 닫아주는데 try with resource문 사용시 자동으로 close해줌
            try(//resource)
            {
                //예외 발생 코드
            }
            catch(ArithmeticException e)
            {
            }
            //finally는 사용 불가 (애초에 보통 finally는 close하기 위해 사용되므로, try with resource문에서는 필요가 없음)
        }
    }

    class MyException extends Exception //extends Exception을 통해 커스터마이즈 익셉션 생성 가능
    {
        MyException() //생성자
        {
            super("Exception by MyException - creator");//Exception클래스, 즉 부모의 생성자를 가져옴 
        }
    }
}
