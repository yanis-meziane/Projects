import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Register from "./Register/Register";
import Login from "./Login/login";
import Main from './Main/Main';
import Admin from './Admin/Admin';

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Register />} />
          <Route path='/login' element={<Login />} />
          <Route path='/Main' element={<Main />} />
          <Route path='/Admin' element={<Admin />} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
