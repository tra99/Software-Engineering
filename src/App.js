import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import LoginForm from './Login';
import SignUpForm from './SignUp';

import './App.css';

const App = () => {
  const [authType, setAuthType] = useState('login');

  const handleSwitchType = () => {
    setAuthType((prevType) => (prevType === 'login' ? 'signup' : 'login'));
  };

  return (
    <div className="app-container">
      <Router>
        <Routes>
          <Route path="/login" element={<LoginForm onSwitchType={handleSwitchType} />} />
          <Route path="/signup" element={<SignUpForm onSwitchType={handleSwitchType} />} />
          <Route path="/" element={<LoginForm onSwitchType={handleSwitchType} />} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;


