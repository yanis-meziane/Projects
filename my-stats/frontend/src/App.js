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
import Beach from './Competition/Beach/Beach';
import Indoor from './Competition/Indoor/Indoor';
import Outdoor from './Competition/Outdoor/Outdoor';
import Tournois from './Competition/Tournois/Tournois';
import Hat from './Competition/Hat/Hat';

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

         <Route path='/competition' element={
          <ProtectedRoute requiredRole="user">
             <Competition />
          </ProtectedRoute>
        }/>

        <Route path='/competition/beach' element={
          <ProtectedRoute requiredRole="user">
              <Beach />
          </ProtectedRoute>
        }/>

        <Route path='/competition/indoor' element={
          <ProtectedRoute requiredRole="user">
            <Indoor />
          </ProtectedRoute>
        } />

        <Route path='/competition/outdoor' element={
          <ProtectedRoute requiredRole="user">
            <Outdoor />
          </ProtectedRoute>
        } />

        <Route path="/competition/tournois" element={
          <ProtectedRoute requiredRole="user">
              <Tournois />
          </ProtectedRoute>
        } />


        <Route path='/competition/hat' element={
          <ProtectedRoute requiredRole="user">
            <Hat />
          </ProtectedRoute>
        } />



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