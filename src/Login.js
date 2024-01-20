import React from 'react';
import AuthForm from './AuthForm';
import axios from 'axios';
import {useState} from 'react';
import { useNavigate } from 'react-router-dom';

const Login = ({ onSwitchType }) => {
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleLogin = async (formData) => {
    try {
      const { username, password } = formData;

      if (!username || !password) {
        setError('Username and password are required.');
        return;
      }

      const response = await axios.post(`http://localhost:8000/api/users/signin?username=${username}&password=${password}`);
      alert('Login successful:', response.data);
      navigate('/home');
    } catch (error) {
      console.error('Login error:', error.message);
      setError('Login failed. Please check your credentials.');
    }
  };

  return (
    <>
      {error && <div style={{ color: 'red'}}>{error}</div>}
      <AuthForm type="login" onSubmit={handleLogin} onSwitchType={onSwitchType} />
    </>
  );
};

export default Login;

