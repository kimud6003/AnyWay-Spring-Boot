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

## JPA ( Java Persistance API ) 

- Persistance라는것은 영구적인것을 의미하는데 Java에 있는 데이터를 DB에 저장할수 있도록 하는 API

- ins(Object Realtional Mapping) : Java에서 만든 클래스를 DB에 Table로 만들어주고 컨트롤할수 있도록 해줌

- Persistance Context : DB와 Java의 Context(모든 정보)를 공유가능

- DB와 OOP의 불일치성을 해결가능 (DB는 객체 저장 불가능, Java는 객체저장 가능)

## HTTP? 톰캣?

- Socket : 연결 Port로 접근하면 새로운 Port를 만들어(스레드) 해당 포트로 클라이언트와 통신하는방법( 서버에 부화가 많음 )

- HTTP : Statelss 방식 Port로 접근한 대상에 대해 바로 응답을 해주는 구조

- Tomcat :

   - 웹서버는 보통 아파치를 사용하는데, 아파치는 .jsp와같은 파일을 읽지 못해서 전송하지 못했다.

   - 그래서 아파치는 .jsp파일을 톰캣에게 전달하고 이것을 컴파일해서 .html파일로 바꿔준다.

   - 그리고 아파치는 이것을 클라이언트에게 다시 전송하는 절차를 밟는다 

- Servlet container:

   - 정적인 파일의 요청만 들어온다면 톰캣은 일을 하지 않는다.

   - 하지만 spring에서는 URI 접근 방식을 요구하기 떄문에 정적파일만 가져오는것은 불가능하다.

   - 요청(java관련된 자원)이 들어오면 서블릿 객체를 생성(init) -> service를 통해 (Post,get,put...)를 구분 -> 구분후 스레드를 통해 Post,get,pu...등을 수행

   - 만약 재요청이 들어오게 된다면, 컨테이너를 만들지 않고 재사용하게 된다

   - 만약 20명이 동시 접근하면 스레드가 20개 까지 늘어나고, 25명이 접근하면 5명이 대기하고 스레드를 재사용(pooling)

   - servlet 객체는 계속 재사용된다.

## Web.xml

- Web.xml이 하는 역할 

   - ServletContext의 초기 파라미터 설정

   - Session의 유효시간 설정 : Session 기간 설정 

   - Servlet/jsp에 대한 정의 

   - Servlet/jsp에 매핑

   - Mime Type 매핑 : Post를 통해 들어온 데이터의 안전성을 유무를 판단하고 가공

   - welcome File List  

   - Erro Pages 처리

   - 리스너/필터 설정

   - 보안


## FrontController 패턴

- 최초 앞단에서 요청을 받아서 FrontController에게 넘겨준다.

- 요청이 들어오면 톰캣으로 간다. -> 톰캣은 Request,Response 객체를 만든다. -> web.xml을 통해 요청이 들어오면 -> FrontController가 받는다.

- FrontController를 통해 내부에 있는 자원에 접근을 하게된다. -> 해당 자원을 접근할때 Requeset를 New하게 되는데 이것을 덮어쓰지 않고 유지하는게 RequestDispactcher

## application context

- 요청이 들어옴 -> web.xml -> DispatcherServlet을 통해 src 내부에 있는 component를 스캔해서 new를 진행  -> 메모리에 올려야하는것들은 @어노테이션으로 알림

- web.xml -> ContextLoaderListner로 도착하는 경우에는 모든 스레드가 공통적으로 사용하는 녀석(DB)를 재활용 하기위해서
