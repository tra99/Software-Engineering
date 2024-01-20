import React from 'react';
import AuthForm from './AuthForm';
import axios from 'axios';

const LoginForm = ({ onSwitchType }) => {
    const handleLogin = async (formData) => {
        try {
          const { username, password } = formData;
          const response = await axios.post(`http://localhost:8000/api/users/signin?username=${username}&password=${password}`);
          console.log('Login successful:', response.data);
        } catch (error) {
          console.error('Login error:', error.message);
        }
      };
      

  return <AuthForm type="login" onSubmit={handleLogin} onSwitchType={onSwitchType} />;
};

export default LoginForm;
