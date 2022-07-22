# Spring 기본강의 


## Lecture1

- FrameWork란 : 틀을 벗어나지 않고 좋은 프로그램을 만들기위한 툴

- Spring : OpenSource, IOC-Container, DI, Many-Filter

- IOC( Inversion of Controlll ) 역전제어 방식 
   
   - class : 설계도, Object : 실체화가 가능한것, Instance : 실체화과 된것

   - 만약 make라는 메소드에서 Apple이라는 객체를 만들고, Delete라는 메소드에서 다시 Apple이라는 객체를 만들면 같은 객체가 아니게된다.

   - 따라서 이런 객체들을 Spring에서 만들어 놓고 관리 할수있다면 편리하다.

- DI(Dependency Injection) : 의존성 주입
   
   -  IOC 방식을 통해 객체를 가져와서 사용하는것을 DI라고 볼수있다.

## Lecture2

- ManyFilter 

   - 톰캣과 스프링은 Filter를 가지고 있다. 

   - 스프링의 Filter는 인터셉터라고 불린다

- ManyAnnotation

   - Annotation: 컴파일러가 체킹할수 있도록 하는 text `ex) @Override`

   - Spring에서는 Annotation을 통해 객체를 생성 

   - Anntoion이 있는 부분에서 부터 분석하는것을 리플렉션(해당 클레스가 어떤것을 들고있는지 찾는 기법)
