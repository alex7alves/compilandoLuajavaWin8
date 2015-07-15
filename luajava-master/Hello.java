import org.keplerproject.luajava.*;

public class Hello
{
  public static void main(String[] args)
  {
    LuaState L = LuaStateFactory.newLuaState();
    L.openLibs();
    
    L.LdoFile("hello.lua");
    
    System.out.println("Olá Mundo de Java!");
  }
}
