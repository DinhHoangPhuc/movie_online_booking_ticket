import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Link, useNavigate } from "react-router-dom";
import { useContext, useEffect } from "react";
import { AuthContext } from "../context/AuthContext";
import axios from "axios";
import { FormProvider, useForm } from "react-hook-form";
import { Input } from "../components/Input";
import { nameValidation,
         emailValidation,
         phoneValidation,
         dobValidation,
         passwordValidation,
         confirmPasswordValidation
} from "../utils/inputValidations";


const Register = () => {
    const { isLoggedIn } = useContext(AuthContext);
    const navigate = useNavigate();
    const methods = useForm();
    
    useEffect(() => {
        if (isLoggedIn) {
            navigate('/');
        }
    });

    const onSubmit = methods.handleSubmit((data) => {
    // Destructure confirmPassword out of data
    // eslint-disable-next-line no-unused-vars
    const { confirmPassword, ...registerData } = data;

        console.log(registerData)
        axios.post('/auth/register', registerData)
        .then((response) => {
            console.log(response);
            toast.success('Đăng kí thành công', {
                position: "top-right",
            });
            navigate('/');
        })
        .catch((error) => {
            if (error.response && error.response.status === 400) {
                const errorData = error.response.data;
                console.error('Error when register', errorData);
                for (const field in errorData) {
                    if (Object.prototype.hasOwnProperty.call(errorData, field)) {
                        methods.setError(field, {
                            type: 'manual',
                            message: errorData[field],
                        });
                    }
                }
            } else {
                console.error('Error when register', error.response.data);
                toast.error('Đăng kí thất bại', {
                    position: "top-right",
                });
            }
        });
    });

    return (
        <div className="login">
            <h1 className='text-2xl text-center' >Đăng kí</h1>
                <FormProvider {...methods}>
                    <form onSubmit={e => e.preventDefault()} className='grid grid-cols-1 w-96 mx-auto mt-4'>
                        <Input { ...nameValidation } />
                        <Input { ...emailValidation } />
                        <Input { ...phoneValidation } />
                        <Input { ...dobValidation } />
                        <Input { ...passwordValidation } />
                        <Input { ...confirmPasswordValidation } />
                        <button
                            onClick={onSubmit}
                            className='mt-4 p-2 bg-orange-400 rounded-lg text-white'>
                                Đăng ký
                        </button>
                        <Link
                            to="/register"
                            className='text-left text-blue-600 mt-3'>
                                Đăng nhập
                        </Link>
                    </form>
                </FormProvider>
            <ToastContainer />
        </div>
    );
};

export default Register;