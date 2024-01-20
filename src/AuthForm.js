import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const AuthForm = ({ type, onSubmit, onSwitchType }) => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
    if (type === 'signup') {
      navigate('/signup'); 
    }
  };

  return (
    <form onSubmit={handleSubmit} className="auth-form">
      <h2>{type === 'login' ? 'Login' : 'Sign Up'}</h2>
       <label>
         Username:
         <input
           type="text"
           name="username"
           value={formData.username}
           onChange={handleChange}
         />
       </label>
       <br />
       <label>
         Password:
         <input
           type="password"
           name="password"
           value={formData.password}
           onChange={handleChange}
         />
       </label>
       {type === 'signup' && ( 
         <div>
           <label>
             Email:
             <input
               type="email"
               name="email"
               value={formData.email}
               onChange={handleChange}
             />
           </label>
           <br />
         </div>
       )}
       <button type="submit">{type === 'login' ? 'Login' : 'Sign Up'}</button>
       {type === 'login' && (
         <p>
           Don't have an account?{' '}
           <a href='./SignUp'><button type="button" onClick={{onSwitchType}}>
             Sign Up
           </button></a>
         </p>
       )}
       {type === 'signup' && (
         <p>
          Already have an account?{' '}
          <a href='./Login'><button type="button" onClick={onSwitchType}>
             Login
           </button></a>
         </p>
      )}
     </form>
);
};

export default AuthForm;
