import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Register from "./Register/Register";
import Login from "./Login/login";
import Main from './Main/Main';
import Admin from './Admin/Admin';
import ProtectedRoute from './ProtectedRoutes';
import Error from './Error/Error'; 
import Trainings from './Trainings/Trainings';
import Competition from './Competition/Competition';
import Fauv from './Trainings/Fauv/Fauv';
import Lutece from './Trainings/Lutece/Lutece';
import Phoenix from './Trainings/Phoenix/Phoenix';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/error' element={<Error />} /> 

{/* Route pour le rôle 'user' */} 

        <Route path='/main' element={
          <ProtectedRoute requiredRole="user">
            <Main />
          </ProtectedRoute>
        } />

        <Route path='/trainings' element={
          <ProtectedRoute requiredRole="user">
            <Trainings />
          </ProtectedRoute>
        }/>

        <Route path='/competition' element={
          <ProtectedRoute requiredRole="user">
             <Competition />
          </ProtectedRoute>
        }/>

        <Route path='/trainings/fauv' element={
          <ProtectedRoute requiredRole="user">
              <Fauv />
          </ProtectedRoute>
        } />

        <Route path='/trainings/lutece' element={
          <ProtectedRoute requiredRole="user">
              <Lutece />
          </ProtectedRoute>
        } />

        <Route path='/trainings/phoenix' element={
          <ProtectedRoute requiredRole="user">
              <Phoenix />
          </ProtectedRoute>
        }/>


{/* Route pour le rôle 'admin' */}

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