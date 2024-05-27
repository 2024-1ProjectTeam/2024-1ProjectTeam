import React, { useState } from "react";
import Iframe from 'react-iframe';
import styled, { css } from 'styled-components';
import theme from '../styles/Theme';
import JoinForm from "./JoinForm";
import LoginForm from "./LoginForm";

const TestForm = () => {
    const [content, setContent] = useState();
    const pages = [
        {id: 0, name:"./JoinForm", text:"회원가입"},
        {id: 1, name:"./LoginForm", text:"로그인"},
        // {id: 2, link:"MatchingForm", text:"매칭시스템"},
        // {id: 3, link:"CommunityForm", text:"커뮤니티"}
    ]

    const handleCheckButton = e => {
        const { name } = e.target;
        setContent(name);
        console.log(name);
    };
    
    return(
        <div>
            <Container>
                {pages.map(data => {
                    return(
                <Button onClick={handleCheckButton} name={data.name} key={data.id}>
                    {data.text}
                </Button>
                );
                })}
            </Container>
            <FrameDiv>
                <Iframe id="frame" height="800px" width="800px" url="https://www.daum.net/" /> 
            </FrameDiv>
        </div>
    )
}

export default TestForm;

const Container = styled.div`
  ${theme.flex.flexBox}
  height: 50px;
`;

const Button = styled.button`
  padding: 1px 2px;
  margin: 10px;
  color: #111111;
  background-color: #eeeeee;
  border-radius: 5px;
`;

const FrameDiv = styled.div`
  ${theme.flex.flexBox}
`;