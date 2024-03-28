/*
컴포넌트는 함수로 만듬.
컴포넌트 함수는 대문자로 시작.(반드시)
컴포넌트 함수는 return을 통해 작성해야 하며,
(괄호) 안에는 하나의 태그로 이루어져야 함. 최상위 태그가 1개이어야 함.
컴포넌트에서 선언한 변수는 재랜더링이 되기전까지 값이 변경되지 않음.
*/
var count = 0;
function App() {
  function countUp() {alert(++count);}
  function countDown() {alert(--count);}
  return (
    /* 클래스 이름은 className을 통해 변경 */
    <div className="App">
      <button onClick={countDown}>-</button>
      <span style={{ "padding": "0 10px" }}>{count}</span>
      <button onClick={countUp}>+</button>
    </div>
  );
}
//만들어진 컴포넌트를 export로 내보내야 함.
export default App;
