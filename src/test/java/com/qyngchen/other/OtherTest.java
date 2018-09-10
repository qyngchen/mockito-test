package com.qyngchen.other;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InOrder;

public class OtherTest {

  @Test
  public void mockTest() throws Exception {
    ArrayList list = mock(ArrayList.class);
//    System.out.println(list.get(0));
//    // 模拟获取第一个元素时，返回字符串first。  给特定的方法调用返回固定值在官方说法中称为stub。
//    Mockito.when(list.get(0)).thenReturn("first");
//    // 此时打印输出first
//    System.out.println(list.get(0));

//    // 模拟获取第二个元素时，抛出RuntimeException
//    //Mockito.when(list.get(1)).thenThrow(new RuntimeException());
//    // 此时将会抛出RuntimeException
//    System.out.println(list.get(1));
//    //如果一个函数没有返回值类型，那么可以使用此方法模拟异常抛出
//    Mockito.doThrow(new RuntimeException("clear exception")).when(list).clear();
//    list.clear();

//    // anyInt()匹配任何int参数，这意味着参数为任意值，其返回值均是element
//    Mockito.when(list.get(anyInt())).thenReturn("element");
//    // 此时打印是element
//    System.out.println(list.get(999));

//    // 调用add一次
//    list.add("once");
//    list.add("twice");
//    list.add("twice");
//    // 下面两个写法验证效果一样，均验证add方法是否被调用了一次
//    Mockito.verify(list).add("once");
//    Mockito.verify(list, times(1)).add("once");
//
//    //add("twice") 调用了俩次  这里不通过
//    Mockito.verify(list, times(1)).add("twice");

//    // mock creation
//    List mockedList = Mockito.mock(List.class);
//    // using mock object
//    mockedList.add("one");
//    mockedList.clear();
//    //verification
//    Mockito.verify(mockedList).add("one");
//    Mockito.verify(mockedList).clear();

//    //可以模拟具体的类，而不仅仅是接口
    List mockedList = mock(List.class);
//    //模拟执行
//    Mockito.when(mockedList.get(0)).thenReturn("first");
//    Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());
//    //输出 "first"
//    System.out.println(mockedList.get(0));
//    //抛出runtime异常
//    System.out.println(mockedList.get(1));
//    //输出"null" 因为get(999)没有被模拟
//    System.out.println(mockedList.get(999));
//
//    Mockito.verify(mockedList).get(0);

//    //使用内置的anyInt（）参数匹配器进行存根
//    Mockito.when(mockedList.get(anyInt())).thenReturn("element");
//    /*
//    也可以使用自定义匹配器进行存根
//    Mockito.when(mockedList.contains(argThat(matches()))).thenReturn("element");
//    自定义参数匹配器的时候需要继承ArgumentMatcher抽象类，它实现了Hamcrest框架的Matcher接口，
//    定义了describeTo方法，所以我们只需要实现matches方法在其中定义规则即可。
//    */
//    //输出"element"
//    System.out.println(mockedList.get(999));
//    //验证
//    Mockito.verify(mockedList).get(anyInt());

    List singleMock = mock(List.class);
    //使用单个模拟
    singleMock.add("was added first");
    singleMock.add("was added second");
    //为单个模拟创建一个inOrder验证程序
    InOrder inOrder = inOrder(singleMock);
    //以下将验证首先调用add “was added first”，然后调用 “was added second”
    inOrder.verify(singleMock).add("was added first");
    inOrder.verify(singleMock).add("was added second");

    //必须按特定顺序使用的多个模拟
    List firstMock = mock(List.class);
    List secondMock = mock(List.class);
    //调用
    firstMock.add("was called first");
    secondMock.add("was called second");
    //创建一个inOrder验证程序
    inOrder = inOrder(firstMock, secondMock);
    //以下将验证首先调用firstMock，然后调用 secondMock
    inOrder.verify(firstMock).add("was called first");
    inOrder.verify(secondMock).add("was called second");
  }
}
