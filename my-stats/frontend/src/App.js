import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Register from "./Register/Register";
import Login from "./Login/login";
import Main from './Main/Main';
import Admin from './Admin/Admin';
import ProtectedRoute from './ProtectedRoutes';
import Error from './Error/Error'; 
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/error' element={<Error />} /> 

        <Route path='/main' element={
          <ProtectedRoute requiredRole="user">
            <Main />
          </ProtectedRoute>
        } />

        <Route path='/admin' element={
          <ProtectedRoute requiredRole="admin">
            <Admin />
          </ProtectedRoute>
        } />
      </Routes>
    </BrowserRouter>
  );
}

export default App;