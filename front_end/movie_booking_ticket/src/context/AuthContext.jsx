import { createContext, useEffect, useState } from 'react';
import { redirect } from 'react-router';

export const AuthContext = createContext();

// eslint-disable-next-line react/prop-types
export const AuthProvider = ({ children }) => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [name, setName] = useState('');

    useEffect(() => {
        const checkLoggedIn = localStorage.getItem('isLoggedIn');
        if (checkLoggedIn) {
            setIsLoggedIn(true);
            setName(localStorage.getItem('name'));
        }
    }, []);

    const login = (name) => {
        localStorage.setItem('isLoggedIn', true);
        localStorage.setItem('name', name);
        setIsLoggedIn(true);
        setName(name);
        redirect('/');
    }

    const logout = () => {
        localStorage.removeItem('isLoggedIn');
        localStorage.removeItem('name');
        setIsLoggedIn(false);
        setName('');
        redirect('/login');
    }

    return (
        <AuthContext.Provider value={{ isLoggedIn, name, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
}