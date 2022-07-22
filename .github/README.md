# Anyway start Spring Boot

## 환경 설정

- `spring-boot`를 시작하기 위해서는 먼저 `java`를 설치할 필요가 있습니다.

- 또한 `javascript` 기반의 `Express`나, `python`기반의 `Django`와는 다르게 사이트에서 `intializer`를 제공한다는 점이 있습니다. [링크](https://start.spring.ioa)

  ![spring](./imgs/1.png)

- 맨 위에 있는 `maven`, `gradle`은 `java`의 빌드관리 도구ㄷ입니다.

- Maven

  - `Maven`은 Java용 프로젝트 관리도구로 Apache의 `Ant` 대안으로 만들어졌습니다.

  - 빌드 중인 프로젝트, 빌드 순서, 다양한 외부 라이브러리 종속성 관계를 `pom.xml`파일에 명시합니다.

  - `Maven`은 외부저장소에서 필요한 라이브러리와 플러그인들을 다운로드 한다음, 로컬시스템의 캐시에 모두 저장합니다.

- Gradle

  - `Maven`과 `Ant`에서 볼수 있는 개념들을 사용하는 대안으로써 나온 프로젝트 빌드 관리 툴이다. (완전한 오픈소스)

  - `Groovy` 언어를 사용한 `Domain-specific-language`를 사용한다. (xml파일을 보다 간결)

  - 꽤 큰규모로 예상되는 `multi-project` 빌드를 도울 수 있도록 디자인되었다.

  - `Gradle`은 프로젝트의 어느부분이 업데이트되었는지 알기 때문에, 빌드에 점진적으로 추가할 수 있다.

- `java`의 버전 선택에 있어서 `17`버전이 기본값으로 되어있어 버전의 수정이 필요했습니다.

  - `SDKman`이라는 `java version tool`이 존재해 통해 버전을 17버전으로 만들었습니다.

## 목차 (index)

[Step1](./Step1/README.md)
[Step1](./Step1/README.md)
