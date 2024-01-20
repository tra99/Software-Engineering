import React from 'react';
import AuthForm from './AuthForm';
import axios from 'axios';

const SignUp = ({ onSwitchType }) => {
    const handleSignUp = async (formData) => {
        try {
          const response = await axios.post('http://localhost:8000/api/users/signup', formData);
          alert('Sign Up successful:', response.data);
        } catch (error) {
          console.error('Sign Up error:', error.message);
        }
      };
  return <AuthForm type="signup" onSubmit={handleSignUp} onSwitchType={onSwitchType} />;
};

export default SignUp;
