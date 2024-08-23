/* eslint-disable react/prop-types */
import { useFormContext } from 'react-hook-form'
import { findInputError } from '../utils/findInputError';
import { isFormInvalid } from '../utils/isFormInvalid';

export const Input = ({ name, label, type, id, placeholder, validation = {required: { value: true, message: 'required'}} }) => {
    const { register, formState: { errors } } = useFormContext();

    const inputError = findInputError(errors, name)
    const isInvalid = isFormInvalid(inputError)
  
    return (
      <div className="flex flex-col w-full gap-1 mb-3">
        <div className="flex justify-between">
          <label htmlFor={id} className="font-semibold capitalize">
            {label}
          </label>
          {isInvalid && (
            <InputError
              message={inputError.error.message}
              key={inputError.error.message}
            />
          )}
        </div>
        <input
          id={id}
          type={type}
          className="w-full p-3 font-medium border rounded-md border-slate-300 placeholder:opacity-60"
          placeholder={placeholder}
          {...register(name, validation)}
        />
      </div>
    );
};

const InputError = ({ message }) => {
    return (
        <span className='text-red-600 bg-red-100 px-2 rounded-lg'>
            {message}
        </span>
    );
};