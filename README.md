- [Section 3]
  - [27.  Primary와 Qualifier - 어떤 Spring 어노테이션을 사용할까요?](#27.  Primary와 Qualifier - 어떤 Spring 어노테이션을 사용할까요?)


## 27.Primary와 Qualifier - 어떤 Spring 어노테이션을 사용할까요?
```
@Component @Primary
class QuickSort implement SortingAlgorithm{}

@Component
class BubbleSort implement SortingAlgorithm{}

@Component @Qualifier("RadixSortQualifier")
class RadixSort implement SortingAlgorithm{}

@Component
class ComplexAlgorithm
  @Autowired
  private SortingAlgorithm algorithm;

@Component
class AnotherComplexAlgorithm
  @Autowired @Qualifier("RadixSortQualifier")
  private SortingAlgorithm iWantToUseRadixSortOnly;

```
### Primary는 여러 후보가 자격이 있는 경우, Bean에게 우선권을 주는 것을 말한다.
### Qualifier의 경우, 특정 Bean이 자동 와이어링되어야 한다. 

ComplexAlgorithm에서는 @Autowired만 사용하고 있다. 한정자는 전혀 적용되지 않았다.
(@Autowired만 사용한다면 가장 적합한 SortingAlgorithm을 달라고 요청하는 것이다.)

반면 AnotherComplexAlgorithm은 특정 SortingAlgorithm만을 사용하고 싶을 때 사용한다.

```
Autowired란?
필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입한다
- 생성자
- Setter
- 필드
위의 3가지의 경우에 Autowired를 사용할 수 있다. 그리고 Autowired는 기본값이 true이기 때문에 의존성 주입을 할 대상을 찾지 못한다면 애플리케이션 구동에 실패한다.
```
