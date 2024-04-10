import './App.css';
import { useState } from 'react';
import { BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom';

function App() {

  let [list, setList] = useState([]);

  function add(movie) {
    setList([movie, ...list]);
  }
  function remove(id) {
    let tmpList = list.filter(item => item.id != id);
    setList(tmpList);
  }
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" exact element={<List list={list} add={add} remove={remove} />} />
        <Route path="/add" exact element={<Add />} />
      </Routes>
    </BrowserRouter>
  );
}

function Nav() {
  return (
    <div className='ul-box'>
      <ul className="menu-list list-box">
        <li className='왼쪽'><Link to="/">List</Link></li>
        <li ><Link to="/add">Add New Movie</Link></li>
      </ul>
    </div>
  );
}

function List({ list, add, remove }) {
  const location = useLocation();
  let movie = location.state;
   
  if (movie != null) {
    add(movie);
    location.state = null
  }

  return (
    <div>
      <h1>Movies</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item) => {
              return (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.title}</td>
                  <td>{item.genre}</td>
                  <td>{item.date}</td>
                  <td><button onClick={() => remove(item.id)}>delete</button></td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  );
}


function Add() {
  let [id, setid] = useState("");
  let [title, setTitle] = useState("");
  let [genre, setGenre] = useState("");
  let [date, setdate] = useState("");


  const idChange = (e) => setid(e.target.value);
  const dateChange = (e) => setdate(e.target.value);
  const titleChange = (e) => setTitle(e.target.value);
  const genreChange = (e) => setGenre(e.target.value);
  const navigate = useNavigate();

  function addMovie() {
    if(id == null||id == ""){
      return alert("아이디를 입력하세요")
    }
    
    if(title == null||title == ""){
      return alert("제목을 입력하세요")
    }

    if(genre == null||genre == ""){
      return alert("장르를 입력하세요")
    }

    if(date == null||date == ""){
      return alert("날짜를 입력하세요")
    }
    
    navigate("/", {
      state: {
        title,
        date,
        genre,
        id
      }
    })
  }
  return (
    <div >
      <h1>Create Movie</h1>
      <div className="table">
        <div >
          <input type='text' id="id" onChange={idChange} placeholder='Input movie id' />
        </div>
        <div>
          <input type='text' id="title" onChange={titleChange} placeholder='Input movie title' />
        </div>
        <div>
          <input type='text' id="genre" onChange={genreChange} placeholder='Input movie genre' />
        </div>
        <div>
          <label>출시일 : </label>
          <input type='date' id="date" onChange={dateChange} />
        </div>
        <button onClick={addMovie}>Add Movie</button>
      </div>
    </div>
  );

}
export default App;
