import {useEffect, useState} from "react";
import axios from "axios";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import JoinForm from "./page/JoinForm";
import LoginForm from "./page/LoginForm";
import styled from "styled-components";
import theme from "./styles/Theme";
import Main from "./page/Main";
import Header from "./layout/Header";

function App() {

    return (
        <div>
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/" element={<Main />}></Route>
                    <Route path="/JoinForm" element={<JoinForm/>}></Route>
                    <Route path="/LoginForm" element={<LoginForm/>}></Route>
                    {/* <Route path="/MatchingForm" element={<MatchingForm/>}></Route>
                    <Route path="/CommunityForm" element={<CommunityForm/>}/>
                    <Route path="/DiaryForm" element={<DiaryForm/>}/> */}
                </Routes>
            </BrowserRouter>
        </div>
    )



}

export default App;
