![Untitled](https://user-images.githubusercontent.com/102807742/205361490-91fdd19d-3766-4562-bf07-f2aeee365072.png)
조영호님의 강의를 보며 작성한 코드의 클래스 다이어 그램입니다.

우선 기본적인 기능부터 설명하면 `밥먹어요` 라는 기능으로 같이 밥먹을 사람을 모으는 글을 올리고 그 글에 우리는 참여할 수 있습니다.

그런데 위의 다이어그램을 보면 `EatTogather` 그리고 `WithEatogather` 클래스 2개가 있는 것을 볼 수 있습니다.

이는 조금 더 안전한 검증을 위해서 위와 같이 2개의 클래스를 만든 것입니다.

우선 `EatTogather` 하나만 있는 경우를 생각해봅시다.

6시에 후문에서 밥먹는다는 내용의 글을 보고 참여버튼을 눌렀습니다.

근데 그 순간 그 글의 작성자가 글의 내용을 6시에서 7시로 수정합니다.

이러한 경우 `EatTogather` 하나만 있다면 우리는 이를 검증하기 힘듭니다.

물론 구현할 수는 있겠지만 굉장히 코드가 지저분해지고 유지보수가 힘들어질 것입니다.

그럼 `WithEatogather` 가 있으면 어떨까요?

`WithEatogather` 는 사용자가 그 정보를 선택한 순간의 정보를 담고 있는 클래스입니다.

우리는 이 클래스의 정보를 바탕으로 사용자가 참여 버튼을 눌렀을때의  `EatTogather` 와 비교하여 일치 여부를 확인하여 글의 정보 변경을 검증할 수 있습니다.

우리가 검증해야할 부분은 `EatTogatherInfo` 와 `WithEatogatherInfo` 의 일치 여부입니다.

이를 위해 `Info` 라는 클래스를 구현하였는데 그 이유는 다음과 같습니다.

`Info` 가 없다면 `EatTogatherInfo`와 `WithEatogatherInfo` 를 비교하기 위해서는 둘 중 하나의 클래스가 다른 하나의 클래스에 대한 의존이 생깁니다.

다른 도메인에 걸쳐 의존 관계가 생기는 것은 우리가 원하는 것이 아닙니다.

이 의존 관계를 줄이기 위해 `Info` 를 만들게 된 것입니다.

`Info` 가  `EatTogatherInfo`와 `WithEatogatherInfo` 사이에서

```java
| EatTogatherInfo -> Info | <- WithEatogatherInfo |
```

와 같이 관계를 만들어 의존성을 낮추는 것입니다.

사실 이게 의존성을 낮춘다는 것이 조금 이해하기 힘들 수 있는데 기존에는  `EatTogatherInfo`와 `WithEatogatherInfo` 둘 중 하나를 수정하면 서로에게 영향을 주었다면 지금은 `Info` 가 사이에 있어 `Info` 에게 영향을 주게 되는 것입니다.

극단적으로 말해서 이제는 `WithEatogatherInfo` 가 사라지고 다른 `WithEatogatherInfo2` 가 나와도

`WithEatogatherInfo2` 를 `Info` 로만 바꾸어주는 메서들 만들면 `EatTogatherInfo` 에게는 아무런 영향이 없는 것입니다.

`JoinMember` 도 `Info` 와 같은 이유로 만들어 준 것입니다.

`EatTogatherMembers` 에 `WithEatogatherMember` 가 추가될 때 직접적으로 되는 것이 아닌 `JoinMember` 를 통해 되는 것 입니다.

이렇게 보면 `Info` 와 `JoinMember` 은 인터페이스와 유사한 역활을 하는 것 같은데 이는 추가적인 공부를 통해 알아보아야 할 것 같습니다.

그리고 여전히 `EatTogather` 그리고 `WithEatogather` 간에 의존성이 남아 있습니다.

이는 version2에서 의존성을 끊어보도록 하겠습니다.