/* eslint-disable no-unused-vars */
import { useState, useContext, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios';
import { AuthContext } from '../context/AuthContext';

function Login() {
    const [payload, setPayload] = useState({ userName: '', password: '' });
    const navigate = useNavigate();
    const { login, isLoggedIn } = useContext(AuthContext);

    useEffect(() => {
        if (isLoggedIn) {
            navigate('/');
        }
    });

    const handleLogin = (e) => {
        e.preventDefault();
        axios.post('/auth/login', payload)
        .then((response) => {
            console.log(response);
            toast.success('Đăng nhập thành công', {
                position: "top-right",
            });
            login(response.data.name);
            navigate('/');
        })
        .catch((error) => {
            if(error.response && error.response.status === 401) {
                console.error('Error when login', error.response.data);
                toast.error('Sai tên đăng nhập hoặc mật khẩu', {
                    position: "top-right",
                });
            }
        });
    };

    return (
        <div className="login">
            <h1 className='text-2xl text-center' >Đăng nhập</h1>
            <form onSubmit={handleLogin} className='grid grid-cols-1 w-96 mx-auto mt-4'>
                <input
                    type="email" 
                    placeholder="Email"
                    required
                    value={payload.userName}
                    onChange={(e) => setPayload({ ...payload, userName: e.target.value })} 
                    className='my-4 p-2 rounded-lg'
                />
                <input
                    type="password" 
                    placeholder="Password" 
                    required
                    value={payload.password}
                    onChange={(e) => setPayload({ ...payload, password: e.target.value })}
                    className='my-1 p-2 rounded-lg' 
                />
                <button
                    type="submit"
                    className='mt-4 p-2 bg-orange-400 rounded-lg text-white'>
                        Đăng nhập
                </button>
                <Link to="/register" className='text-center text-blue-600 mt-3'>Đăng kí</Link>
            </form>
            <ToastContainer />
        </div>
    );
}

export default Login;
