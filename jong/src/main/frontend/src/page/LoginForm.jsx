import React from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
import styled, { css } from 'styled-components';
import theme from '../styles/Theme';
import { useNavigate } from 'react-router-dom';


const LoginForm = () =>{
    const {register, handleSubmit} = useForm();
    const navigate = useNavigate();

    const clickLogin = async (data) =>{
        try {
            const response = await axios.post("/api/login",
        {
            email: data.email,
            password: data.password

        },{withCredentials:true});
        if(response.status == 200) {
            navigate('/')
        }else{
            alert('Invalid credentials');
        }} catch (error) {
            console.error('Error during login:', error);
            alert('Login failed');
        }
    }
    

    return(
        <LabelDiv>
            <form onSubmit={handleSubmit(clickLogin)}>
                <label htmlFor="email">이메일</label>
                <input id="email" type="email" placeholder="xx@email.com" {...register("email")}/>
                <label htmlFor="password">비밀번호</label>
                <input id="password" type="password" placeholder="password" {...register("password")}/>
                <button type="submit">로그인</button>
            </form>
        </LabelDiv>
    )

}

export default LoginForm;

const LabelDiv = styled.div`
  ${theme.flex.flexBox}
`;