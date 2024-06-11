import React, { useEffect, useState } from "react";
import Iframe from 'react-iframe';
import styled, { css } from 'styled-components';
import theme from '../styles/Theme';
import axios from "axios";



const Main = () => {

    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(true);
  
    useEffect(() => {
      // 데이터 가져오기 함수
      const fetchData = async (data) => {
        try {
          const response = await axios.get('/api/main', { withCredentials:true })
          alert(response.data);
          if(response.status === 200){
            setData(response.data);
          }else{            
            alert('Invalid credentials');
          }
        } catch (error) {
          console.error('Error fetching data:', error);
        } finally {
          setLoading(false);
        }
      };
  
      fetchData();
    }, []);
  
    if (loading) {
      return <div>Loading...</div>;
    }
  
    return (
      <div>
        {data ? (
          <div>{data}님 반갑습니다.</div>
        ) : (
          <div>No data available</div>
        )}
      </div>
    );
  }

export default Main;