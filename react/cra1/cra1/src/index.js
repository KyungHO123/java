import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
/*
 컴포넌트를 넣을 때는 <컴포넌트명 />을 통해 넣어 줌
 이 때 컴포넌트 명이 소문자로 시작하면 동작이 안됨.
*/
root.render(
  <App />
);

