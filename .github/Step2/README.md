# H2,JDBC

- 이번 프로젝트에서는 `DB`를 사용하는 프로젝를 해볼겁니다.

-  `H2`를 사용해서 관계형 DB를 만들고 `JDBC`를 통해 DB에 연결과 쿼리를 날려 보도록하겠습니다.

| H2 | JDBC |
|--------------- | --------------- |
|  따로 설치 X  |  Java에서 DB접속  |
|  용량이 가볍다  |  SQL문을 구성하고 DB에 요청  |
|  In-Memory Type DB  |  DBMS 벤더에 의존X   |

- `JDBC`에서 특별히  다른 DB가 없을 경우 자동으로 `H2`데이터 베이스에 연결을 해줍니다.



## Project

- 일단 예시로 `Customer`라는 객체를 만들겠습니다.

```java
public class Customer {
  private long id;
  private String firstName, lastName;

  public Customer(long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
  }
}

```
- 두번째는 데이터를 저장하고 불러와 보도록하겠습니다.

```java
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
 // logger
  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Autowired JdbcTemplate jdbcTemplate;

  @Override
  public void run(String... args) throws Exception {
    log.info("Creating tables");

    jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
    jdbcTemplate.execute(
        "CREATE TABLE  customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

    List<Object[]> splitUpNames =
        Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
            .map(name -> name.split(" "))
            .collect(Collectors.toList());

    splitUpNames.forEach(
        name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

    jdbcTemplate.batchUpdate(
        "INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

    log.info("Querying for customer records where first_name = 'Josh':");
    jdbcTemplate
        .query(
            "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
            new Object[] {"Josh"},
            (rs, rowNum) ->
                new Customer(
                    rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
        .forEach(customer -> log.info(customer.toString()));
  }
}
```  

- Autowired는 
