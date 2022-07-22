# Spring 기본강의 


## Srping 개념

- FrameWork란 : 틀을 벗어나지 않고 좋은 프로그램을 만들기위한 툴

- Spring : OpenSource, IOC-Container, DI, Many-Filter

- IOC( Inversion of Controlll ) 역전제어 방식 
   
   - class : 설계도, Object : 실체화가 가능한것, Instance : 실체화과 된것

   - 만약 make라는 메소드에서 Apple이라는 객체를 만들고, Delete라는 메소드에서 다시 Apple이라는 객체를 만들면 같은 객체가 아니게된다.

   - 따라서 이런 객체들을 Spring에서 만들어 놓고 관리 할수있다면 편리하다.

- DI(Dependency Injection) : 의존성 주입
   
   -  IOC 방식을 통해 객체를 가져와서 사용하는것을 DI라고 볼수있다.

- ManyFilter 

   - 톰캣과 스프링은 Filter를 가지고 있다. 

   - 스프링의 Filter는 인터셉터라고 불린다

- ManyAnnotation

   - Annotation: 컴파일러가 체킹할수 있도록 하는 text `ex) @Override`

   - Spring에서는 Annotation을 통해 객체를 생성 

   - Anntoion이 있는 부분에서 부터 분석하는것을 리플렉션(해당 클레스가 어떤것을 들고있는지 찾는 기법)

- Message Converter

   - Java Object를  Json을 통해 만들어주는것  (현재 Jackson라이브러리를 사용)

- BufferedRread, Write

   - 통신을 할때는 Stream으로 보내게되는데, InputStreamReader를 통해 문자로 번역

   - 하지만 여러개의 문자를 받기위해 문자열을 사용하면 문자가 적거나 많아지면 버려지는 메모리가 많아짐

   - 떠라서 BufferedRread를 통해 문자열 가변길이를 통해 메모리 절약이 가능

   - printWriter를 통해 글을 쓸수있다 (print,println)

   - spring에서는 @ReponseBody를 통해 BufferedRread,와 @RequestBody를 통해 Bufferedwrite를 사용가능
