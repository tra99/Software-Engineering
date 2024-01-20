import React from 'react';
import AuthForm from './AuthForm';
import axios from 'axios';

const SignUpForm = ({ onSwitchType }) => {
    const handleSignUp = async (formData) => {
        try {
          const response = await axios.post('http://localhost:8000/api/users/signup', formData);
          console.log('Sign Up successful:', response.data);
        } catch (error) {
          console.error('Sign Up error:', error.message);
        }
      };
  return <AuthForm type="signup" onSubmit={handleSignUp} onSwitchType={onSwitchType} />;
};

export default SignUpForm;
