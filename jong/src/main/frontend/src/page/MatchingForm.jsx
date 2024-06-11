import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
import styled, { css } from 'styled-components';
import theme from '../styles/Theme';


const MatchingForm = () =>{
    const {register, handleSubmit} = useForm();
    const [data, setData] = useState();

    const clickMatching = async (data) =>{
        try {
            const response = await axios.get("/api/Matching",{withCredentials:true});
        } catch (error) {
            console.error('Error during login:', error);
            alert('Matching failed');
        }
    }



    return(
        <LabelDiv>
            <form onSubmit={handleSubmit(clickMatching)}>
                <label htmlFor="email">이메일</label>
                <input id="email" type="email" placeholder="xx@email.com" {...register("email")}/>
                <label htmlFor="password">비밀번호</label>
                <input id="password" type="password" placeholder="password" {...register("password")}/>
                <button type="submit">로그인</button>
            </form>
        </LabelDiv>
    )

}

export default MatchingForm;

const LabelDiv = styled.div`
  ${theme.flex.flexBox}
`;